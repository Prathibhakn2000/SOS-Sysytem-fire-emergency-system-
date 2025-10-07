/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package RoleManagementDB.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RoleTableService}.
 *
 * @author Brian Wing Shun Chan
 * @see RoleTableService
 * @generated
 */
public class RoleTableServiceWrapper
	implements RoleTableService, ServiceWrapper<RoleTableService> {

	public RoleTableServiceWrapper() {
		this(null);
	}

	public RoleTableServiceWrapper(RoleTableService roleTableService) {
		_roleTableService = roleTableService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _roleTableService.getOSGiServiceIdentifier();
	}

	@Override
	public RoleTableService getWrappedService() {
		return _roleTableService;
	}

	@Override
	public void setWrappedService(RoleTableService roleTableService) {
		_roleTableService = roleTableService;
	}

	private RoleTableService _roleTableService;

}