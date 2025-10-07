/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package RoleManagementDB.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchUserRoleTableException extends NoSuchModelException {

	public NoSuchUserRoleTableException() {
	}

	public NoSuchUserRoleTableException(String msg) {
		super(msg);
	}

	public NoSuchUserRoleTableException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchUserRoleTableException(Throwable throwable) {
		super(throwable);
	}

}