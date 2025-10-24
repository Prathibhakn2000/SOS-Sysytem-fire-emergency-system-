package EmergencyResponseTeamPortlet.portlet;

import EmergencyResponseTeamPortlet.constants.EmergencyResponseTeamPortletKeys;
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
        "mvc.command.name=" + EmergencyResponseTeamPortletKeys.VIEW_TEAMS
    },
    service = MVCRenderCommand.class
)
public class ViewTeamsMVCRenderCommand implements MVCRenderCommand {
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
        List<UserGroup> userGroups = UserGroupLocalServiceUtil.getUserGroups(-1, -1);
        renderRequest.setAttribute("userGroups", userGroups);
        return "/view_teams.jsp";
    }
}
