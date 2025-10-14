/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package EmergencyRequestDB.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmergencyRequestService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmergencyRequestService
 * @generated
 */
public class EmergencyRequestServiceWrapper
	implements EmergencyRequestService,
			   ServiceWrapper<EmergencyRequestService> {

	public EmergencyRequestServiceWrapper() {
		this(null);
	}

	public EmergencyRequestServiceWrapper(
		EmergencyRequestService emergencyRequestService) {

		_emergencyRequestService = emergencyRequestService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _emergencyRequestService.getOSGiServiceIdentifier();
	}

	@Override
	public EmergencyRequestService getWrappedService() {
		return _emergencyRequestService;
	}

	@Override
	public void setWrappedService(
		EmergencyRequestService emergencyRequestService) {

		_emergencyRequestService = emergencyRequestService;
	}

	private EmergencyRequestService _emergencyRequestService;

}