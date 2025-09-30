
package VerifyEmailPortlet.portlet;
  
  import com.liferay.portal.kernel.log.Log; import
  com.liferay.portal.kernel.log.LogFactoryUtil; import
  com.liferay.portal.kernel.model.User; import
  com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand; import
  com.liferay.portal.kernel.service.UserLocalServiceUtil; import
  com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.RenderRequest; import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
  
  import VerifyEmailPortlet.constants.VerifyEmailPortletKeys;
 
 
 /*
 * @Component( immediate = true, property = { "javax.portlet.name=" +
 * VerifyEmailPortletKeys.VERIFYEMAIL, "mvc.command.name=/verify_email" },
 * service = MVCRenderCommand.class ) public class VerifyEmailMVCRenderCommand
 * implements MVCRenderCommand {
 * 
 * private static final Log log =
 * LogFactoryUtil.getLog(VerifyEmailMVCRenderCommand.class);
 * 
 * @Override public String render(RenderRequest renderRequest, RenderResponse
 * renderResponse) { long userId = ParamUtil.getLong(renderRequest, "userId");
 * String token = ParamUtil.getString(renderRequest, "token");
 * 
 * try { User user = UserLocalServiceUtil.getUser(userId); String savedToken =
 * (String) user.getExpandoBridge() .getAttribute("emailVerificationToken");
 * 
 * if (savedToken != null && savedToken.equals(token)) { // Token is valid →
 * allow sending OTP renderRequest.setAttribute("userId", userId);
 * renderRequest.setAttribute("emailAddress", user.getEmailAddress()); } else {
 * renderRequest.setAttribute("error", "Invalid activation link.");
 * log.warn("Invalid token for userId: " + userId); } } catch (Exception e) {
 * log.error(e); renderRequest.setAttribute("error",
 * "Error verifying your account."); }
 * 
 * return "/verify_email.jsp"; // JSP page with email input + Send OTP button }
 * }
 */



@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" +VerifyEmailPortletKeys.VERIFYEMAIL,
        "mvc.command.name=/verify/sendOtp"
    },
    service = MVCRenderCommand.class
)
public class VerifyEmailMVCRenderCommand implements MVCRenderCommand {

    private static final Log _log = LogFactoryUtil.getLog(VerifyEmailMVCRenderCommand.class);

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
        try {
            HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
            HttpServletRequest originalRequest = PortalUtil.getOriginalServletRequest(httpRequest);

            String userIdStr = originalRequest.getParameter("userId");
            String token = originalRequest.getParameter("token");

            if (_log.isInfoEnabled()) {
                _log.info("VerifyEmail page opened with userId=" + userIdStr + " & token=" + token);
            }

            renderRequest.setAttribute("userId", userIdStr);
            renderRequest.setAttribute("token", token);

        } catch (Exception e) {
            _log.error("Error rendering VerifyEmail page", e);
        }
        return "/verify_email.jsp";  // JSP where user enters email



}
}
