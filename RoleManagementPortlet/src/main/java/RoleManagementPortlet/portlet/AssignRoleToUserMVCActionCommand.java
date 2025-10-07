package RoleManagementPortlet.portlet;

import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import RoleManagementPortlet.constants.RoleManagementPortletKeys;

@Component(
    property = {
        "javax.portlet.name=" + RoleManagementPortletKeys.ROLEMANAGEMENT,
        "mvc.command.name=/assign_user_to_role"
    },
    service = MVCActionCommand.class
)
public class AssignRoleToUserMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        long roleId = ParamUtil.getLong(actionRequest, "roleId");
        long userId = ParamUtil.getLong(actionRequest, "userId");

        System.out.println("Assigning userId=" + userId + " to roleId=" + roleId);

        // ✅ Check if user exists
        User user = UserLocalServiceUtil.fetchUser(userId);
        if (user == null) {
            System.out.println("User not found with ID: " + userId);
            return; // abort
        }

        // ✅ Check if role exists
        Role role = RoleLocalServiceUtil.fetchRole(roleId);
        if (role == null) {
            System.out.println("Role not found with ID: " + roleId);
            return; // abort
        }

        // ✅ Assign role to user
        UserLocalServiceUtil.addRoleUser(roleId, userId);

        System.out.println("User " + user.getFullName() + " assigned to role " + role.getName());
    }
}
