/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package RequestManagementDB.service.persistence;

import RequestManagementDB.exception.NoSuchEmrgcyRequestException;

import RequestManagementDB.model.EmrgcyRequest;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the emrgcy request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmrgcyRequestUtil
 * @generated
 */
@ProviderType
public interface EmrgcyRequestPersistence
	extends BasePersistence<EmrgcyRequest> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmrgcyRequestUtil} to access the emrgcy request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the emrgcy requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching emrgcy requests
	 */
	public java.util.List<EmrgcyRequest> findByUuid(String uuid);

	/**
	 * Returns a range of all the emrgcy requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmrgcyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of emrgcy requests
	 * @param end the upper bound of the range of emrgcy requests (not inclusive)
	 * @return the range of matching emrgcy requests
	 */
	public java.util.List<EmrgcyRequest> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the emrgcy requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmrgcyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of emrgcy requests
	 * @param end the upper bound of the range of emrgcy requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emrgcy requests
	 */
	public java.util.List<EmrgcyRequest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmrgcyRequest>
			orderByComparator);

	/**
	 * Returns an ordered range of all the emrgcy requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmrgcyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of emrgcy requests
	 * @param end the upper bound of the range of emrgcy requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching emrgcy requests
	 */
	public java.util.List<EmrgcyRequest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmrgcyRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first emrgcy request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emrgcy request
	 * @throws NoSuchEmrgcyRequestException if a matching emrgcy request could not be found
	 */
	public EmrgcyRequest findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmrgcyRequest>
				orderByComparator)
		throws NoSuchEmrgcyRequestException;

	/**
	 * Returns the first emrgcy request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emrgcy request, or <code>null</code> if a matching emrgcy request could not be found
	 */
	public EmrgcyRequest fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmrgcyRequest>
			orderByComparator);

	/**
	 * Returns the last emrgcy request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emrgcy request
	 * @throws NoSuchEmrgcyRequestException if a matching emrgcy request could not be found
	 */
	public EmrgcyRequest findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmrgcyRequest>
				orderByComparator)
		throws NoSuchEmrgcyRequestException;

	/**
	 * Returns the last emrgcy request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emrgcy request, or <code>null</code> if a matching emrgcy request could not be found
	 */
	public EmrgcyRequest fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EmrgcyRequest>
			orderByComparator);

	/**
	 * Returns the emrgcy requests before and after the current emrgcy request in the ordered set where uuid = &#63;.
	 *
	 * @param requestId the primary key of the current emrgcy request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emrgcy request
	 * @throws NoSuchEmrgcyRequestException if a emrgcy request with the primary key could not be found
	 */
	public EmrgcyRequest[] findByUuid_PrevAndNext(
			long requestId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EmrgcyRequest>
				orderByComparator)
		throws NoSuchEmrgcyRequestException;

	/**
	 * Removes all the emrgcy requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of emrgcy requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching emrgcy requests
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the emrgcy requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching emrgcy requests
	 */
	public java.util.List<EmrgcyRequest> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the emrgcy requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmrgcyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of emrgcy requests
	 * @param end the upper bound of the range of emrgcy requests (not inclusive)
	 * @return the range of matching emrgcy requests
	 */
	public java.util.List<EmrgcyRequest> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the emrgcy requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmrgcyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of emrgcy requests
	 * @param end the upper bound of the range of emrgcy requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emrgcy requests
	 */
	public java.util.List<EmrgcyRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmrgcyRequest>
			orderByComparator);

	/**
	 * Returns an ordered range of all the emrgcy requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmrgcyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of emrgcy requests
	 * @param end the upper bound of the range of emrgcy requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching emrgcy requests
	 */
	public java.util.List<EmrgcyRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmrgcyRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first emrgcy request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emrgcy request
	 * @throws NoSuchEmrgcyRequestException if a matching emrgcy request could not be found
	 */
	public EmrgcyRequest findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmrgcyRequest>
				orderByComparator)
		throws NoSuchEmrgcyRequestException;

	/**
	 * Returns the first emrgcy request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emrgcy request, or <code>null</code> if a matching emrgcy request could not be found
	 */
	public EmrgcyRequest fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmrgcyRequest>
			orderByComparator);

	/**
	 * Returns the last emrgcy request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emrgcy request
	 * @throws NoSuchEmrgcyRequestException if a matching emrgcy request could not be found
	 */
	public EmrgcyRequest findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmrgcyRequest>
				orderByComparator)
		throws NoSuchEmrgcyRequestException;

	/**
	 * Returns the last emrgcy request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emrgcy request, or <code>null</code> if a matching emrgcy request could not be found
	 */
	public EmrgcyRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EmrgcyRequest>
			orderByComparator);

	/**
	 * Returns the emrgcy requests before and after the current emrgcy request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param requestId the primary key of the current emrgcy request
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emrgcy request
	 * @throws NoSuchEmrgcyRequestException if a emrgcy request with the primary key could not be found
	 */
	public EmrgcyRequest[] findByUuid_C_PrevAndNext(
			long requestId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EmrgcyRequest>
				orderByComparator)
		throws NoSuchEmrgcyRequestException;

	/**
	 * Removes all the emrgcy requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of emrgcy requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching emrgcy requests
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the emrgcy request in the entity cache if it is enabled.
	 *
	 * @param emrgcyRequest the emrgcy request
	 */
	public void cacheResult(EmrgcyRequest emrgcyRequest);

	/**
	 * Caches the emrgcy requests in the entity cache if it is enabled.
	 *
	 * @param emrgcyRequests the emrgcy requests
	 */
	public void cacheResult(java.util.List<EmrgcyRequest> emrgcyRequests);

	/**
	 * Creates a new emrgcy request with the primary key. Does not add the emrgcy request to the database.
	 *
	 * @param requestId the primary key for the new emrgcy request
	 * @return the new emrgcy request
	 */
	public EmrgcyRequest create(long requestId);

	/**
	 * Removes the emrgcy request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param requestId the primary key of the emrgcy request
	 * @return the emrgcy request that was removed
	 * @throws NoSuchEmrgcyRequestException if a emrgcy request with the primary key could not be found
	 */
	public EmrgcyRequest remove(long requestId)
		throws NoSuchEmrgcyRequestException;

	public EmrgcyRequest updateImpl(EmrgcyRequest emrgcyRequest);

	/**
	 * Returns the emrgcy request with the primary key or throws a <code>NoSuchEmrgcyRequestException</code> if it could not be found.
	 *
	 * @param requestId the primary key of the emrgcy request
	 * @return the emrgcy request
	 * @throws NoSuchEmrgcyRequestException if a emrgcy request with the primary key could not be found
	 */
	public EmrgcyRequest findByPrimaryKey(long requestId)
		throws NoSuchEmrgcyRequestException;

	/**
	 * Returns the emrgcy request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param requestId the primary key of the emrgcy request
	 * @return the emrgcy request, or <code>null</code> if a emrgcy request with the primary key could not be found
	 */
	public EmrgcyRequest fetchByPrimaryKey(long requestId);

	/**
	 * Returns all the emrgcy requests.
	 *
	 * @return the emrgcy requests
	 */
	public java.util.List<EmrgcyRequest> findAll();

	/**
	 * Returns a range of all the emrgcy requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmrgcyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of emrgcy requests
	 * @param end the upper bound of the range of emrgcy requests (not inclusive)
	 * @return the range of emrgcy requests
	 */
	public java.util.List<EmrgcyRequest> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the emrgcy requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmrgcyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of emrgcy requests
	 * @param end the upper bound of the range of emrgcy requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of emrgcy requests
	 */
	public java.util.List<EmrgcyRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmrgcyRequest>
			orderByComparator);

	/**
	 * Returns an ordered range of all the emrgcy requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmrgcyRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of emrgcy requests
	 * @param end the upper bound of the range of emrgcy requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of emrgcy requests
	 */
	public java.util.List<EmrgcyRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmrgcyRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the emrgcy requests from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of emrgcy requests.
	 *
	 * @return the number of emrgcy requests
	 */
	public int countAll();

}