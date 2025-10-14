/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package EmergencyRequestDB.service.persistence;

import EmergencyRequestDB.exception.NoSuchEmergencyRequestException;

import EmergencyRequestDB.model.EmergencyRequest;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the emergency request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmergencyRequestUtil
 * @generated
 */
@ProviderType
public interface EmergencyRequestPersistence
	extends BasePersistence<EmergencyRequest> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmergencyRequestUtil} to access the emergency request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the emergency requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching emergency requests
	 */
	public java.util.List<EmergencyRequest> findByUuid(String uuid);

	/**
	 * Returns a range of all the emergency requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmergencyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of emergency requests
	 * @param end the upper bound of the range of emergency requests (not inclusive)
	 * @return the range of matching emergency requests
	 */
	public java.util.List<EmergencyRequest> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the emergency requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmergencyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of emergency requests
	 * @param end the upper bound of the range of emergency requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emergency requests
	 */
	public java.util.List<EmergencyRequest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmergencyRequest>
			orderByComparator);

	/**
	 * Returns an ordered range of all the emergency requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmergencyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of emergency requests
	 * @param end the upper bound of the range of emergency requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching emergency requests
	 */
	public java.util.List<EmergencyRequest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmergencyRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first emergency request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emergency request
	 * @throws NoSuchEmergencyRequestException if a matching emergency request could not be found
	 */
	public EmergencyRequest findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmergencyRequest>
				orderByComparator)
		throws NoSuchEmergencyRequestException;

	/**
	 * Returns the first emergency request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emergency request, or <code>null</code> if a matching emergency request could not be found
	 */
	public EmergencyRequest fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmergencyRequest>
			orderByComparator);

	/**
	 * Returns the last emergency request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emergency request
	 * @throws NoSuchEmergencyRequestException if a matching emergency request could not be found
	 */
	public EmergencyRequest findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmergencyRequest>
				orderByComparator)
		throws NoSuchEmergencyRequestException;

	/**
	 * Returns the last emergency request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emergency request, or <code>null</code> if a matching emergency request could not be found
	 */
	public EmergencyRequest fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmergencyRequest>
			orderByComparator);

	/**
	 * Returns the emergency requests before and after the current emergency request in the ordered set where uuid = &#63;.
	 *
	 * @param requestId the primary key of the current emergency request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emergency request
	 * @throws NoSuchEmergencyRequestException if a emergency request with the primary key could not be found
	 */
	public EmergencyRequest[] findByUuid_PrevAndNext(
			long requestId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmergencyRequest>
				orderByComparator)
		throws NoSuchEmergencyRequestException;

	/**
	 * Removes all the emergency requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of emergency requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching emergency requests
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the emergency request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmergencyRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching emergency request
	 * @throws NoSuchEmergencyRequestException if a matching emergency request could not be found
	 */
	public EmergencyRequest findByUUID_G(String uuid, long groupId)
		throws NoSuchEmergencyRequestException;

	/**
	 * Returns the emergency request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching emergency request, or <code>null</code> if a matching emergency request could not be found
	 */
	public EmergencyRequest fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the emergency request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching emergency request, or <code>null</code> if a matching emergency request could not be found
	 */
	public EmergencyRequest fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the emergency request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the emergency request that was removed
	 */
	public EmergencyRequest removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmergencyRequestException;

	/**
	 * Returns the number of emergency requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching emergency requests
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the emergency requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching emergency requests
	 */
	public java.util.List<EmergencyRequest> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the emergency requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmergencyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of emergency requests
	 * @param end the upper bound of the range of emergency requests (not inclusive)
	 * @return the range of matching emergency requests
	 */
	public java.util.List<EmergencyRequest> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the emergency requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmergencyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of emergency requests
	 * @param end the upper bound of the range of emergency requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emergency requests
	 */
	public java.util.List<EmergencyRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmergencyRequest>
			orderByComparator);

	/**
	 * Returns an ordered range of all the emergency requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmergencyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of emergency requests
	 * @param end the upper bound of the range of emergency requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching emergency requests
	 */
	public java.util.List<EmergencyRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmergencyRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first emergency request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emergency request
	 * @throws NoSuchEmergencyRequestException if a matching emergency request could not be found
	 */
	public EmergencyRequest findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmergencyRequest>
				orderByComparator)
		throws NoSuchEmergencyRequestException;

	/**
	 * Returns the first emergency request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emergency request, or <code>null</code> if a matching emergency request could not be found
	 */
	public EmergencyRequest fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmergencyRequest>
			orderByComparator);

	/**
	 * Returns the last emergency request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emergency request
	 * @throws NoSuchEmergencyRequestException if a matching emergency request could not be found
	 */
	public EmergencyRequest findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmergencyRequest>
				orderByComparator)
		throws NoSuchEmergencyRequestException;

	/**
	 * Returns the last emergency request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emergency request, or <code>null</code> if a matching emergency request could not be found
	 */
	public EmergencyRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmergencyRequest>
			orderByComparator);

	/**
	 * Returns the emergency requests before and after the current emergency request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param requestId the primary key of the current emergency request
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emergency request
	 * @throws NoSuchEmergencyRequestException if a emergency request with the primary key could not be found
	 */
	public EmergencyRequest[] findByUuid_C_PrevAndNext(
			long requestId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmergencyRequest>
				orderByComparator)
		throws NoSuchEmergencyRequestException;

	/**
	 * Removes all the emergency requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of emergency requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching emergency requests
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the emergency requests where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching emergency requests
	 */
	public java.util.List<EmergencyRequest> findByUserId(long userId);

	/**
	 * Returns a range of all the emergency requests where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmergencyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of emergency requests
	 * @param end the upper bound of the range of emergency requests (not inclusive)
	 * @return the range of matching emergency requests
	 */
	public java.util.List<EmergencyRequest> findByUserId(
		long userId, int start, int end);

	/**
	 * Returns an ordered range of all the emergency requests where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmergencyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of emergency requests
	 * @param end the upper bound of the range of emergency requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emergency requests
	 */
	public java.util.List<EmergencyRequest> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmergencyRequest>
			orderByComparator);

	/**
	 * Returns an ordered range of all the emergency requests where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmergencyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of emergency requests
	 * @param end the upper bound of the range of emergency requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching emergency requests
	 */
	public java.util.List<EmergencyRequest> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmergencyRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first emergency request in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emergency request
	 * @throws NoSuchEmergencyRequestException if a matching emergency request could not be found
	 */
	public EmergencyRequest findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<EmergencyRequest>
				orderByComparator)
		throws NoSuchEmergencyRequestException;

	/**
	 * Returns the first emergency request in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emergency request, or <code>null</code> if a matching emergency request could not be found
	 */
	public EmergencyRequest fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<EmergencyRequest>
			orderByComparator);

	/**
	 * Returns the last emergency request in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emergency request
	 * @throws NoSuchEmergencyRequestException if a matching emergency request could not be found
	 */
	public EmergencyRequest findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<EmergencyRequest>
				orderByComparator)
		throws NoSuchEmergencyRequestException;

	/**
	 * Returns the last emergency request in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emergency request, or <code>null</code> if a matching emergency request could not be found
	 */
	public EmergencyRequest fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<EmergencyRequest>
			orderByComparator);

	/**
	 * Returns the emergency requests before and after the current emergency request in the ordered set where userId = &#63;.
	 *
	 * @param requestId the primary key of the current emergency request
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emergency request
	 * @throws NoSuchEmergencyRequestException if a emergency request with the primary key could not be found
	 */
	public EmergencyRequest[] findByUserId_PrevAndNext(
			long requestId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<EmergencyRequest>
				orderByComparator)
		throws NoSuchEmergencyRequestException;

	/**
	 * Removes all the emergency requests where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of emergency requests where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching emergency requests
	 */
	public int countByUserId(long userId);

	/**
	 * Caches the emergency request in the entity cache if it is enabled.
	 *
	 * @param emergencyRequest the emergency request
	 */
	public void cacheResult(EmergencyRequest emergencyRequest);

	/**
	 * Caches the emergency requests in the entity cache if it is enabled.
	 *
	 * @param emergencyRequests the emergency requests
	 */
	public void cacheResult(java.util.List<EmergencyRequest> emergencyRequests);

	/**
	 * Creates a new emergency request with the primary key. Does not add the emergency request to the database.
	 *
	 * @param requestId the primary key for the new emergency request
	 * @return the new emergency request
	 */
	public EmergencyRequest create(long requestId);

	/**
	 * Removes the emergency request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param requestId the primary key of the emergency request
	 * @return the emergency request that was removed
	 * @throws NoSuchEmergencyRequestException if a emergency request with the primary key could not be found
	 */
	public EmergencyRequest remove(long requestId)
		throws NoSuchEmergencyRequestException;

	public EmergencyRequest updateImpl(EmergencyRequest emergencyRequest);

	/**
	 * Returns the emergency request with the primary key or throws a <code>NoSuchEmergencyRequestException</code> if it could not be found.
	 *
	 * @param requestId the primary key of the emergency request
	 * @return the emergency request
	 * @throws NoSuchEmergencyRequestException if a emergency request with the primary key could not be found
	 */
	public EmergencyRequest findByPrimaryKey(long requestId)
		throws NoSuchEmergencyRequestException;

	/**
	 * Returns the emergency request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param requestId the primary key of the emergency request
	 * @return the emergency request, or <code>null</code> if a emergency request with the primary key could not be found
	 */
	public EmergencyRequest fetchByPrimaryKey(long requestId);

	/**
	 * Returns all the emergency requests.
	 *
	 * @return the emergency requests
	 */
	public java.util.List<EmergencyRequest> findAll();

	/**
	 * Returns a range of all the emergency requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmergencyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of emergency requests
	 * @param end the upper bound of the range of emergency requests (not inclusive)
	 * @return the range of emergency requests
	 */
	public java.util.List<EmergencyRequest> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the emergency requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmergencyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of emergency requests
	 * @param end the upper bound of the range of emergency requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of emergency requests
	 */
	public java.util.List<EmergencyRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmergencyRequest>
			orderByComparator);

	/**
	 * Returns an ordered range of all the emergency requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmergencyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of emergency requests
	 * @param end the upper bound of the range of emergency requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of emergency requests
	 */
	public java.util.List<EmergencyRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmergencyRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the emergency requests from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of emergency requests.
	 *
	 * @return the number of emergency requests
	 */
	public int countAll();

}