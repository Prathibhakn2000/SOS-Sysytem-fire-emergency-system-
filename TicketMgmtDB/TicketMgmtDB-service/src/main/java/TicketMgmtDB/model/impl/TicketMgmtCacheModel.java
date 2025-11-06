/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package TicketMgmtDB.model.impl;

import TicketMgmtDB.model.TicketMgmt;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TicketMgmt in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TicketMgmtCacheModel
	implements CacheModel<TicketMgmt>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TicketMgmtCacheModel)) {
			return false;
		}

		TicketMgmtCacheModel ticketMgmtCacheModel =
			(TicketMgmtCacheModel)object;

		if (ticket_id == ticketMgmtCacheModel.ticket_id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ticket_id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", ticket_id=");
		sb.append(ticket_id);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", busNumber=");
		sb.append(busNumber);
		sb.append(", fromLocation=");
		sb.append(fromLocation);
		sb.append(", toLocation=");
		sb.append(toLocation);
		sb.append(", journeyDate=");
		sb.append(journeyDate);
		sb.append(", seatNumber=");
		sb.append(seatNumber);
		sb.append(", fareAmount=");
		sb.append(fareAmount);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TicketMgmt toEntityModel() {
		TicketMgmtImpl ticketMgmtImpl = new TicketMgmtImpl();

		if (uuid == null) {
			ticketMgmtImpl.setUuid("");
		}
		else {
			ticketMgmtImpl.setUuid(uuid);
		}

		ticketMgmtImpl.setTicket_id(ticket_id);
		ticketMgmtImpl.setGroupId(groupId);
		ticketMgmtImpl.setCompanyId(companyId);
		ticketMgmtImpl.setUserId(userId);

		if (userName == null) {
			ticketMgmtImpl.setUserName("");
		}
		else {
			ticketMgmtImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			ticketMgmtImpl.setCreateDate(null);
		}
		else {
			ticketMgmtImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			ticketMgmtImpl.setModifiedDate(null);
		}
		else {
			ticketMgmtImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (busNumber == null) {
			ticketMgmtImpl.setBusNumber("");
		}
		else {
			ticketMgmtImpl.setBusNumber(busNumber);
		}

		if (fromLocation == null) {
			ticketMgmtImpl.setFromLocation("");
		}
		else {
			ticketMgmtImpl.setFromLocation(fromLocation);
		}

		if (toLocation == null) {
			ticketMgmtImpl.setToLocation("");
		}
		else {
			ticketMgmtImpl.setToLocation(toLocation);
		}

		if (journeyDate == Long.MIN_VALUE) {
			ticketMgmtImpl.setJourneyDate(null);
		}
		else {
			ticketMgmtImpl.setJourneyDate(new Date(journeyDate));
		}

		ticketMgmtImpl.setSeatNumber(seatNumber);
		ticketMgmtImpl.setFareAmount(fareAmount);

		ticketMgmtImpl.resetOriginalValues();

		return ticketMgmtImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		ticket_id = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		busNumber = objectInput.readUTF();
		fromLocation = objectInput.readUTF();
		toLocation = objectInput.readUTF();
		journeyDate = objectInput.readLong();

		seatNumber = objectInput.readInt();

		fareAmount = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(ticket_id);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (busNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(busNumber);
		}

		if (fromLocation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fromLocation);
		}

		if (toLocation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(toLocation);
		}

		objectOutput.writeLong(journeyDate);

		objectOutput.writeInt(seatNumber);

		objectOutput.writeLong(fareAmount);
	}

	public String uuid;
	public long ticket_id;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String busNumber;
	public String fromLocation;
	public String toLocation;
	public long journeyDate;
	public int seatNumber;
	public long fareAmount;

}