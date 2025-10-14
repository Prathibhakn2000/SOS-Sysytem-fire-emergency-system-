/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package EmergencyRequestDB.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the EmergencyRequest service. Represents a row in the &quot;Fire_EmergencyRequest&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see EmergencyRequestModel
 * @generated
 */
@ImplementationClassName("EmergencyRequestDB.model.impl.EmergencyRequestImpl")
@ProviderType
public interface EmergencyRequest
	extends EmergencyRequestModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>EmergencyRequestDB.model.impl.EmergencyRequestImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<EmergencyRequest, Long> REQUEST_ID_ACCESSOR =
		new Accessor<EmergencyRequest, Long>() {

			@Override
			public Long get(EmergencyRequest emergencyRequest) {
				return emergencyRequest.getRequestId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<EmergencyRequest> getTypeClass() {
				return EmergencyRequest.class;
			}

		};

}