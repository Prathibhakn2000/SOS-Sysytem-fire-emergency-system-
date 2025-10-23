package EmergencyResponseTeamPortlet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;
import EmergencyResponseTeamPortlet.constants.EmergencyResponseTeamPortletKeys;
import com.liferay.portal.kernel.util.ParamUtil;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + EmergencyResponseTeamPortletKeys.EMERGENCYRESPONSETEAM,
        "mvc.command.name=/add_member"
    },
    service = MVCRenderCommand.class
)
public class AddMemberMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

        // ✅ Fetch userGroupId from request parameter (passed from previous page)
        long userGroupId = ParamUtil.getLong(renderRequest, "userGroupId");

        // ✅ Set it as a request attribute so JSP can access it
        renderRequest.setAttribute("userGroupId", userGroupId);

        return "/add_member.jsp";
    }
}
