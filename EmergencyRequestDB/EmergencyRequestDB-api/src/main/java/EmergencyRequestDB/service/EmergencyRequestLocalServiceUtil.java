/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package EmergencyRequestDB.service;

import EmergencyRequestDB.model.EmergencyRequest;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for EmergencyRequest. This utility wraps
 * <code>EmergencyRequestDB.service.impl.EmergencyRequestLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EmergencyRequestLocalService
 * @generated
 */
public class EmergencyRequestLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>EmergencyRequestDB.service.impl.EmergencyRequestLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the emergency request to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmergencyRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param emergencyRequest the emergency request
	 * @return the emergency request that was added
	 */
	public static EmergencyRequest addEmergencyRequest(
		EmergencyRequest emergencyRequest) {

		return getService().addEmergencyRequest(emergencyRequest);
	}

	/**
	 * Creates a new emergency request with the primary key. Does not add the emergency request to the database.
	 *
	 * @param requestId the primary key for the new emergency request
	 * @return the new emergency request
	 */
	public static EmergencyRequest createEmergencyRequest(long requestId) {
		return getService().createEmergencyRequest(requestId);
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
	 * Deletes the emergency request from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmergencyRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param emergencyRequest the emergency request
	 * @return the emergency request that was removed
	 */
	public static EmergencyRequest deleteEmergencyRequest(
		EmergencyRequest emergencyRequest) {

		return getService().deleteEmergencyRequest(emergencyRequest);
	}

	/**
	 * Deletes the emergency request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmergencyRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param requestId the primary key of the emergency request
	 * @return the emergency request that was removed
	 * @throws PortalException if a emergency request with the primary key could not be found
	 */
	public static EmergencyRequest deleteEmergencyRequest(long requestId)
		throws PortalException {

		return getService().deleteEmergencyRequest(requestId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmergencyRequestDB.model.impl.EmergencyRequestModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmergencyRequestDB.model.impl.EmergencyRequestModelImpl</code>.
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

	public static EmergencyRequest fetchEmergencyRequest(long requestId) {
		return getService().fetchEmergencyRequest(requestId);
	}

	/**
	 * Returns the emergency request matching the UUID and group.
	 *
	 * @param uuid the emergency request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching emergency request, or <code>null</code> if a matching emergency request could not be found
	 */
	public static EmergencyRequest fetchEmergencyRequestByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchEmergencyRequestByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the emergency request with the primary key.
	 *
	 * @param requestId the primary key of the emergency request
	 * @return the emergency request
	 * @throws PortalException if a emergency request with the primary key could not be found
	 */
	public static EmergencyRequest getEmergencyRequest(long requestId)
		throws PortalException {

		return getService().getEmergencyRequest(requestId);
	}

	/**
	 * Returns the emergency request matching the UUID and group.
	 *
	 * @param uuid the emergency request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching emergency request
	 * @throws PortalException if a matching emergency request could not be found
	 */
	public static EmergencyRequest getEmergencyRequestByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getEmergencyRequestByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the emergency requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmergencyRequestDB.model.impl.EmergencyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of emergency requests
	 * @param end the upper bound of the range of emergency requests (not inclusive)
	 * @return the range of emergency requests
	 */
	public static List<EmergencyRequest> getEmergencyRequests(
		int start, int end) {

		return getService().getEmergencyRequests(start, end);
	}

	public static List<EmergencyRequest> getEmergencyRequestsByUserId(
		long userId) {

		return getService().getEmergencyRequestsByUserId(userId);
	}

	/**
	 * Returns all the emergency requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the emergency requests
	 * @param companyId the primary key of the company
	 * @return the matching emergency requests, or an empty list if no matches were found
	 */
	public static List<EmergencyRequest> getEmergencyRequestsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getEmergencyRequestsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of emergency requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the emergency requests
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of emergency requests
	 * @param end the upper bound of the range of emergency requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching emergency requests, or an empty list if no matches were found
	 */
	public static List<EmergencyRequest> getEmergencyRequestsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmergencyRequest> orderByComparator) {

		return getService().getEmergencyRequestsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of emergency requests.
	 *
	 * @return the number of emergency requests
	 */
	public static int getEmergencyRequestsCount() {
		return getService().getEmergencyRequestsCount();
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
	 * Updates the emergency request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmergencyRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param emergencyRequest the emergency request
	 * @return the emergency request that was updated
	 */
	public static EmergencyRequest updateEmergencyRequest(
		EmergencyRequest emergencyRequest) {

		return getService().updateEmergencyRequest(emergencyRequest);
	}

	public static EmergencyRequestLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<EmergencyRequestLocalService>
		_serviceSnapshot = new Snapshot<>(
			EmergencyRequestLocalServiceUtil.class,
			EmergencyRequestLocalService.class);

}