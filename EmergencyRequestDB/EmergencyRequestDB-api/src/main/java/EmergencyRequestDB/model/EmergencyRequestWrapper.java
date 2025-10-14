/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package EmergencyRequestDB.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EmergencyRequest}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmergencyRequest
 * @generated
 */
public class EmergencyRequestWrapper
	extends BaseModelWrapper<EmergencyRequest>
	implements EmergencyRequest, ModelWrapper<EmergencyRequest> {

	public EmergencyRequestWrapper(EmergencyRequest emergencyRequest) {
		super(emergencyRequest);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("requestId", getRequestId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("requestTitle", getRequestTitle());
		attributes.put("description", getDescription());
		attributes.put("location", getLocation());
		attributes.put("exactAddress", getExactAddress());
		attributes.put("attachmentPath", getAttachmentPath());
		attributes.put("status", getStatus());
		attributes.put("allocatedTeamId", getAllocatedTeamId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long requestId = (Long)attributes.get("requestId");

		if (requestId != null) {
			setRequestId(requestId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String requestTitle = (String)attributes.get("requestTitle");

		if (requestTitle != null) {
			setRequestTitle(requestTitle);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		String exactAddress = (String)attributes.get("exactAddress");

		if (exactAddress != null) {
			setExactAddress(exactAddress);
		}

		String attachmentPath = (String)attributes.get("attachmentPath");

		if (attachmentPath != null) {
			setAttachmentPath(attachmentPath);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long allocatedTeamId = (Long)attributes.get("allocatedTeamId");

		if (allocatedTeamId != null) {
			setAllocatedTeamId(allocatedTeamId);
		}
	}

	@Override
	public EmergencyRequest cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the allocated team ID of this emergency request.
	 *
	 * @return the allocated team ID of this emergency request
	 */
	@Override
	public long getAllocatedTeamId() {
		return model.getAllocatedTeamId();
	}

	/**
	 * Returns the attachment path of this emergency request.
	 *
	 * @return the attachment path of this emergency request
	 */
	@Override
	public String getAttachmentPath() {
		return model.getAttachmentPath();
	}

	/**
	 * Returns the company ID of this emergency request.
	 *
	 * @return the company ID of this emergency request
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this emergency request.
	 *
	 * @return the create date of this emergency request
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this emergency request.
	 *
	 * @return the description of this emergency request
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the exact address of this emergency request.
	 *
	 * @return the exact address of this emergency request
	 */
	@Override
	public String getExactAddress() {
		return model.getExactAddress();
	}

	/**
	 * Returns the group ID of this emergency request.
	 *
	 * @return the group ID of this emergency request
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the location of this emergency request.
	 *
	 * @return the location of this emergency request
	 */
	@Override
	public String getLocation() {
		return model.getLocation();
	}

	/**
	 * Returns the modified date of this emergency request.
	 *
	 * @return the modified date of this emergency request
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this emergency request.
	 *
	 * @return the primary key of this emergency request
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the request ID of this emergency request.
	 *
	 * @return the request ID of this emergency request
	 */
	@Override
	public long getRequestId() {
		return model.getRequestId();
	}

	/**
	 * Returns the request title of this emergency request.
	 *
	 * @return the request title of this emergency request
	 */
	@Override
	public String getRequestTitle() {
		return model.getRequestTitle();
	}

	/**
	 * Returns the status of this emergency request.
	 *
	 * @return the status of this emergency request
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this emergency request.
	 *
	 * @return the user ID of this emergency request
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this emergency request.
	 *
	 * @return the user name of this emergency request
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this emergency request.
	 *
	 * @return the user uuid of this emergency request
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this emergency request.
	 *
	 * @return the uuid of this emergency request
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the allocated team ID of this emergency request.
	 *
	 * @param allocatedTeamId the allocated team ID of this emergency request
	 */
	@Override
	public void setAllocatedTeamId(long allocatedTeamId) {
		model.setAllocatedTeamId(allocatedTeamId);
	}

	/**
	 * Sets the attachment path of this emergency request.
	 *
	 * @param attachmentPath the attachment path of this emergency request
	 */
	@Override
	public void setAttachmentPath(String attachmentPath) {
		model.setAttachmentPath(attachmentPath);
	}

	/**
	 * Sets the company ID of this emergency request.
	 *
	 * @param companyId the company ID of this emergency request
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this emergency request.
	 *
	 * @param createDate the create date of this emergency request
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this emergency request.
	 *
	 * @param description the description of this emergency request
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the exact address of this emergency request.
	 *
	 * @param exactAddress the exact address of this emergency request
	 */
	@Override
	public void setExactAddress(String exactAddress) {
		model.setExactAddress(exactAddress);
	}

	/**
	 * Sets the group ID of this emergency request.
	 *
	 * @param groupId the group ID of this emergency request
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the location of this emergency request.
	 *
	 * @param location the location of this emergency request
	 */
	@Override
	public void setLocation(String location) {
		model.setLocation(location);
	}

	/**
	 * Sets the modified date of this emergency request.
	 *
	 * @param modifiedDate the modified date of this emergency request
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this emergency request.
	 *
	 * @param primaryKey the primary key of this emergency request
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the request ID of this emergency request.
	 *
	 * @param requestId the request ID of this emergency request
	 */
	@Override
	public void setRequestId(long requestId) {
		model.setRequestId(requestId);
	}

	/**
	 * Sets the request title of this emergency request.
	 *
	 * @param requestTitle the request title of this emergency request
	 */
	@Override
	public void setRequestTitle(String requestTitle) {
		model.setRequestTitle(requestTitle);
	}

	/**
	 * Sets the status of this emergency request.
	 *
	 * @param status the status of this emergency request
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this emergency request.
	 *
	 * @param userId the user ID of this emergency request
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this emergency request.
	 *
	 * @param userName the user name of this emergency request
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this emergency request.
	 *
	 * @param userUuid the user uuid of this emergency request
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this emergency request.
	 *
	 * @param uuid the uuid of this emergency request
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected EmergencyRequestWrapper wrap(EmergencyRequest emergencyRequest) {
		return new EmergencyRequestWrapper(emergencyRequest);
	}

}