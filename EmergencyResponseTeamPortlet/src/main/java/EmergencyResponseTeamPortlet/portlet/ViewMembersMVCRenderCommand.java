package EmergencyResponseTeamPortlet.portlet;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import EmergencyResponseTeamPortlet.constants.EmergencyResponseTeamPortletKeys;

@Component(
    property = {
        "javax.portlet.name=" + EmergencyResponseTeamPortletKeys.EMERGENCYRESPONSETEAM,
        "mvc.command.name=/view_members"
    },
    service = MVCRenderCommand.class
)
public class ViewMembersMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

        try {
            String teamIdParam = renderRequest.getParameter("teamId");

            if (teamIdParam != null) {
                long teamId = Long.parseLong(teamIdParam);
                List<User> members = UserLocalServiceUtil.getUserGroupUsers(teamId);
                renderRequest.setAttribute("members", members);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/view_members.jsp"; // ✅ different page
    }
}
