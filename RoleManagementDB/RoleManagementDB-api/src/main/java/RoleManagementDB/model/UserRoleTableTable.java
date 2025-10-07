/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package RoleManagementDB.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;UserRoleTable&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see UserRoleTable
 * @generated
 */
public class UserRoleTableTable extends BaseTable<UserRoleTableTable> {

	public static final UserRoleTableTable INSTANCE = new UserRoleTableTable();

	public final Column<UserRoleTableTable, Long> userRoleId = createColumn(
		"userRoleId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<UserRoleTableTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UserRoleTableTable, Long> roleId = createColumn(
		"roleId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private UserRoleTableTable() {
		super("UserRoleTable", UserRoleTableTable::new);
	}

}