/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package TicketMgmtDB.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TicketMgmt}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketMgmt
 * @generated
 */
public class TicketMgmtWrapper
	extends BaseModelWrapper<TicketMgmt>
	implements ModelWrapper<TicketMgmt>, TicketMgmt {

	public TicketMgmtWrapper(TicketMgmt ticketMgmt) {
		super(ticketMgmt);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("ticket_id", getTicket_id());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("busNumber", getBusNumber());
		attributes.put("fromLocation", getFromLocation());
		attributes.put("toLocation", getToLocation());
		attributes.put("journeyDate", getJourneyDate());
		attributes.put("seatNumber", getSeatNumber());
		attributes.put("fareAmount", getFareAmount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long ticket_id = (Long)attributes.get("ticket_id");

		if (ticket_id != null) {
			setTicket_id(ticket_id);
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

		String busNumber = (String)attributes.get("busNumber");

		if (busNumber != null) {
			setBusNumber(busNumber);
		}

		String fromLocation = (String)attributes.get("fromLocation");

		if (fromLocation != null) {
			setFromLocation(fromLocation);
		}

		String toLocation = (String)attributes.get("toLocation");

		if (toLocation != null) {
			setToLocation(toLocation);
		}

		Date journeyDate = (Date)attributes.get("journeyDate");

		if (journeyDate != null) {
			setJourneyDate(journeyDate);
		}

		Integer seatNumber = (Integer)attributes.get("seatNumber");

		if (seatNumber != null) {
			setSeatNumber(seatNumber);
		}

		Long fareAmount = (Long)attributes.get("fareAmount");

		if (fareAmount != null) {
			setFareAmount(fareAmount);
		}
	}

	@Override
	public TicketMgmt cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the bus number of this ticket mgmt.
	 *
	 * @return the bus number of this ticket mgmt
	 */
	@Override
	public String getBusNumber() {
		return model.getBusNumber();
	}

	/**
	 * Returns the company ID of this ticket mgmt.
	 *
	 * @return the company ID of this ticket mgmt
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this ticket mgmt.
	 *
	 * @return the create date of this ticket mgmt
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the fare amount of this ticket mgmt.
	 *
	 * @return the fare amount of this ticket mgmt
	 */
	@Override
	public Long getFareAmount() {
		return model.getFareAmount();
	}

	/**
	 * Returns the from location of this ticket mgmt.
	 *
	 * @return the from location of this ticket mgmt
	 */
	@Override
	public String getFromLocation() {
		return model.getFromLocation();
	}

	/**
	 * Returns the group ID of this ticket mgmt.
	 *
	 * @return the group ID of this ticket mgmt
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the journey date of this ticket mgmt.
	 *
	 * @return the journey date of this ticket mgmt
	 */
	@Override
	public Date getJourneyDate() {
		return model.getJourneyDate();
	}

	/**
	 * Returns the modified date of this ticket mgmt.
	 *
	 * @return the modified date of this ticket mgmt
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this ticket mgmt.
	 *
	 * @return the primary key of this ticket mgmt
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the seat number of this ticket mgmt.
	 *
	 * @return the seat number of this ticket mgmt
	 */
	@Override
	public int getSeatNumber() {
		return model.getSeatNumber();
	}

	/**
	 * Returns the ticket_id of this ticket mgmt.
	 *
	 * @return the ticket_id of this ticket mgmt
	 */
	@Override
	public long getTicket_id() {
		return model.getTicket_id();
	}

	/**
	 * Returns the to location of this ticket mgmt.
	 *
	 * @return the to location of this ticket mgmt
	 */
	@Override
	public String getToLocation() {
		return model.getToLocation();
	}

	/**
	 * Returns the user ID of this ticket mgmt.
	 *
	 * @return the user ID of this ticket mgmt
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this ticket mgmt.
	 *
	 * @return the user name of this ticket mgmt
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this ticket mgmt.
	 *
	 * @return the user uuid of this ticket mgmt
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this ticket mgmt.
	 *
	 * @return the uuid of this ticket mgmt
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
	 * Sets the bus number of this ticket mgmt.
	 *
	 * @param busNumber the bus number of this ticket mgmt
	 */
	@Override
	public void setBusNumber(String busNumber) {
		model.setBusNumber(busNumber);
	}

	/**
	 * Sets the company ID of this ticket mgmt.
	 *
	 * @param companyId the company ID of this ticket mgmt
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this ticket mgmt.
	 *
	 * @param createDate the create date of this ticket mgmt
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the fare amount of this ticket mgmt.
	 *
	 * @param fareAmount the fare amount of this ticket mgmt
	 */
	@Override
	public void setFareAmount(Long fareAmount) {
		model.setFareAmount(fareAmount);
	}

	/**
	 * Sets the from location of this ticket mgmt.
	 *
	 * @param fromLocation the from location of this ticket mgmt
	 */
	@Override
	public void setFromLocation(String fromLocation) {
		model.setFromLocation(fromLocation);
	}

	/**
	 * Sets the group ID of this ticket mgmt.
	 *
	 * @param groupId the group ID of this ticket mgmt
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the journey date of this ticket mgmt.
	 *
	 * @param journeyDate the journey date of this ticket mgmt
	 */
	@Override
	public void setJourneyDate(Date journeyDate) {
		model.setJourneyDate(journeyDate);
	}

	/**
	 * Sets the modified date of this ticket mgmt.
	 *
	 * @param modifiedDate the modified date of this ticket mgmt
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this ticket mgmt.
	 *
	 * @param primaryKey the primary key of this ticket mgmt
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the seat number of this ticket mgmt.
	 *
	 * @param seatNumber the seat number of this ticket mgmt
	 */
	@Override
	public void setSeatNumber(int seatNumber) {
		model.setSeatNumber(seatNumber);
	}

	/**
	 * Sets the ticket_id of this ticket mgmt.
	 *
	 * @param ticket_id the ticket_id of this ticket mgmt
	 */
	@Override
	public void setTicket_id(long ticket_id) {
		model.setTicket_id(ticket_id);
	}

	/**
	 * Sets the to location of this ticket mgmt.
	 *
	 * @param toLocation the to location of this ticket mgmt
	 */
	@Override
	public void setToLocation(String toLocation) {
		model.setToLocation(toLocation);
	}

	/**
	 * Sets the user ID of this ticket mgmt.
	 *
	 * @param userId the user ID of this ticket mgmt
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this ticket mgmt.
	 *
	 * @param userName the user name of this ticket mgmt
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this ticket mgmt.
	 *
	 * @param userUuid the user uuid of this ticket mgmt
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this ticket mgmt.
	 *
	 * @param uuid the uuid of this ticket mgmt
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
	protected TicketMgmtWrapper wrap(TicketMgmt ticketMgmt) {
		return new TicketMgmtWrapper(ticketMgmt);
	}

}