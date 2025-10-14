package EmergencyRequestPortlet.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import EmergencyRequestDB.model.EmergencyRequest;
import EmergencyRequestDB.service.EmergencyRequestLocalServiceUtil;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import EmergencyRequestPortlet.constants.EmergencyRequestPortletKeys;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + EmergencyRequestPortletKeys.EMERGENCYREQUEST,
        "mvc.command.name=allocateTeam"
    },
    service = MVCActionCommand.class
)
public class AllocateTeamMVCActionCommand extends BaseMVCActionCommand {

    private static final Log _log = LogFactoryUtil.getLog(AllocateTeamMVCActionCommand.class);

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        long requestId = ParamUtil.getLong(actionRequest, "requestId");
        long teamId = ParamUtil.getLong(actionRequest, "teamId");

        try {
            EmergencyRequest request = EmergencyRequestLocalServiceUtil.getEmergencyRequest(requestId);
            request.setAllocatedTeamId(teamId);
            request.setStatus("Assigned");
            request.setModifiedDate(new Date());

            EmergencyRequestLocalServiceUtil.updateEmergencyRequest(request);

            _log.info("✅ Request ID " + requestId + " assigned to team ID " + teamId);

        } catch (Exception e) {
            _log.error("❌ Error allocating team: ", e);
        }
    }
}
