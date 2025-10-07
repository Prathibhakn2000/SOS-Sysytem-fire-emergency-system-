/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package RoleManagementDB.service.persistence;

import RoleManagementDB.exception.NoSuchUserRoleTableException;

import RoleManagementDB.model.UserRoleTable;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user role table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserRoleTableUtil
 * @generated
 */
@ProviderType
public interface UserRoleTablePersistence
	extends BasePersistence<UserRoleTable> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserRoleTableUtil} to access the user role table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the user role table in the entity cache if it is enabled.
	 *
	 * @param userRoleTable the user role table
	 */
	public void cacheResult(UserRoleTable userRoleTable);

	/**
	 * Caches the user role tables in the entity cache if it is enabled.
	 *
	 * @param userRoleTables the user role tables
	 */
	public void cacheResult(java.util.List<UserRoleTable> userRoleTables);

	/**
	 * Creates a new user role table with the primary key. Does not add the user role table to the database.
	 *
	 * @param userRoleId the primary key for the new user role table
	 * @return the new user role table
	 */
	public UserRoleTable create(long userRoleId);

	/**
	 * Removes the user role table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userRoleId the primary key of the user role table
	 * @return the user role table that was removed
	 * @throws NoSuchUserRoleTableException if a user role table with the primary key could not be found
	 */
	public UserRoleTable remove(long userRoleId)
		throws NoSuchUserRoleTableException;

	public UserRoleTable updateImpl(UserRoleTable userRoleTable);

	/**
	 * Returns the user role table with the primary key or throws a <code>NoSuchUserRoleTableException</code> if it could not be found.
	 *
	 * @param userRoleId the primary key of the user role table
	 * @return the user role table
	 * @throws NoSuchUserRoleTableException if a user role table with the primary key could not be found
	 */
	public UserRoleTable findByPrimaryKey(long userRoleId)
		throws NoSuchUserRoleTableException;

	/**
	 * Returns the user role table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userRoleId the primary key of the user role table
	 * @return the user role table, or <code>null</code> if a user role table with the primary key could not be found
	 */
	public UserRoleTable fetchByPrimaryKey(long userRoleId);

	/**
	 * Returns all the user role tables.
	 *
	 * @return the user role tables
	 */
	public java.util.List<UserRoleTable> findAll();

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
	public java.util.List<UserRoleTable> findAll(int start, int end);

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
	public java.util.List<UserRoleTable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserRoleTable>
			orderByComparator);

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
	public java.util.List<UserRoleTable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserRoleTable>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the user role tables from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user role tables.
	 *
	 * @return the number of user role tables
	 */
	public int countAll();

}