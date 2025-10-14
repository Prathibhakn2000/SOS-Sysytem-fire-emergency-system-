/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package EmergencyRequestDB.service.impl;

import EmergencyRequestDB.model.EmergencyRequest;
import EmergencyRequestDB.service.base.EmergencyRequestLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=EmergencyRequestDB.model.EmergencyRequest",
	service = AopService.class
)
public class EmergencyRequestLocalServiceImpl
	extends EmergencyRequestLocalServiceBaseImpl {
	
	public List<EmergencyRequest> getEmergencyRequestsByUserId(long userId) {
        return emergencyRequestPersistence.findByUserId(userId);
    }
}