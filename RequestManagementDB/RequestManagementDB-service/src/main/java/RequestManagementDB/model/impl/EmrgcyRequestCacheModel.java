/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package RequestManagementDB.model.impl;

import RequestManagementDB.model.EmrgcyRequest;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmrgcyRequest in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmrgcyRequestCacheModel
	implements CacheModel<EmrgcyRequest>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmrgcyRequestCacheModel)) {
			return false;
		}

		EmrgcyRequestCacheModel emrgcyRequestCacheModel =
			(EmrgcyRequestCacheModel)object;

		if (requestId == emrgcyRequestCacheModel.requestId) {
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
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", requestId=");
		sb.append(requestId);
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
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", location=");
		sb.append(location);
		sb.append(", status=");
		sb.append(status);
		sb.append(", assignedTeam=");
		sb.append(assignedTeam);
		sb.append(", requesterUserId=");
		sb.append(requesterUserId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmrgcyRequest toEntityModel() {
		EmrgcyRequestImpl emrgcyRequestImpl = new EmrgcyRequestImpl();

		if (uuid == null) {
			emrgcyRequestImpl.setUuid("");
		}
		else {
			emrgcyRequestImpl.setUuid(uuid);
		}

		emrgcyRequestImpl.setRequestId(requestId);
		emrgcyRequestImpl.setCompanyId(companyId);
		emrgcyRequestImpl.setUserId(userId);

		if (userName == null) {
			emrgcyRequestImpl.setUserName("");
		}
		else {
			emrgcyRequestImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			emrgcyRequestImpl.setCreateDate(null);
		}
		else {
			emrgcyRequestImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			emrgcyRequestImpl.setModifiedDate(null);
		}
		else {
			emrgcyRequestImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			emrgcyRequestImpl.setTitle("");
		}
		else {
			emrgcyRequestImpl.setTitle(title);
		}

		if (description == null) {
			emrgcyRequestImpl.setDescription("");
		}
		else {
			emrgcyRequestImpl.setDescription(description);
		}

		if (location == null) {
			emrgcyRequestImpl.setLocation("");
		}
		else {
			emrgcyRequestImpl.setLocation(location);
		}

		if (status == null) {
			emrgcyRequestImpl.setStatus("");
		}
		else {
			emrgcyRequestImpl.setStatus(status);
		}

		if (assignedTeam == null) {
			emrgcyRequestImpl.setAssignedTeam("");
		}
		else {
			emrgcyRequestImpl.setAssignedTeam(assignedTeam);
		}

		emrgcyRequestImpl.setRequesterUserId(requesterUserId);

		emrgcyRequestImpl.resetOriginalValues();

		return emrgcyRequestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		requestId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		location = objectInput.readUTF();
		status = objectInput.readUTF();
		assignedTeam = objectInput.readUTF();

		requesterUserId = objectInput.readLong();
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

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
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

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (assignedTeam == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(assignedTeam);
		}

		objectOutput.writeLong(requesterUserId);
	}

	public String uuid;
	public long requestId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String description;
	public String location;
	public String status;
	public String assignedTeam;
	public long requesterUserId;

}