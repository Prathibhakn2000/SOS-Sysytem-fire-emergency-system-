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
    immediate = true,
    property = {
    		"javax.portlet.name=" + EmergencyResponseTeamPortletKeys.EMERGENCYRESPONSETEAM, // replace with your actual portlet name
        "mvc.command.name=/view_user_groups"
    },
    service = MVCRenderCommand.class
)
public class ViewUserGroupsMVCRenderCommand implements MVCRenderCommand {

	@Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long companyId = themeDisplay.getCompanyId();

        // ✅ Universal method — fetch all user groups
        List<UserGroup> allGroups = UserGroupLocalServiceUtil.getUserGroups(-1, -1);

        // ✅ Filter only groups from the current company
        List<UserGroup> userGroups = allGroups.stream()
                .filter(g -> g.getCompanyId() == companyId)
                .collect(Collectors.toList());

        System.out.println(">>> Found User Groups: " + userGroups.size());

        renderRequest.setAttribute("userGroups", userGroups);

        return "/view.jsp";
    }
}