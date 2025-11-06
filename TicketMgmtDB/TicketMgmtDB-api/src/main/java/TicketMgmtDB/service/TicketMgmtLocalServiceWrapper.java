/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package TicketMgmtDB.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link TicketMgmtLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TicketMgmtLocalService
 * @generated
 */
public class TicketMgmtLocalServiceWrapper
	implements ServiceWrapper<TicketMgmtLocalService>, TicketMgmtLocalService {

	public TicketMgmtLocalServiceWrapper() {
		this(null);
	}

	public TicketMgmtLocalServiceWrapper(
		TicketMgmtLocalService ticketMgmtLocalService) {

		_ticketMgmtLocalService = ticketMgmtLocalService;
	}

	/**
	 * Adds the ticket mgmt to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TicketMgmtLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ticketMgmt the ticket mgmt
	 * @return the ticket mgmt that was added
	 */
	@Override
	public TicketMgmtDB.model.TicketMgmt addTicketMgmt(
		TicketMgmtDB.model.TicketMgmt ticketMgmt) {

		return _ticketMgmtLocalService.addTicketMgmt(ticketMgmt);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketMgmtLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new ticket mgmt with the primary key. Does not add the ticket mgmt to the database.
	 *
	 * @param ticket_id the primary key for the new ticket mgmt
	 * @return the new ticket mgmt
	 */
	@Override
	public TicketMgmtDB.model.TicketMgmt createTicketMgmt(long ticket_id) {
		return _ticketMgmtLocalService.createTicketMgmt(ticket_id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketMgmtLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the ticket mgmt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TicketMgmtLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ticket_id the primary key of the ticket mgmt
	 * @return the ticket mgmt that was removed
	 * @throws PortalException if a ticket mgmt with the primary key could not be found
	 */
	@Override
	public TicketMgmtDB.model.TicketMgmt deleteTicketMgmt(long ticket_id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketMgmtLocalService.deleteTicketMgmt(ticket_id);
	}

	/**
	 * Deletes the ticket mgmt from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TicketMgmtLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ticketMgmt the ticket mgmt
	 * @return the ticket mgmt that was removed
	 */
	@Override
	public TicketMgmtDB.model.TicketMgmt deleteTicketMgmt(
		TicketMgmtDB.model.TicketMgmt ticketMgmt) {

		return _ticketMgmtLocalService.deleteTicketMgmt(ticketMgmt);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _ticketMgmtLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _ticketMgmtLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ticketMgmtLocalService.dynamicQuery();
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

		return _ticketMgmtLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketMgmtDB.model.impl.TicketMgmtModelImpl</code>.
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

		return _ticketMgmtLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketMgmtDB.model.impl.TicketMgmtModelImpl</code>.
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

		return _ticketMgmtLocalService.dynamicQuery(
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

		return _ticketMgmtLocalService.dynamicQueryCount(dynamicQuery);
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

		return _ticketMgmtLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public TicketMgmtDB.model.TicketMgmt fetchTicketMgmt(long ticket_id) {
		return _ticketMgmtLocalService.fetchTicketMgmt(ticket_id);
	}

	/**
	 * Returns the ticket mgmt matching the UUID and group.
	 *
	 * @param uuid the ticket mgmt's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ticket mgmt, or <code>null</code> if a matching ticket mgmt could not be found
	 */
	@Override
	public TicketMgmtDB.model.TicketMgmt fetchTicketMgmtByUuidAndGroupId(
		String uuid, long groupId) {

		return _ticketMgmtLocalService.fetchTicketMgmtByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ticketMgmtLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _ticketMgmtLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ticketMgmtLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public TicketMgmtDB.model.TicketMgmt getInstance() {
		return _ticketMgmtLocalService.getInstance();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ticketMgmtLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketMgmtLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the ticket mgmt with the primary key.
	 *
	 * @param ticket_id the primary key of the ticket mgmt
	 * @return the ticket mgmt
	 * @throws PortalException if a ticket mgmt with the primary key could not be found
	 */
	@Override
	public TicketMgmtDB.model.TicketMgmt getTicketMgmt(long ticket_id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketMgmtLocalService.getTicketMgmt(ticket_id);
	}

	/**
	 * Returns the ticket mgmt matching the UUID and group.
	 *
	 * @param uuid the ticket mgmt's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ticket mgmt
	 * @throws PortalException if a matching ticket mgmt could not be found
	 */
	@Override
	public TicketMgmtDB.model.TicketMgmt getTicketMgmtByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketMgmtLocalService.getTicketMgmtByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the ticket mgmts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketMgmtDB.model.impl.TicketMgmtModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket mgmts
	 * @param end the upper bound of the range of ticket mgmts (not inclusive)
	 * @return the range of ticket mgmts
	 */
	@Override
	public java.util.List<TicketMgmtDB.model.TicketMgmt> getTicketMgmts(
		int start, int end) {

		return _ticketMgmtLocalService.getTicketMgmts(start, end);
	}

	/**
	 * Returns all the ticket mgmts matching the UUID and company.
	 *
	 * @param uuid the UUID of the ticket mgmts
	 * @param companyId the primary key of the company
	 * @return the matching ticket mgmts, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<TicketMgmtDB.model.TicketMgmt>
		getTicketMgmtsByUuidAndCompanyId(String uuid, long companyId) {

		return _ticketMgmtLocalService.getTicketMgmtsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of ticket mgmts matching the UUID and company.
	 *
	 * @param uuid the UUID of the ticket mgmts
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of ticket mgmts
	 * @param end the upper bound of the range of ticket mgmts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching ticket mgmts, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<TicketMgmtDB.model.TicketMgmt>
		getTicketMgmtsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<TicketMgmtDB.model.TicketMgmt> orderByComparator) {

		return _ticketMgmtLocalService.getTicketMgmtsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of ticket mgmts.
	 *
	 * @return the number of ticket mgmts
	 */
	@Override
	public int getTicketMgmtsCount() {
		return _ticketMgmtLocalService.getTicketMgmtsCount();
	}

	/**
	 * Updates the ticket mgmt in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TicketMgmtLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ticketMgmt the ticket mgmt
	 * @return the ticket mgmt that was updated
	 */
	@Override
	public TicketMgmtDB.model.TicketMgmt updateTicketMgmt(
		TicketMgmtDB.model.TicketMgmt ticketMgmt) {

		return _ticketMgmtLocalService.updateTicketMgmt(ticketMgmt);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _ticketMgmtLocalService.getBasePersistence();
	}

	@Override
	public TicketMgmtLocalService getWrappedService() {
		return _ticketMgmtLocalService;
	}

	@Override
	public void setWrappedService(
		TicketMgmtLocalService ticketMgmtLocalService) {

		_ticketMgmtLocalService = ticketMgmtLocalService;
	}

	private TicketMgmtLocalService _ticketMgmtLocalService;

}