/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package RoleManagementDB.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserRoleTable}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserRoleTable
 * @generated
 */
public class UserRoleTableWrapper
	extends BaseModelWrapper<UserRoleTable>
	implements ModelWrapper<UserRoleTable>, UserRoleTable {

	public UserRoleTableWrapper(UserRoleTable userRoleTable) {
		super(userRoleTable);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userRoleId", getUserRoleId());
		attributes.put("userId", getUserId());
		attributes.put("roleId", getRoleId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userRoleId = (Long)attributes.get("userRoleId");

		if (userRoleId != null) {
			setUserRoleId(userRoleId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}
	}

	@Override
	public UserRoleTable cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the primary key of this user role table.
	 *
	 * @return the primary key of this user role table
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the role ID of this user role table.
	 *
	 * @return the role ID of this user role table
	 */
	@Override
	public long getRoleId() {
		return model.getRoleId();
	}

	/**
	 * Returns the user ID of this user role table.
	 *
	 * @return the user ID of this user role table
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user role ID of this user role table.
	 *
	 * @return the user role ID of this user role table
	 */
	@Override
	public long getUserRoleId() {
		return model.getUserRoleId();
	}

	/**
	 * Returns the user uuid of this user role table.
	 *
	 * @return the user uuid of this user role table
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the primary key of this user role table.
	 *
	 * @param primaryKey the primary key of this user role table
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the role ID of this user role table.
	 *
	 * @param roleId the role ID of this user role table
	 */
	@Override
	public void setRoleId(long roleId) {
		model.setRoleId(roleId);
	}

	/**
	 * Sets the user ID of this user role table.
	 *
	 * @param userId the user ID of this user role table
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user role ID of this user role table.
	 *
	 * @param userRoleId the user role ID of this user role table
	 */
	@Override
	public void setUserRoleId(long userRoleId) {
		model.setUserRoleId(userRoleId);
	}

	/**
	 * Sets the user uuid of this user role table.
	 *
	 * @param userUuid the user uuid of this user role table
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected UserRoleTableWrapper wrap(UserRoleTable userRoleTable) {
		return new UserRoleTableWrapper(userRoleTable);
	}

}