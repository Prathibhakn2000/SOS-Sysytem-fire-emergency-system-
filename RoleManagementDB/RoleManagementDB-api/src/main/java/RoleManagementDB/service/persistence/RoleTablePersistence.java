/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package RoleManagementDB.service.persistence;

import RoleManagementDB.exception.NoSuchRoleTableException;

import RoleManagementDB.model.RoleTable;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the role table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RoleTableUtil
 * @generated
 */
@ProviderType
public interface RoleTablePersistence extends BasePersistence<RoleTable> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RoleTableUtil} to access the role table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the role tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching role tables
	 */
	public java.util.List<RoleTable> findByUuid(String uuid);

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
	public java.util.List<RoleTable> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<RoleTable> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RoleTable>
			orderByComparator);

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
	public java.util.List<RoleTable> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RoleTable>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first role table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role table
	 * @throws NoSuchRoleTableException if a matching role table could not be found
	 */
	public RoleTable findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<RoleTable>
				orderByComparator)
		throws NoSuchRoleTableException;

	/**
	 * Returns the first role table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role table, or <code>null</code> if a matching role table could not be found
	 */
	public RoleTable fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RoleTable>
			orderByComparator);

	/**
	 * Returns the last role table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role table
	 * @throws NoSuchRoleTableException if a matching role table could not be found
	 */
	public RoleTable findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<RoleTable>
				orderByComparator)
		throws NoSuchRoleTableException;

	/**
	 * Returns the last role table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role table, or <code>null</code> if a matching role table could not be found
	 */
	public RoleTable fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<RoleTable>
			orderByComparator);

	/**
	 * Returns the role tables before and after the current role table in the ordered set where uuid = &#63;.
	 *
	 * @param roleId the primary key of the current role table
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role table
	 * @throws NoSuchRoleTableException if a role table with the primary key could not be found
	 */
	public RoleTable[] findByUuid_PrevAndNext(
			long roleId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<RoleTable>
				orderByComparator)
		throws NoSuchRoleTableException;

	/**
	 * Removes all the role tables where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of role tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching role tables
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the role table where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRoleTableException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching role table
	 * @throws NoSuchRoleTableException if a matching role table could not be found
	 */
	public RoleTable findByUUID_G(String uuid, long groupId)
		throws NoSuchRoleTableException;

	/**
	 * Returns the role table where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching role table, or <code>null</code> if a matching role table could not be found
	 */
	public RoleTable fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the role table where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching role table, or <code>null</code> if a matching role table could not be found
	 */
	public RoleTable fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the role table where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the role table that was removed
	 */
	public RoleTable removeByUUID_G(String uuid, long groupId)
		throws NoSuchRoleTableException;

	/**
	 * Returns the number of role tables where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching role tables
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the role tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching role tables
	 */
	public java.util.List<RoleTable> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<RoleTable> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<RoleTable> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RoleTable>
			orderByComparator);

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
	public java.util.List<RoleTable> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RoleTable>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first role table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role table
	 * @throws NoSuchRoleTableException if a matching role table could not be found
	 */
	public RoleTable findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<RoleTable>
				orderByComparator)
		throws NoSuchRoleTableException;

	/**
	 * Returns the first role table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role table, or <code>null</code> if a matching role table could not be found
	 */
	public RoleTable fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<RoleTable>
			orderByComparator);

	/**
	 * Returns the last role table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role table
	 * @throws NoSuchRoleTableException if a matching role table could not be found
	 */
	public RoleTable findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<RoleTable>
				orderByComparator)
		throws NoSuchRoleTableException;

	/**
	 * Returns the last role table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role table, or <code>null</code> if a matching role table could not be found
	 */
	public RoleTable fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<RoleTable>
			orderByComparator);

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
	public RoleTable[] findByUuid_C_PrevAndNext(
			long roleId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<RoleTable>
				orderByComparator)
		throws NoSuchRoleTableException;

	/**
	 * Removes all the role tables where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of role tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching role tables
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the role table in the entity cache if it is enabled.
	 *
	 * @param roleTable the role table
	 */
	public void cacheResult(RoleTable roleTable);

	/**
	 * Caches the role tables in the entity cache if it is enabled.
	 *
	 * @param roleTables the role tables
	 */
	public void cacheResult(java.util.List<RoleTable> roleTables);

	/**
	 * Creates a new role table with the primary key. Does not add the role table to the database.
	 *
	 * @param roleId the primary key for the new role table
	 * @return the new role table
	 */
	public RoleTable create(long roleId);

	/**
	 * Removes the role table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param roleId the primary key of the role table
	 * @return the role table that was removed
	 * @throws NoSuchRoleTableException if a role table with the primary key could not be found
	 */
	public RoleTable remove(long roleId) throws NoSuchRoleTableException;

	public RoleTable updateImpl(RoleTable roleTable);

	/**
	 * Returns the role table with the primary key or throws a <code>NoSuchRoleTableException</code> if it could not be found.
	 *
	 * @param roleId the primary key of the role table
	 * @return the role table
	 * @throws NoSuchRoleTableException if a role table with the primary key could not be found
	 */
	public RoleTable findByPrimaryKey(long roleId)
		throws NoSuchRoleTableException;

	/**
	 * Returns the role table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param roleId the primary key of the role table
	 * @return the role table, or <code>null</code> if a role table with the primary key could not be found
	 */
	public RoleTable fetchByPrimaryKey(long roleId);

	/**
	 * Returns all the role tables.
	 *
	 * @return the role tables
	 */
	public java.util.List<RoleTable> findAll();

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
	public java.util.List<RoleTable> findAll(int start, int end);

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
	public java.util.List<RoleTable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RoleTable>
			orderByComparator);

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
	public java.util.List<RoleTable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RoleTable>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the role tables from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of role tables.
	 *
	 * @return the number of role tables
	 */
	public int countAll();

}