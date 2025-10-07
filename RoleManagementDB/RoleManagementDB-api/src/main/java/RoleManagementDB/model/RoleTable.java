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
 * The extended model interface for the RoleTable service. Represents a row in the &quot;fire_RoleTable&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see RoleTableModel
 * @generated
 */
@ImplementationClassName("RoleManagementDB.model.impl.RoleTableImpl")
@ProviderType
public interface RoleTable extends PersistedModel, RoleTableModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>RoleManagementDB.model.impl.RoleTableImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<RoleTable, Long> ROLE_ID_ACCESSOR =
		new Accessor<RoleTable, Long>() {

			@Override
			public Long get(RoleTable roleTable) {
				return roleTable.getRoleId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<RoleTable> getTypeClass() {
				return RoleTable.class;
			}

		};

}