/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package RequestManagementDB.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link EmrgcyRequestLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmrgcyRequestLocalService
 * @generated
 */
public class EmrgcyRequestLocalServiceWrapper
	implements EmrgcyRequestLocalService,
			   ServiceWrapper<EmrgcyRequestLocalService> {

	public EmrgcyRequestLocalServiceWrapper() {
		this(null);
	}

	public EmrgcyRequestLocalServiceWrapper(
		EmrgcyRequestLocalService emrgcyRequestLocalService) {

		_emrgcyRequestLocalService = emrgcyRequestLocalService;
	}

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
	@Override
	public RequestManagementDB.model.EmrgcyRequest addEmrgcyRequest(
		RequestManagementDB.model.EmrgcyRequest emrgcyRequest) {

		return _emrgcyRequestLocalService.addEmrgcyRequest(emrgcyRequest);
	}

	/**
	 * Creates a new emrgcy request with the primary key. Does not add the emrgcy request to the database.
	 *
	 * @param requestId the primary key for the new emrgcy request
	 * @return the new emrgcy request
	 */
	@Override
	public RequestManagementDB.model.EmrgcyRequest createEmrgcyRequest(
		long requestId) {

		return _emrgcyRequestLocalService.createEmrgcyRequest(requestId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emrgcyRequestLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public RequestManagementDB.model.EmrgcyRequest deleteEmrgcyRequest(
		RequestManagementDB.model.EmrgcyRequest emrgcyRequest) {

		return _emrgcyRequestLocalService.deleteEmrgcyRequest(emrgcyRequest);
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
	@Override
	public RequestManagementDB.model.EmrgcyRequest deleteEmrgcyRequest(
			long requestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emrgcyRequestLocalService.deleteEmrgcyRequest(requestId);
	}

	/**
	 * Deletes multiple EmrgcyRequest records by their IDs.
	 */
	@Override
	public void deleteEmrgcyRequestBatch(java.util.List<Long> requestIds) {
		_emrgcyRequestLocalService.deleteEmrgcyRequestBatch(requestIds);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emrgcyRequestLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _emrgcyRequestLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _emrgcyRequestLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _emrgcyRequestLocalService.dynamicQuery();
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

		return _emrgcyRequestLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _emrgcyRequestLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _emrgcyRequestLocalService.dynamicQuery(
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

		return _emrgcyRequestLocalService.dynamicQueryCount(dynamicQuery);
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

		return _emrgcyRequestLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public RequestManagementDB.model.EmrgcyRequest fetchEmrgcyRequest(
		long requestId) {

		return _emrgcyRequestLocalService.fetchEmrgcyRequest(requestId);
	}

	/**
	 * Returns the emrgcy request with the matching UUID and company.
	 *
	 * @param uuid the emrgcy request's UUID
	 * @param companyId the primary key of the company
	 * @return the matching emrgcy request, or <code>null</code> if a matching emrgcy request could not be found
	 */
	@Override
	public RequestManagementDB.model.EmrgcyRequest
		fetchEmrgcyRequestByUuidAndCompanyId(String uuid, long companyId) {

		return _emrgcyRequestLocalService.fetchEmrgcyRequestByUuidAndCompanyId(
			uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _emrgcyRequestLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the emrgcy request with the primary key.
	 *
	 * @param requestId the primary key of the emrgcy request
	 * @return the emrgcy request
	 * @throws PortalException if a emrgcy request with the primary key could not be found
	 */
	@Override
	public RequestManagementDB.model.EmrgcyRequest getEmrgcyRequest(
			long requestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emrgcyRequestLocalService.getEmrgcyRequest(requestId);
	}

	/**
	 * Returns the emrgcy request with the matching UUID and company.
	 *
	 * @param uuid the emrgcy request's UUID
	 * @param companyId the primary key of the company
	 * @return the matching emrgcy request
	 * @throws PortalException if a matching emrgcy request could not be found
	 */
	@Override
	public RequestManagementDB.model.EmrgcyRequest
			getEmrgcyRequestByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emrgcyRequestLocalService.getEmrgcyRequestByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<RequestManagementDB.model.EmrgcyRequest>
		getEmrgcyRequests(int start, int end) {

		return _emrgcyRequestLocalService.getEmrgcyRequests(start, end);
	}

	/**
	 * Returns the number of emrgcy requests.
	 *
	 * @return the number of emrgcy requests
	 */
	@Override
	public int getEmrgcyRequestsCount() {
		return _emrgcyRequestLocalService.getEmrgcyRequestsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _emrgcyRequestLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _emrgcyRequestLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _emrgcyRequestLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _emrgcyRequestLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public RequestManagementDB.model.EmrgcyRequest updateEmrgcyRequest(
		RequestManagementDB.model.EmrgcyRequest emrgcyRequest) {

		return _emrgcyRequestLocalService.updateEmrgcyRequest(emrgcyRequest);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _emrgcyRequestLocalService.getBasePersistence();
	}

	@Override
	public EmrgcyRequestLocalService getWrappedService() {
		return _emrgcyRequestLocalService;
	}

	@Override
	public void setWrappedService(
		EmrgcyRequestLocalService emrgcyRequestLocalService) {

		_emrgcyRequestLocalService = emrgcyRequestLocalService;
	}

	private EmrgcyRequestLocalService _emrgcyRequestLocalService;

}