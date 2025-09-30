/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package OTP_DB.service.persistence;

import OTP_DB.exception.NoSuchSignUpOTPException;

import OTP_DB.model.SignUpOTP;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the sign up otp service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SignUpOTPUtil
 * @generated
 */
@ProviderType
public interface SignUpOTPPersistence extends BasePersistence<SignUpOTP> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SignUpOTPUtil} to access the sign up otp persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the sign up otps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching sign up otps
	 */
	public java.util.List<SignUpOTP> findByUuid(String uuid);

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
	public java.util.List<SignUpOTP> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<SignUpOTP> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SignUpOTP>
			orderByComparator);

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
	public java.util.List<SignUpOTP> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SignUpOTP>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sign up otp in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sign up otp
	 * @throws NoSuchSignUpOTPException if a matching sign up otp could not be found
	 */
	public SignUpOTP findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SignUpOTP>
				orderByComparator)
		throws NoSuchSignUpOTPException;

	/**
	 * Returns the first sign up otp in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sign up otp, or <code>null</code> if a matching sign up otp could not be found
	 */
	public SignUpOTP fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SignUpOTP>
			orderByComparator);

	/**
	 * Returns the last sign up otp in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sign up otp
	 * @throws NoSuchSignUpOTPException if a matching sign up otp could not be found
	 */
	public SignUpOTP findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SignUpOTP>
				orderByComparator)
		throws NoSuchSignUpOTPException;

	/**
	 * Returns the last sign up otp in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sign up otp, or <code>null</code> if a matching sign up otp could not be found
	 */
	public SignUpOTP fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SignUpOTP>
			orderByComparator);

	/**
	 * Returns the sign up otps before and after the current sign up otp in the ordered set where uuid = &#63;.
	 *
	 * @param otpId the primary key of the current sign up otp
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sign up otp
	 * @throws NoSuchSignUpOTPException if a sign up otp with the primary key could not be found
	 */
	public SignUpOTP[] findByUuid_PrevAndNext(
			long otpId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SignUpOTP>
				orderByComparator)
		throws NoSuchSignUpOTPException;

	/**
	 * Removes all the sign up otps where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of sign up otps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching sign up otps
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the sign up otp where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSignUpOTPException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sign up otp
	 * @throws NoSuchSignUpOTPException if a matching sign up otp could not be found
	 */
	public SignUpOTP findByUUID_G(String uuid, long groupId)
		throws NoSuchSignUpOTPException;

	/**
	 * Returns the sign up otp where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sign up otp, or <code>null</code> if a matching sign up otp could not be found
	 */
	public SignUpOTP fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the sign up otp where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sign up otp, or <code>null</code> if a matching sign up otp could not be found
	 */
	public SignUpOTP fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the sign up otp where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the sign up otp that was removed
	 */
	public SignUpOTP removeByUUID_G(String uuid, long groupId)
		throws NoSuchSignUpOTPException;

	/**
	 * Returns the number of sign up otps where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching sign up otps
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the sign up otps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching sign up otps
	 */
	public java.util.List<SignUpOTP> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<SignUpOTP> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<SignUpOTP> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SignUpOTP>
			orderByComparator);

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
	public java.util.List<SignUpOTP> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SignUpOTP>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sign up otp in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sign up otp
	 * @throws NoSuchSignUpOTPException if a matching sign up otp could not be found
	 */
	public SignUpOTP findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SignUpOTP>
				orderByComparator)
		throws NoSuchSignUpOTPException;

	/**
	 * Returns the first sign up otp in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sign up otp, or <code>null</code> if a matching sign up otp could not be found
	 */
	public SignUpOTP fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SignUpOTP>
			orderByComparator);

	/**
	 * Returns the last sign up otp in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sign up otp
	 * @throws NoSuchSignUpOTPException if a matching sign up otp could not be found
	 */
	public SignUpOTP findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SignUpOTP>
				orderByComparator)
		throws NoSuchSignUpOTPException;

	/**
	 * Returns the last sign up otp in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sign up otp, or <code>null</code> if a matching sign up otp could not be found
	 */
	public SignUpOTP fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SignUpOTP>
			orderByComparator);

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
	public SignUpOTP[] findByUuid_C_PrevAndNext(
			long otpId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SignUpOTP>
				orderByComparator)
		throws NoSuchSignUpOTPException;

	/**
	 * Removes all the sign up otps where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of sign up otps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching sign up otps
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the sign up otp in the entity cache if it is enabled.
	 *
	 * @param signUpOTP the sign up otp
	 */
	public void cacheResult(SignUpOTP signUpOTP);

	/**
	 * Caches the sign up otps in the entity cache if it is enabled.
	 *
	 * @param signUpOTPs the sign up otps
	 */
	public void cacheResult(java.util.List<SignUpOTP> signUpOTPs);

	/**
	 * Creates a new sign up otp with the primary key. Does not add the sign up otp to the database.
	 *
	 * @param otpId the primary key for the new sign up otp
	 * @return the new sign up otp
	 */
	public SignUpOTP create(long otpId);

	/**
	 * Removes the sign up otp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param otpId the primary key of the sign up otp
	 * @return the sign up otp that was removed
	 * @throws NoSuchSignUpOTPException if a sign up otp with the primary key could not be found
	 */
	public SignUpOTP remove(long otpId) throws NoSuchSignUpOTPException;

	public SignUpOTP updateImpl(SignUpOTP signUpOTP);

	/**
	 * Returns the sign up otp with the primary key or throws a <code>NoSuchSignUpOTPException</code> if it could not be found.
	 *
	 * @param otpId the primary key of the sign up otp
	 * @return the sign up otp
	 * @throws NoSuchSignUpOTPException if a sign up otp with the primary key could not be found
	 */
	public SignUpOTP findByPrimaryKey(long otpId)
		throws NoSuchSignUpOTPException;

	/**
	 * Returns the sign up otp with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param otpId the primary key of the sign up otp
	 * @return the sign up otp, or <code>null</code> if a sign up otp with the primary key could not be found
	 */
	public SignUpOTP fetchByPrimaryKey(long otpId);

	/**
	 * Returns all the sign up otps.
	 *
	 * @return the sign up otps
	 */
	public java.util.List<SignUpOTP> findAll();

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
	public java.util.List<SignUpOTP> findAll(int start, int end);

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
	public java.util.List<SignUpOTP> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SignUpOTP>
			orderByComparator);

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
	public java.util.List<SignUpOTP> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SignUpOTP>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sign up otps from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of sign up otps.
	 *
	 * @return the number of sign up otps
	 */
	public int countAll();

}