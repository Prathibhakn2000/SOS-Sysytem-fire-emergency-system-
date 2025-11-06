/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package RequestManagementDB.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EmrgcyRequest}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmrgcyRequest
 * @generated
 */
public class EmrgcyRequestWrapper
	extends BaseModelWrapper<EmrgcyRequest>
	implements EmrgcyRequest, ModelWrapper<EmrgcyRequest> {

	public EmrgcyRequestWrapper(EmrgcyRequest emrgcyRequest) {
		super(emrgcyRequest);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("requestId", getRequestId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("location", getLocation());
		attributes.put("status", getStatus());
		attributes.put("assignedTeam", getAssignedTeam());
		attributes.put("requesterUserId", getRequesterUserId());

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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String assignedTeam = (String)attributes.get("assignedTeam");

		if (assignedTeam != null) {
			setAssignedTeam(assignedTeam);
		}

		Long requesterUserId = (Long)attributes.get("requesterUserId");

		if (requesterUserId != null) {
			setRequesterUserId(requesterUserId);
		}
	}

	@Override
	public EmrgcyRequest cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the assigned team of this emrgcy request.
	 *
	 * @return the assigned team of this emrgcy request
	 */
	@Override
	public String getAssignedTeam() {
		return model.getAssignedTeam();
	}

	/**
	 * Returns the company ID of this emrgcy request.
	 *
	 * @return the company ID of this emrgcy request
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this emrgcy request.
	 *
	 * @return the create date of this emrgcy request
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this emrgcy request.
	 *
	 * @return the description of this emrgcy request
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the location of this emrgcy request.
	 *
	 * @return the location of this emrgcy request
	 */
	@Override
	public String getLocation() {
		return model.getLocation();
	}

	/**
	 * Returns the modified date of this emrgcy request.
	 *
	 * @return the modified date of this emrgcy request
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this emrgcy request.
	 *
	 * @return the primary key of this emrgcy request
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the requester user ID of this emrgcy request.
	 *
	 * @return the requester user ID of this emrgcy request
	 */
	@Override
	public long getRequesterUserId() {
		return model.getRequesterUserId();
	}

	/**
	 * Returns the requester user uuid of this emrgcy request.
	 *
	 * @return the requester user uuid of this emrgcy request
	 */
	@Override
	public String getRequesterUserUuid() {
		return model.getRequesterUserUuid();
	}

	/**
	 * Returns the request ID of this emrgcy request.
	 *
	 * @return the request ID of this emrgcy request
	 */
	@Override
	public long getRequestId() {
		return model.getRequestId();
	}

	/**
	 * Returns the status of this emrgcy request.
	 *
	 * @return the status of this emrgcy request
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the title of this emrgcy request.
	 *
	 * @return the title of this emrgcy request
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this emrgcy request.
	 *
	 * @return the user ID of this emrgcy request
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this emrgcy request.
	 *
	 * @return the user name of this emrgcy request
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this emrgcy request.
	 *
	 * @return the user uuid of this emrgcy request
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this emrgcy request.
	 *
	 * @return the uuid of this emrgcy request
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
	 * Sets the assigned team of this emrgcy request.
	 *
	 * @param assignedTeam the assigned team of this emrgcy request
	 */
	@Override
	public void setAssignedTeam(String assignedTeam) {
		model.setAssignedTeam(assignedTeam);
	}

	/**
	 * Sets the company ID of this emrgcy request.
	 *
	 * @param companyId the company ID of this emrgcy request
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this emrgcy request.
	 *
	 * @param createDate the create date of this emrgcy request
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this emrgcy request.
	 *
	 * @param description the description of this emrgcy request
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the location of this emrgcy request.
	 *
	 * @param location the location of this emrgcy request
	 */
	@Override
	public void setLocation(String location) {
		model.setLocation(location);
	}

	/**
	 * Sets the modified date of this emrgcy request.
	 *
	 * @param modifiedDate the modified date of this emrgcy request
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this emrgcy request.
	 *
	 * @param primaryKey the primary key of this emrgcy request
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the requester user ID of this emrgcy request.
	 *
	 * @param requesterUserId the requester user ID of this emrgcy request
	 */
	@Override
	public void setRequesterUserId(long requesterUserId) {
		model.setRequesterUserId(requesterUserId);
	}

	/**
	 * Sets the requester user uuid of this emrgcy request.
	 *
	 * @param requesterUserUuid the requester user uuid of this emrgcy request
	 */
	@Override
	public void setRequesterUserUuid(String requesterUserUuid) {
		model.setRequesterUserUuid(requesterUserUuid);
	}

	/**
	 * Sets the request ID of this emrgcy request.
	 *
	 * @param requestId the request ID of this emrgcy request
	 */
	@Override
	public void setRequestId(long requestId) {
		model.setRequestId(requestId);
	}

	/**
	 * Sets the status of this emrgcy request.
	 *
	 * @param status the status of this emrgcy request
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the title of this emrgcy request.
	 *
	 * @param title the title of this emrgcy request
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this emrgcy request.
	 *
	 * @param userId the user ID of this emrgcy request
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this emrgcy request.
	 *
	 * @param userName the user name of this emrgcy request
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this emrgcy request.
	 *
	 * @param userUuid the user uuid of this emrgcy request
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this emrgcy request.
	 *
	 * @param uuid the uuid of this emrgcy request
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
	protected EmrgcyRequestWrapper wrap(EmrgcyRequest emrgcyRequest) {
		return new EmrgcyRequestWrapper(emrgcyRequest);
	}

}