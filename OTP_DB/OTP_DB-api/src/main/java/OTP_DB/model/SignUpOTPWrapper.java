/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package OTP_DB.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SignUpOTP}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SignUpOTP
 * @generated
 */
public class SignUpOTPWrapper
	extends BaseModelWrapper<SignUpOTP>
	implements ModelWrapper<SignUpOTP>, SignUpOTP {

	public SignUpOTPWrapper(SignUpOTP signUpOTP) {
		super(signUpOTP);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("otpId", getOtpId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("email_address", getEmail_address());
		attributes.put("OTP", getOTP());
		attributes.put("status", isStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long otpId = (Long)attributes.get("otpId");

		if (otpId != null) {
			setOtpId(otpId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String email_address = (String)attributes.get("email_address");

		if (email_address != null) {
			setEmail_address(email_address);
		}

		String OTP = (String)attributes.get("OTP");

		if (OTP != null) {
			setOTP(OTP);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public SignUpOTP cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this sign up otp.
	 *
	 * @return the company ID of this sign up otp
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this sign up otp.
	 *
	 * @return the create date of this sign up otp
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the email_address of this sign up otp.
	 *
	 * @return the email_address of this sign up otp
	 */
	@Override
	public String getEmail_address() {
		return model.getEmail_address();
	}

	/**
	 * Returns the group ID of this sign up otp.
	 *
	 * @return the group ID of this sign up otp
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this sign up otp.
	 *
	 * @return the modified date of this sign up otp
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the otp of this sign up otp.
	 *
	 * @return the otp of this sign up otp
	 */
	@Override
	public String getOTP() {
		return model.getOTP();
	}

	/**
	 * Returns the otp ID of this sign up otp.
	 *
	 * @return the otp ID of this sign up otp
	 */
	@Override
	public long getOtpId() {
		return model.getOtpId();
	}

	/**
	 * Returns the primary key of this sign up otp.
	 *
	 * @return the primary key of this sign up otp
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this sign up otp.
	 *
	 * @return the status of this sign up otp
	 */
	@Override
	public boolean getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this sign up otp.
	 *
	 * @return the user ID of this sign up otp
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this sign up otp.
	 *
	 * @return the user name of this sign up otp
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this sign up otp.
	 *
	 * @return the user uuid of this sign up otp
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this sign up otp.
	 *
	 * @return the uuid of this sign up otp
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this sign up otp is status.
	 *
	 * @return <code>true</code> if this sign up otp is status; <code>false</code> otherwise
	 */
	@Override
	public boolean isStatus() {
		return model.isStatus();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this sign up otp.
	 *
	 * @param companyId the company ID of this sign up otp
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this sign up otp.
	 *
	 * @param createDate the create date of this sign up otp
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the email_address of this sign up otp.
	 *
	 * @param email_address the email_address of this sign up otp
	 */
	@Override
	public void setEmail_address(String email_address) {
		model.setEmail_address(email_address);
	}

	/**
	 * Sets the group ID of this sign up otp.
	 *
	 * @param groupId the group ID of this sign up otp
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this sign up otp.
	 *
	 * @param modifiedDate the modified date of this sign up otp
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the otp of this sign up otp.
	 *
	 * @param OTP the otp of this sign up otp
	 */
	@Override
	public void setOTP(String OTP) {
		model.setOTP(OTP);
	}

	/**
	 * Sets the otp ID of this sign up otp.
	 *
	 * @param otpId the otp ID of this sign up otp
	 */
	@Override
	public void setOtpId(long otpId) {
		model.setOtpId(otpId);
	}

	/**
	 * Sets the primary key of this sign up otp.
	 *
	 * @param primaryKey the primary key of this sign up otp
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this sign up otp is status.
	 *
	 * @param status the status of this sign up otp
	 */
	@Override
	public void setStatus(boolean status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this sign up otp.
	 *
	 * @param userId the user ID of this sign up otp
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this sign up otp.
	 *
	 * @param userName the user name of this sign up otp
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this sign up otp.
	 *
	 * @param userUuid the user uuid of this sign up otp
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this sign up otp.
	 *
	 * @param uuid the uuid of this sign up otp
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected SignUpOTPWrapper wrap(SignUpOTP signUpOTP) {
		return new SignUpOTPWrapper(signUpOTP);
	}

}