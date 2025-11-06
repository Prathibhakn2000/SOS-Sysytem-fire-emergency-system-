/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package RequestManagementDB.service.persistence;

import RequestManagementDB.model.EmrgcyRequest;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the emrgcy request service. This utility wraps <code>RequestManagementDB.service.persistence.impl.EmrgcyRequestPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmrgcyRequestPersistence
 * @generated
 */
public class EmrgcyRequestUtil {

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
	public static void clearCache(EmrgcyRequest emrgcyRequest) {
		getPersistence().clearCache(emrgcyRequest);
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
	public static Map<Serializable, EmrgcyRequest> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmrgcyRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmrgcyRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmrgcyRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmrgcyRequest> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmrgcyRequest update(EmrgcyRequest emrgcyRequest) {
		return getPersistence().update(emrgcyRequest);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmrgcyRequest update(
		EmrgcyRequest emrgcyRequest, ServiceContext serviceContext) {

		return getPersistence().update(emrgcyRequest, serviceContext);
	}

	/**
	 * Returns all the emrgcy requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching emrgcy requests
	 */
	public static List<EmrgcyRequest> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<EmrgcyRequest> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<EmrgcyRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmrgcyRequest> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<EmrgcyRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmrgcyRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first emrgcy request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emrgcy request
	 * @throws NoSuchEmrgcyRequestException if a matching emrgcy request could not be found
	 */
	public static EmrgcyRequest findByUuid_First(
			String uuid, OrderByComparator<EmrgcyRequest> orderByComparator)
		throws RequestManagementDB.exception.NoSuchEmrgcyRequestException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first emrgcy request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emrgcy request, or <code>null</code> if a matching emrgcy request could not be found
	 */
	public static EmrgcyRequest fetchByUuid_First(
		String uuid, OrderByComparator<EmrgcyRequest> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last emrgcy request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emrgcy request
	 * @throws NoSuchEmrgcyRequestException if a matching emrgcy request could not be found
	 */
	public static EmrgcyRequest findByUuid_Last(
			String uuid, OrderByComparator<EmrgcyRequest> orderByComparator)
		throws RequestManagementDB.exception.NoSuchEmrgcyRequestException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last emrgcy request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emrgcy request, or <code>null</code> if a matching emrgcy request could not be found
	 */
	public static EmrgcyRequest fetchByUuid_Last(
		String uuid, OrderByComparator<EmrgcyRequest> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the emrgcy requests before and after the current emrgcy request in the ordered set where uuid = &#63;.
	 *
	 * @param requestId the primary key of the current emrgcy request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emrgcy request
	 * @throws NoSuchEmrgcyRequestException if a emrgcy request with the primary key could not be found
	 */
	public static EmrgcyRequest[] findByUuid_PrevAndNext(
			long requestId, String uuid,
			OrderByComparator<EmrgcyRequest> orderByComparator)
		throws RequestManagementDB.exception.NoSuchEmrgcyRequestException {

		return getPersistence().findByUuid_PrevAndNext(
			requestId, uuid, orderByComparator);
	}

	/**
	 * Removes all the emrgcy requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of emrgcy requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching emrgcy requests
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the emrgcy requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching emrgcy requests
	 */
	public static List<EmrgcyRequest> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<EmrgcyRequest> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<EmrgcyRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmrgcyRequest> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<EmrgcyRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmrgcyRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first emrgcy request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emrgcy request
	 * @throws NoSuchEmrgcyRequestException if a matching emrgcy request could not be found
	 */
	public static EmrgcyRequest findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EmrgcyRequest> orderByComparator)
		throws RequestManagementDB.exception.NoSuchEmrgcyRequestException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first emrgcy request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emrgcy request, or <code>null</code> if a matching emrgcy request could not be found
	 */
	public static EmrgcyRequest fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EmrgcyRequest> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last emrgcy request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emrgcy request
	 * @throws NoSuchEmrgcyRequestException if a matching emrgcy request could not be found
	 */
	public static EmrgcyRequest findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EmrgcyRequest> orderByComparator)
		throws RequestManagementDB.exception.NoSuchEmrgcyRequestException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last emrgcy request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emrgcy request, or <code>null</code> if a matching emrgcy request could not be found
	 */
	public static EmrgcyRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EmrgcyRequest> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static EmrgcyRequest[] findByUuid_C_PrevAndNext(
			long requestId, String uuid, long companyId,
			OrderByComparator<EmrgcyRequest> orderByComparator)
		throws RequestManagementDB.exception.NoSuchEmrgcyRequestException {

		return getPersistence().findByUuid_C_PrevAndNext(
			requestId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the emrgcy requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of emrgcy requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching emrgcy requests
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the emrgcy request in the entity cache if it is enabled.
	 *
	 * @param emrgcyRequest the emrgcy request
	 */
	public static void cacheResult(EmrgcyRequest emrgcyRequest) {
		getPersistence().cacheResult(emrgcyRequest);
	}

	/**
	 * Caches the emrgcy requests in the entity cache if it is enabled.
	 *
	 * @param emrgcyRequests the emrgcy requests
	 */
	public static void cacheResult(List<EmrgcyRequest> emrgcyRequests) {
		getPersistence().cacheResult(emrgcyRequests);
	}

	/**
	 * Creates a new emrgcy request with the primary key. Does not add the emrgcy request to the database.
	 *
	 * @param requestId the primary key for the new emrgcy request
	 * @return the new emrgcy request
	 */
	public static EmrgcyRequest create(long requestId) {
		return getPersistence().create(requestId);
	}

	/**
	 * Removes the emrgcy request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param requestId the primary key of the emrgcy request
	 * @return the emrgcy request that was removed
	 * @throws NoSuchEmrgcyRequestException if a emrgcy request with the primary key could not be found
	 */
	public static EmrgcyRequest remove(long requestId)
		throws RequestManagementDB.exception.NoSuchEmrgcyRequestException {

		return getPersistence().remove(requestId);
	}

	public static EmrgcyRequest updateImpl(EmrgcyRequest emrgcyRequest) {
		return getPersistence().updateImpl(emrgcyRequest);
	}

	/**
	 * Returns the emrgcy request with the primary key or throws a <code>NoSuchEmrgcyRequestException</code> if it could not be found.
	 *
	 * @param requestId the primary key of the emrgcy request
	 * @return the emrgcy request
	 * @throws NoSuchEmrgcyRequestException if a emrgcy request with the primary key could not be found
	 */
	public static EmrgcyRequest findByPrimaryKey(long requestId)
		throws RequestManagementDB.exception.NoSuchEmrgcyRequestException {

		return getPersistence().findByPrimaryKey(requestId);
	}

	/**
	 * Returns the emrgcy request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param requestId the primary key of the emrgcy request
	 * @return the emrgcy request, or <code>null</code> if a emrgcy request with the primary key could not be found
	 */
	public static EmrgcyRequest fetchByPrimaryKey(long requestId) {
		return getPersistence().fetchByPrimaryKey(requestId);
	}

	/**
	 * Returns all the emrgcy requests.
	 *
	 * @return the emrgcy requests
	 */
	public static List<EmrgcyRequest> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<EmrgcyRequest> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<EmrgcyRequest> findAll(
		int start, int end,
		OrderByComparator<EmrgcyRequest> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<EmrgcyRequest> findAll(
		int start, int end, OrderByComparator<EmrgcyRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the emrgcy requests from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of emrgcy requests.
	 *
	 * @return the number of emrgcy requests
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmrgcyRequestPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(EmrgcyRequestPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile EmrgcyRequestPersistence _persistence;

}