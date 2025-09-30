package SignUpPortlet.portlet;

import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.cache.SingleVMPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import SignUpPortlet.constants.SignUpPortletKeys;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import java.util.Locale;
import java.util.UUID;



@Component(
    immediate = true,
    property = {
    		"javax.portlet.name=" +
    				  SignUpPortletKeys.SIGNUP, 
        "mvc.command.name=/user/add_user"
    },
    service = MVCActionCommand.class
)
public class AddUserMVCActionCommand implements MVCActionCommand {
	
	
	 private static final Log _log = LogFactoryUtil.getLog(SignUpPortlet.class);
	 
	 @Reference
	    private SingleVMPool singleVMPool;
	 
	    private PortalCache<Long, String> tokenCache;
	 
	 @SuppressWarnings("unchecked")
	    public void activate() {
	        // The cast is safe because we know we are storing Long -> String
	        tokenCache = (PortalCache<Long, String>) singleVMPool.getPortalCache("SIGNUP_TOKEN_CACHE");
	    }
	 

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
            String firstName = ParamUtil.getString(actionRequest, "firstName");
            String lastName = ParamUtil.getString(actionRequest, "lastName");
            String screenName = ParamUtil.getString(actionRequest, "screenName");
            String emailAddress = ParamUtil.getString(actionRequest, "emailAddress");
            String password = ParamUtil.getString(actionRequest, "password");


         // inside your MVCActionCommand
         ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

         User user = UserLocalServiceUtil.addUser(
             0,                         // creatorUserId
             PortalUtil.getDefaultCompanyId(),
             false,                     // autoPassword
             password,                  // password1
             password,                  // password2
             true,                      // autoScreenName
             screenName,
             emailAddress,
             Locale.ENGLISH,            // locale
             firstName,
             "",                        // middleName
             lastName,
             0,                         // prefixId
             0,                         // suffixId
             true,                      // male
             1, 1, 1990,                // birthday (month, day, year)
             "",                        // jobTitle
             0, new long[] {},              // groupIds
             new long[] {},              // organizationIds
             new long[] {},              // roleIds
             new long[] {},              // userGroupIds
             true,                      // sendEmail
             serviceContext
         );

            user.setStatus(WorkflowConstants.STATUS_DRAFT); // inactive
            UserLocalServiceUtil.updateUser(user);

            // Generate activation token
            String token = UUID.randomUUID().toString();
            tokenCache.put(user.getUserId(), token);
            

            // Send activation email
            String activationURL = PortalUtil.getPortalURL(actionRequest)
                    + "/web/guest/verifyemail"
                    + "?p_p_id=VerifyEmailPortlet"
                    + "&p_p_lifecycle=0"
                    + "&_VerifyEmailPortlet_mvcRenderCommandName=/verify/email"
                    + "&userId=" + user.getUserId()
                    + "&token=" + token;
            
            _log.info("Activation Link :  " +  activationURL);

            MailMessage mailMessage = new MailMessage();
            mailMessage.setTo(new InternetAddress(emailAddress));
            mailMessage.setFrom(new InternetAddress("prathibhakn88@gmail.com", "Fire Emergency System"));
            mailMessage.setSubject("Activate your account");
            mailMessage.setBody("Click this link to verify your email: " + activationURL);

            MailServiceUtil.sendEmail(mailMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
