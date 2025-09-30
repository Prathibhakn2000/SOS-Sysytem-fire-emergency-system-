package VerifyEmailPortlet.portlet;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;

import java.util.Date;
import java.util.Random;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import OTP_DB.model.SignUpOTP;
import OTP_DB.service.SignUpOTPLocalServiceUtil;
import VerifyEmailPortlet.constants.VerifyEmailPortletKeys;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + VerifyEmailPortletKeys.VERIFYEMAIL,
        "mvc.command.name=/verify/email"
    },
    service = MVCActionCommand.class
)
public class VerifyEmailMVCActionCommand extends BaseMVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(VerifyEmailMVCActionCommand.class);

    @Reference
    private UserLocalService _userLocalService;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {

        long userId = ParamUtil.getLong(actionRequest, "userId");
        String token = ParamUtil.getString(actionRequest, "token");
        String enteredEmail = ParamUtil.getString(actionRequest, "email");

        User user = _userLocalService.fetchUser(userId);
        if (user == null || !enteredEmail.equalsIgnoreCase(user.getEmailAddress())) {
            SessionErrors.add(actionRequest, "user-not-found");
            return;
        }

        // Generate OTP
        String otp = String.format("%06d", new Random().nextInt(999999));
        
        log.info("Generated OTP:" +otp);

        // Save OTP in DB
        SignUpOTP signupOTP = SignUpOTPLocalServiceUtil.createSignUpOTP(0);
        signupOTP.setUserId(userId);
        signupOTP.setUserName(user.getFullName());
        signupOTP.setCompanyId(user.getCompanyId());
        signupOTP.setGroupId(user.getGroupId());
        signupOTP.setEmail_address(user.getEmailAddress());
        signupOTP.setOTP(otp);
        signupOTP.setStatus(true);
        signupOTP.setCreateDate(new Date());
        signupOTP.setModifiedDate(new Date());
        

        SignUpOTPLocalServiceUtil.addSignUpOTP(signupOTP);
        
        log.info("OTP Saved to DB:"+signupOTP);

        // Build OTP portlet URL
        String portalURL = PortalUtil.getPortalURL(actionRequest);
        String redirectURL = portalURL + "/web/guest/otp"
                + "?p_p_id=OTP_PORTLET"
                + "&p_p_lifecycle=0"
                + "&_OtpPortlet_mvcRenderCommandName=/verify/otp"
                + "&userId=" + userId
                + "&token=" + token;

        // Email OTP
        String content = "Dear " + user.getFullName() + ",\n\n"
                + "Your OTP is: " + otp + "\n\n"
                + "This code is valid for 5 minutes.\n\n"
                + "Thank you,\nFire Emergency system Team";

        try {
            InternetAddress from = new InternetAddress("prathibhakn88@gmail.com", "Fire Emergency System");
            InternetAddress to = new InternetAddress(user.getEmailAddress());

            MailMessage mailMessage = new MailMessage(from, to, "Your OTP Code", content, false);
            MailServiceUtil.sendEmail(mailMessage);

            SessionMessages.add(actionRequest, "otp-sent");
        } catch (Exception e) {
            log.error("Failed to send OTP", e);
            SessionErrors.add(actionRequest, "otp-send-failed");
            return;
        }

        actionResponse.sendRedirect(redirectURL);
    }
}
