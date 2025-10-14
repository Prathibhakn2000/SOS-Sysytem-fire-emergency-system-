package EmergencyRequestPortlet.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import EmergencyRequestDB.model.EmergencyRequest;
import EmergencyRequestDB.service.EmergencyRequestLocalServiceUtil;

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

        List<EmergencyRequest> requests;

        // ✅ Check if logged-in user has permission to view all requests
        boolean hasViewAllPermission = false;
		try {
			hasViewAllPermission = RoleLocalServiceUtil.hasUserRole(userId, companyId, "Admin", true) ||
			RoleLocalServiceUtil.hasUserRole(userId, companyId, "Dispatcher", true) ||
			RoleLocalServiceUtil.hasUserRole(userId, companyId, "Team Leader", true);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        if (hasViewAllPermission) {
            // Admin or special roles → show all requests
            requests = EmergencyRequestLocalServiceUtil.getEmergencyRequests(-1, -1);
        } else {
            // Normal user → show only their own requests
            requests = EmergencyRequestLocalServiceUtil.getEmergencyRequestsByUserId(userId);
        }

        // Pass data to JSP
        renderRequest.setAttribute("requests", requests);

        return "/request_history.jsp";
    }
}
