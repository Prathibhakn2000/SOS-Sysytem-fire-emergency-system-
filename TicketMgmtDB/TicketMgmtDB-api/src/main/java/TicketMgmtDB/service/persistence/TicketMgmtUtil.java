/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package TicketMgmtDB.service.persistence;

import TicketMgmtDB.model.TicketMgmt;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the ticket mgmt service. This utility wraps <code>TicketMgmtDB.service.persistence.impl.TicketMgmtPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketMgmtPersistence
 * @generated
 */
public class TicketMgmtUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(TicketMgmt ticketMgmt) {
		getPersistence().clearCache(ticketMgmt);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, TicketMgmt> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TicketMgmt> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TicketMgmt> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TicketMgmt> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TicketMgmt> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TicketMgmt update(TicketMgmt ticketMgmt) {
		return getPersistence().update(ticketMgmt);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TicketMgmt update(
		TicketMgmt ticketMgmt, ServiceContext serviceContext) {

		return getPersistence().update(ticketMgmt, serviceContext);
	}

	/**
	 * Returns all the ticket mgmts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ticket mgmts
	 */
	public static List<TicketMgmt> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the ticket mgmts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketMgmtModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ticket mgmts
	 * @param end the upper bound of the range of ticket mgmts (not inclusive)
	 * @return the range of matching ticket mgmts
	 */
	public static List<TicketMgmt> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the ticket mgmts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketMgmtModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ticket mgmts
	 * @param end the upper bound of the range of ticket mgmts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket mgmts
	 */
	public static List<TicketMgmt> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TicketMgmt> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket mgmts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketMgmtModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ticket mgmts
	 * @param end the upper bound of the range of ticket mgmts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket mgmts
	 */
	public static List<TicketMgmt> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TicketMgmt> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ticket mgmt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket mgmt
	 * @throws NoSuchTicketMgmtException if a matching ticket mgmt could not be found
	 */
	public static TicketMgmt findByUuid_First(
			String uuid, OrderByComparator<TicketMgmt> orderByComparator)
		throws TicketMgmtDB.exception.NoSuchTicketMgmtException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first ticket mgmt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket mgmt, or <code>null</code> if a matching ticket mgmt could not be found
	 */
	public static TicketMgmt fetchByUuid_First(
		String uuid, OrderByComparator<TicketMgmt> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last ticket mgmt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket mgmt
	 * @throws NoSuchTicketMgmtException if a matching ticket mgmt could not be found
	 */
	public static TicketMgmt findByUuid_Last(
			String uuid, OrderByComparator<TicketMgmt> orderByComparator)
		throws TicketMgmtDB.exception.NoSuchTicketMgmtException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last ticket mgmt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket mgmt, or <code>null</code> if a matching ticket mgmt could not be found
	 */
	public static TicketMgmt fetchByUuid_Last(
		String uuid, OrderByComparator<TicketMgmt> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the ticket mgmts before and after the current ticket mgmt in the ordered set where uuid = &#63;.
	 *
	 * @param ticket_id the primary key of the current ticket mgmt
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket mgmt
	 * @throws NoSuchTicketMgmtException if a ticket mgmt with the primary key could not be found
	 */
	public static TicketMgmt[] findByUuid_PrevAndNext(
			long ticket_id, String uuid,
			OrderByComparator<TicketMgmt> orderByComparator)
		throws TicketMgmtDB.exception.NoSuchTicketMgmtException {

		return getPersistence().findByUuid_PrevAndNext(
			ticket_id, uuid, orderByComparator);
	}

	/**
	 * Removes all the ticket mgmts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of ticket mgmts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ticket mgmts
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the ticket mgmt where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTicketMgmtException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ticket mgmt
	 * @throws NoSuchTicketMgmtException if a matching ticket mgmt could not be found
	 */
	public static TicketMgmt findByUUID_G(String uuid, long groupId)
		throws TicketMgmtDB.exception.NoSuchTicketMgmtException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the ticket mgmt where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ticket mgmt, or <code>null</code> if a matching ticket mgmt could not be found
	 */
	public static TicketMgmt fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the ticket mgmt where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ticket mgmt, or <code>null</code> if a matching ticket mgmt could not be found
	 */
	public static TicketMgmt fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the ticket mgmt where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ticket mgmt that was removed
	 */
	public static TicketMgmt removeByUUID_G(String uuid, long groupId)
		throws TicketMgmtDB.exception.NoSuchTicketMgmtException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of ticket mgmts where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching ticket mgmts
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the ticket mgmts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching ticket mgmts
	 */
	public static List<TicketMgmt> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the ticket mgmts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketMgmtModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ticket mgmts
	 * @param end the upper bound of the range of ticket mgmts (not inclusive)
	 * @return the range of matching ticket mgmts
	 */
	public static List<TicketMgmt> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the ticket mgmts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketMgmtModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ticket mgmts
	 * @param end the upper bound of the range of ticket mgmts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket mgmts
	 */
	public static List<TicketMgmt> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TicketMgmt> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket mgmts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketMgmtModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ticket mgmts
	 * @param end the upper bound of the range of ticket mgmts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket mgmts
	 */
	public static List<TicketMgmt> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TicketMgmt> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ticket mgmt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket mgmt
	 * @throws NoSuchTicketMgmtException if a matching ticket mgmt could not be found
	 */
	public static TicketMgmt findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TicketMgmt> orderByComparator)
		throws TicketMgmtDB.exception.NoSuchTicketMgmtException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first ticket mgmt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket mgmt, or <code>null</code> if a matching ticket mgmt could not be found
	 */
	public static TicketMgmt fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TicketMgmt> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last ticket mgmt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket mgmt
	 * @throws NoSuchTicketMgmtException if a matching ticket mgmt could not be found
	 */
	public static TicketMgmt findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TicketMgmt> orderByComparator)
		throws TicketMgmtDB.exception.NoSuchTicketMgmtException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last ticket mgmt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket mgmt, or <code>null</code> if a matching ticket mgmt could not be found
	 */
	public static TicketMgmt fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TicketMgmt> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the ticket mgmts before and after the current ticket mgmt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param ticket_id the primary key of the current ticket mgmt
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket mgmt
	 * @throws NoSuchTicketMgmtException if a ticket mgmt with the primary key could not be found
	 */
	public static TicketMgmt[] findByUuid_C_PrevAndNext(
			long ticket_id, String uuid, long companyId,
			OrderByComparator<TicketMgmt> orderByComparator)
		throws TicketMgmtDB.exception.NoSuchTicketMgmtException {

		return getPersistence().findByUuid_C_PrevAndNext(
			ticket_id, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the ticket mgmts where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of ticket mgmts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching ticket mgmts
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the ticket mgmt in the entity cache if it is enabled.
	 *
	 * @param ticketMgmt the ticket mgmt
	 */
	public static void cacheResult(TicketMgmt ticketMgmt) {
		getPersistence().cacheResult(ticketMgmt);
	}

	/**
	 * Caches the ticket mgmts in the entity cache if it is enabled.
	 *
	 * @param ticketMgmts the ticket mgmts
	 */
	public static void cacheResult(List<TicketMgmt> ticketMgmts) {
		getPersistence().cacheResult(ticketMgmts);
	}

	/**
	 * Creates a new ticket mgmt with the primary key. Does not add the ticket mgmt to the database.
	 *
	 * @param ticket_id the primary key for the new ticket mgmt
	 * @return the new ticket mgmt
	 */
	public static TicketMgmt create(long ticket_id) {
		return getPersistence().create(ticket_id);
	}

	/**
	 * Removes the ticket mgmt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticket_id the primary key of the ticket mgmt
	 * @return the ticket mgmt that was removed
	 * @throws NoSuchTicketMgmtException if a ticket mgmt with the primary key could not be found
	 */
	public static TicketMgmt remove(long ticket_id)
		throws TicketMgmtDB.exception.NoSuchTicketMgmtException {

		return getPersistence().remove(ticket_id);
	}

	public static TicketMgmt updateImpl(TicketMgmt ticketMgmt) {
		return getPersistence().updateImpl(ticketMgmt);
	}

	/**
	 * Returns the ticket mgmt with the primary key or throws a <code>NoSuchTicketMgmtException</code> if it could not be found.
	 *
	 * @param ticket_id the primary key of the ticket mgmt
	 * @return the ticket mgmt
	 * @throws NoSuchTicketMgmtException if a ticket mgmt with the primary key could not be found
	 */
	public static TicketMgmt findByPrimaryKey(long ticket_id)
		throws TicketMgmtDB.exception.NoSuchTicketMgmtException {

		return getPersistence().findByPrimaryKey(ticket_id);
	}

	/**
	 * Returns the ticket mgmt with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ticket_id the primary key of the ticket mgmt
	 * @return the ticket mgmt, or <code>null</code> if a ticket mgmt with the primary key could not be found
	 */
	public static TicketMgmt fetchByPrimaryKey(long ticket_id) {
		return getPersistence().fetchByPrimaryKey(ticket_id);
	}

	/**
	 * Returns all the ticket mgmts.
	 *
	 * @return the ticket mgmts
	 */
	public static List<TicketMgmt> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ticket mgmts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketMgmtModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket mgmts
	 * @param end the upper bound of the range of ticket mgmts (not inclusive)
	 * @return the range of ticket mgmts
	 */
	public static List<TicketMgmt> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ticket mgmts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketMgmtModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket mgmts
	 * @param end the upper bound of the range of ticket mgmts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket mgmts
	 */
	public static List<TicketMgmt> findAll(
		int start, int end, OrderByComparator<TicketMgmt> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket mgmts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketMgmtModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket mgmts
	 * @param end the upper bound of the range of ticket mgmts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ticket mgmts
	 */
	public static List<TicketMgmt> findAll(
		int start, int end, OrderByComparator<TicketMgmt> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ticket mgmts from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ticket mgmts.
	 *
	 * @return the number of ticket mgmts
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TicketMgmtPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(TicketMgmtPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile TicketMgmtPersistence _persistence;

}