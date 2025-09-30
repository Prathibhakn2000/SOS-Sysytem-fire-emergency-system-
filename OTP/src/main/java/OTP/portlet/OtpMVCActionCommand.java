package OTP.portlet;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.Date;
import java.util.List;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import OTP.constants.OTPPortletKeys;
import OTP_DB.model.SignUpOTP;
import OTP_DB.service.SignUpOTPLocalServiceUtil;

@Component(
    immediate = true,
    property = {
    		"javax.portlet.name=" + OTPPortletKeys.OTP,
        "mvc.command.name=/verify/otp"
    },
    service = MVCActionCommand.class
)
public class OtpMVCActionCommand extends BaseMVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(OtpMVCActionCommand.class);

    @Reference
    private UserLocalService _userLocalService;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {

        long userId = ParamUtil.getLong(actionRequest, "userId");
        String token = ParamUtil.getString(actionRequest, "token");
        String enteredOtp = ParamUtil.getString(actionRequest, "otp");

        // Fetch active OTPs for user
        List<SignUpOTP> otps = SignUpOTPLocalServiceUtil.getSignUpOTPs(0, Integer.MAX_VALUE);
        SignUpOTP validOtp = null;
        for (SignUpOTP o : otps) {
            if (o.getUserId() == userId && o.isStatus() && o.getOTP().equals(enteredOtp)) {
                validOtp = o;
                break;
            }
        }

        if (validOtp == null) {
            SessionErrors.add(actionRequest, "invalid-otp");
            return;
        }

        // Mark OTP as used
        validOtp.setStatus(false);
        validOtp.setModifiedDate(new Date());
        SignUpOTPLocalServiceUtil.updateSignUpOTP(validOtp);

        // Activate user
        User user = _userLocalService.getUser(userId);
        user.setStatus(WorkflowConstants.STATUS_APPROVED);
        _userLocalService.updateUser(user);

        // Send success email
        try {
            String subject = "Email Verification Successful";
            String body = "Dear " + user.getFullName() + ",\n\n"
                        + "Your email has been successfully verified and your account is now active.\n\n"
                        + "Thank you for registering!\n\n"
                        + "Best Regards,\nFire Emenrgency System";

            InternetAddress from = new InternetAddress("prathibhakn88@gmail.com", "Fire Emergency System");
            InternetAddress to = new InternetAddress(user.getEmailAddress());

            MailMessage mailMessage = new MailMessage(from, to, subject, body, false);
            MailServiceUtil.sendEmail(mailMessage);

            log.info("Success email sent to userId: " + userId);

        } catch (Exception e) {
            log.error("Error sending success email to userId: " + userId, e);
        }

        SessionMessages.add(actionRequest, "otp-verified");
        
     // ✅ Redirect to dashboard page
        actionResponse.sendRedirect("/web/guest/dashboard");
    }
}
