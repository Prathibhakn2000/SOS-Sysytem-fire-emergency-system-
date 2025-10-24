package EmergencyResponseTeamPortlet.portlet;

import EmergencyResponseTeamPortlet.constants.EmergencyResponseTeamPortletKeys;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import java.util.List;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;

@Component(
    property = {
        "javax.portlet.name=" + EmergencyResponseTeamPortletKeys.EMERGENCYRESPONSETEAM,
        "mvc.command.name=" + EmergencyResponseTeamPortletKeys.VIEW_MEMBERS
    },
    service = MVCRenderCommand.class
)
public class ViewMembersMVCRenderCommand implements MVCRenderCommand {
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
        long userGroupId = Long.parseLong(renderRequest.getParameter("userGroupId"));
        UserGroup userGroup = UserGroupLocalServiceUtil.fetchUserGroup(userGroupId);
        List<User> users = com.liferay.portal.kernel.service.UserLocalServiceUtil.getUserGroupUsers(userGroupId);


        renderRequest.setAttribute("team", userGroup);
        renderRequest.setAttribute("members", users);

        return "/view_members.jsp";
    }
}
