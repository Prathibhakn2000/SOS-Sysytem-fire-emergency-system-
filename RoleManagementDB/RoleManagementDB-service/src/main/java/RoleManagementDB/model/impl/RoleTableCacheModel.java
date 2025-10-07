/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package RoleManagementDB.model.impl;

import RoleManagementDB.model.RoleTable;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RoleTable in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RoleTableCacheModel
	implements CacheModel<RoleTable>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RoleTableCacheModel)) {
			return false;
		}

		RoleTableCacheModel roleTableCacheModel = (RoleTableCacheModel)object;

		if (roleId == roleTableCacheModel.roleId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, roleId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", roleId=");
		sb.append(roleId);
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
		sb.append(", roleName=");
		sb.append(roleName);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RoleTable toEntityModel() {
		RoleTableImpl roleTableImpl = new RoleTableImpl();

		if (uuid == null) {
			roleTableImpl.setUuid("");
		}
		else {
			roleTableImpl.setUuid(uuid);
		}

		roleTableImpl.setRoleId(roleId);
		roleTableImpl.setGroupId(groupId);
		roleTableImpl.setCompanyId(companyId);
		roleTableImpl.setUserId(userId);

		if (userName == null) {
			roleTableImpl.setUserName("");
		}
		else {
			roleTableImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			roleTableImpl.setCreateDate(null);
		}
		else {
			roleTableImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			roleTableImpl.setModifiedDate(null);
		}
		else {
			roleTableImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (roleName == null) {
			roleTableImpl.setRoleName("");
		}
		else {
			roleTableImpl.setRoleName(roleName);
		}

		if (description == null) {
			roleTableImpl.setDescription("");
		}
		else {
			roleTableImpl.setDescription(description);
		}

		roleTableImpl.resetOriginalValues();

		return roleTableImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		roleId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		roleName = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(roleId);

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

		if (roleName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(roleName);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public String uuid;
	public long roleId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String roleName;
	public String description;

}