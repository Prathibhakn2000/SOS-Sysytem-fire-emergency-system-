package EmergencyResponseTeamPortlet.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import EmergencyResponseTeamPortlet.constants.EmergencyResponseTeamPortletKeys;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + EmergencyResponseTeamPortletKeys.EMERGENCYRESPONSETEAM,
        "mvc.command.name=/view_members"
    },
    service = MVCRenderCommand.class
)
public class ViewMembersMVCRenderCommand implements MVCRenderCommand {

    private static final Log _log = LogFactoryUtil.getLog(ViewMembersMVCRenderCommand.class);

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

        long teamId = ParamUtil.getLong(renderRequest, "teamId");

        try {
            // ✅ Correct method for fetching users in a Team
            List<User> members = UserLocalServiceUtil.getTeamUsers(teamId);

            renderRequest.setAttribute("members", members);
            renderRequest.setAttribute("teamId", teamId);

            _log.info("✅ Loaded " + members.size() + " members for teamId=" + teamId);
        } catch (Exception e) {
            _log.error("❌ Error fetching members for teamId=" + teamId, e);
        }

        return "/view_members.jsp";
    }
}
