

package EmergencyResponseTeamPortlet.portlet;

import EmergencyResponseTeamPortlet.constants.EmergencyResponseTeamPortletKeys;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;
import com.liferay.portal.kernel.util.ParamUtil;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + EmergencyResponseTeamPortletKeys.EMERGENCYRESPONSETEAM,
        "mvc.command.name=/add_member"
    },
    service = MVCRenderCommand.class
)
public class AddMemberFormMVCRenderCommand implements MVCRenderCommand {
	
	   private static final Log log = LogFactoryUtil.getLog(AddMemberMVCActionCommand.class);

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
    	long userGroupId = ParamUtil.getLong(renderRequest, "userGroupId", 0);
    	if(userGroupId <= 0) {
    	    // optional: redirect to error page or log
    	    log.error("userGroupId missing in render request!");
    	}
    	renderRequest.setAttribute("userGroupId", userGroupId);
        return "/add_member.jsp";
    	
    
    		       
    		    }
    		}

    
