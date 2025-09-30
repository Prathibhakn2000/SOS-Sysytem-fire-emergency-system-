/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package OTP_DB.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchSignUpOTPException extends NoSuchModelException {

	public NoSuchSignUpOTPException() {
	}

	public NoSuchSignUpOTPException(String msg) {
		super(msg);
	}

	public NoSuchSignUpOTPException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchSignUpOTPException(Throwable throwable) {
		super(throwable);
	}

}