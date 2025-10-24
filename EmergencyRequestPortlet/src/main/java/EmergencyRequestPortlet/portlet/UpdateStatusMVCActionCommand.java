package EmergencyRequestPortlet.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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
        "mvc.command.name=update_status"
    },
    service = MVCActionCommand.class
)
public class UpdateStatusMVCActionCommand implements MVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(UpdateStatusMVCActionCommand.class);

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {

        long requestId = ParamUtil.getLong(actionRequest, "requestId");
        String status = ParamUtil.getString(actionRequest, "status");

        try {
            EmergencyRequest request = EmergencyRequestLocalServiceUtil.getEmergencyRequest(requestId);
            request.setStatus(status);
            request.setModifiedDate(new Date());

            EmergencyRequestLocalServiceUtil.updateEmergencyRequest(request);

            log.info("Request " + requestId + " updated to status: " + status);

        } catch (Exception e) {
            log.error("Error updating request status", e);
        }

        return true;
    }
}
