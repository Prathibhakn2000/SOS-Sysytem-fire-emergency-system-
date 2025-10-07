/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package RoleManagementDB.service.persistence;

import RoleManagementDB.model.UserRoleTable;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the user role table service. This utility wraps <code>RoleManagementDB.service.persistence.impl.UserRoleTablePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserRoleTablePersistence
 * @generated
 */
public class UserRoleTableUtil {

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
	public static void clearCache(UserRoleTable userRoleTable) {
		getPersistence().clearCache(userRoleTable);
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
	public static Map<Serializable, UserRoleTable> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserRoleTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserRoleTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserRoleTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserRoleTable> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserRoleTable update(UserRoleTable userRoleTable) {
		return getPersistence().update(userRoleTable);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserRoleTable update(
		UserRoleTable userRoleTable, ServiceContext serviceContext) {

		return getPersistence().update(userRoleTable, serviceContext);
	}

	/**
	 * Caches the user role table in the entity cache if it is enabled.
	 *
	 * @param userRoleTable the user role table
	 */
	public static void cacheResult(UserRoleTable userRoleTable) {
		getPersistence().cacheResult(userRoleTable);
	}

	/**
	 * Caches the user role tables in the entity cache if it is enabled.
	 *
	 * @param userRoleTables the user role tables
	 */
	public static void cacheResult(List<UserRoleTable> userRoleTables) {
		getPersistence().cacheResult(userRoleTables);
	}

	/**
	 * Creates a new user role table with the primary key. Does not add the user role table to the database.
	 *
	 * @param userRoleId the primary key for the new user role table
	 * @return the new user role table
	 */
	public static UserRoleTable create(long userRoleId) {
		return getPersistence().create(userRoleId);
	}

	/**
	 * Removes the user role table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userRoleId the primary key of the user role table
	 * @return the user role table that was removed
	 * @throws NoSuchUserRoleTableException if a user role table with the primary key could not be found
	 */
	public static UserRoleTable remove(long userRoleId)
		throws RoleManagementDB.exception.NoSuchUserRoleTableException {

		return getPersistence().remove(userRoleId);
	}

	public static UserRoleTable updateImpl(UserRoleTable userRoleTable) {
		return getPersistence().updateImpl(userRoleTable);
	}

	/**
	 * Returns the user role table with the primary key or throws a <code>NoSuchUserRoleTableException</code> if it could not be found.
	 *
	 * @param userRoleId the primary key of the user role table
	 * @return the user role table
	 * @throws NoSuchUserRoleTableException if a user role table with the primary key could not be found
	 */
	public static UserRoleTable findByPrimaryKey(long userRoleId)
		throws RoleManagementDB.exception.NoSuchUserRoleTableException {

		return getPersistence().findByPrimaryKey(userRoleId);
	}

	/**
	 * Returns the user role table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userRoleId the primary key of the user role table
	 * @return the user role table, or <code>null</code> if a user role table with the primary key could not be found
	 */
	public static UserRoleTable fetchByPrimaryKey(long userRoleId) {
		return getPersistence().fetchByPrimaryKey(userRoleId);
	}

	/**
	 * Returns all the user role tables.
	 *
	 * @return the user role tables
	 */
	public static List<UserRoleTable> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the user role tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRoleTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user role tables
	 * @param end the upper bound of the range of user role tables (not inclusive)
	 * @return the range of user role tables
	 */
	public static List<UserRoleTable> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the user role tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRoleTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user role tables
	 * @param end the upper bound of the range of user role tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user role tables
	 */
	public static List<UserRoleTable> findAll(
		int start, int end,
		OrderByComparator<UserRoleTable> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user role tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRoleTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user role tables
	 * @param end the upper bound of the range of user role tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user role tables
	 */
	public static List<UserRoleTable> findAll(
		int start, int end, OrderByComparator<UserRoleTable> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the user role tables from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of user role tables.
	 *
	 * @return the number of user role tables
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static UserRoleTablePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(UserRoleTablePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile UserRoleTablePersistence _persistence;

}