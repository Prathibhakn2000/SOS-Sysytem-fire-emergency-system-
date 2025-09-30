package VerifyEmailPortlet.portlet;

import VerifyEmailPortlet.constants.VerifyEmailPortletKeys;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.cache.SingleVMPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.mail.internet.InternetAddress;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import OTP_DB.model.SignUpOTP;
import OTP_DB.service.SignUpOTPLocalServiceUtil;

/**
 * @author prath
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=VerifyEmail",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + VerifyEmailPortletKeys.VERIFYEMAIL,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class VerifyEmailPortlet extends MVCPortlet {
	
	 

		/*
		 * @Override public void doView(RenderRequest renderRequest, RenderResponse
		 * renderResponse) throws IOException, PortletException { HttpServletRequest
		 * httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
		 * HttpServletRequest originalRequest =
		 * PortalUtil.getOriginalServletRequest(httpRequest);
		 * 
		 * String userIdStr = originalRequest.getParameter("userId"); String token =
		 * originalRequest.getParameter("token"); long userId = 0; if (userIdStr !=
		 * null) { userId = Long.parseLong(userIdStr); }
		 * 
		 * log.info("userId in verify Portlet: "+userId);
		 * log.info("token in verify Portlet: "+token);
		 * 
		 * renderRequest.setAttribute("userId", userId);
		 * renderRequest.setAttribute("token", token);
		 * 
		 * super.doView(renderRequest, renderResponse);
		 * 
		 * }
		 */
	 

    private static final Log log = LogFactoryUtil.getLog(VerifyEmailPortlet.class);

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {

        HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
        HttpServletRequest originalRequest = PortalUtil.getOriginalServletRequest(httpRequest);

        long userId = 0;
        String userIdStr = originalRequest.getParameter("userId");
        String token = originalRequest.getParameter("token");

        if (userIdStr != null) {
            userId = Long.parseLong(userIdStr);
        }

        log.info("VerifyPortlet - userId: " + userId + ", token: " + token);

        renderRequest.setAttribute("userId", userId);
        renderRequest.setAttribute("token", token);

        super.doView(renderRequest, renderResponse);
    }
}