/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package EmergencyRequestDB.model.impl;

import EmergencyRequestDB.model.EmergencyRequest;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmergencyRequest in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmergencyRequestCacheModel
	implements CacheModel<EmergencyRequest>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmergencyRequestCacheModel)) {
			return false;
		}

		EmergencyRequestCacheModel emergencyRequestCacheModel =
			(EmergencyRequestCacheModel)object;

		if (requestId == emergencyRequestCacheModel.requestId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, requestId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", requestId=");
		sb.append(requestId);
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
		sb.append(", requestTitle=");
		sb.append(requestTitle);
		sb.append(", description=");
		sb.append(description);
		sb.append(", location=");
		sb.append(location);
		sb.append(", exactAddress=");
		sb.append(exactAddress);
		sb.append(", attachmentPath=");
		sb.append(attachmentPath);
		sb.append(", status=");
		sb.append(status);
		sb.append(", allocatedTeamId=");
		sb.append(allocatedTeamId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmergencyRequest toEntityModel() {
		EmergencyRequestImpl emergencyRequestImpl = new EmergencyRequestImpl();

		if (uuid == null) {
			emergencyRequestImpl.setUuid("");
		}
		else {
			emergencyRequestImpl.setUuid(uuid);
		}

		emergencyRequestImpl.setRequestId(requestId);
		emergencyRequestImpl.setGroupId(groupId);
		emergencyRequestImpl.setCompanyId(companyId);
		emergencyRequestImpl.setUserId(userId);

		if (userName == null) {
			emergencyRequestImpl.setUserName("");
		}
		else {
			emergencyRequestImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			emergencyRequestImpl.setCreateDate(null);
		}
		else {
			emergencyRequestImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			emergencyRequestImpl.setModifiedDate(null);
		}
		else {
			emergencyRequestImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (requestTitle == null) {
			emergencyRequestImpl.setRequestTitle("");
		}
		else {
			emergencyRequestImpl.setRequestTitle(requestTitle);
		}

		if (description == null) {
			emergencyRequestImpl.setDescription("");
		}
		else {
			emergencyRequestImpl.setDescription(description);
		}

		if (location == null) {
			emergencyRequestImpl.setLocation("");
		}
		else {
			emergencyRequestImpl.setLocation(location);
		}

		if (exactAddress == null) {
			emergencyRequestImpl.setExactAddress("");
		}
		else {
			emergencyRequestImpl.setExactAddress(exactAddress);
		}

		if (attachmentPath == null) {
			emergencyRequestImpl.setAttachmentPath("");
		}
		else {
			emergencyRequestImpl.setAttachmentPath(attachmentPath);
		}

		if (status == null) {
			emergencyRequestImpl.setStatus("");
		}
		else {
			emergencyRequestImpl.setStatus(status);
		}

		emergencyRequestImpl.setAllocatedTeamId(allocatedTeamId);

		emergencyRequestImpl.resetOriginalValues();

		return emergencyRequestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		requestId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		requestTitle = objectInput.readUTF();
		description = objectInput.readUTF();
		location = objectInput.readUTF();
		exactAddress = objectInput.readUTF();
		attachmentPath = objectInput.readUTF();
		status = objectInput.readUTF();

		allocatedTeamId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(requestId);

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

		if (requestTitle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(requestTitle);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (location == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(location);
		}

		if (exactAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(exactAddress);
		}

		if (attachmentPath == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(attachmentPath);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeLong(allocatedTeamId);
	}

	public String uuid;
	public long requestId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String requestTitle;
	public String description;
	public String location;
	public String exactAddress;
	public String attachmentPath;
	public String status;
	public long allocatedTeamId;

}