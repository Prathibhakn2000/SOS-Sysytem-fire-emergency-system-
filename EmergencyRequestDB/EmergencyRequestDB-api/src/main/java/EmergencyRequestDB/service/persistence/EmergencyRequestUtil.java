/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package EmergencyRequestDB.service.persistence;

import EmergencyRequestDB.model.EmergencyRequest;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the emergency request service. This utility wraps <code>EmergencyRequestDB.service.persistence.impl.EmergencyRequestPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmergencyRequestPersistence
 * @generated
 */
public class EmergencyRequestUtil {

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
	public static void clearCache(EmergencyRequest emergencyRequest) {
		getPersistence().clearCache(emergencyRequest);
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
	public static Map<Serializable, EmergencyRequest> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmergencyRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmergencyRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmergencyRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmergencyRequest> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmergencyRequest update(EmergencyRequest emergencyRequest) {
		return getPersistence().update(emergencyRequest);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmergencyRequest update(
		EmergencyRequest emergencyRequest, ServiceContext serviceContext) {

		return getPersistence().update(emergencyRequest, serviceContext);
	}

	/**
	 * Returns all the emergency requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching emergency requests
	 */
	public static List<EmergencyRequest> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<EmergencyRequest> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<EmergencyRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmergencyRequest> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<EmergencyRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmergencyRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first emergency request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emergency request
	 * @throws NoSuchEmergencyRequestException if a matching emergency request could not be found
	 */
	public static EmergencyRequest findByUuid_First(
			String uuid, OrderByComparator<EmergencyRequest> orderByComparator)
		throws EmergencyRequestDB.exception.NoSuchEmergencyRequestException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first emergency request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emergency request, or <code>null</code> if a matching emergency request could not be found
	 */
	public static EmergencyRequest fetchByUuid_First(
		String uuid, OrderByComparator<EmergencyRequest> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last emergency request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emergency request
	 * @throws NoSuchEmergencyRequestException if a matching emergency request could not be found
	 */
	public static EmergencyRequest findByUuid_Last(
			String uuid, OrderByComparator<EmergencyRequest> orderByComparator)
		throws EmergencyRequestDB.exception.NoSuchEmergencyRequestException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last emergency request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emergency request, or <code>null</code> if a matching emergency request could not be found
	 */
	public static EmergencyRequest fetchByUuid_Last(
		String uuid, OrderByComparator<EmergencyRequest> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the emergency requests before and after the current emergency request in the ordered set where uuid = &#63;.
	 *
	 * @param requestId the primary key of the current emergency request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emergency request
	 * @throws NoSuchEmergencyRequestException if a emergency request with the primary key could not be found
	 */
	public static EmergencyRequest[] findByUuid_PrevAndNext(
			long requestId, String uuid,
			OrderByComparator<EmergencyRequest> orderByComparator)
		throws EmergencyRequestDB.exception.NoSuchEmergencyRequestException {

		return getPersistence().findByUuid_PrevAndNext(
			requestId, uuid, orderByComparator);
	}

	/**
	 * Removes all the emergency requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of emergency requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching emergency requests
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the emergency request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmergencyRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching emergency request
	 * @throws NoSuchEmergencyRequestException if a matching emergency request could not be found
	 */
	public static EmergencyRequest findByUUID_G(String uuid, long groupId)
		throws EmergencyRequestDB.exception.NoSuchEmergencyRequestException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the emergency request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching emergency request, or <code>null</code> if a matching emergency request could not be found
	 */
	public static EmergencyRequest fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the emergency request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching emergency request, or <code>null</code> if a matching emergency request could not be found
	 */
	public static EmergencyRequest fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the emergency request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the emergency request that was removed
	 */
	public static EmergencyRequest removeByUUID_G(String uuid, long groupId)
		throws EmergencyRequestDB.exception.NoSuchEmergencyRequestException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of emergency requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching emergency requests
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the emergency requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching emergency requests
	 */
	public static List<EmergencyRequest> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<EmergencyRequest> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<EmergencyRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmergencyRequest> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<EmergencyRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmergencyRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first emergency request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emergency request
	 * @throws NoSuchEmergencyRequestException if a matching emergency request could not be found
	 */
	public static EmergencyRequest findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EmergencyRequest> orderByComparator)
		throws EmergencyRequestDB.exception.NoSuchEmergencyRequestException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first emergency request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emergency request, or <code>null</code> if a matching emergency request could not be found
	 */
	public static EmergencyRequest fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EmergencyRequest> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last emergency request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emergency request
	 * @throws NoSuchEmergencyRequestException if a matching emergency request could not be found
	 */
	public static EmergencyRequest findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EmergencyRequest> orderByComparator)
		throws EmergencyRequestDB.exception.NoSuchEmergencyRequestException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last emergency request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emergency request, or <code>null</code> if a matching emergency request could not be found
	 */
	public static EmergencyRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EmergencyRequest> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static EmergencyRequest[] findByUuid_C_PrevAndNext(
			long requestId, String uuid, long companyId,
			OrderByComparator<EmergencyRequest> orderByComparator)
		throws EmergencyRequestDB.exception.NoSuchEmergencyRequestException {

		return getPersistence().findByUuid_C_PrevAndNext(
			requestId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the emergency requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of emergency requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching emergency requests
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the emergency requests where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching emergency requests
	 */
	public static List<EmergencyRequest> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

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
	public static List<EmergencyRequest> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

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
	public static List<EmergencyRequest> findByUserId(
		long userId, int start, int end,
		OrderByComparator<EmergencyRequest> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

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
	public static List<EmergencyRequest> findByUserId(
		long userId, int start, int end,
		OrderByComparator<EmergencyRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first emergency request in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emergency request
	 * @throws NoSuchEmergencyRequestException if a matching emergency request could not be found
	 */
	public static EmergencyRequest findByUserId_First(
			long userId, OrderByComparator<EmergencyRequest> orderByComparator)
		throws EmergencyRequestDB.exception.NoSuchEmergencyRequestException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first emergency request in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emergency request, or <code>null</code> if a matching emergency request could not be found
	 */
	public static EmergencyRequest fetchByUserId_First(
		long userId, OrderByComparator<EmergencyRequest> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last emergency request in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emergency request
	 * @throws NoSuchEmergencyRequestException if a matching emergency request could not be found
	 */
	public static EmergencyRequest findByUserId_Last(
			long userId, OrderByComparator<EmergencyRequest> orderByComparator)
		throws EmergencyRequestDB.exception.NoSuchEmergencyRequestException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last emergency request in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emergency request, or <code>null</code> if a matching emergency request could not be found
	 */
	public static EmergencyRequest fetchByUserId_Last(
		long userId, OrderByComparator<EmergencyRequest> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the emergency requests before and after the current emergency request in the ordered set where userId = &#63;.
	 *
	 * @param requestId the primary key of the current emergency request
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emergency request
	 * @throws NoSuchEmergencyRequestException if a emergency request with the primary key could not be found
	 */
	public static EmergencyRequest[] findByUserId_PrevAndNext(
			long requestId, long userId,
			OrderByComparator<EmergencyRequest> orderByComparator)
		throws EmergencyRequestDB.exception.NoSuchEmergencyRequestException {

		return getPersistence().findByUserId_PrevAndNext(
			requestId, userId, orderByComparator);
	}

	/**
	 * Removes all the emergency requests where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of emergency requests where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching emergency requests
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Caches the emergency request in the entity cache if it is enabled.
	 *
	 * @param emergencyRequest the emergency request
	 */
	public static void cacheResult(EmergencyRequest emergencyRequest) {
		getPersistence().cacheResult(emergencyRequest);
	}

	/**
	 * Caches the emergency requests in the entity cache if it is enabled.
	 *
	 * @param emergencyRequests the emergency requests
	 */
	public static void cacheResult(List<EmergencyRequest> emergencyRequests) {
		getPersistence().cacheResult(emergencyRequests);
	}

	/**
	 * Creates a new emergency request with the primary key. Does not add the emergency request to the database.
	 *
	 * @param requestId the primary key for the new emergency request
	 * @return the new emergency request
	 */
	public static EmergencyRequest create(long requestId) {
		return getPersistence().create(requestId);
	}

	/**
	 * Removes the emergency request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param requestId the primary key of the emergency request
	 * @return the emergency request that was removed
	 * @throws NoSuchEmergencyRequestException if a emergency request with the primary key could not be found
	 */
	public static EmergencyRequest remove(long requestId)
		throws EmergencyRequestDB.exception.NoSuchEmergencyRequestException {

		return getPersistence().remove(requestId);
	}

	public static EmergencyRequest updateImpl(
		EmergencyRequest emergencyRequest) {

		return getPersistence().updateImpl(emergencyRequest);
	}

	/**
	 * Returns the emergency request with the primary key or throws a <code>NoSuchEmergencyRequestException</code> if it could not be found.
	 *
	 * @param requestId the primary key of the emergency request
	 * @return the emergency request
	 * @throws NoSuchEmergencyRequestException if a emergency request with the primary key could not be found
	 */
	public static EmergencyRequest findByPrimaryKey(long requestId)
		throws EmergencyRequestDB.exception.NoSuchEmergencyRequestException {

		return getPersistence().findByPrimaryKey(requestId);
	}

	/**
	 * Returns the emergency request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param requestId the primary key of the emergency request
	 * @return the emergency request, or <code>null</code> if a emergency request with the primary key could not be found
	 */
	public static EmergencyRequest fetchByPrimaryKey(long requestId) {
		return getPersistence().fetchByPrimaryKey(requestId);
	}

	/**
	 * Returns all the emergency requests.
	 *
	 * @return the emergency requests
	 */
	public static List<EmergencyRequest> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<EmergencyRequest> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<EmergencyRequest> findAll(
		int start, int end,
		OrderByComparator<EmergencyRequest> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<EmergencyRequest> findAll(
		int start, int end,
		OrderByComparator<EmergencyRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the emergency requests from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of emergency requests.
	 *
	 * @return the number of emergency requests
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmergencyRequestPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(EmergencyRequestPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile EmergencyRequestPersistence _persistence;

}