/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package TicketMgmtDB.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the TicketMgmt service. Represents a row in the &quot;ATS_TicketMgmt&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see TicketMgmtModel
 * @generated
 */
@ImplementationClassName("TicketMgmtDB.model.impl.TicketMgmtImpl")
@ProviderType
public interface TicketMgmt extends PersistedModel, TicketMgmtModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>TicketMgmtDB.model.impl.TicketMgmtImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<TicketMgmt, Long> TICKET_ID_ACCESSOR =
		new Accessor<TicketMgmt, Long>() {

			@Override
			public Long get(TicketMgmt ticketMgmt) {
				return ticketMgmt.getTicket_id();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<TicketMgmt> getTypeClass() {
				return TicketMgmt.class;
			}

		};

}