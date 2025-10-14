/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package EmergencyRequestDB.service.persistence.impl;

import EmergencyRequestDB.exception.NoSuchEmergencyRequestException;

import EmergencyRequestDB.model.EmergencyRequest;
import EmergencyRequestDB.model.EmergencyRequestTable;
import EmergencyRequestDB.model.impl.EmergencyRequestImpl;
import EmergencyRequestDB.model.impl.EmergencyRequestModelImpl;

import EmergencyRequestDB.service.persistence.EmergencyRequestPersistence;
import EmergencyRequestDB.service.persistence.EmergencyRequestUtil;
import EmergencyRequestDB.service.persistence.impl.constants.FirePersistenceConstants;

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
 * The persistence implementation for the emergency request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmergencyRequestPersistence.class)
public class EmergencyRequestPersistenceImpl
	extends BasePersistenceImpl<EmergencyRequest>
	implements EmergencyRequestPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmergencyRequestUtil</code> to access the emergency request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmergencyRequestImpl.class.getName();

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
	 * Returns all the emergency requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching emergency requests
	 */
	@Override
	public List<EmergencyRequest> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<EmergencyRequest> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<EmergencyRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmergencyRequest> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<EmergencyRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EmergencyRequest> orderByComparator,
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

		List<EmergencyRequest> list = null;

		if (useFinderCache) {
			list = (List<EmergencyRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmergencyRequest emergencyRequest : list) {
					if (!uuid.equals(emergencyRequest.getUuid())) {
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

			sb.append(_SQL_SELECT_EMERGENCYREQUEST_WHERE);

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
				sb.append(EmergencyRequestModelImpl.ORDER_BY_JPQL);
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

				list = (List<EmergencyRequest>)QueryUtil.list(
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
	 * Returns the first emergency request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emergency request
	 * @throws NoSuchEmergencyRequestException if a matching emergency request could not be found
	 */
	@Override
	public EmergencyRequest findByUuid_First(
			String uuid, OrderByComparator<EmergencyRequest> orderByComparator)
		throws NoSuchEmergencyRequestException {

		EmergencyRequest emergencyRequest = fetchByUuid_First(
			uuid, orderByComparator);

		if (emergencyRequest != null) {
			return emergencyRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEmergencyRequestException(sb.toString());
	}

	/**
	 * Returns the first emergency request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emergency request, or <code>null</code> if a matching emergency request could not be found
	 */
	@Override
	public EmergencyRequest fetchByUuid_First(
		String uuid, OrderByComparator<EmergencyRequest> orderByComparator) {

		List<EmergencyRequest> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emergency request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emergency request
	 * @throws NoSuchEmergencyRequestException if a matching emergency request could not be found
	 */
	@Override
	public EmergencyRequest findByUuid_Last(
			String uuid, OrderByComparator<EmergencyRequest> orderByComparator)
		throws NoSuchEmergencyRequestException {

		EmergencyRequest emergencyRequest = fetchByUuid_Last(
			uuid, orderByComparator);

		if (emergencyRequest != null) {
			return emergencyRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEmergencyRequestException(sb.toString());
	}

	/**
	 * Returns the last emergency request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emergency request, or <code>null</code> if a matching emergency request could not be found
	 */
	@Override
	public EmergencyRequest fetchByUuid_Last(
		String uuid, OrderByComparator<EmergencyRequest> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EmergencyRequest> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EmergencyRequest[] findByUuid_PrevAndNext(
			long requestId, String uuid,
			OrderByComparator<EmergencyRequest> orderByComparator)
		throws NoSuchEmergencyRequestException {

		uuid = Objects.toString(uuid, "");

		EmergencyRequest emergencyRequest = findByPrimaryKey(requestId);

		Session session = null;

		try {
			session = openSession();

			EmergencyRequest[] array = new EmergencyRequestImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, emergencyRequest, uuid, orderByComparator, true);

			array[1] = emergencyRequest;

			array[2] = getByUuid_PrevAndNext(
				session, emergencyRequest, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmergencyRequest getByUuid_PrevAndNext(
		Session session, EmergencyRequest emergencyRequest, String uuid,
		OrderByComparator<EmergencyRequest> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EMERGENCYREQUEST_WHERE);

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
			sb.append(EmergencyRequestModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						emergencyRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmergencyRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emergency requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (EmergencyRequest emergencyRequest :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(emergencyRequest);
		}
	}

	/**
	 * Returns the number of emergency requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching emergency requests
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMERGENCYREQUEST_WHERE);

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
		"emergencyRequest.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(emergencyRequest.uuid IS NULL OR emergencyRequest.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the emergency request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEmergencyRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching emergency request
	 * @throws NoSuchEmergencyRequestException if a matching emergency request could not be found
	 */
	@Override
	public EmergencyRequest findByUUID_G(String uuid, long groupId)
		throws NoSuchEmergencyRequestException {

		EmergencyRequest emergencyRequest = fetchByUUID_G(uuid, groupId);

		if (emergencyRequest == null) {
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

			throw new NoSuchEmergencyRequestException(sb.toString());
		}

		return emergencyRequest;
	}

	/**
	 * Returns the emergency request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching emergency request, or <code>null</code> if a matching emergency request could not be found
	 */
	@Override
	public EmergencyRequest fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the emergency request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching emergency request, or <code>null</code> if a matching emergency request could not be found
	 */
	@Override
	public EmergencyRequest fetchByUUID_G(
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

		if (result instanceof EmergencyRequest) {
			EmergencyRequest emergencyRequest = (EmergencyRequest)result;

			if (!Objects.equals(uuid, emergencyRequest.getUuid()) ||
				(groupId != emergencyRequest.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_EMERGENCYREQUEST_WHERE);

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

				List<EmergencyRequest> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					EmergencyRequest emergencyRequest = list.get(0);

					result = emergencyRequest;

					cacheResult(emergencyRequest);
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
			return (EmergencyRequest)result;
		}
	}

	/**
	 * Removes the emergency request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the emergency request that was removed
	 */
	@Override
	public EmergencyRequest removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmergencyRequestException {

		EmergencyRequest emergencyRequest = findByUUID_G(uuid, groupId);

		return remove(emergencyRequest);
	}

	/**
	 * Returns the number of emergency requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching emergency requests
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		EmergencyRequest emergencyRequest = fetchByUUID_G(uuid, groupId);

		if (emergencyRequest == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"emergencyRequest.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(emergencyRequest.uuid IS NULL OR emergencyRequest.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"emergencyRequest.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the emergency requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching emergency requests
	 */
	@Override
	public List<EmergencyRequest> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<EmergencyRequest> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<EmergencyRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmergencyRequest> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<EmergencyRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EmergencyRequest> orderByComparator,
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

		List<EmergencyRequest> list = null;

		if (useFinderCache) {
			list = (List<EmergencyRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmergencyRequest emergencyRequest : list) {
					if (!uuid.equals(emergencyRequest.getUuid()) ||
						(companyId != emergencyRequest.getCompanyId())) {

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

			sb.append(_SQL_SELECT_EMERGENCYREQUEST_WHERE);

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
				sb.append(EmergencyRequestModelImpl.ORDER_BY_JPQL);
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

				list = (List<EmergencyRequest>)QueryUtil.list(
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
	 * Returns the first emergency request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emergency request
	 * @throws NoSuchEmergencyRequestException if a matching emergency request could not be found
	 */
	@Override
	public EmergencyRequest findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EmergencyRequest> orderByComparator)
		throws NoSuchEmergencyRequestException {

		EmergencyRequest emergencyRequest = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (emergencyRequest != null) {
			return emergencyRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEmergencyRequestException(sb.toString());
	}

	/**
	 * Returns the first emergency request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emergency request, or <code>null</code> if a matching emergency request could not be found
	 */
	@Override
	public EmergencyRequest fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EmergencyRequest> orderByComparator) {

		List<EmergencyRequest> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EmergencyRequest findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EmergencyRequest> orderByComparator)
		throws NoSuchEmergencyRequestException {

		EmergencyRequest emergencyRequest = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (emergencyRequest != null) {
			return emergencyRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEmergencyRequestException(sb.toString());
	}

	/**
	 * Returns the last emergency request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emergency request, or <code>null</code> if a matching emergency request could not be found
	 */
	@Override
	public EmergencyRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EmergencyRequest> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<EmergencyRequest> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EmergencyRequest[] findByUuid_C_PrevAndNext(
			long requestId, String uuid, long companyId,
			OrderByComparator<EmergencyRequest> orderByComparator)
		throws NoSuchEmergencyRequestException {

		uuid = Objects.toString(uuid, "");

		EmergencyRequest emergencyRequest = findByPrimaryKey(requestId);

		Session session = null;

		try {
			session = openSession();

			EmergencyRequest[] array = new EmergencyRequestImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, emergencyRequest, uuid, companyId, orderByComparator,
				true);

			array[1] = emergencyRequest;

			array[2] = getByUuid_C_PrevAndNext(
				session, emergencyRequest, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmergencyRequest getByUuid_C_PrevAndNext(
		Session session, EmergencyRequest emergencyRequest, String uuid,
		long companyId, OrderByComparator<EmergencyRequest> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_EMERGENCYREQUEST_WHERE);

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
			sb.append(EmergencyRequestModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						emergencyRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmergencyRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emergency requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (EmergencyRequest emergencyRequest :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(emergencyRequest);
		}
	}

	/**
	 * Returns the number of emergency requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching emergency requests
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EMERGENCYREQUEST_WHERE);

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
		"emergencyRequest.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(emergencyRequest.uuid IS NULL OR emergencyRequest.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"emergencyRequest.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the emergency requests where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching emergency requests
	 */
	@Override
	public List<EmergencyRequest> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<EmergencyRequest> findByUserId(
		long userId, int start, int end) {

		return findByUserId(userId, start, end, null);
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
	@Override
	public List<EmergencyRequest> findByUserId(
		long userId, int start, int end,
		OrderByComparator<EmergencyRequest> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
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
	@Override
	public List<EmergencyRequest> findByUserId(
		long userId, int start, int end,
		OrderByComparator<EmergencyRequest> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserId;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<EmergencyRequest> list = null;

		if (useFinderCache) {
			list = (List<EmergencyRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmergencyRequest emergencyRequest : list) {
					if (userId != emergencyRequest.getUserId()) {
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

			sb.append(_SQL_SELECT_EMERGENCYREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmergencyRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<EmergencyRequest>)QueryUtil.list(
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
	 * Returns the first emergency request in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emergency request
	 * @throws NoSuchEmergencyRequestException if a matching emergency request could not be found
	 */
	@Override
	public EmergencyRequest findByUserId_First(
			long userId, OrderByComparator<EmergencyRequest> orderByComparator)
		throws NoSuchEmergencyRequestException {

		EmergencyRequest emergencyRequest = fetchByUserId_First(
			userId, orderByComparator);

		if (emergencyRequest != null) {
			return emergencyRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchEmergencyRequestException(sb.toString());
	}

	/**
	 * Returns the first emergency request in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emergency request, or <code>null</code> if a matching emergency request could not be found
	 */
	@Override
	public EmergencyRequest fetchByUserId_First(
		long userId, OrderByComparator<EmergencyRequest> orderByComparator) {

		List<EmergencyRequest> list = findByUserId(
			userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emergency request in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emergency request
	 * @throws NoSuchEmergencyRequestException if a matching emergency request could not be found
	 */
	@Override
	public EmergencyRequest findByUserId_Last(
			long userId, OrderByComparator<EmergencyRequest> orderByComparator)
		throws NoSuchEmergencyRequestException {

		EmergencyRequest emergencyRequest = fetchByUserId_Last(
			userId, orderByComparator);

		if (emergencyRequest != null) {
			return emergencyRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchEmergencyRequestException(sb.toString());
	}

	/**
	 * Returns the last emergency request in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emergency request, or <code>null</code> if a matching emergency request could not be found
	 */
	@Override
	public EmergencyRequest fetchByUserId_Last(
		long userId, OrderByComparator<EmergencyRequest> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<EmergencyRequest> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public EmergencyRequest[] findByUserId_PrevAndNext(
			long requestId, long userId,
			OrderByComparator<EmergencyRequest> orderByComparator)
		throws NoSuchEmergencyRequestException {

		EmergencyRequest emergencyRequest = findByPrimaryKey(requestId);

		Session session = null;

		try {
			session = openSession();

			EmergencyRequest[] array = new EmergencyRequestImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, emergencyRequest, userId, orderByComparator, true);

			array[1] = emergencyRequest;

			array[2] = getByUserId_PrevAndNext(
				session, emergencyRequest, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmergencyRequest getByUserId_PrevAndNext(
		Session session, EmergencyRequest emergencyRequest, long userId,
		OrderByComparator<EmergencyRequest> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EMERGENCYREQUEST_WHERE);

		sb.append(_FINDER_COLUMN_USERID_USERID_2);

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
			sb.append(EmergencyRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						emergencyRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EmergencyRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emergency requests where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (EmergencyRequest emergencyRequest :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(emergencyRequest);
		}
	}

	/**
	 * Returns the number of emergency requests where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching emergency requests
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMERGENCYREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"emergencyRequest.userId = ?";

	public EmergencyRequestPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EmergencyRequest.class);

		setModelImplClass(EmergencyRequestImpl.class);
		setModelPKClass(long.class);

		setTable(EmergencyRequestTable.INSTANCE);
	}

	/**
	 * Caches the emergency request in the entity cache if it is enabled.
	 *
	 * @param emergencyRequest the emergency request
	 */
	@Override
	public void cacheResult(EmergencyRequest emergencyRequest) {
		entityCache.putResult(
			EmergencyRequestImpl.class, emergencyRequest.getPrimaryKey(),
			emergencyRequest);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				emergencyRequest.getUuid(), emergencyRequest.getGroupId()
			},
			emergencyRequest);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the emergency requests in the entity cache if it is enabled.
	 *
	 * @param emergencyRequests the emergency requests
	 */
	@Override
	public void cacheResult(List<EmergencyRequest> emergencyRequests) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (emergencyRequests.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (EmergencyRequest emergencyRequest : emergencyRequests) {
			if (entityCache.getResult(
					EmergencyRequestImpl.class,
					emergencyRequest.getPrimaryKey()) == null) {

				cacheResult(emergencyRequest);
			}
		}
	}

	/**
	 * Clears the cache for all emergency requests.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmergencyRequestImpl.class);

		finderCache.clearCache(EmergencyRequestImpl.class);
	}

	/**
	 * Clears the cache for the emergency request.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmergencyRequest emergencyRequest) {
		entityCache.removeResult(EmergencyRequestImpl.class, emergencyRequest);
	}

	@Override
	public void clearCache(List<EmergencyRequest> emergencyRequests) {
		for (EmergencyRequest emergencyRequest : emergencyRequests) {
			entityCache.removeResult(
				EmergencyRequestImpl.class, emergencyRequest);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EmergencyRequestImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmergencyRequestImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EmergencyRequestModelImpl emergencyRequestModelImpl) {

		Object[] args = new Object[] {
			emergencyRequestModelImpl.getUuid(),
			emergencyRequestModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, emergencyRequestModelImpl);
	}

	/**
	 * Creates a new emergency request with the primary key. Does not add the emergency request to the database.
	 *
	 * @param requestId the primary key for the new emergency request
	 * @return the new emergency request
	 */
	@Override
	public EmergencyRequest create(long requestId) {
		EmergencyRequest emergencyRequest = new EmergencyRequestImpl();

		emergencyRequest.setNew(true);
		emergencyRequest.setPrimaryKey(requestId);

		String uuid = PortalUUIDUtil.generate();

		emergencyRequest.setUuid(uuid);

		emergencyRequest.setCompanyId(CompanyThreadLocal.getCompanyId());

		return emergencyRequest;
	}

	/**
	 * Removes the emergency request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param requestId the primary key of the emergency request
	 * @return the emergency request that was removed
	 * @throws NoSuchEmergencyRequestException if a emergency request with the primary key could not be found
	 */
	@Override
	public EmergencyRequest remove(long requestId)
		throws NoSuchEmergencyRequestException {

		return remove((Serializable)requestId);
	}

	/**
	 * Removes the emergency request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the emergency request
	 * @return the emergency request that was removed
	 * @throws NoSuchEmergencyRequestException if a emergency request with the primary key could not be found
	 */
	@Override
	public EmergencyRequest remove(Serializable primaryKey)
		throws NoSuchEmergencyRequestException {

		Session session = null;

		try {
			session = openSession();

			EmergencyRequest emergencyRequest = (EmergencyRequest)session.get(
				EmergencyRequestImpl.class, primaryKey);

			if (emergencyRequest == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmergencyRequestException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(emergencyRequest);
		}
		catch (NoSuchEmergencyRequestException noSuchEntityException) {
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
	protected EmergencyRequest removeImpl(EmergencyRequest emergencyRequest) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(emergencyRequest)) {
				emergencyRequest = (EmergencyRequest)session.get(
					EmergencyRequestImpl.class,
					emergencyRequest.getPrimaryKeyObj());
			}

			if (emergencyRequest != null) {
				session.delete(emergencyRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (emergencyRequest != null) {
			clearCache(emergencyRequest);
		}

		return emergencyRequest;
	}

	@Override
	public EmergencyRequest updateImpl(EmergencyRequest emergencyRequest) {
		boolean isNew = emergencyRequest.isNew();

		if (!(emergencyRequest instanceof EmergencyRequestModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(emergencyRequest.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					emergencyRequest);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in emergencyRequest proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmergencyRequest implementation " +
					emergencyRequest.getClass());
		}

		EmergencyRequestModelImpl emergencyRequestModelImpl =
			(EmergencyRequestModelImpl)emergencyRequest;

		if (Validator.isNull(emergencyRequest.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			emergencyRequest.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (emergencyRequest.getCreateDate() == null)) {
			if (serviceContext == null) {
				emergencyRequest.setCreateDate(date);
			}
			else {
				emergencyRequest.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!emergencyRequestModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				emergencyRequest.setModifiedDate(date);
			}
			else {
				emergencyRequest.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(emergencyRequest);
			}
			else {
				emergencyRequest = (EmergencyRequest)session.merge(
					emergencyRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmergencyRequestImpl.class, emergencyRequestModelImpl, false, true);

		cacheUniqueFindersCache(emergencyRequestModelImpl);

		if (isNew) {
			emergencyRequest.setNew(false);
		}

		emergencyRequest.resetOriginalValues();

		return emergencyRequest;
	}

	/**
	 * Returns the emergency request with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the emergency request
	 * @return the emergency request
	 * @throws NoSuchEmergencyRequestException if a emergency request with the primary key could not be found
	 */
	@Override
	public EmergencyRequest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmergencyRequestException {

		EmergencyRequest emergencyRequest = fetchByPrimaryKey(primaryKey);

		if (emergencyRequest == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmergencyRequestException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return emergencyRequest;
	}

	/**
	 * Returns the emergency request with the primary key or throws a <code>NoSuchEmergencyRequestException</code> if it could not be found.
	 *
	 * @param requestId the primary key of the emergency request
	 * @return the emergency request
	 * @throws NoSuchEmergencyRequestException if a emergency request with the primary key could not be found
	 */
	@Override
	public EmergencyRequest findByPrimaryKey(long requestId)
		throws NoSuchEmergencyRequestException {

		return findByPrimaryKey((Serializable)requestId);
	}

	/**
	 * Returns the emergency request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param requestId the primary key of the emergency request
	 * @return the emergency request, or <code>null</code> if a emergency request with the primary key could not be found
	 */
	@Override
	public EmergencyRequest fetchByPrimaryKey(long requestId) {
		return fetchByPrimaryKey((Serializable)requestId);
	}

	/**
	 * Returns all the emergency requests.
	 *
	 * @return the emergency requests
	 */
	@Override
	public List<EmergencyRequest> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<EmergencyRequest> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<EmergencyRequest> findAll(
		int start, int end,
		OrderByComparator<EmergencyRequest> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<EmergencyRequest> findAll(
		int start, int end,
		OrderByComparator<EmergencyRequest> orderByComparator,
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

		List<EmergencyRequest> list = null;

		if (useFinderCache) {
			list = (List<EmergencyRequest>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMERGENCYREQUEST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMERGENCYREQUEST;

				sql = sql.concat(EmergencyRequestModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EmergencyRequest>)QueryUtil.list(
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
	 * Removes all the emergency requests from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmergencyRequest emergencyRequest : findAll()) {
			remove(emergencyRequest);
		}
	}

	/**
	 * Returns the number of emergency requests.
	 *
	 * @return the number of emergency requests
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EMERGENCYREQUEST);

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
		return "requestId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMERGENCYREQUEST;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmergencyRequestModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the emergency request persistence.
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

		_finderPathWithPaginationFindByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userId"}, true);

		_finderPathWithoutPaginationFindByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"},
			false);

		EmergencyRequestUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		EmergencyRequestUtil.setPersistence(null);

		entityCache.removeCache(EmergencyRequestImpl.class.getName());
	}

	@Override
	@Reference(
		target = FirePersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = FirePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = FirePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_EMERGENCYREQUEST =
		"SELECT emergencyRequest FROM EmergencyRequest emergencyRequest";

	private static final String _SQL_SELECT_EMERGENCYREQUEST_WHERE =
		"SELECT emergencyRequest FROM EmergencyRequest emergencyRequest WHERE ";

	private static final String _SQL_COUNT_EMERGENCYREQUEST =
		"SELECT COUNT(emergencyRequest) FROM EmergencyRequest emergencyRequest";

	private static final String _SQL_COUNT_EMERGENCYREQUEST_WHERE =
		"SELECT COUNT(emergencyRequest) FROM EmergencyRequest emergencyRequest WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "emergencyRequest.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EmergencyRequest exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EmergencyRequest exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmergencyRequestPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}