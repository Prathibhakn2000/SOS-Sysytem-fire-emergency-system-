/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package RoleManagementDB.model.impl;

import RoleManagementDB.model.UserRoleTable;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing UserRoleTable in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserRoleTableCacheModel
	implements CacheModel<UserRoleTable>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserRoleTableCacheModel)) {
			return false;
		}

		UserRoleTableCacheModel userRoleTableCacheModel =
			(UserRoleTableCacheModel)object;

		if (userRoleId == userRoleTableCacheModel.userRoleId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userRoleId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{userRoleId=");
		sb.append(userRoleId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", roleId=");
		sb.append(roleId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserRoleTable toEntityModel() {
		UserRoleTableImpl userRoleTableImpl = new UserRoleTableImpl();

		userRoleTableImpl.setUserRoleId(userRoleId);
		userRoleTableImpl.setUserId(userId);
		userRoleTableImpl.setRoleId(roleId);

		userRoleTableImpl.resetOriginalValues();

		return userRoleTableImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userRoleId = objectInput.readLong();

		userId = objectInput.readLong();

		roleId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(userRoleId);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(roleId);
	}

	public long userRoleId;
	public long userId;
	public long roleId;

}