package EmergencyRequestPortlet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import org.osgi.service.component.annotations.Component;
import EmergencyRequestDB.model.EmergencyRequest;
import EmergencyRequestDB.service.EmergencyRequestLocalServiceUtil;
import EmergencyRequestPortlet.constants.EmergencyRequestPortletKeys;

@Component(
    property = {
    		"javax.portlet.name=" + EmergencyRequestPortletKeys.EMERGENCYREQUEST,
        "mvc.command.name=verifyRequest"
    },
    service = MVCActionCommand.class
)
public class VerifyRequestMVCActionCommand extends BaseMVCActionCommand {

    private static final Log _log = LogFactoryUtil.getLog(VerifyRequestMVCActionCommand.class);

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        long requestId = ParamUtil.getLong(actionRequest, "requestId");
        String status = ParamUtil.getString(actionRequest, "status");

        EmergencyRequest req = EmergencyRequestLocalServiceUtil.getEmergencyRequest(requestId);
        req.setStatus(status);
        EmergencyRequestLocalServiceUtil.updateEmergencyRequest(req);

        _log.info("✅ Request " + requestId + " updated to status: " + status);
    }
}
