/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package TicketMgmtDB.service.impl;

import TicketMgmtDB.model.TicketMgmt;
import TicketMgmtDB.model.impl.TicketMgmtImpl;
import TicketMgmtDB.service.base.TicketMgmtLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=TicketMgmtDB.model.TicketMgmt",
	service = AopService.class
)
public class TicketMgmtLocalServiceImpl extends TicketMgmtLocalServiceBaseImpl {
	
	public TicketMgmt getInstance() {
	
	return new TicketMgmtImpl();
	}
	
}