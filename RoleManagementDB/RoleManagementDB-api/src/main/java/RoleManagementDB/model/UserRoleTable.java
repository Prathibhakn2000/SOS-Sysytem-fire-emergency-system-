/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package RoleManagementDB.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the UserRoleTable service. Represents a row in the &quot;UserRoleTable&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see UserRoleTableModel
 * @generated
 */
@ImplementationClassName("RoleManagementDB.model.impl.UserRoleTableImpl")
@ProviderType
public interface UserRoleTable extends PersistedModel, UserRoleTableModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>RoleManagementDB.model.impl.UserRoleTableImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<UserRoleTable, Long> USER_ROLE_ID_ACCESSOR =
		new Accessor<UserRoleTable, Long>() {

			@Override
			public Long get(UserRoleTable userRoleTable) {
				return userRoleTable.getUserRoleId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<UserRoleTable> getTypeClass() {
				return UserRoleTable.class;
			}

		};

}