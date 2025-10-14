package EmergencyResponseTeamPortlet.portlet;

import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import EmergencyResponseTeamPortlet.constants.EmergencyResponseTeamPortletKeys;

@Component(
    property = {
        "javax.portlet.name=" + EmergencyResponseTeamPortletKeys.EMERGENCYRESPONSETEAM,
        "mvc.command.name=/view_teams"
    },
    service = MVCRenderCommand.class
)
public class ViewTeamsMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long companyId = themeDisplay.getCompanyId();

        try {
            List<UserGroup> allGroups = UserGroupLocalServiceUtil.getUserGroups(-1, -1);
            List<UserGroup> teams = allGroups.stream()
                    .filter(group -> group.getCompanyId() == companyId)
                    .collect(Collectors.toList());

            renderRequest.setAttribute("teams", teams);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/view_teams.jsp"; // ✅ different page
    }
}
