package EmergencyResponseTeamPortlet.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import java.util.Locale;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import org.osgi.service.component.annotations.Component;
import EmergencyResponseTeamPortlet.constants.EmergencyResponseTeamPortletKeys;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + EmergencyResponseTeamPortletKeys.EMERGENCYRESPONSETEAM,
        "mvc.command.name=/add_member"
    },
    service = MVCActionCommand.class
)
public class AddMemberMVCActionCommand implements MVCActionCommand {

    private static final Log _log = LogFactoryUtil.getLog(AddMemberMVCActionCommand.class);

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        long companyId = themeDisplay.getCompanyId();
        long creatorUserId = themeDisplay.getUserId();
        Locale locale = themeDisplay.getLocale();
        long siteGroupId = themeDisplay.getScopeGroupId();

        // ✅ Fetch the User Group ID from the request
        long userGroupId = ParamUtil.getLong(actionRequest, "userGroupId");

        // ✅ Validation: make sure it's a valid User Group
        if (userGroupId <= 0) {
            _log.error("❌ Invalid userGroupId: " + userGroupId);
            return false; // stop processing if invalid
        }

        String firstName = ParamUtil.getString(actionRequest, "firstName");
        String lastName = ParamUtil.getString(actionRequest, "lastName");
        String email = ParamUtil.getString(actionRequest, "emailAddress");
        String password = ParamUtil.getString(actionRequest, "password");

        try {
            ServiceContext serviceContext = new ServiceContext();
            serviceContext.setScopeGroupId(siteGroupId);
            serviceContext.setCompanyId(companyId);

            long[] emptyArray = new long[0];

            // Create user
            User user = UserLocalServiceUtil.addUser(
                    creatorUserId,
                    companyId,
                    false,
                    password,
                    password,
                    false,
                    email.split("@")[0],
                    email,
                    locale,
                    firstName,
                    "",
                    lastName,
                    0, 0, true,
                    1, 1, 2000,
                    "", 1,
                    emptyArray, emptyArray, emptyArray, emptyArray,
                    false,
                    serviceContext
            );

            // Add user to the site
            UserLocalServiceUtil.addGroupUsers(siteGroupId, new long[]{user.getUserId()});

            // Add user to the User Group
            UserGroupLocalServiceUtil.addUserUserGroup(user.getUserId(), userGroupId);

            _log.info("✅ Added member " + user.getFullName() + " to userGroupId=" + userGroupId);

            actionResponse.setRenderParameter("mvcRenderCommandName", "/view_members");
            actionResponse.setRenderParameter("userGroupId", String.valueOf(userGroupId));

        } catch (Exception e) {
            _log.error("❌ Error adding member to userGroupId=" + userGroupId, e);
        }

        return true;
    }

}
