/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package RequestManagementDB.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;Fire_EmrgcyRequest&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see EmrgcyRequest
 * @generated
 */
public class EmrgcyRequestTable extends BaseTable<EmrgcyRequestTable> {

	public static final EmrgcyRequestTable INSTANCE = new EmrgcyRequestTable();

	public final Column<EmrgcyRequestTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmrgcyRequestTable, Long> requestId = createColumn(
		"requestId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EmrgcyRequestTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmrgcyRequestTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmrgcyRequestTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmrgcyRequestTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmrgcyRequestTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmrgcyRequestTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmrgcyRequestTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmrgcyRequestTable, String> location = createColumn(
		"location", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmrgcyRequestTable, String> status = createColumn(
		"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmrgcyRequestTable, String> assignedTeam = createColumn(
		"assignedTeam", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmrgcyRequestTable, Long> requesterUserId =
		createColumn(
			"requesterUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private EmrgcyRequestTable() {
		super("Fire_EmrgcyRequest", EmrgcyRequestTable::new);
	}

}