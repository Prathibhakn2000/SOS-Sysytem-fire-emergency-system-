/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package TicketMgmtDB.service.persistence;

import TicketMgmtDB.exception.NoSuchTicketMgmtException;

import TicketMgmtDB.model.TicketMgmt;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ticket mgmt service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketMgmtUtil
 * @generated
 */
@ProviderType
public interface TicketMgmtPersistence extends BasePersistence<TicketMgmt> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TicketMgmtUtil} to access the ticket mgmt persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the ticket mgmts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ticket mgmts
	 */
	public java.util.List<TicketMgmt> findByUuid(String uuid);

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
	public java.util.List<TicketMgmt> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<TicketMgmt> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketMgmt>
			orderByComparator);

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
	public java.util.List<TicketMgmt> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketMgmt>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ticket mgmt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket mgmt
	 * @throws NoSuchTicketMgmtException if a matching ticket mgmt could not be found
	 */
	public TicketMgmt findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TicketMgmt>
				orderByComparator)
		throws NoSuchTicketMgmtException;

	/**
	 * Returns the first ticket mgmt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket mgmt, or <code>null</code> if a matching ticket mgmt could not be found
	 */
	public TicketMgmt fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TicketMgmt>
			orderByComparator);

	/**
	 * Returns the last ticket mgmt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket mgmt
	 * @throws NoSuchTicketMgmtException if a matching ticket mgmt could not be found
	 */
	public TicketMgmt findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TicketMgmt>
				orderByComparator)
		throws NoSuchTicketMgmtException;

	/**
	 * Returns the last ticket mgmt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket mgmt, or <code>null</code> if a matching ticket mgmt could not be found
	 */
	public TicketMgmt fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TicketMgmt>
			orderByComparator);

	/**
	 * Returns the ticket mgmts before and after the current ticket mgmt in the ordered set where uuid = &#63;.
	 *
	 * @param ticket_id the primary key of the current ticket mgmt
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket mgmt
	 * @throws NoSuchTicketMgmtException if a ticket mgmt with the primary key could not be found
	 */
	public TicketMgmt[] findByUuid_PrevAndNext(
			long ticket_id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TicketMgmt>
				orderByComparator)
		throws NoSuchTicketMgmtException;

	/**
	 * Removes all the ticket mgmts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of ticket mgmts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ticket mgmts
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the ticket mgmt where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTicketMgmtException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ticket mgmt
	 * @throws NoSuchTicketMgmtException if a matching ticket mgmt could not be found
	 */
	public TicketMgmt findByUUID_G(String uuid, long groupId)
		throws NoSuchTicketMgmtException;

	/**
	 * Returns the ticket mgmt where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ticket mgmt, or <code>null</code> if a matching ticket mgmt could not be found
	 */
	public TicketMgmt fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the ticket mgmt where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ticket mgmt, or <code>null</code> if a matching ticket mgmt could not be found
	 */
	public TicketMgmt fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the ticket mgmt where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ticket mgmt that was removed
	 */
	public TicketMgmt removeByUUID_G(String uuid, long groupId)
		throws NoSuchTicketMgmtException;

	/**
	 * Returns the number of ticket mgmts where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching ticket mgmts
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the ticket mgmts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching ticket mgmts
	 */
	public java.util.List<TicketMgmt> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<TicketMgmt> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<TicketMgmt> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketMgmt>
			orderByComparator);

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
	public java.util.List<TicketMgmt> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketMgmt>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ticket mgmt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket mgmt
	 * @throws NoSuchTicketMgmtException if a matching ticket mgmt could not be found
	 */
	public TicketMgmt findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TicketMgmt>
				orderByComparator)
		throws NoSuchTicketMgmtException;

	/**
	 * Returns the first ticket mgmt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket mgmt, or <code>null</code> if a matching ticket mgmt could not be found
	 */
	public TicketMgmt fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TicketMgmt>
			orderByComparator);

	/**
	 * Returns the last ticket mgmt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket mgmt
	 * @throws NoSuchTicketMgmtException if a matching ticket mgmt could not be found
	 */
	public TicketMgmt findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TicketMgmt>
				orderByComparator)
		throws NoSuchTicketMgmtException;

	/**
	 * Returns the last ticket mgmt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket mgmt, or <code>null</code> if a matching ticket mgmt could not be found
	 */
	public TicketMgmt fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TicketMgmt>
			orderByComparator);

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
	public TicketMgmt[] findByUuid_C_PrevAndNext(
			long ticket_id, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TicketMgmt>
				orderByComparator)
		throws NoSuchTicketMgmtException;

	/**
	 * Removes all the ticket mgmts where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of ticket mgmts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching ticket mgmts
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the ticket mgmt in the entity cache if it is enabled.
	 *
	 * @param ticketMgmt the ticket mgmt
	 */
	public void cacheResult(TicketMgmt ticketMgmt);

	/**
	 * Caches the ticket mgmts in the entity cache if it is enabled.
	 *
	 * @param ticketMgmts the ticket mgmts
	 */
	public void cacheResult(java.util.List<TicketMgmt> ticketMgmts);

	/**
	 * Creates a new ticket mgmt with the primary key. Does not add the ticket mgmt to the database.
	 *
	 * @param ticket_id the primary key for the new ticket mgmt
	 * @return the new ticket mgmt
	 */
	public TicketMgmt create(long ticket_id);

	/**
	 * Removes the ticket mgmt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticket_id the primary key of the ticket mgmt
	 * @return the ticket mgmt that was removed
	 * @throws NoSuchTicketMgmtException if a ticket mgmt with the primary key could not be found
	 */
	public TicketMgmt remove(long ticket_id) throws NoSuchTicketMgmtException;

	public TicketMgmt updateImpl(TicketMgmt ticketMgmt);

	/**
	 * Returns the ticket mgmt with the primary key or throws a <code>NoSuchTicketMgmtException</code> if it could not be found.
	 *
	 * @param ticket_id the primary key of the ticket mgmt
	 * @return the ticket mgmt
	 * @throws NoSuchTicketMgmtException if a ticket mgmt with the primary key could not be found
	 */
	public TicketMgmt findByPrimaryKey(long ticket_id)
		throws NoSuchTicketMgmtException;

	/**
	 * Returns the ticket mgmt with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ticket_id the primary key of the ticket mgmt
	 * @return the ticket mgmt, or <code>null</code> if a ticket mgmt with the primary key could not be found
	 */
	public TicketMgmt fetchByPrimaryKey(long ticket_id);

	/**
	 * Returns all the ticket mgmts.
	 *
	 * @return the ticket mgmts
	 */
	public java.util.List<TicketMgmt> findAll();

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
	public java.util.List<TicketMgmt> findAll(int start, int end);

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
	public java.util.List<TicketMgmt> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketMgmt>
			orderByComparator);

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
	public java.util.List<TicketMgmt> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketMgmt>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ticket mgmts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ticket mgmts.
	 *
	 * @return the number of ticket mgmts
	 */
	public int countAll();

}