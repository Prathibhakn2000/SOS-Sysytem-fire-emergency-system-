package EmergencyResponseTeamPortlet.portlet;


import EmergencyResponseTeamPortlet.constants.EmergencyResponseTeamPortletKeys;

import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import org.osgi.service.component.annotations.Component;

@Component(
    property = {
        "javax.portlet.name=" + EmergencyResponseTeamPortletKeys.EMERGENCYRESPONSETEAM,
        "mvc.command.name=/delete_member"
    },
    service = MVCActionCommand.class
)

public class DeleteMemberMVCActionCommand extends BaseMVCActionCommand {
	@Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        long userId = ParamUtil.getLong(actionRequest, "userId");
        long userGroupId = ParamUtil.getLong(actionRequest, "userGroupId");

        try {
            UserLocalServiceUtil.deleteUserGroupUser(userGroupId, userId);
            SessionMessages.add(actionRequest, "memberRemoved");
        } catch (Exception e) {
            SessionErrors.add(actionRequest, "memberRemoveFailed");
        }

        // Redirect back to the team view
        actionResponse.setRenderParameter("mvcRenderCommandName", "/view_teams");
        actionResponse.setRenderParameter("userGroupId", String.valueOf(userGroupId));
    }

}
