/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package EmergencyRequestDB.service.impl;

import EmergencyRequestDB.service.base.EmergencyRequestServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=fire",
		"json.web.service.context.path=EmergencyRequest"
	},
	service = AopService.class
)
public class EmergencyRequestServiceImpl
	extends EmergencyRequestServiceBaseImpl {
}