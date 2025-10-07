/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package RoleManagementDB.service.persistence;

import RoleManagementDB.model.RoleTable;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the role table service. This utility wraps <code>RoleManagementDB.service.persistence.impl.RoleTablePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RoleTablePersistence
 * @generated
 */
public class RoleTableUtil {

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
	public static void clearCache(RoleTable roleTable) {
		getPersistence().clearCache(roleTable);
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
	public static Map<Serializable, RoleTable> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RoleTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RoleTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RoleTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RoleTable> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RoleTable update(RoleTable roleTable) {
		return getPersistence().update(roleTable);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RoleTable update(
		RoleTable roleTable, ServiceContext serviceContext) {

		return getPersistence().update(roleTable, serviceContext);
	}

	/**
	 * Returns all the role tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching role tables
	 */
	public static List<RoleTable> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the role tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of role tables
	 * @param end the upper bound of the range of role tables (not inclusive)
	 * @return the range of matching role tables
	 */
	public static List<RoleTable> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the role tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of role tables
	 * @param end the upper bound of the range of role tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching role tables
	 */
	public static List<RoleTable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RoleTable> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the role tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of role tables
	 * @param end the upper bound of the range of role tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching role tables
	 */
	public static List<RoleTable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RoleTable> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first role table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role table
	 * @throws NoSuchRoleTableException if a matching role table could not be found
	 */
	public static RoleTable findByUuid_First(
			String uuid, OrderByComparator<RoleTable> orderByComparator)
		throws RoleManagementDB.exception.NoSuchRoleTableException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first role table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role table, or <code>null</code> if a matching role table could not be found
	 */
	public static RoleTable fetchByUuid_First(
		String uuid, OrderByComparator<RoleTable> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last role table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role table
	 * @throws NoSuchRoleTableException if a matching role table could not be found
	 */
	public static RoleTable findByUuid_Last(
			String uuid, OrderByComparator<RoleTable> orderByComparator)
		throws RoleManagementDB.exception.NoSuchRoleTableException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last role table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role table, or <code>null</code> if a matching role table could not be found
	 */
	public static RoleTable fetchByUuid_Last(
		String uuid, OrderByComparator<RoleTable> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the role tables before and after the current role table in the ordered set where uuid = &#63;.
	 *
	 * @param roleId the primary key of the current role table
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role table
	 * @throws NoSuchRoleTableException if a role table with the primary key could not be found
	 */
	public static RoleTable[] findByUuid_PrevAndNext(
			long roleId, String uuid,
			OrderByComparator<RoleTable> orderByComparator)
		throws RoleManagementDB.exception.NoSuchRoleTableException {

		return getPersistence().findByUuid_PrevAndNext(
			roleId, uuid, orderByComparator);
	}

	/**
	 * Removes all the role tables where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of role tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching role tables
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the role table where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRoleTableException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching role table
	 * @throws NoSuchRoleTableException if a matching role table could not be found
	 */
	public static RoleTable findByUUID_G(String uuid, long groupId)
		throws RoleManagementDB.exception.NoSuchRoleTableException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the role table where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching role table, or <code>null</code> if a matching role table could not be found
	 */
	public static RoleTable fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the role table where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching role table, or <code>null</code> if a matching role table could not be found
	 */
	public static RoleTable fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the role table where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the role table that was removed
	 */
	public static RoleTable removeByUUID_G(String uuid, long groupId)
		throws RoleManagementDB.exception.NoSuchRoleTableException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of role tables where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching role tables
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the role tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching role tables
	 */
	public static List<RoleTable> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the role tables where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of role tables
	 * @param end the upper bound of the range of role tables (not inclusive)
	 * @return the range of matching role tables
	 */
	public static List<RoleTable> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the role tables where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of role tables
	 * @param end the upper bound of the range of role tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching role tables
	 */
	public static List<RoleTable> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RoleTable> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the role tables where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of role tables
	 * @param end the upper bound of the range of role tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching role tables
	 */
	public static List<RoleTable> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RoleTable> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first role table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role table
	 * @throws NoSuchRoleTableException if a matching role table could not be found
	 */
	public static RoleTable findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<RoleTable> orderByComparator)
		throws RoleManagementDB.exception.NoSuchRoleTableException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first role table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role table, or <code>null</code> if a matching role table could not be found
	 */
	public static RoleTable fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<RoleTable> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last role table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role table
	 * @throws NoSuchRoleTableException if a matching role table could not be found
	 */
	public static RoleTable findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<RoleTable> orderByComparator)
		throws RoleManagementDB.exception.NoSuchRoleTableException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last role table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role table, or <code>null</code> if a matching role table could not be found
	 */
	public static RoleTable fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<RoleTable> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the role tables before and after the current role table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param roleId the primary key of the current role table
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role table
	 * @throws NoSuchRoleTableException if a role table with the primary key could not be found
	 */
	public static RoleTable[] findByUuid_C_PrevAndNext(
			long roleId, String uuid, long companyId,
			OrderByComparator<RoleTable> orderByComparator)
		throws RoleManagementDB.exception.NoSuchRoleTableException {

		return getPersistence().findByUuid_C_PrevAndNext(
			roleId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the role tables where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of role tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching role tables
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the role table in the entity cache if it is enabled.
	 *
	 * @param roleTable the role table
	 */
	public static void cacheResult(RoleTable roleTable) {
		getPersistence().cacheResult(roleTable);
	}

	/**
	 * Caches the role tables in the entity cache if it is enabled.
	 *
	 * @param roleTables the role tables
	 */
	public static void cacheResult(List<RoleTable> roleTables) {
		getPersistence().cacheResult(roleTables);
	}

	/**
	 * Creates a new role table with the primary key. Does not add the role table to the database.
	 *
	 * @param roleId the primary key for the new role table
	 * @return the new role table
	 */
	public static RoleTable create(long roleId) {
		return getPersistence().create(roleId);
	}

	/**
	 * Removes the role table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param roleId the primary key of the role table
	 * @return the role table that was removed
	 * @throws NoSuchRoleTableException if a role table with the primary key could not be found
	 */
	public static RoleTable remove(long roleId)
		throws RoleManagementDB.exception.NoSuchRoleTableException {

		return getPersistence().remove(roleId);
	}

	public static RoleTable updateImpl(RoleTable roleTable) {
		return getPersistence().updateImpl(roleTable);
	}

	/**
	 * Returns the role table with the primary key or throws a <code>NoSuchRoleTableException</code> if it could not be found.
	 *
	 * @param roleId the primary key of the role table
	 * @return the role table
	 * @throws NoSuchRoleTableException if a role table with the primary key could not be found
	 */
	public static RoleTable findByPrimaryKey(long roleId)
		throws RoleManagementDB.exception.NoSuchRoleTableException {

		return getPersistence().findByPrimaryKey(roleId);
	}

	/**
	 * Returns the role table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param roleId the primary key of the role table
	 * @return the role table, or <code>null</code> if a role table with the primary key could not be found
	 */
	public static RoleTable fetchByPrimaryKey(long roleId) {
		return getPersistence().fetchByPrimaryKey(roleId);
	}

	/**
	 * Returns all the role tables.
	 *
	 * @return the role tables
	 */
	public static List<RoleTable> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the role tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role tables
	 * @param end the upper bound of the range of role tables (not inclusive)
	 * @return the range of role tables
	 */
	public static List<RoleTable> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the role tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role tables
	 * @param end the upper bound of the range of role tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of role tables
	 */
	public static List<RoleTable> findAll(
		int start, int end, OrderByComparator<RoleTable> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the role tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role tables
	 * @param end the upper bound of the range of role tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of role tables
	 */
	public static List<RoleTable> findAll(
		int start, int end, OrderByComparator<RoleTable> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the role tables from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of role tables.
	 *
	 * @return the number of role tables
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RoleTablePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(RoleTablePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile RoleTablePersistence _persistence;

}