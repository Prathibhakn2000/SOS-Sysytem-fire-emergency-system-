/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package OTP_DB.service.persistence.impl;

import OTP_DB.model.SignUpOTPTable;
import OTP_DB.model.impl.SignUpOTPImpl;
import OTP_DB.model.impl.SignUpOTPModelImpl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from SignUpOTP.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=OTP_DB.model.impl.SignUpOTPImpl",
		"table.name=fire_SignUpOTP"
	},
	service = ArgumentsResolver.class
)
public class SignUpOTPModelArgumentsResolver implements ArgumentsResolver {

	@Override
	public Object[] getArguments(
		FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
		boolean original) {

		String[] columnNames = finderPath.getColumnNames();

		if ((columnNames == null) || (columnNames.length == 0)) {
			if (baseModel.isNew()) {
				return new Object[0];
			}

			return null;
		}

		SignUpOTPModelImpl signUpOTPModelImpl = (SignUpOTPModelImpl)baseModel;

		long columnBitmask = signUpOTPModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(signUpOTPModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |= signUpOTPModelImpl.getColumnBitmask(
					columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(signUpOTPModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return SignUpOTPImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return SignUpOTPTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		SignUpOTPModelImpl signUpOTPModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = signUpOTPModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = signUpOTPModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}