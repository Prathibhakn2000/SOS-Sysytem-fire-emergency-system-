/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package OTP_DB.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;fire_SignUpOTP&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see SignUpOTP
 * @generated
 */
public class SignUpOTPTable extends BaseTable<SignUpOTPTable> {

	public static final SignUpOTPTable INSTANCE = new SignUpOTPTable();

	public final Column<SignUpOTPTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SignUpOTPTable, Long> otpId = createColumn(
		"otpId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SignUpOTPTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SignUpOTPTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SignUpOTPTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SignUpOTPTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SignUpOTPTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SignUpOTPTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SignUpOTPTable, String> email_address = createColumn(
		"email_address", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<SignUpOTPTable, String> OTP = createColumn(
		"OTP", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<SignUpOTPTable, Boolean> status = createColumn(
		"status", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private SignUpOTPTable() {
		super("fire_SignUpOTP", SignUpOTPTable::new);
	}

}