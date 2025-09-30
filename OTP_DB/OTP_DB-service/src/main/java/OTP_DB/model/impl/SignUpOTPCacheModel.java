/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package OTP_DB.model.impl;

import OTP_DB.model.SignUpOTP;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SignUpOTP in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SignUpOTPCacheModel
	implements CacheModel<SignUpOTP>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SignUpOTPCacheModel)) {
			return false;
		}

		SignUpOTPCacheModel signUpOTPCacheModel = (SignUpOTPCacheModel)object;

		if (otpId == signUpOTPCacheModel.otpId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, otpId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", otpId=");
		sb.append(otpId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", email_address=");
		sb.append(email_address);
		sb.append(", OTP=");
		sb.append(OTP);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SignUpOTP toEntityModel() {
		SignUpOTPImpl signUpOTPImpl = new SignUpOTPImpl();

		if (uuid == null) {
			signUpOTPImpl.setUuid("");
		}
		else {
			signUpOTPImpl.setUuid(uuid);
		}

		signUpOTPImpl.setOtpId(otpId);
		signUpOTPImpl.setGroupId(groupId);
		signUpOTPImpl.setCompanyId(companyId);
		signUpOTPImpl.setUserId(userId);

		if (userName == null) {
			signUpOTPImpl.setUserName("");
		}
		else {
			signUpOTPImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			signUpOTPImpl.setCreateDate(null);
		}
		else {
			signUpOTPImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			signUpOTPImpl.setModifiedDate(null);
		}
		else {
			signUpOTPImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (email_address == null) {
			signUpOTPImpl.setEmail_address("");
		}
		else {
			signUpOTPImpl.setEmail_address(email_address);
		}

		if (OTP == null) {
			signUpOTPImpl.setOTP("");
		}
		else {
			signUpOTPImpl.setOTP(OTP);
		}

		signUpOTPImpl.setStatus(status);

		signUpOTPImpl.resetOriginalValues();

		return signUpOTPImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		otpId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		email_address = objectInput.readUTF();
		OTP = objectInput.readUTF();

		status = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(otpId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (email_address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email_address);
		}

		if (OTP == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(OTP);
		}

		objectOutput.writeBoolean(status);
	}

	public String uuid;
	public long otpId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String email_address;

	public String OTP;

	public boolean status;

}