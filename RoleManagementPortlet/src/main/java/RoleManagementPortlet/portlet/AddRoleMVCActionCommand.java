package RoleManagementPortlet.portlet;

import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import RoleManagementPortlet.constants.RoleManagementPortletKeys;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

@Component(
    property = {
        "javax.portlet.name=" + RoleManagementPortletKeys.ROLEMANAGEMENT,
        "mvc.command.name=/add_role"
    },
    service = MVCActionCommand.class
)
public class AddRoleMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long companyId = themeDisplay.getCompanyId();
        long userId = themeDisplay.getUserId();
        Locale siteLocale = themeDisplay.getLocale(); // ✅ Correct locale

        String roleName = ParamUtil.getString(actionRequest, "roleName");
        String description = ParamUtil.getString(actionRequest, "description");

        Map<Locale, String> titleMap = new HashMap<>();
        Map<Locale, String> descriptionMap = new HashMap<>();

        // ✅ Use ThemeDisplay locale instead of JVM locale
        descriptionMap.put(siteLocale, description);

        ServiceContext serviceContext = new ServiceContext();

        Role role = RoleLocalServiceUtil.addRole(
            userId,
            null,   // className (null for regular role)
            0,      // classPK (0 for regular)
            roleName,
            titleMap,
            descriptionMap,
            RoleConstants.TYPE_REGULAR,
            null,   // subtype
            serviceContext
        );

        System.out.println("✅ Role added successfully: " + role.getName());
        System.out.println("📘 Description saved: " + role.getDescription(siteLocale));
    }
}
