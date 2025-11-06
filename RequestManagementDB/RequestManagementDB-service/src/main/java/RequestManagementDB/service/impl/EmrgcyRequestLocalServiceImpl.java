/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package RequestManagementDB.service.impl;

import RequestManagementDB.service.base.EmrgcyRequestLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=RequestManagementDB.model.EmrgcyRequest",
	service = AopService.class
)
public class EmrgcyRequestLocalServiceImpl
	extends EmrgcyRequestLocalServiceBaseImpl {
	
	
	private static final Log _log = LogFactoryUtil.getLog(
			EmrgcyRequestLocalServiceImpl.class);

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void deleteEmrgcyRequestBatch(List<Long> requestIds) {
	    if (requestIds == null || requestIds.isEmpty()) {
	        _log.warn("No request IDs provided for batch deletion.");
	        return;
	    }

	    for (Long requestId : requestIds) {
	        try {
				deleteEmrgcyRequest(requestId);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        _log.info("Deleted EmergencyRequest with ID: " + requestId);
	    }
	}
}