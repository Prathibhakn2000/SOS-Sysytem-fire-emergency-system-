package RoleManagementPortlet.portlet;

import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import RoleManagementPortlet.constants.RoleManagementPortletKeys;

@Component(
    property = {
        "javax.portlet.name=" + RoleManagementPortletKeys.ROLEMANAGEMENT,
        "mvc.command.name=/delete_role"
    },
    service = MVCActionCommand.class
)
public class DeleteRoleMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        long roleId = ParamUtil.getLong(actionRequest, "roleId");
        RoleLocalServiceUtil.deleteRole(roleId);
    }
}
