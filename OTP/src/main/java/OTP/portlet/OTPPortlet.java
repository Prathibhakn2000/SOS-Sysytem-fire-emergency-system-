package OTP.portlet;

import OTP.constants.OTPPortletKeys;

import com.liferay.adaptive.media.exception.AMRuntimeException.IOException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author prath
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=OTP",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + OTPPortletKeys.OTP,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OTPPortlet extends MVCPortlet {
	
	private static final Log log = LogFactoryUtil.getLog(OTPPortlet.class);

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException, java.io.IOException {

        HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
        HttpServletRequest originalRequest = PortalUtil.getOriginalServletRequest(httpRequest);

        long userId = 0;
        String token = originalRequest.getParameter("userId");
        String tokenParam = originalRequest.getParameter("token");

        if (token != null) {
            userId = Long.parseLong(token);
        }

        renderRequest.setAttribute("userId", userId);
        renderRequest.setAttribute("token", tokenParam);

        super.doView(renderRequest, renderResponse);
    }
}