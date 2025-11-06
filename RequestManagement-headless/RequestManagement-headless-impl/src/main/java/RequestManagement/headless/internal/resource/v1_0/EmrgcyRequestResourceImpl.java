package RequestManagement.headless.internal.resource.v1_0;

import RequestManagement.headless.dto.v1_0.EmrgcyRequest;
import RequestManagement.headless.resource.v1_0.EmrgcyRequestResource;

import RequestManagementDB.service.EmrgcyRequestLocalService;


import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.Validator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author prath
 */
@Component(
    properties = "OSGI-INF/liferay/rest/v1_0/emrgcy-request.properties",
    scope = ServiceScope.PROTOTYPE,
    service = EmrgcyRequestResource.class
)
public class EmrgcyRequestResourceImpl extends BaseEmrgcyRequestResourceImpl {

    private static final Log _log = LogFactoryUtil.getLog(EmrgcyRequestResourceImpl.class);

    /**
     * GET - Get all emergency requests
     */
    @Override
    public EmrgcyRequest getEmrgcyRequests() throws Exception {
        _log.info("Fetching all emergency requests...");

        // get list of ServiceBuilder model entities
        List<RequestManagementDB.model.EmrgcyRequest> models =
            _emrgcyRequestLocalService.getEmrgcyRequests(-1, -1);

        // Convert Service Builder models to DTOs
        List<RequestManagement.headless.dto.v1_0.EmrgcyRequest> dtoList =
            models.stream().map(this::toDTO).collect(Collectors.toList());

        // Wrap in a response DTO (you used this response pattern in your original code)
        RequestManagement.headless.dto.v1_0.EmrgcyRequest response =
            new RequestManagement.headless.dto.v1_0.EmrgcyRequest();
        response.setMessage("Emergency requests fetched successfully");
        response.setData(dtoList);

        return response;
    }

    /**
     * POST - Add a new emergency request
     */
    @Override
    public EmrgcyRequest addEmrgcyRequest(EmrgcyRequest emrgcyRequestDTO) throws Exception {
        _log.info("Adding new emergency request...");

        long userId = (contextUser != null) ? contextUser.getUserId() : 0L;
        long companyId = (contextCompany != null) ? contextCompany.getCompanyId() : 0L;
        Date now = new Date();

        // create model object (ServiceBuilder entity)
        RequestManagementDB.model.EmrgcyRequest model =
            _emrgcyRequestLocalService.createEmrgcyRequest(0);

        model.setCompanyId(companyId);
        model.setUserId(userId);
        model.setUserName(contextUser != null ? contextUser.getFullName() : null);
        model.setCreateDate(now);
        model.setModifiedDate(now);
        model.setTitle(emrgcyRequestDTO.getTitle());
        model.setDescription(emrgcyRequestDTO.getDescription());
        model.setLocation(emrgcyRequestDTO.getLocation());
        model.setStatus(emrgcyRequestDTO.getStatus());
        model.setAssignedTeam(emrgcyRequestDTO.getAssignedTeam());
        model.setRequesterUserId(emrgcyRequestDTO.getRequesterUserId());

        RequestManagementDB.model.EmrgcyRequest saved =
            _emrgcyRequestLocalService.addEmrgcyRequest(model);

        RequestManagement.headless.dto.v1_0.EmrgcyRequest response = toDTO(saved);
        response.setMessage("Emergency request added successfully");
        return response;
    }

    /**
     * PUT - Update an existing emergency request
     */
    @Override
    public EmrgcyRequest updateEmrgcyRequest(Long requestId, EmrgcyRequest emrgcyRequest)
            throws Exception {

        _log.info("Updating emergency request: " + requestId);

        RequestManagementDB.model.EmrgcyRequest existingRequest =
            _emrgcyRequestLocalService.fetchEmrgcyRequest(requestId);

        if (existingRequest == null) {
            throw new NoSuchElementException("No EmergencyRequest found with ID: " + requestId);
        }

        existingRequest.setTitle(emrgcyRequest.getTitle());
        existingRequest.setDescription(emrgcyRequest.getDescription());
        existingRequest.setLocation(emrgcyRequest.getLocation());
        existingRequest.setStatus(emrgcyRequest.getStatus());
        existingRequest.setAssignedTeam(emrgcyRequest.getAssignedTeam());
        existingRequest.setModifiedDate(new java.util.Date());

        existingRequest = _emrgcyRequestLocalService.updateEmrgcyRequest(existingRequest);

        return toDTO(existingRequest);
    }
    

    /**
     * DELETE - Delete emergency request by ID
     */
    @Override
    public EmrgcyRequest deleteEmrgcyRequest(Long requestId) throws Exception {
        _log.info("Deleting emergency request ID: " + requestId);

        try {
            _emrgcyRequestLocalService.deleteEmrgcyRequest(requestId);

            EmrgcyRequest response = new EmrgcyRequest();
            response.setMessage("Emergency request deleted successfully");
            return response;
        } catch (PortalException pe) {
            _log.error("Error deleting emergency request: " + requestId, pe);
            throw pe;
        }
    }

    /**
     * Convert ServiceBuilder entity to DTO
     */
    private RequestManagement.headless.dto.v1_0.EmrgcyRequest toDTO(
            RequestManagementDB.model.EmrgcyRequest entity) {

        RequestManagement.headless.dto.v1_0.EmrgcyRequest dto =
            new RequestManagement.headless.dto.v1_0.EmrgcyRequest();

        dto.setRequestId(entity.getRequestId());
        dto.setCompanyId(entity.getCompanyId());
        dto.setUserId(entity.getUserId());
        dto.setUserName(entity.getUserName());
        dto.setCreateDate(entity.getCreateDate());
        dto.setModifiedDate(entity.getModifiedDate());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setLocation(entity.getLocation());
        dto.setStatus(entity.getStatus());
        dto.setAssignedTeam(entity.getAssignedTeam());
        dto.setRequesterUserId(entity.getRequesterUserId());

        return dto;
    }
    
 

    /* =====================
       OSGi-injected service
       ===================== */
    @Reference
    private RequestManagementDB.service.EmrgcyRequestLocalService _emrgcyRequestLocalService;

    /**
     * Batch consumer setter override (single implementation)
     */
    @Override
    public void setContextBatchUnsafeBiConsumer(
            UnsafeBiConsumer<Collection<EmrgcyRequest>,
            UnsafeFunction<EmrgcyRequest, EmrgcyRequest, Exception>,
            Exception> contextBatchUnsafeBiConsumer) {
        // Not needed for now.
    }
    
    @Override
    public EmrgcyRequest patchEmrgcyRequest(Long requestId, EmrgcyRequest emrgcyRequest) throws Exception {

        // 1️⃣ Fetch the existing record from the DB
        RequestManagementDB.model.EmrgcyRequest existingRequest = _emrgcyRequestLocalService.getEmrgcyRequest(requestId);

        // 2️⃣ Update only fields that are non-null and meaningful
        if (Validator.isNotNull(emrgcyRequest.getTitle()) && !"string".equals(emrgcyRequest.getTitle())) {
            existingRequest.setTitle(emrgcyRequest.getTitle());
        }
        if (Validator.isNotNull(emrgcyRequest.getDescription()) && !"string".equals(emrgcyRequest.getDescription())) {
            existingRequest.setDescription(emrgcyRequest.getDescription());
        }
        if (Validator.isNotNull(emrgcyRequest.getStatus()) && !"string".equals(emrgcyRequest.getStatus())) {
            existingRequest.setStatus(emrgcyRequest.getStatus());
        }
        if (Validator.isNotNull(emrgcyRequest.getAssignedTeam()) && !"string".equals(emrgcyRequest.getAssignedTeam())) {
            existingRequest.setAssignedTeam(emrgcyRequest.getAssignedTeam());
        }
        if (Validator.isNotNull(emrgcyRequest.getLocation()) && !"string".equals(emrgcyRequest.getLocation())) {
            existingRequest.setLocation(emrgcyRequest.getLocation());
        }

        // 3️⃣ Always update modified date
        existingRequest.setModifiedDate(new Date());

        // 4️⃣ Save updates using Local Service
        existingRequest = _emrgcyRequestLocalService.updateEmrgcyRequest(existingRequest);

        // 5️⃣ Convert entity to DTO and return
        return toDTO(existingRequest);
    }
    
    
    
    /**
     * DELETE /emrgcy-requests/delete/batch
     * Custom batch delete implementation.
     */
    @AccessControlled(guestAccessEnabled = true)
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @DELETE
    @Path("/emrgcy-requests/delete/batch")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteEmrgcyRequestBatch(String requestBody) {
        try {
            // Parse JSON body as array of IDs
            JSONArray jsonArray = JSONFactoryUtil.createJSONArray(requestBody);

            if (jsonArray.length() == 0) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("{\"error\": \"Request body cannot be empty\"}")
                        .build();
            }

            int deletedCount = 0;

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);

                // Each object should contain requestId
                long requestId = obj.getLong("requestId");

                try {
                    _emrgcyRequestLocalService.deleteEmrgcyRequest(requestId);
                    deletedCount++;
                } catch (Exception e) {
                    _log.error("Failed to delete emergency request ID: " + requestId, e);
                }
            }

            JSONObject successResponse = JSONFactoryUtil.createJSONObject();
            successResponse.put("message", "Batch delete successful");
            successResponse.put("deletedCount", deletedCount);

            return Response.ok(successResponse.toString()).build();

        } catch (JSONException e) {
            _log.error("Invalid JSON format in batch delete request", e);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\": \"Invalid JSON format\"}")
                    .build();

        } catch (Exception e) {
            _log.error("Error deleting emergency requests in batch", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\": \"Batch delete failed\"}")
                    .build();
        }
    }


}