package EmergencyRequestPortlet.portlet;

import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import EmergencyRequestDB.model.EmergencyRequest;
import EmergencyRequestDB.service.EmergencyRequestLocalServiceUtil;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.UUID;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=EmergencyRequestPortlet_EmergencyRequestPortlet",
        "mvc.command.name=submitEmergencyRequest"
    },
    service = MVCActionCommand.class
)
public class SubmitEmergencyRequestMVCActionCommand extends BaseMVCActionCommand {

    private static final Log _log = LogFactoryUtil.getLog(SubmitEmergencyRequestMVCActionCommand.class);

    @Reference
    private MimeTypes _mimeTypes;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        try {
            long userId = PortalUtil.getUserId(actionRequest);
            long groupId = PortalUtil.getScopeGroupId(actionRequest);
            ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);

            // Form fields
            String requestTitle = ParamUtil.getString(actionRequest, "requestTitle");
            String description = ParamUtil.getString(actionRequest, "description");
            String location = ParamUtil.getString(actionRequest, "location");
            String exactAddress = ParamUtil.getString(actionRequest, "exactAddress");

            // Handle file upload
            UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
            File file = uploadRequest.getFile("attachment");
            String attachmentPath = "";

            if (file != null && file.length() > 0) {
                String fileName = uploadRequest.getFileName("attachment");
                String mimeType = _mimeTypes.getContentType(file);
                long repositoryId = groupId;

                // Create folder if not exists
                Folder folder;
                try {
                    folder = DLAppLocalServiceUtil.getFolder(
                        repositoryId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "Emergency Attachments");
                } catch (Exception e) {
                    folder = DLAppLocalServiceUtil.addFolder(
                        mimeType, userId, repositoryId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
                        "Emergency Attachments",
                        "Folder for uploaded emergency request attachments",
                        serviceContext
                    );
                }

                // Generate unique ERC and unique file name
                String externalReferenceCode = UUID.randomUUID().toString();
                String uniqueFileName = System.currentTimeMillis() + "_" + fileName;

                // Upload file to DL safely
                DLAppLocalServiceUtil.addFileEntry(
                    externalReferenceCode, // ✅ unique ERC
                    userId,
                    repositoryId,
                    folder.getFolderId(),
                    uniqueFileName,
                    mimeType,
                    uniqueFileName,
                    "Emergency request attachment",
                    "",
                    uniqueFileName, new FileInputStream(file),
                    file.length(),
                    null, null, null, serviceContext
                );

                attachmentPath = "/documents/" + groupId + "/" + folder.getFolderId() + "/" + uniqueFileName;
            }

            // Save to custom table
            EmergencyRequest emergencyRequest = EmergencyRequestLocalServiceUtil.createEmergencyRequest(0);
            emergencyRequest.setUserId(userId);
            emergencyRequest.setGroupId(groupId);
            emergencyRequest.setCreateDate(new Date());
            emergencyRequest.setModifiedDate(new Date());
            emergencyRequest.setRequestTitle(requestTitle);
            emergencyRequest.setDescription(description);
            emergencyRequest.setLocation(location);
            emergencyRequest.setExactAddress(exactAddress);
            emergencyRequest.setAttachmentPath(attachmentPath);
            emergencyRequest.setStatus("Pending");

            EmergencyRequestLocalServiceUtil.addEmergencyRequest(emergencyRequest);

            _log.info("✅ Emergency request submitted successfully by userId: " + userId);

        } catch (Exception e) {
            _log.error("❌ Error while submitting emergency request: ", e);
        }
    }
}
