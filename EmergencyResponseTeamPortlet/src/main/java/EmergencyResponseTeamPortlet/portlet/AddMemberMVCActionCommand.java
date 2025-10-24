package EmergencyResponseTeamPortlet.portlet;

import EmergencyResponseTeamPortlet.constants.EmergencyResponseTeamPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;

import java.util.Locale;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import org.osgi.service.component.annotations.Component;

@Component(
    property = {
        "javax.portlet.name=" + EmergencyResponseTeamPortletKeys.EMERGENCYRESPONSETEAM,
        "mvc.command.name=/add_member_action"
    },
    service = MVCActionCommand.class
)
public class AddMemberMVCActionCommand implements MVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(AddMemberMVCActionCommand.class);

    @Override
    public boolean processAction(ActionRequest request, ActionResponse response) {
        try {
        	
        	long userGroupId = ParamUtil.getLong(request, "userGroupId");
        			log.info("userGroupId"+userGroupId);

            long companyId = PortalUtil.getCompanyId(request);
            long creatorUserId = PortalUtil.getUserId(request);

            String firstName = request.getParameter("firstName");
            
            log.info("firstName"+firstName);
            
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String screenName = request.getParameter("screenName");
            String password = request.getParameter("password");

            ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), request);

            User newUser = UserLocalServiceUtil.addUser(
                creatorUserId,
                companyId,
                false,
                password,
                password,
                false,
                screenName,
                email,
                Locale.getDefault(),
                firstName,
                "",
                lastName,
                0,
                0,
                true,
                1,
                1,
                1970,
                "",
                1, null,
                null,
                null,
                null,
                false,
                serviceContext
            );

            UserGroupLocalServiceUtil.addUserUserGroup(newUser.getUserId(), userGroupId);
            log.info("✅ Added new member: " + newUser.getFullName() + " to group ID: " + userGroupId);

            
            Indexer<User> indexer = IndexerRegistryUtil.nullSafeGetIndexer(User.class);
            indexer.reindex(newUser);
            
            
        } catch (Exception e) {
            log.error("Error adding member", e);
        }
        return true;
    }

}
