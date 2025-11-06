/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package RequestManagementDB.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmrgcyRequestService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmrgcyRequestService
 * @generated
 */
public class EmrgcyRequestServiceWrapper
	implements EmrgcyRequestService, ServiceWrapper<EmrgcyRequestService> {

	public EmrgcyRequestServiceWrapper() {
		this(null);
	}

	public EmrgcyRequestServiceWrapper(
		EmrgcyRequestService emrgcyRequestService) {

		_emrgcyRequestService = emrgcyRequestService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _emrgcyRequestService.getOSGiServiceIdentifier();
	}

	@Override
	public EmrgcyRequestService getWrappedService() {
		return _emrgcyRequestService;
	}

	@Override
	public void setWrappedService(EmrgcyRequestService emrgcyRequestService) {
		_emrgcyRequestService = emrgcyRequestService;
	}

	private EmrgcyRequestService _emrgcyRequestService;

}