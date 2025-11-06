/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package TicketMgmtDB.service;

import TicketMgmtDB.model.TicketMgmt;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for TicketMgmt. This utility wraps
 * <code>TicketMgmtDB.service.impl.TicketMgmtLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TicketMgmtLocalService
 * @generated
 */
public class TicketMgmtLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>TicketMgmtDB.service.impl.TicketMgmtLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static TicketMgmt addTicketMgmt(TicketMgmt ticketMgmt) {
		return getService().addTicketMgmt(ticketMgmt);
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
	 * Creates a new ticket mgmt with the primary key. Does not add the ticket mgmt to the database.
	 *
	 * @param ticket_id the primary key for the new ticket mgmt
	 * @return the new ticket mgmt
	 */
	public static TicketMgmt createTicketMgmt(long ticket_id) {
		return getService().createTicketMgmt(ticket_id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static TicketMgmt deleteTicketMgmt(long ticket_id)
		throws PortalException {

		return getService().deleteTicketMgmt(ticket_id);
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
	public static TicketMgmt deleteTicketMgmt(TicketMgmt ticketMgmt) {
		return getService().deleteTicketMgmt(ticketMgmt);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketMgmtDB.model.impl.TicketMgmtModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketMgmtDB.model.impl.TicketMgmtModelImpl</code>.
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

	public static TicketMgmt fetchTicketMgmt(long ticket_id) {
		return getService().fetchTicketMgmt(ticket_id);
	}

	/**
	 * Returns the ticket mgmt matching the UUID and group.
	 *
	 * @param uuid the ticket mgmt's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ticket mgmt, or <code>null</code> if a matching ticket mgmt could not be found
	 */
	public static TicketMgmt fetchTicketMgmtByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchTicketMgmtByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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

	public static TicketMgmt getInstance() {
		return getService().getInstance();
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
	 * Returns the ticket mgmt with the primary key.
	 *
	 * @param ticket_id the primary key of the ticket mgmt
	 * @return the ticket mgmt
	 * @throws PortalException if a ticket mgmt with the primary key could not be found
	 */
	public static TicketMgmt getTicketMgmt(long ticket_id)
		throws PortalException {

		return getService().getTicketMgmt(ticket_id);
	}

	/**
	 * Returns the ticket mgmt matching the UUID and group.
	 *
	 * @param uuid the ticket mgmt's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ticket mgmt
	 * @throws PortalException if a matching ticket mgmt could not be found
	 */
	public static TicketMgmt getTicketMgmtByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getTicketMgmtByUuidAndGroupId(uuid, groupId);
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
	public static List<TicketMgmt> getTicketMgmts(int start, int end) {
		return getService().getTicketMgmts(start, end);
	}

	/**
	 * Returns all the ticket mgmts matching the UUID and company.
	 *
	 * @param uuid the UUID of the ticket mgmts
	 * @param companyId the primary key of the company
	 * @return the matching ticket mgmts, or an empty list if no matches were found
	 */
	public static List<TicketMgmt> getTicketMgmtsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getTicketMgmtsByUuidAndCompanyId(uuid, companyId);
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
	public static List<TicketMgmt> getTicketMgmtsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TicketMgmt> orderByComparator) {

		return getService().getTicketMgmtsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of ticket mgmts.
	 *
	 * @return the number of ticket mgmts
	 */
	public static int getTicketMgmtsCount() {
		return getService().getTicketMgmtsCount();
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
	public static TicketMgmt updateTicketMgmt(TicketMgmt ticketMgmt) {
		return getService().updateTicketMgmt(ticketMgmt);
	}

	public static TicketMgmtLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<TicketMgmtLocalService> _serviceSnapshot =
		new Snapshot<>(
			TicketMgmtLocalServiceUtil.class, TicketMgmtLocalService.class);

}