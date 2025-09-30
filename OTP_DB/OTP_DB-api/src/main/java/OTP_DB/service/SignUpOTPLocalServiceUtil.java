/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package OTP_DB.service;

import OTP_DB.model.SignUpOTP;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for SignUpOTP. This utility wraps
 * <code>OTP_DB.service.impl.SignUpOTPLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SignUpOTPLocalService
 * @generated
 */
public class SignUpOTPLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>OTP_DB.service.impl.SignUpOTPLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the sign up otp to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SignUpOTPLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param signUpOTP the sign up otp
	 * @return the sign up otp that was added
	 */
	public static SignUpOTP addSignUpOTP(SignUpOTP signUpOTP) {
		return getService().addSignUpOTP(signUpOTP);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new sign up otp with the primary key. Does not add the sign up otp to the database.
	 *
	 * @param otpId the primary key for the new sign up otp
	 * @return the new sign up otp
	 */
	public static SignUpOTP createSignUpOTP(long otpId) {
		return getService().createSignUpOTP(otpId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the sign up otp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SignUpOTPLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param otpId the primary key of the sign up otp
	 * @return the sign up otp that was removed
	 * @throws PortalException if a sign up otp with the primary key could not be found
	 */
	public static SignUpOTP deleteSignUpOTP(long otpId) throws PortalException {
		return getService().deleteSignUpOTP(otpId);
	}

	/**
	 * Deletes the sign up otp from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SignUpOTPLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param signUpOTP the sign up otp
	 * @return the sign up otp that was removed
	 */
	public static SignUpOTP deleteSignUpOTP(SignUpOTP signUpOTP) {
		return getService().deleteSignUpOTP(signUpOTP);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OTP_DB.model.impl.SignUpOTPModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OTP_DB.model.impl.SignUpOTPModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static SignUpOTP fetchSignUpOTP(long otpId) {
		return getService().fetchSignUpOTP(otpId);
	}

	/**
	 * Returns the sign up otp matching the UUID and group.
	 *
	 * @param uuid the sign up otp's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sign up otp, or <code>null</code> if a matching sign up otp could not be found
	 */
	public static SignUpOTP fetchSignUpOTPByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchSignUpOTPByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the sign up otp with the primary key.
	 *
	 * @param otpId the primary key of the sign up otp
	 * @return the sign up otp
	 * @throws PortalException if a sign up otp with the primary key could not be found
	 */
	public static SignUpOTP getSignUpOTP(long otpId) throws PortalException {
		return getService().getSignUpOTP(otpId);
	}

	/**
	 * Returns the sign up otp matching the UUID and group.
	 *
	 * @param uuid the sign up otp's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sign up otp
	 * @throws PortalException if a matching sign up otp could not be found
	 */
	public static SignUpOTP getSignUpOTPByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getSignUpOTPByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the sign up otps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OTP_DB.model.impl.SignUpOTPModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sign up otps
	 * @param end the upper bound of the range of sign up otps (not inclusive)
	 * @return the range of sign up otps
	 */
	public static List<SignUpOTP> getSignUpOTPs(int start, int end) {
		return getService().getSignUpOTPs(start, end);
	}

	/**
	 * Returns all the sign up otps matching the UUID and company.
	 *
	 * @param uuid the UUID of the sign up otps
	 * @param companyId the primary key of the company
	 * @return the matching sign up otps, or an empty list if no matches were found
	 */
	public static List<SignUpOTP> getSignUpOTPsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getSignUpOTPsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of sign up otps matching the UUID and company.
	 *
	 * @param uuid the UUID of the sign up otps
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of sign up otps
	 * @param end the upper bound of the range of sign up otps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching sign up otps, or an empty list if no matches were found
	 */
	public static List<SignUpOTP> getSignUpOTPsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SignUpOTP> orderByComparator) {

		return getService().getSignUpOTPsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of sign up otps.
	 *
	 * @return the number of sign up otps
	 */
	public static int getSignUpOTPsCount() {
		return getService().getSignUpOTPsCount();
	}

	/**
	 * Updates the sign up otp in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SignUpOTPLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param signUpOTP the sign up otp
	 * @return the sign up otp that was updated
	 */
	public static SignUpOTP updateSignUpOTP(SignUpOTP signUpOTP) {
		return getService().updateSignUpOTP(signUpOTP);
	}

	public static SignUpOTPLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<SignUpOTPLocalService> _serviceSnapshot =
		new Snapshot<>(
			SignUpOTPLocalServiceUtil.class, SignUpOTPLocalService.class);

}