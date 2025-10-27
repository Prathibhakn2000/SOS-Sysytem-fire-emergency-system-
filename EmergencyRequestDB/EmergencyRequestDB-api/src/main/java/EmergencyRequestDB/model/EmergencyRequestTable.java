/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package EmergencyRequestDB.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;Fire_EmergencyRequest&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see EmergencyRequest
 * @generated
 */
public class EmergencyRequestTable extends BaseTable<EmergencyRequestTable> {

	public static final EmergencyRequestTable INSTANCE =
		new EmergencyRequestTable();

	public final Column<EmergencyRequestTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmergencyRequestTable, Long> requestId = createColumn(
		"requestId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EmergencyRequestTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmergencyRequestTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmergencyRequestTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmergencyRequestTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmergencyRequestTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmergencyRequestTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmergencyRequestTable, String> requestTitle =
		createColumn(
			"requestTitle", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmergencyRequestTable, String> description =
		createColumn(
			"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmergencyRequestTable, String> location = createColumn(
		"location", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmergencyRequestTable, String> exactAddress =
		createColumn(
			"exactAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmergencyRequestTable, Long> contactNumber =
		createColumn(
			"contactNumber", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmergencyRequestTable, String> attachmentPath =
		createColumn(
			"attachmentPath", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmergencyRequestTable, String> status = createColumn(
		"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmergencyRequestTable, Long> allocatedTeamId =
		createColumn(
			"allocatedTeamId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private EmergencyRequestTable() {
		super("Fire_EmergencyRequest", EmergencyRequestTable::new);
	}

}