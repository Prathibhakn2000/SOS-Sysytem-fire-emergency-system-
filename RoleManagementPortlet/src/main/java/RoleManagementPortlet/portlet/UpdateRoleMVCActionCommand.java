package RoleManagementPortlet.portlet;

import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import RoleManagementPortlet.constants.RoleManagementPortletKeys;

@Component(
    property = {
        "javax.portlet.name=" + RoleManagementPortletKeys.ROLEMANAGEMENT,
        "mvc.command.name=/update_role"
    },
    service = MVCActionCommand.class
)
public class UpdateRoleMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        long roleId = ParamUtil.getLong(actionRequest, "roleId");
        String roleName = ParamUtil.getString(actionRequest, "roleName");
        String description = ParamUtil.getString(actionRequest, "description");

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        Role role = RoleLocalServiceUtil.getRole(roleId);

        role.setName(roleName);

        // ✅ Save description as localized map
        Map<Locale, String> descriptionMap = new HashMap<>();
        descriptionMap.put(themeDisplay.getLocale(), description);
        role.setDescriptionMap(descriptionMap);

        RoleLocalServiceUtil.updateRole(role);
    }
}
