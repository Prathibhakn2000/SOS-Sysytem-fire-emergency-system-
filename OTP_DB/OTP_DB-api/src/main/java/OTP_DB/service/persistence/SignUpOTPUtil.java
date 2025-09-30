/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package OTP_DB.service.persistence;

import OTP_DB.model.SignUpOTP;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the sign up otp service. This utility wraps <code>OTP_DB.service.persistence.impl.SignUpOTPPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SignUpOTPPersistence
 * @generated
 */
public class SignUpOTPUtil {

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
	public static void clearCache(SignUpOTP signUpOTP) {
		getPersistence().clearCache(signUpOTP);
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
	public static Map<Serializable, SignUpOTP> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SignUpOTP> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SignUpOTP> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SignUpOTP> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SignUpOTP> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SignUpOTP update(SignUpOTP signUpOTP) {
		return getPersistence().update(signUpOTP);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SignUpOTP update(
		SignUpOTP signUpOTP, ServiceContext serviceContext) {

		return getPersistence().update(signUpOTP, serviceContext);
	}

	/**
	 * Returns all the sign up otps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching sign up otps
	 */
	public static List<SignUpOTP> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the sign up otps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignUpOTPModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sign up otps
	 * @param end the upper bound of the range of sign up otps (not inclusive)
	 * @return the range of matching sign up otps
	 */
	public static List<SignUpOTP> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the sign up otps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignUpOTPModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sign up otps
	 * @param end the upper bound of the range of sign up otps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sign up otps
	 */
	public static List<SignUpOTP> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SignUpOTP> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sign up otps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignUpOTPModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sign up otps
	 * @param end the upper bound of the range of sign up otps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sign up otps
	 */
	public static List<SignUpOTP> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SignUpOTP> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sign up otp in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sign up otp
	 * @throws NoSuchSignUpOTPException if a matching sign up otp could not be found
	 */
	public static SignUpOTP findByUuid_First(
			String uuid, OrderByComparator<SignUpOTP> orderByComparator)
		throws OTP_DB.exception.NoSuchSignUpOTPException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first sign up otp in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sign up otp, or <code>null</code> if a matching sign up otp could not be found
	 */
	public static SignUpOTP fetchByUuid_First(
		String uuid, OrderByComparator<SignUpOTP> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last sign up otp in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sign up otp
	 * @throws NoSuchSignUpOTPException if a matching sign up otp could not be found
	 */
	public static SignUpOTP findByUuid_Last(
			String uuid, OrderByComparator<SignUpOTP> orderByComparator)
		throws OTP_DB.exception.NoSuchSignUpOTPException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last sign up otp in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sign up otp, or <code>null</code> if a matching sign up otp could not be found
	 */
	public static SignUpOTP fetchByUuid_Last(
		String uuid, OrderByComparator<SignUpOTP> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the sign up otps before and after the current sign up otp in the ordered set where uuid = &#63;.
	 *
	 * @param otpId the primary key of the current sign up otp
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sign up otp
	 * @throws NoSuchSignUpOTPException if a sign up otp with the primary key could not be found
	 */
	public static SignUpOTP[] findByUuid_PrevAndNext(
			long otpId, String uuid,
			OrderByComparator<SignUpOTP> orderByComparator)
		throws OTP_DB.exception.NoSuchSignUpOTPException {

		return getPersistence().findByUuid_PrevAndNext(
			otpId, uuid, orderByComparator);
	}

	/**
	 * Removes all the sign up otps where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of sign up otps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching sign up otps
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the sign up otp where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSignUpOTPException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sign up otp
	 * @throws NoSuchSignUpOTPException if a matching sign up otp could not be found
	 */
	public static SignUpOTP findByUUID_G(String uuid, long groupId)
		throws OTP_DB.exception.NoSuchSignUpOTPException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the sign up otp where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sign up otp, or <code>null</code> if a matching sign up otp could not be found
	 */
	public static SignUpOTP fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the sign up otp where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sign up otp, or <code>null</code> if a matching sign up otp could not be found
	 */
	public static SignUpOTP fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the sign up otp where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the sign up otp that was removed
	 */
	public static SignUpOTP removeByUUID_G(String uuid, long groupId)
		throws OTP_DB.exception.NoSuchSignUpOTPException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of sign up otps where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching sign up otps
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the sign up otps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching sign up otps
	 */
	public static List<SignUpOTP> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the sign up otps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignUpOTPModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sign up otps
	 * @param end the upper bound of the range of sign up otps (not inclusive)
	 * @return the range of matching sign up otps
	 */
	public static List<SignUpOTP> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the sign up otps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignUpOTPModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sign up otps
	 * @param end the upper bound of the range of sign up otps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sign up otps
	 */
	public static List<SignUpOTP> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SignUpOTP> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sign up otps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignUpOTPModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sign up otps
	 * @param end the upper bound of the range of sign up otps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sign up otps
	 */
	public static List<SignUpOTP> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SignUpOTP> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sign up otp in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sign up otp
	 * @throws NoSuchSignUpOTPException if a matching sign up otp could not be found
	 */
	public static SignUpOTP findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<SignUpOTP> orderByComparator)
		throws OTP_DB.exception.NoSuchSignUpOTPException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first sign up otp in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sign up otp, or <code>null</code> if a matching sign up otp could not be found
	 */
	public static SignUpOTP fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<SignUpOTP> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last sign up otp in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sign up otp
	 * @throws NoSuchSignUpOTPException if a matching sign up otp could not be found
	 */
	public static SignUpOTP findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<SignUpOTP> orderByComparator)
		throws OTP_DB.exception.NoSuchSignUpOTPException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last sign up otp in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sign up otp, or <code>null</code> if a matching sign up otp could not be found
	 */
	public static SignUpOTP fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<SignUpOTP> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the sign up otps before and after the current sign up otp in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param otpId the primary key of the current sign up otp
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sign up otp
	 * @throws NoSuchSignUpOTPException if a sign up otp with the primary key could not be found
	 */
	public static SignUpOTP[] findByUuid_C_PrevAndNext(
			long otpId, String uuid, long companyId,
			OrderByComparator<SignUpOTP> orderByComparator)
		throws OTP_DB.exception.NoSuchSignUpOTPException {

		return getPersistence().findByUuid_C_PrevAndNext(
			otpId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the sign up otps where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of sign up otps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching sign up otps
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the sign up otp in the entity cache if it is enabled.
	 *
	 * @param signUpOTP the sign up otp
	 */
	public static void cacheResult(SignUpOTP signUpOTP) {
		getPersistence().cacheResult(signUpOTP);
	}

	/**
	 * Caches the sign up otps in the entity cache if it is enabled.
	 *
	 * @param signUpOTPs the sign up otps
	 */
	public static void cacheResult(List<SignUpOTP> signUpOTPs) {
		getPersistence().cacheResult(signUpOTPs);
	}

	/**
	 * Creates a new sign up otp with the primary key. Does not add the sign up otp to the database.
	 *
	 * @param otpId the primary key for the new sign up otp
	 * @return the new sign up otp
	 */
	public static SignUpOTP create(long otpId) {
		return getPersistence().create(otpId);
	}

	/**
	 * Removes the sign up otp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param otpId the primary key of the sign up otp
	 * @return the sign up otp that was removed
	 * @throws NoSuchSignUpOTPException if a sign up otp with the primary key could not be found
	 */
	public static SignUpOTP remove(long otpId)
		throws OTP_DB.exception.NoSuchSignUpOTPException {

		return getPersistence().remove(otpId);
	}

	public static SignUpOTP updateImpl(SignUpOTP signUpOTP) {
		return getPersistence().updateImpl(signUpOTP);
	}

	/**
	 * Returns the sign up otp with the primary key or throws a <code>NoSuchSignUpOTPException</code> if it could not be found.
	 *
	 * @param otpId the primary key of the sign up otp
	 * @return the sign up otp
	 * @throws NoSuchSignUpOTPException if a sign up otp with the primary key could not be found
	 */
	public static SignUpOTP findByPrimaryKey(long otpId)
		throws OTP_DB.exception.NoSuchSignUpOTPException {

		return getPersistence().findByPrimaryKey(otpId);
	}

	/**
	 * Returns the sign up otp with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param otpId the primary key of the sign up otp
	 * @return the sign up otp, or <code>null</code> if a sign up otp with the primary key could not be found
	 */
	public static SignUpOTP fetchByPrimaryKey(long otpId) {
		return getPersistence().fetchByPrimaryKey(otpId);
	}

	/**
	 * Returns all the sign up otps.
	 *
	 * @return the sign up otps
	 */
	public static List<SignUpOTP> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the sign up otps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignUpOTPModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sign up otps
	 * @param end the upper bound of the range of sign up otps (not inclusive)
	 * @return the range of sign up otps
	 */
	public static List<SignUpOTP> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the sign up otps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignUpOTPModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sign up otps
	 * @param end the upper bound of the range of sign up otps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sign up otps
	 */
	public static List<SignUpOTP> findAll(
		int start, int end, OrderByComparator<SignUpOTP> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sign up otps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignUpOTPModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sign up otps
	 * @param end the upper bound of the range of sign up otps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sign up otps
	 */
	public static List<SignUpOTP> findAll(
		int start, int end, OrderByComparator<SignUpOTP> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the sign up otps from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of sign up otps.
	 *
	 * @return the number of sign up otps
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SignUpOTPPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(SignUpOTPPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile SignUpOTPPersistence _persistence;

}