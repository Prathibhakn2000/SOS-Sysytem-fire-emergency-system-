/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package EmergencyRequestDB.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link EmergencyRequestLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmergencyRequestLocalService
 * @generated
 */
public class EmergencyRequestLocalServiceWrapper
	implements EmergencyRequestLocalService,
			   ServiceWrapper<EmergencyRequestLocalService> {

	public EmergencyRequestLocalServiceWrapper() {
		this(null);
	}

	public EmergencyRequestLocalServiceWrapper(
		EmergencyRequestLocalService emergencyRequestLocalService) {

		_emergencyRequestLocalService = emergencyRequestLocalService;
	}

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
	@Override
	public EmergencyRequestDB.model.EmergencyRequest addEmergencyRequest(
		EmergencyRequestDB.model.EmergencyRequest emergencyRequest) {

		return _emergencyRequestLocalService.addEmergencyRequest(
			emergencyRequest);
	}

	/**
	 * Creates a new emergency request with the primary key. Does not add the emergency request to the database.
	 *
	 * @param requestId the primary key for the new emergency request
	 * @return the new emergency request
	 */
	@Override
	public EmergencyRequestDB.model.EmergencyRequest createEmergencyRequest(
		long requestId) {

		return _emergencyRequestLocalService.createEmergencyRequest(requestId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emergencyRequestLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public EmergencyRequestDB.model.EmergencyRequest deleteEmergencyRequest(
		EmergencyRequestDB.model.EmergencyRequest emergencyRequest) {

		return _emergencyRequestLocalService.deleteEmergencyRequest(
			emergencyRequest);
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
	@Override
	public EmergencyRequestDB.model.EmergencyRequest deleteEmergencyRequest(
			long requestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emergencyRequestLocalService.deleteEmergencyRequest(requestId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emergencyRequestLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _emergencyRequestLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _emergencyRequestLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _emergencyRequestLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _emergencyRequestLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _emergencyRequestLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _emergencyRequestLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _emergencyRequestLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _emergencyRequestLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public EmergencyRequestDB.model.EmergencyRequest fetchEmergencyRequest(
		long requestId) {

		return _emergencyRequestLocalService.fetchEmergencyRequest(requestId);
	}

	/**
	 * Returns the emergency request matching the UUID and group.
	 *
	 * @param uuid the emergency request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching emergency request, or <code>null</code> if a matching emergency request could not be found
	 */
	@Override
	public EmergencyRequestDB.model.EmergencyRequest
		fetchEmergencyRequestByUuidAndGroupId(String uuid, long groupId) {

		return _emergencyRequestLocalService.
			fetchEmergencyRequestByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _emergencyRequestLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the emergency request with the primary key.
	 *
	 * @param requestId the primary key of the emergency request
	 * @return the emergency request
	 * @throws PortalException if a emergency request with the primary key could not be found
	 */
	@Override
	public EmergencyRequestDB.model.EmergencyRequest getEmergencyRequest(
			long requestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emergencyRequestLocalService.getEmergencyRequest(requestId);
	}

	/**
	 * Returns the emergency request matching the UUID and group.
	 *
	 * @param uuid the emergency request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching emergency request
	 * @throws PortalException if a matching emergency request could not be found
	 */
	@Override
	public EmergencyRequestDB.model.EmergencyRequest
			getEmergencyRequestByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emergencyRequestLocalService.
			getEmergencyRequestByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<EmergencyRequestDB.model.EmergencyRequest>
		getEmergencyRequests(int start, int end) {

		return _emergencyRequestLocalService.getEmergencyRequests(start, end);
	}

	@Override
	public java.util.List<EmergencyRequestDB.model.EmergencyRequest>
		getEmergencyRequestsByUserId(long userId) {

		return _emergencyRequestLocalService.getEmergencyRequestsByUserId(
			userId);
	}

	/**
	 * Returns all the emergency requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the emergency requests
	 * @param companyId the primary key of the company
	 * @return the matching emergency requests, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<EmergencyRequestDB.model.EmergencyRequest>
		getEmergencyRequestsByUuidAndCompanyId(String uuid, long companyId) {

		return _emergencyRequestLocalService.
			getEmergencyRequestsByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<EmergencyRequestDB.model.EmergencyRequest>
		getEmergencyRequestsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<EmergencyRequestDB.model.EmergencyRequest> orderByComparator) {

		return _emergencyRequestLocalService.
			getEmergencyRequestsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of emergency requests.
	 *
	 * @return the number of emergency requests
	 */
	@Override
	public int getEmergencyRequestsCount() {
		return _emergencyRequestLocalService.getEmergencyRequestsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _emergencyRequestLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _emergencyRequestLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _emergencyRequestLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emergencyRequestLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public EmergencyRequestDB.model.EmergencyRequest updateEmergencyRequest(
		EmergencyRequestDB.model.EmergencyRequest emergencyRequest) {

		return _emergencyRequestLocalService.updateEmergencyRequest(
			emergencyRequest);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _emergencyRequestLocalService.getBasePersistence();
	}

	@Override
	public EmergencyRequestLocalService getWrappedService() {
		return _emergencyRequestLocalService;
	}

	@Override
	public void setWrappedService(
		EmergencyRequestLocalService emergencyRequestLocalService) {

		_emergencyRequestLocalService = emergencyRequestLocalService;
	}

	private EmergencyRequestLocalService _emergencyRequestLocalService;

}