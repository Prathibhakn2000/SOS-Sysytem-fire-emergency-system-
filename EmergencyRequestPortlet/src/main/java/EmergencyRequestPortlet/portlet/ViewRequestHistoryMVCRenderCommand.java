package EmergencyRequestPortlet.portlet;

import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;

import EmergencyRequestDB.model.EmergencyRequest;
import EmergencyRequestDB.service.EmergencyRequestLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import EmergencyRequestPortlet.constants.EmergencyRequestPortletKeys;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + EmergencyRequestPortletKeys.EMERGENCYREQUEST,
        "mvc.command.name=/view_requests"
    },
    service = MVCRenderCommand.class
)
public class ViewRequestHistoryMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long userId = themeDisplay.getUserId();
        long companyId = themeDisplay.getCompanyId();

        List<EmergencyRequest> requests = new ArrayList<>();
        boolean isAdmin = false;
        try {
            // Check if user is Admin / Dispatcher / Team Leader
            isAdmin = RoleLocalServiceUtil.hasUserRole(userId, companyId, "Admin", true)
                   || RoleLocalServiceUtil.hasUserRole(userId, companyId, "Dispatcher", true)
                   || RoleLocalServiceUtil.hasUserRole(userId, companyId, "Team Leader", true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (isAdmin) {
            // Admin sees all requests
            requests = EmergencyRequestLocalServiceUtil.getEmergencyRequests(-1, -1);
        } else {
            // Team members see requests assigned to their teams
            List<UserGroup> userGroups = UserGroupLocalServiceUtil.getUserUserGroups(userId);
            for (UserGroup group : userGroups) {
                requests.addAll(EmergencyRequestLocalServiceUtil.getEmergencyRequestsByUserId(group.getUserGroupId()));
            }
        }

        renderRequest.setAttribute("requests", requests);
        renderRequest.setAttribute("isAdmin", isAdmin);
        renderRequest.setAttribute("userId", userId);

        return "/request_history.jsp";
    }
}
