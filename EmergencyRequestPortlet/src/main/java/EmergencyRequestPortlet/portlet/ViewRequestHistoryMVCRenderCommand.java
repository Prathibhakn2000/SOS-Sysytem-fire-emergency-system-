package EmergencyRequestPortlet.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import EmergencyRequestDB.model.EmergencyRequest;
import EmergencyRequestDB.service.EmergencyRequestLocalServiceUtil;
import EmergencyRequestPortlet.constants.EmergencyRequestPortletKeys;

import org.osgi.service.component.annotations.Component;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import java.util.ArrayList;
import java.util.List;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + EmergencyRequestPortletKeys.EMERGENCYREQUEST,
        "mvc.command.name=/view_requests"
    },
    service = MVCRenderCommand.class
)
public class ViewRequestHistoryMVCRenderCommand implements MVCRenderCommand {

    private static final Log _log = LogFactoryUtil.getLog(ViewRequestHistoryMVCRenderCommand.class);

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
        try {
            ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
            long userId = themeDisplay.getUserId();
            long companyId = themeDisplay.getCompanyId();

            User user = UserLocalServiceUtil.getUser(userId);
            _log.info("User logged in: ID=" + userId + ", Name=" + user.getFullName());

            List<EmergencyRequest> requests = new ArrayList<>();

            // Check roles
            boolean isAdmin = RoleLocalServiceUtil.hasUserRole(userId, companyId, "Admin", true);
            boolean isDispatcher = RoleLocalServiceUtil.hasUserRole(userId, companyId, "Dispatcher", true);
            boolean isTeamLeader = RoleLocalServiceUtil.hasUserRole(userId, companyId, "Team Leader", true);
            boolean isTeamMember = RoleLocalServiceUtil.hasUserRole(userId, companyId, "Team Member", true);

            _log.info("Roles → Admin: " + isAdmin + ", Dispatcher: " + isDispatcher + ", Team Leader: " + isTeamLeader + ", Team Member: " + isTeamMember);

            // Fetch all requests
            List<EmergencyRequest> allRequests = EmergencyRequestLocalServiceUtil.getEmergencyRequests(-1, -1);
            _log.info("Total requests in system: " + allRequests.size());

            if (isAdmin || isDispatcher || isTeamLeader) {
                // Admin/Dispatcher/Team Leader → see all requests
                requests = allRequests;
                _log.info("User sees ALL requests.");
            } else if (isTeamMember) {
                // Team member → see only requests assigned to their team(s)
                List<UserGroup> userGroups = UserGroupLocalServiceUtil.getUserUserGroups(userId);
                List<Long> userGroupIds = new ArrayList<>();
                for (UserGroup group : userGroups) {
                    userGroupIds.add(group.getUserGroupId());
                    _log.info("User belongs to UserGroup: " + group.getName() + " (ID=" + group.getUserGroupId() + ")");
                }

                for (EmergencyRequest req : allRequests) {
                    if (req.getAllocatedTeamId() > 0 && userGroupIds.contains(req.getAllocatedTeamId())) {
                        requests.add(req);
                        _log.info("Assigned request added: RequestID=" + req.getRequestId() + ", AllocatedTeamID=" + req.getAllocatedTeamId());
                    }
                }

                _log.info("Total requests visible to team member: " + requests.size());

            } else {
                // Normal user → see only their own requests
                for (EmergencyRequest req : allRequests) {
                    if (req.getUserId() == userId) {
                        requests.add(req);
                        _log.info("User's own request added: RequestID=" + req.getRequestId());
                    }
                }
                _log.info("Total requests visible to normal user: " + requests.size());
            }

            renderRequest.setAttribute("requests", requests);

        } catch (Exception e) {
            _log.error("Error loading emergency requests", e);
        }

        return "/request_history.jsp";
    }
}
