package SignUpPortlet.portlet;


  import SignUpPortlet.constants.SignUpPortletKeys;
  
  import com.liferay.adaptive.media.exception.AMRuntimeException.IOException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.List;

import javax.portlet.ActionRequest; import javax.portlet.ActionResponse;
  import javax.portlet.Portlet; import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
 

	
	  
	/*
		 * @author prath
		 */
	 
		  @Component( property = {
		  "com.liferay.portlet.display-category=category.sample",
		  "com.liferay.portlet.header-portlet-css=/css/main.css",
		  "com.liferay.portlet.instanceable=true", "javax.portlet.display-name=SignUp",
		  "javax.portlet.init-param.template-path=/",
		  "javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" +
		  SignUpPortletKeys.SIGNUP, "javax.portlet.resource-bundle=content.Language",
		  "javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class
		  ) 
		  
		  public class SignUpPortlet extends MVCPortlet {
			  
			  
			  private static final Log _log = LogFactoryUtil.getLog(SignUpPortlet.class);
			  
			  @Override
			    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			            throws IOException, PortletException, java.io.IOException {

			        // Fetch all users
			        List<User> users = UserLocalServiceUtil.getUsers(-1, -1);

			        // Pass to JSP
			        renderRequest.setAttribute("users", users);

			        super.doView(renderRequest, renderResponse);
			    }
			 
		  }
		 
