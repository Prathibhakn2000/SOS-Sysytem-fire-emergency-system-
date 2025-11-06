/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package RequestManagementDB.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the EmrgcyRequest service. Represents a row in the &quot;Fire_EmrgcyRequest&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see EmrgcyRequestModel
 * @generated
 */
@ImplementationClassName("RequestManagementDB.model.impl.EmrgcyRequestImpl")
@ProviderType
public interface EmrgcyRequest extends EmrgcyRequestModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>RequestManagementDB.model.impl.EmrgcyRequestImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<EmrgcyRequest, Long> REQUEST_ID_ACCESSOR =
		new Accessor<EmrgcyRequest, Long>() {

			@Override
			public Long get(EmrgcyRequest emrgcyRequest) {
				return emrgcyRequest.getRequestId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<EmrgcyRequest> getTypeClass() {
				return EmrgcyRequest.class;
			}

		};

}