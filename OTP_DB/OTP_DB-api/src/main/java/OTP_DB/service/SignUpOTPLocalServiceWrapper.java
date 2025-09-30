/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package OTP_DB.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link SignUpOTPLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SignUpOTPLocalService
 * @generated
 */
public class SignUpOTPLocalServiceWrapper
	implements ServiceWrapper<SignUpOTPLocalService>, SignUpOTPLocalService {

	public SignUpOTPLocalServiceWrapper() {
		this(null);
	}

	public SignUpOTPLocalServiceWrapper(
		SignUpOTPLocalService signUpOTPLocalService) {

		_signUpOTPLocalService = signUpOTPLocalService;
	}

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
	@Override
	public OTP_DB.model.SignUpOTP addSignUpOTP(
		OTP_DB.model.SignUpOTP signUpOTP) {

		return _signUpOTPLocalService.addSignUpOTP(signUpOTP);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _signUpOTPLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new sign up otp with the primary key. Does not add the sign up otp to the database.
	 *
	 * @param otpId the primary key for the new sign up otp
	 * @return the new sign up otp
	 */
	@Override
	public OTP_DB.model.SignUpOTP createSignUpOTP(long otpId) {
		return _signUpOTPLocalService.createSignUpOTP(otpId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _signUpOTPLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public OTP_DB.model.SignUpOTP deleteSignUpOTP(long otpId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _signUpOTPLocalService.deleteSignUpOTP(otpId);
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
	@Override
	public OTP_DB.model.SignUpOTP deleteSignUpOTP(
		OTP_DB.model.SignUpOTP signUpOTP) {

		return _signUpOTPLocalService.deleteSignUpOTP(signUpOTP);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _signUpOTPLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _signUpOTPLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _signUpOTPLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _signUpOTPLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _signUpOTPLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _signUpOTPLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _signUpOTPLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _signUpOTPLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public OTP_DB.model.SignUpOTP fetchSignUpOTP(long otpId) {
		return _signUpOTPLocalService.fetchSignUpOTP(otpId);
	}

	/**
	 * Returns the sign up otp matching the UUID and group.
	 *
	 * @param uuid the sign up otp's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sign up otp, or <code>null</code> if a matching sign up otp could not be found
	 */
	@Override
	public OTP_DB.model.SignUpOTP fetchSignUpOTPByUuidAndGroupId(
		String uuid, long groupId) {

		return _signUpOTPLocalService.fetchSignUpOTPByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _signUpOTPLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _signUpOTPLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _signUpOTPLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _signUpOTPLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _signUpOTPLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the sign up otp with the primary key.
	 *
	 * @param otpId the primary key of the sign up otp
	 * @return the sign up otp
	 * @throws PortalException if a sign up otp with the primary key could not be found
	 */
	@Override
	public OTP_DB.model.SignUpOTP getSignUpOTP(long otpId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _signUpOTPLocalService.getSignUpOTP(otpId);
	}

	/**
	 * Returns the sign up otp matching the UUID and group.
	 *
	 * @param uuid the sign up otp's UUID
	 * @param groupId the primary key of the group
	 * @return the matching sign up otp
	 * @throws PortalException if a matching sign up otp could not be found
	 */
	@Override
	public OTP_DB.model.SignUpOTP getSignUpOTPByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _signUpOTPLocalService.getSignUpOTPByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<OTP_DB.model.SignUpOTP> getSignUpOTPs(
		int start, int end) {

		return _signUpOTPLocalService.getSignUpOTPs(start, end);
	}

	/**
	 * Returns all the sign up otps matching the UUID and company.
	 *
	 * @param uuid the UUID of the sign up otps
	 * @param companyId the primary key of the company
	 * @return the matching sign up otps, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<OTP_DB.model.SignUpOTP>
		getSignUpOTPsByUuidAndCompanyId(String uuid, long companyId) {

		return _signUpOTPLocalService.getSignUpOTPsByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<OTP_DB.model.SignUpOTP>
		getSignUpOTPsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<OTP_DB.model.SignUpOTP> orderByComparator) {

		return _signUpOTPLocalService.getSignUpOTPsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of sign up otps.
	 *
	 * @return the number of sign up otps
	 */
	@Override
	public int getSignUpOTPsCount() {
		return _signUpOTPLocalService.getSignUpOTPsCount();
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
	@Override
	public OTP_DB.model.SignUpOTP updateSignUpOTP(
		OTP_DB.model.SignUpOTP signUpOTP) {

		return _signUpOTPLocalService.updateSignUpOTP(signUpOTP);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _signUpOTPLocalService.getBasePersistence();
	}

	@Override
	public SignUpOTPLocalService getWrappedService() {
		return _signUpOTPLocalService;
	}

	@Override
	public void setWrappedService(SignUpOTPLocalService signUpOTPLocalService) {
		_signUpOTPLocalService = signUpOTPLocalService;
	}

	private SignUpOTPLocalService _signUpOTPLocalService;

}