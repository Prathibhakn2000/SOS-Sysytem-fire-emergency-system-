/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package TicketMgmtDB.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;ATS_TicketMgmt&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see TicketMgmt
 * @generated
 */
public class TicketMgmtTable extends BaseTable<TicketMgmtTable> {

	public static final TicketMgmtTable INSTANCE = new TicketMgmtTable();

	public final Column<TicketMgmtTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TicketMgmtTable, Long> ticket_id = createColumn(
		"ticket_id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<TicketMgmtTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TicketMgmtTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TicketMgmtTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TicketMgmtTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TicketMgmtTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TicketMgmtTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TicketMgmtTable, String> busNumber = createColumn(
		"busNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TicketMgmtTable, String> fromLocation = createColumn(
		"fromLocation", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TicketMgmtTable, String> toLocation = createColumn(
		"toLocation", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TicketMgmtTable, Date> journeyDate = createColumn(
		"journeyDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TicketMgmtTable, Integer> seatNumber = createColumn(
		"seatNumber", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<TicketMgmtTable, Long> fareAmount = createColumn(
		"fareAmount", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private TicketMgmtTable() {
		super("ATS_TicketMgmt", TicketMgmtTable::new);
	}

}