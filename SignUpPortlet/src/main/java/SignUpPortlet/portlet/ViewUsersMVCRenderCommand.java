package SignUpPortlet.portlet;


import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import SignUpPortlet.constants.SignUpPortletKeys;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + SignUpPortletKeys.SIGNUP,
        "mvc.command.name=/user/view_users"
    },
    service = MVCRenderCommand.class
)
public class ViewUsersMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

        // Get all users
        List<User> users = UserLocalServiceUtil.getUsers(-1, -1);

        // Pass them to JSP
        renderRequest.setAttribute("users", users);

        return "/view.jsp"; // JSP file
    }
}



