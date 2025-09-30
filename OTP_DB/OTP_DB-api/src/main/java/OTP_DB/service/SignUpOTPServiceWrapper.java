/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package OTP_DB.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SignUpOTPService}.
 *
 * @author Brian Wing Shun Chan
 * @see SignUpOTPService
 * @generated
 */
public class SignUpOTPServiceWrapper
	implements ServiceWrapper<SignUpOTPService>, SignUpOTPService {

	public SignUpOTPServiceWrapper() {
		this(null);
	}

	public SignUpOTPServiceWrapper(SignUpOTPService signUpOTPService) {
		_signUpOTPService = signUpOTPService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _signUpOTPService.getOSGiServiceIdentifier();
	}

	@Override
	public SignUpOTPService getWrappedService() {
		return _signUpOTPService;
	}

	@Override
	public void setWrappedService(SignUpOTPService signUpOTPService) {
		_signUpOTPService = signUpOTPService;
	}

	private SignUpOTPService _signUpOTPService;

}