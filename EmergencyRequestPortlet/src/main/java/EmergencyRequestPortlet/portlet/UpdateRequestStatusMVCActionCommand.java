package EmergencyRequestPortlet.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import EmergencyRequestDB.model.EmergencyRequest;
import EmergencyRequestDB.service.EmergencyRequestLocalServiceUtil;
import org.osgi.service.component.annotations.Component;
import EmergencyRequestPortlet.constants.EmergencyRequestPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.util.Date;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + EmergencyRequestPortletKeys.EMERGENCYREQUEST,
        "mvc.command.name=updateStatus"
    },
    service = MVCActionCommand.class
)
public class UpdateRequestStatusMVCActionCommand extends BaseMVCActionCommand {

    private static final Log _log = LogFactoryUtil.getLog(UpdateRequestStatusMVCActionCommand.class);

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        long requestId = ParamUtil.getLong(actionRequest, "requestId");
        String status = ParamUtil.getString(actionRequest, "status");

        try {
            EmergencyRequest request = EmergencyRequestLocalServiceUtil.getEmergencyRequest(requestId);
            request.setStatus(status);
            request.setModifiedDate(new Date());

            EmergencyRequestLocalServiceUtil.updateEmergencyRequest(request);
            _log.info("✅ Request " + requestId + " status updated to: " + status);
        } catch (Exception e) {
            _log.error("❌ Error updating request status: ", e);
        }
    }
}
