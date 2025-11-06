/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package RequestManagementDB.service;

import RequestManagementDB.model.EmrgcyRequest;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for EmrgcyRequest. This utility wraps
 * <code>RequestManagementDB.service.impl.EmrgcyRequestLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EmrgcyRequestLocalService
 * @generated
 */
public class EmrgcyRequestLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>RequestManagementDB.service.impl.EmrgcyRequestLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the emrgcy request to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmrgcyRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param emrgcyRequest the emrgcy request
	 * @return the emrgcy request that was added
	 */
	public static EmrgcyRequest addEmrgcyRequest(EmrgcyRequest emrgcyRequest) {
		return getService().addEmrgcyRequest(emrgcyRequest);
	}

	/**
	 * Creates a new emrgcy request with the primary key. Does not add the emrgcy request to the database.
	 *
	 * @param requestId the primary key for the new emrgcy request
	 * @return the new emrgcy request
	 */
	public static EmrgcyRequest createEmrgcyRequest(long requestId) {
		return getService().createEmrgcyRequest(requestId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the emrgcy request from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmrgcyRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param emrgcyRequest the emrgcy request
	 * @return the emrgcy request that was removed
	 */
	public static EmrgcyRequest deleteEmrgcyRequest(
		EmrgcyRequest emrgcyRequest) {

		return getService().deleteEmrgcyRequest(emrgcyRequest);
	}

	/**
	 * Deletes the emrgcy request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmrgcyRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param requestId the primary key of the emrgcy request
	 * @return the emrgcy request that was removed
	 * @throws PortalException if a emrgcy request with the primary key could not be found
	 */
	public static EmrgcyRequest deleteEmrgcyRequest(long requestId)
		throws PortalException {

		return getService().deleteEmrgcyRequest(requestId);
	}

	/**
	 * Deletes multiple EmrgcyRequest records by their IDs.
	 */
	public static void deleteEmrgcyRequestBatch(List<Long> requestIds) {
		getService().deleteEmrgcyRequestBatch(requestIds);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RequestManagementDB.model.impl.EmrgcyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RequestManagementDB.model.impl.EmrgcyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static EmrgcyRequest fetchEmrgcyRequest(long requestId) {
		return getService().fetchEmrgcyRequest(requestId);
	}

	/**
	 * Returns the emrgcy request with the matching UUID and company.
	 *
	 * @param uuid the emrgcy request's UUID
	 * @param companyId the primary key of the company
	 * @return the matching emrgcy request, or <code>null</code> if a matching emrgcy request could not be found
	 */
	public static EmrgcyRequest fetchEmrgcyRequestByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().fetchEmrgcyRequestByUuidAndCompanyId(
			uuid, companyId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the emrgcy request with the primary key.
	 *
	 * @param requestId the primary key of the emrgcy request
	 * @return the emrgcy request
	 * @throws PortalException if a emrgcy request with the primary key could not be found
	 */
	public static EmrgcyRequest getEmrgcyRequest(long requestId)
		throws PortalException {

		return getService().getEmrgcyRequest(requestId);
	}

	/**
	 * Returns the emrgcy request with the matching UUID and company.
	 *
	 * @param uuid the emrgcy request's UUID
	 * @param companyId the primary key of the company
	 * @return the matching emrgcy request
	 * @throws PortalException if a matching emrgcy request could not be found
	 */
	public static EmrgcyRequest getEmrgcyRequestByUuidAndCompanyId(
			String uuid, long companyId)
		throws PortalException {

		return getService().getEmrgcyRequestByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of all the emrgcy requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RequestManagementDB.model.impl.EmrgcyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of emrgcy requests
	 * @param end the upper bound of the range of emrgcy requests (not inclusive)
	 * @return the range of emrgcy requests
	 */
	public static List<EmrgcyRequest> getEmrgcyRequests(int start, int end) {
		return getService().getEmrgcyRequests(start, end);
	}

	/**
	 * Returns the number of emrgcy requests.
	 *
	 * @return the number of emrgcy requests
	 */
	public static int getEmrgcyRequestsCount() {
		return getService().getEmrgcyRequestsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the emrgcy request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmrgcyRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param emrgcyRequest the emrgcy request
	 * @return the emrgcy request that was updated
	 */
	public static EmrgcyRequest updateEmrgcyRequest(
		EmrgcyRequest emrgcyRequest) {

		return getService().updateEmrgcyRequest(emrgcyRequest);
	}

	public static EmrgcyRequestLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<EmrgcyRequestLocalService> _serviceSnapshot =
		new Snapshot<>(
			EmrgcyRequestLocalServiceUtil.class,
			EmrgcyRequestLocalService.class);

}