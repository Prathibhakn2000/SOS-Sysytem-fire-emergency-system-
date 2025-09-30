/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package OTP_DB.service.persistence.impl;

import OTP_DB.exception.NoSuchSignUpOTPException;

import OTP_DB.model.SignUpOTP;
import OTP_DB.model.SignUpOTPTable;
import OTP_DB.model.impl.SignUpOTPImpl;
import OTP_DB.model.impl.SignUpOTPModelImpl;

import OTP_DB.service.persistence.SignUpOTPPersistence;
import OTP_DB.service.persistence.SignUpOTPUtil;
import OTP_DB.service.persistence.impl.constants.firePersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the sign up otp service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SignUpOTPPersistence.class)
public class SignUpOTPPersistenceImpl
	extends BasePersistenceImpl<SignUpOTP> implements SignUpOTPPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SignUpOTPUtil</code> to access the sign up otp persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SignUpOTPImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the sign up otps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching sign up otps
	 */
	@Override
	public List<SignUpOTP> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SignUpOTP> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<SignUpOTP> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SignUpOTP> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<SignUpOTP> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SignUpOTP> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<SignUpOTP> list = null;

		if (useFinderCache) {
			list = (List<SignUpOTP>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SignUpOTP signUpOTP : list) {
					if (!uuid.equals(signUpOTP.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SIGNUPOTP_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SignUpOTPModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<SignUpOTP>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first sign up otp in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sign up otp
	 * @throws NoSuchSignUpOTPException if a matching sign up otp could not be found
	 */
	@Override
	public SignUpOTP findByUuid_First(
			String uuid, OrderByComparator<SignUpOTP> orderByComparator)
		throws NoSuchSignUpOTPException {

		SignUpOTP signUpOTP = fetchByUuid_First(uuid, orderByComparator);

		if (signUpOTP != null) {
			return signUpOTP;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSignUpOTPException(sb.toString());
	}

	/**
	 * Returns the first sign up otp in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sign up otp, or <code>null</code> if a matching sign up otp could not be found
	 */
	@Override
	public SignUpOTP fetchByUuid_First(
		String uuid, OrderByComparator<SignUpOTP> orderByComparator) {

		List<SignUpOTP> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sign up otp in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sign up otp
	 * @throws NoSuchSignUpOTPException if a matching sign up otp could not be found
	 */
	@Override
	public SignUpOTP findByUuid_Last(
			String uuid, OrderByComparator<SignUpOTP> orderByComparator)
		throws NoSuchSignUpOTPException {

		SignUpOTP signUpOTP = fetchByUuid_Last(uuid, orderByComparator);

		if (signUpOTP != null) {
			return signUpOTP;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSignUpOTPException(sb.toString());
	}

	/**
	 * Returns the last sign up otp in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sign up otp, or <code>null</code> if a matching sign up otp could not be found
	 */
	@Override
	public SignUpOTP fetchByUuid_Last(
		String uuid, OrderByComparator<SignUpOTP> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SignUpOTP> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SignUpOTP[] findByUuid_PrevAndNext(
			long otpId, String uuid,
			OrderByComparator<SignUpOTP> orderByComparator)
		throws NoSuchSignUpOTPException {

		uuid = Objects.toString(uuid, "");

		SignUpOTP signUpOTP = findByPrimaryKey(otpId);

		Session session = null;

		try {
			session = openSession();

			SignUpOTP[] array = new SignUpOTPImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, signUpOTP, uuid, orderByComparator, true);

			array[1] = signUpOTP;

			array[2] = getByUuid_PrevAndNext(
				session, signUpOTP, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SignUpOTP getByUuid_PrevAndNext(
		Session session, SignUpOTP signUpOTP, String uuid,
		OrderByComparator<SignUpOTP> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SIGNUPOTP_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SignUpOTPModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(signUpOTP)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SignUpOTP> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sign up otps where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (SignUpOTP signUpOTP :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(signUpOTP);
		}
	}

	/**
	 * Returns the number of sign up otps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching sign up otps
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SIGNUPOTP_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"signUpOTP.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(signUpOTP.uuid IS NULL OR signUpOTP.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the sign up otp where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSignUpOTPException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sign up otp
	 * @throws NoSuchSignUpOTPException if a matching sign up otp could not be found
	 */
	@Override
	public SignUpOTP findByUUID_G(String uuid, long groupId)
		throws NoSuchSignUpOTPException {

		SignUpOTP signUpOTP = fetchByUUID_G(uuid, groupId);

		if (signUpOTP == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchSignUpOTPException(sb.toString());
		}

		return signUpOTP;
	}

	/**
	 * Returns the sign up otp where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sign up otp, or <code>null</code> if a matching sign up otp could not be found
	 */
	@Override
	public SignUpOTP fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the sign up otp where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sign up otp, or <code>null</code> if a matching sign up otp could not be found
	 */
	@Override
	public SignUpOTP fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof SignUpOTP) {
			SignUpOTP signUpOTP = (SignUpOTP)result;

			if (!Objects.equals(uuid, signUpOTP.getUuid()) ||
				(groupId != signUpOTP.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_SIGNUPOTP_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<SignUpOTP> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					SignUpOTP signUpOTP = list.get(0);

					result = signUpOTP;

					cacheResult(signUpOTP);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (SignUpOTP)result;
		}
	}

	/**
	 * Removes the sign up otp where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the sign up otp that was removed
	 */
	@Override
	public SignUpOTP removeByUUID_G(String uuid, long groupId)
		throws NoSuchSignUpOTPException {

		SignUpOTP signUpOTP = findByUUID_G(uuid, groupId);

		return remove(signUpOTP);
	}

	/**
	 * Returns the number of sign up otps where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching sign up otps
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		SignUpOTP signUpOTP = fetchByUUID_G(uuid, groupId);

		if (signUpOTP == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"signUpOTP.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(signUpOTP.uuid IS NULL OR signUpOTP.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"signUpOTP.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the sign up otps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching sign up otps
	 */
	@Override
	public List<SignUpOTP> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SignUpOTP> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<SignUpOTP> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SignUpOTP> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<SignUpOTP> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SignUpOTP> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<SignUpOTP> list = null;

		if (useFinderCache) {
			list = (List<SignUpOTP>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SignUpOTP signUpOTP : list) {
					if (!uuid.equals(signUpOTP.getUuid()) ||
						(companyId != signUpOTP.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_SIGNUPOTP_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SignUpOTPModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<SignUpOTP>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public SignUpOTP findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<SignUpOTP> orderByComparator)
		throws NoSuchSignUpOTPException {

		SignUpOTP signUpOTP = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (signUpOTP != null) {
			return signUpOTP;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSignUpOTPException(sb.toString());
	}

	/**
	 * Returns the first sign up otp in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sign up otp, or <code>null</code> if a matching sign up otp could not be found
	 */
	@Override
	public SignUpOTP fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<SignUpOTP> orderByComparator) {

		List<SignUpOTP> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SignUpOTP findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<SignUpOTP> orderByComparator)
		throws NoSuchSignUpOTPException {

		SignUpOTP signUpOTP = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (signUpOTP != null) {
			return signUpOTP;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSignUpOTPException(sb.toString());
	}

	/**
	 * Returns the last sign up otp in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sign up otp, or <code>null</code> if a matching sign up otp could not be found
	 */
	@Override
	public SignUpOTP fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<SignUpOTP> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SignUpOTP> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SignUpOTP[] findByUuid_C_PrevAndNext(
			long otpId, String uuid, long companyId,
			OrderByComparator<SignUpOTP> orderByComparator)
		throws NoSuchSignUpOTPException {

		uuid = Objects.toString(uuid, "");

		SignUpOTP signUpOTP = findByPrimaryKey(otpId);

		Session session = null;

		try {
			session = openSession();

			SignUpOTP[] array = new SignUpOTPImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, signUpOTP, uuid, companyId, orderByComparator, true);

			array[1] = signUpOTP;

			array[2] = getByUuid_C_PrevAndNext(
				session, signUpOTP, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SignUpOTP getByUuid_C_PrevAndNext(
		Session session, SignUpOTP signUpOTP, String uuid, long companyId,
		OrderByComparator<SignUpOTP> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SIGNUPOTP_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SignUpOTPModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(signUpOTP)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SignUpOTP> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sign up otps where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (SignUpOTP signUpOTP :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(signUpOTP);
		}
	}

	/**
	 * Returns the number of sign up otps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching sign up otps
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SIGNUPOTP_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"signUpOTP.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(signUpOTP.uuid IS NULL OR signUpOTP.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"signUpOTP.companyId = ?";

	public SignUpOTPPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SignUpOTP.class);

		setModelImplClass(SignUpOTPImpl.class);
		setModelPKClass(long.class);

		setTable(SignUpOTPTable.INSTANCE);
	}

	/**
	 * Caches the sign up otp in the entity cache if it is enabled.
	 *
	 * @param signUpOTP the sign up otp
	 */
	@Override
	public void cacheResult(SignUpOTP signUpOTP) {
		entityCache.putResult(
			SignUpOTPImpl.class, signUpOTP.getPrimaryKey(), signUpOTP);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {signUpOTP.getUuid(), signUpOTP.getGroupId()},
			signUpOTP);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the sign up otps in the entity cache if it is enabled.
	 *
	 * @param signUpOTPs the sign up otps
	 */
	@Override
	public void cacheResult(List<SignUpOTP> signUpOTPs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (signUpOTPs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SignUpOTP signUpOTP : signUpOTPs) {
			if (entityCache.getResult(
					SignUpOTPImpl.class, signUpOTP.getPrimaryKey()) == null) {

				cacheResult(signUpOTP);
			}
		}
	}

	/**
	 * Clears the cache for all sign up otps.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SignUpOTPImpl.class);

		finderCache.clearCache(SignUpOTPImpl.class);
	}

	/**
	 * Clears the cache for the sign up otp.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SignUpOTP signUpOTP) {
		entityCache.removeResult(SignUpOTPImpl.class, signUpOTP);
	}

	@Override
	public void clearCache(List<SignUpOTP> signUpOTPs) {
		for (SignUpOTP signUpOTP : signUpOTPs) {
			entityCache.removeResult(SignUpOTPImpl.class, signUpOTP);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SignUpOTPImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SignUpOTPImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		SignUpOTPModelImpl signUpOTPModelImpl) {

		Object[] args = new Object[] {
			signUpOTPModelImpl.getUuid(), signUpOTPModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, signUpOTPModelImpl);
	}

	/**
	 * Creates a new sign up otp with the primary key. Does not add the sign up otp to the database.
	 *
	 * @param otpId the primary key for the new sign up otp
	 * @return the new sign up otp
	 */
	@Override
	public SignUpOTP create(long otpId) {
		SignUpOTP signUpOTP = new SignUpOTPImpl();

		signUpOTP.setNew(true);
		signUpOTP.setPrimaryKey(otpId);

		String uuid = PortalUUIDUtil.generate();

		signUpOTP.setUuid(uuid);

		signUpOTP.setCompanyId(CompanyThreadLocal.getCompanyId());

		return signUpOTP;
	}

	/**
	 * Removes the sign up otp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param otpId the primary key of the sign up otp
	 * @return the sign up otp that was removed
	 * @throws NoSuchSignUpOTPException if a sign up otp with the primary key could not be found
	 */
	@Override
	public SignUpOTP remove(long otpId) throws NoSuchSignUpOTPException {
		return remove((Serializable)otpId);
	}

	/**
	 * Removes the sign up otp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sign up otp
	 * @return the sign up otp that was removed
	 * @throws NoSuchSignUpOTPException if a sign up otp with the primary key could not be found
	 */
	@Override
	public SignUpOTP remove(Serializable primaryKey)
		throws NoSuchSignUpOTPException {

		Session session = null;

		try {
			session = openSession();

			SignUpOTP signUpOTP = (SignUpOTP)session.get(
				SignUpOTPImpl.class, primaryKey);

			if (signUpOTP == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSignUpOTPException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(signUpOTP);
		}
		catch (NoSuchSignUpOTPException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected SignUpOTP removeImpl(SignUpOTP signUpOTP) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(signUpOTP)) {
				signUpOTP = (SignUpOTP)session.get(
					SignUpOTPImpl.class, signUpOTP.getPrimaryKeyObj());
			}

			if (signUpOTP != null) {
				session.delete(signUpOTP);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (signUpOTP != null) {
			clearCache(signUpOTP);
		}

		return signUpOTP;
	}

	@Override
	public SignUpOTP updateImpl(SignUpOTP signUpOTP) {
		boolean isNew = signUpOTP.isNew();

		if (!(signUpOTP instanceof SignUpOTPModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(signUpOTP.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(signUpOTP);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in signUpOTP proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SignUpOTP implementation " +
					signUpOTP.getClass());
		}

		SignUpOTPModelImpl signUpOTPModelImpl = (SignUpOTPModelImpl)signUpOTP;

		if (Validator.isNull(signUpOTP.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			signUpOTP.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (signUpOTP.getCreateDate() == null)) {
			if (serviceContext == null) {
				signUpOTP.setCreateDate(date);
			}
			else {
				signUpOTP.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!signUpOTPModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				signUpOTP.setModifiedDate(date);
			}
			else {
				signUpOTP.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(signUpOTP);
			}
			else {
				signUpOTP = (SignUpOTP)session.merge(signUpOTP);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SignUpOTPImpl.class, signUpOTPModelImpl, false, true);

		cacheUniqueFindersCache(signUpOTPModelImpl);

		if (isNew) {
			signUpOTP.setNew(false);
		}

		signUpOTP.resetOriginalValues();

		return signUpOTP;
	}

	/**
	 * Returns the sign up otp with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sign up otp
	 * @return the sign up otp
	 * @throws NoSuchSignUpOTPException if a sign up otp with the primary key could not be found
	 */
	@Override
	public SignUpOTP findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSignUpOTPException {

		SignUpOTP signUpOTP = fetchByPrimaryKey(primaryKey);

		if (signUpOTP == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSignUpOTPException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return signUpOTP;
	}

	/**
	 * Returns the sign up otp with the primary key or throws a <code>NoSuchSignUpOTPException</code> if it could not be found.
	 *
	 * @param otpId the primary key of the sign up otp
	 * @return the sign up otp
	 * @throws NoSuchSignUpOTPException if a sign up otp with the primary key could not be found
	 */
	@Override
	public SignUpOTP findByPrimaryKey(long otpId)
		throws NoSuchSignUpOTPException {

		return findByPrimaryKey((Serializable)otpId);
	}

	/**
	 * Returns the sign up otp with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param otpId the primary key of the sign up otp
	 * @return the sign up otp, or <code>null</code> if a sign up otp with the primary key could not be found
	 */
	@Override
	public SignUpOTP fetchByPrimaryKey(long otpId) {
		return fetchByPrimaryKey((Serializable)otpId);
	}

	/**
	 * Returns all the sign up otps.
	 *
	 * @return the sign up otps
	 */
	@Override
	public List<SignUpOTP> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SignUpOTP> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<SignUpOTP> findAll(
		int start, int end, OrderByComparator<SignUpOTP> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<SignUpOTP> findAll(
		int start, int end, OrderByComparator<SignUpOTP> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<SignUpOTP> list = null;

		if (useFinderCache) {
			list = (List<SignUpOTP>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SIGNUPOTP);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SIGNUPOTP;

				sql = sql.concat(SignUpOTPModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SignUpOTP>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the sign up otps from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SignUpOTP signUpOTP : findAll()) {
			remove(signUpOTP);
		}
	}

	/**
	 * Returns the number of sign up otps.
	 *
	 * @return the number of sign up otps
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SIGNUPOTP);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "otpId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SIGNUPOTP;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SignUpOTPModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sign up otp persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		SignUpOTPUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		SignUpOTPUtil.setPersistence(null);

		entityCache.removeCache(SignUpOTPImpl.class.getName());
	}

	@Override
	@Reference(
		target = firePersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = firePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = firePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SIGNUPOTP =
		"SELECT signUpOTP FROM SignUpOTP signUpOTP";

	private static final String _SQL_SELECT_SIGNUPOTP_WHERE =
		"SELECT signUpOTP FROM SignUpOTP signUpOTP WHERE ";

	private static final String _SQL_COUNT_SIGNUPOTP =
		"SELECT COUNT(signUpOTP) FROM SignUpOTP signUpOTP";

	private static final String _SQL_COUNT_SIGNUPOTP_WHERE =
		"SELECT COUNT(signUpOTP) FROM SignUpOTP signUpOTP WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "signUpOTP.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SignUpOTP exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SignUpOTP exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SignUpOTPPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}