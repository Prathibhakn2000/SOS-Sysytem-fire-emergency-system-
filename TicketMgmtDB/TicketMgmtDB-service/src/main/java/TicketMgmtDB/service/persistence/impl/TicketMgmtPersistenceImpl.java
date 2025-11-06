/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package TicketMgmtDB.service.persistence.impl;

import TicketMgmtDB.exception.NoSuchTicketMgmtException;

import TicketMgmtDB.model.TicketMgmt;
import TicketMgmtDB.model.TicketMgmtTable;
import TicketMgmtDB.model.impl.TicketMgmtImpl;
import TicketMgmtDB.model.impl.TicketMgmtModelImpl;

import TicketMgmtDB.service.persistence.TicketMgmtPersistence;
import TicketMgmtDB.service.persistence.TicketMgmtUtil;
import TicketMgmtDB.service.persistence.impl.constants.ATSPersistenceConstants;

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
 * The persistence implementation for the ticket mgmt service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TicketMgmtPersistence.class)
public class TicketMgmtPersistenceImpl
	extends BasePersistenceImpl<TicketMgmt> implements TicketMgmtPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TicketMgmtUtil</code> to access the ticket mgmt persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TicketMgmtImpl.class.getName();

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
	 * Returns all the ticket mgmts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ticket mgmts
	 */
	@Override
	public List<TicketMgmt> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ticket mgmts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketMgmtModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ticket mgmts
	 * @param end the upper bound of the range of ticket mgmts (not inclusive)
	 * @return the range of matching ticket mgmts
	 */
	@Override
	public List<TicketMgmt> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ticket mgmts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketMgmtModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ticket mgmts
	 * @param end the upper bound of the range of ticket mgmts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket mgmts
	 */
	@Override
	public List<TicketMgmt> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TicketMgmt> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ticket mgmts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketMgmtModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ticket mgmts
	 * @param end the upper bound of the range of ticket mgmts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket mgmts
	 */
	@Override
	public List<TicketMgmt> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TicketMgmt> orderByComparator,
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

		List<TicketMgmt> list = null;

		if (useFinderCache) {
			list = (List<TicketMgmt>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TicketMgmt ticketMgmt : list) {
					if (!uuid.equals(ticketMgmt.getUuid())) {
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

			sb.append(_SQL_SELECT_TICKETMGMT_WHERE);

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
				sb.append(TicketMgmtModelImpl.ORDER_BY_JPQL);
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

				list = (List<TicketMgmt>)QueryUtil.list(
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
	 * Returns the first ticket mgmt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket mgmt
	 * @throws NoSuchTicketMgmtException if a matching ticket mgmt could not be found
	 */
	@Override
	public TicketMgmt findByUuid_First(
			String uuid, OrderByComparator<TicketMgmt> orderByComparator)
		throws NoSuchTicketMgmtException {

		TicketMgmt ticketMgmt = fetchByUuid_First(uuid, orderByComparator);

		if (ticketMgmt != null) {
			return ticketMgmt;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTicketMgmtException(sb.toString());
	}

	/**
	 * Returns the first ticket mgmt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket mgmt, or <code>null</code> if a matching ticket mgmt could not be found
	 */
	@Override
	public TicketMgmt fetchByUuid_First(
		String uuid, OrderByComparator<TicketMgmt> orderByComparator) {

		List<TicketMgmt> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ticket mgmt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket mgmt
	 * @throws NoSuchTicketMgmtException if a matching ticket mgmt could not be found
	 */
	@Override
	public TicketMgmt findByUuid_Last(
			String uuid, OrderByComparator<TicketMgmt> orderByComparator)
		throws NoSuchTicketMgmtException {

		TicketMgmt ticketMgmt = fetchByUuid_Last(uuid, orderByComparator);

		if (ticketMgmt != null) {
			return ticketMgmt;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTicketMgmtException(sb.toString());
	}

	/**
	 * Returns the last ticket mgmt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket mgmt, or <code>null</code> if a matching ticket mgmt could not be found
	 */
	@Override
	public TicketMgmt fetchByUuid_Last(
		String uuid, OrderByComparator<TicketMgmt> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<TicketMgmt> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ticket mgmts before and after the current ticket mgmt in the ordered set where uuid = &#63;.
	 *
	 * @param ticket_id the primary key of the current ticket mgmt
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket mgmt
	 * @throws NoSuchTicketMgmtException if a ticket mgmt with the primary key could not be found
	 */
	@Override
	public TicketMgmt[] findByUuid_PrevAndNext(
			long ticket_id, String uuid,
			OrderByComparator<TicketMgmt> orderByComparator)
		throws NoSuchTicketMgmtException {

		uuid = Objects.toString(uuid, "");

		TicketMgmt ticketMgmt = findByPrimaryKey(ticket_id);

		Session session = null;

		try {
			session = openSession();

			TicketMgmt[] array = new TicketMgmtImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, ticketMgmt, uuid, orderByComparator, true);

			array[1] = ticketMgmt;

			array[2] = getByUuid_PrevAndNext(
				session, ticketMgmt, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TicketMgmt getByUuid_PrevAndNext(
		Session session, TicketMgmt ticketMgmt, String uuid,
		OrderByComparator<TicketMgmt> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TICKETMGMT_WHERE);

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
			sb.append(TicketMgmtModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(ticketMgmt)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TicketMgmt> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ticket mgmts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (TicketMgmt ticketMgmt :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ticketMgmt);
		}
	}

	/**
	 * Returns the number of ticket mgmts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ticket mgmts
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TICKETMGMT_WHERE);

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
		"ticketMgmt.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(ticketMgmt.uuid IS NULL OR ticketMgmt.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the ticket mgmt where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTicketMgmtException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ticket mgmt
	 * @throws NoSuchTicketMgmtException if a matching ticket mgmt could not be found
	 */
	@Override
	public TicketMgmt findByUUID_G(String uuid, long groupId)
		throws NoSuchTicketMgmtException {

		TicketMgmt ticketMgmt = fetchByUUID_G(uuid, groupId);

		if (ticketMgmt == null) {
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

			throw new NoSuchTicketMgmtException(sb.toString());
		}

		return ticketMgmt;
	}

	/**
	 * Returns the ticket mgmt where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ticket mgmt, or <code>null</code> if a matching ticket mgmt could not be found
	 */
	@Override
	public TicketMgmt fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the ticket mgmt where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ticket mgmt, or <code>null</code> if a matching ticket mgmt could not be found
	 */
	@Override
	public TicketMgmt fetchByUUID_G(
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

		if (result instanceof TicketMgmt) {
			TicketMgmt ticketMgmt = (TicketMgmt)result;

			if (!Objects.equals(uuid, ticketMgmt.getUuid()) ||
				(groupId != ticketMgmt.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_TICKETMGMT_WHERE);

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

				List<TicketMgmt> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					TicketMgmt ticketMgmt = list.get(0);

					result = ticketMgmt;

					cacheResult(ticketMgmt);
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
			return (TicketMgmt)result;
		}
	}

	/**
	 * Removes the ticket mgmt where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ticket mgmt that was removed
	 */
	@Override
	public TicketMgmt removeByUUID_G(String uuid, long groupId)
		throws NoSuchTicketMgmtException {

		TicketMgmt ticketMgmt = findByUUID_G(uuid, groupId);

		return remove(ticketMgmt);
	}

	/**
	 * Returns the number of ticket mgmts where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching ticket mgmts
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		TicketMgmt ticketMgmt = fetchByUUID_G(uuid, groupId);

		if (ticketMgmt == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"ticketMgmt.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(ticketMgmt.uuid IS NULL OR ticketMgmt.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"ticketMgmt.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the ticket mgmts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching ticket mgmts
	 */
	@Override
	public List<TicketMgmt> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ticket mgmts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketMgmtModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ticket mgmts
	 * @param end the upper bound of the range of ticket mgmts (not inclusive)
	 * @return the range of matching ticket mgmts
	 */
	@Override
	public List<TicketMgmt> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ticket mgmts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketMgmtModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ticket mgmts
	 * @param end the upper bound of the range of ticket mgmts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket mgmts
	 */
	@Override
	public List<TicketMgmt> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TicketMgmt> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ticket mgmts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketMgmtModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of ticket mgmts
	 * @param end the upper bound of the range of ticket mgmts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket mgmts
	 */
	@Override
	public List<TicketMgmt> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TicketMgmt> orderByComparator,
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

		List<TicketMgmt> list = null;

		if (useFinderCache) {
			list = (List<TicketMgmt>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TicketMgmt ticketMgmt : list) {
					if (!uuid.equals(ticketMgmt.getUuid()) ||
						(companyId != ticketMgmt.getCompanyId())) {

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

			sb.append(_SQL_SELECT_TICKETMGMT_WHERE);

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
				sb.append(TicketMgmtModelImpl.ORDER_BY_JPQL);
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

				list = (List<TicketMgmt>)QueryUtil.list(
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
	 * Returns the first ticket mgmt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket mgmt
	 * @throws NoSuchTicketMgmtException if a matching ticket mgmt could not be found
	 */
	@Override
	public TicketMgmt findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TicketMgmt> orderByComparator)
		throws NoSuchTicketMgmtException {

		TicketMgmt ticketMgmt = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (ticketMgmt != null) {
			return ticketMgmt;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTicketMgmtException(sb.toString());
	}

	/**
	 * Returns the first ticket mgmt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket mgmt, or <code>null</code> if a matching ticket mgmt could not be found
	 */
	@Override
	public TicketMgmt fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TicketMgmt> orderByComparator) {

		List<TicketMgmt> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ticket mgmt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket mgmt
	 * @throws NoSuchTicketMgmtException if a matching ticket mgmt could not be found
	 */
	@Override
	public TicketMgmt findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TicketMgmt> orderByComparator)
		throws NoSuchTicketMgmtException {

		TicketMgmt ticketMgmt = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (ticketMgmt != null) {
			return ticketMgmt;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTicketMgmtException(sb.toString());
	}

	/**
	 * Returns the last ticket mgmt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket mgmt, or <code>null</code> if a matching ticket mgmt could not be found
	 */
	@Override
	public TicketMgmt fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TicketMgmt> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<TicketMgmt> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ticket mgmts before and after the current ticket mgmt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param ticket_id the primary key of the current ticket mgmt
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket mgmt
	 * @throws NoSuchTicketMgmtException if a ticket mgmt with the primary key could not be found
	 */
	@Override
	public TicketMgmt[] findByUuid_C_PrevAndNext(
			long ticket_id, String uuid, long companyId,
			OrderByComparator<TicketMgmt> orderByComparator)
		throws NoSuchTicketMgmtException {

		uuid = Objects.toString(uuid, "");

		TicketMgmt ticketMgmt = findByPrimaryKey(ticket_id);

		Session session = null;

		try {
			session = openSession();

			TicketMgmt[] array = new TicketMgmtImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, ticketMgmt, uuid, companyId, orderByComparator, true);

			array[1] = ticketMgmt;

			array[2] = getByUuid_C_PrevAndNext(
				session, ticketMgmt, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TicketMgmt getByUuid_C_PrevAndNext(
		Session session, TicketMgmt ticketMgmt, String uuid, long companyId,
		OrderByComparator<TicketMgmt> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TICKETMGMT_WHERE);

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
			sb.append(TicketMgmtModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(ticketMgmt)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TicketMgmt> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ticket mgmts where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (TicketMgmt ticketMgmt :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(ticketMgmt);
		}
	}

	/**
	 * Returns the number of ticket mgmts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching ticket mgmts
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TICKETMGMT_WHERE);

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
		"ticketMgmt.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(ticketMgmt.uuid IS NULL OR ticketMgmt.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"ticketMgmt.companyId = ?";

	public TicketMgmtPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(TicketMgmt.class);

		setModelImplClass(TicketMgmtImpl.class);
		setModelPKClass(long.class);

		setTable(TicketMgmtTable.INSTANCE);
	}

	/**
	 * Caches the ticket mgmt in the entity cache if it is enabled.
	 *
	 * @param ticketMgmt the ticket mgmt
	 */
	@Override
	public void cacheResult(TicketMgmt ticketMgmt) {
		entityCache.putResult(
			TicketMgmtImpl.class, ticketMgmt.getPrimaryKey(), ticketMgmt);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {ticketMgmt.getUuid(), ticketMgmt.getGroupId()},
			ticketMgmt);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the ticket mgmts in the entity cache if it is enabled.
	 *
	 * @param ticketMgmts the ticket mgmts
	 */
	@Override
	public void cacheResult(List<TicketMgmt> ticketMgmts) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (ticketMgmts.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TicketMgmt ticketMgmt : ticketMgmts) {
			if (entityCache.getResult(
					TicketMgmtImpl.class, ticketMgmt.getPrimaryKey()) == null) {

				cacheResult(ticketMgmt);
			}
		}
	}

	/**
	 * Clears the cache for all ticket mgmts.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TicketMgmtImpl.class);

		finderCache.clearCache(TicketMgmtImpl.class);
	}

	/**
	 * Clears the cache for the ticket mgmt.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TicketMgmt ticketMgmt) {
		entityCache.removeResult(TicketMgmtImpl.class, ticketMgmt);
	}

	@Override
	public void clearCache(List<TicketMgmt> ticketMgmts) {
		for (TicketMgmt ticketMgmt : ticketMgmts) {
			entityCache.removeResult(TicketMgmtImpl.class, ticketMgmt);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TicketMgmtImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TicketMgmtImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TicketMgmtModelImpl ticketMgmtModelImpl) {

		Object[] args = new Object[] {
			ticketMgmtModelImpl.getUuid(), ticketMgmtModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, ticketMgmtModelImpl);
	}

	/**
	 * Creates a new ticket mgmt with the primary key. Does not add the ticket mgmt to the database.
	 *
	 * @param ticket_id the primary key for the new ticket mgmt
	 * @return the new ticket mgmt
	 */
	@Override
	public TicketMgmt create(long ticket_id) {
		TicketMgmt ticketMgmt = new TicketMgmtImpl();

		ticketMgmt.setNew(true);
		ticketMgmt.setPrimaryKey(ticket_id);

		String uuid = PortalUUIDUtil.generate();

		ticketMgmt.setUuid(uuid);

		ticketMgmt.setCompanyId(CompanyThreadLocal.getCompanyId());

		return ticketMgmt;
	}

	/**
	 * Removes the ticket mgmt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticket_id the primary key of the ticket mgmt
	 * @return the ticket mgmt that was removed
	 * @throws NoSuchTicketMgmtException if a ticket mgmt with the primary key could not be found
	 */
	@Override
	public TicketMgmt remove(long ticket_id) throws NoSuchTicketMgmtException {
		return remove((Serializable)ticket_id);
	}

	/**
	 * Removes the ticket mgmt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ticket mgmt
	 * @return the ticket mgmt that was removed
	 * @throws NoSuchTicketMgmtException if a ticket mgmt with the primary key could not be found
	 */
	@Override
	public TicketMgmt remove(Serializable primaryKey)
		throws NoSuchTicketMgmtException {

		Session session = null;

		try {
			session = openSession();

			TicketMgmt ticketMgmt = (TicketMgmt)session.get(
				TicketMgmtImpl.class, primaryKey);

			if (ticketMgmt == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTicketMgmtException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ticketMgmt);
		}
		catch (NoSuchTicketMgmtException noSuchEntityException) {
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
	protected TicketMgmt removeImpl(TicketMgmt ticketMgmt) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ticketMgmt)) {
				ticketMgmt = (TicketMgmt)session.get(
					TicketMgmtImpl.class, ticketMgmt.getPrimaryKeyObj());
			}

			if (ticketMgmt != null) {
				session.delete(ticketMgmt);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (ticketMgmt != null) {
			clearCache(ticketMgmt);
		}

		return ticketMgmt;
	}

	@Override
	public TicketMgmt updateImpl(TicketMgmt ticketMgmt) {
		boolean isNew = ticketMgmt.isNew();

		if (!(ticketMgmt instanceof TicketMgmtModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ticketMgmt.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(ticketMgmt);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ticketMgmt proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TicketMgmt implementation " +
					ticketMgmt.getClass());
		}

		TicketMgmtModelImpl ticketMgmtModelImpl =
			(TicketMgmtModelImpl)ticketMgmt;

		if (Validator.isNull(ticketMgmt.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			ticketMgmt.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (ticketMgmt.getCreateDate() == null)) {
			if (serviceContext == null) {
				ticketMgmt.setCreateDate(date);
			}
			else {
				ticketMgmt.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!ticketMgmtModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				ticketMgmt.setModifiedDate(date);
			}
			else {
				ticketMgmt.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(ticketMgmt);
			}
			else {
				ticketMgmt = (TicketMgmt)session.merge(ticketMgmt);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TicketMgmtImpl.class, ticketMgmtModelImpl, false, true);

		cacheUniqueFindersCache(ticketMgmtModelImpl);

		if (isNew) {
			ticketMgmt.setNew(false);
		}

		ticketMgmt.resetOriginalValues();

		return ticketMgmt;
	}

	/**
	 * Returns the ticket mgmt with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ticket mgmt
	 * @return the ticket mgmt
	 * @throws NoSuchTicketMgmtException if a ticket mgmt with the primary key could not be found
	 */
	@Override
	public TicketMgmt findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTicketMgmtException {

		TicketMgmt ticketMgmt = fetchByPrimaryKey(primaryKey);

		if (ticketMgmt == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTicketMgmtException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ticketMgmt;
	}

	/**
	 * Returns the ticket mgmt with the primary key or throws a <code>NoSuchTicketMgmtException</code> if it could not be found.
	 *
	 * @param ticket_id the primary key of the ticket mgmt
	 * @return the ticket mgmt
	 * @throws NoSuchTicketMgmtException if a ticket mgmt with the primary key could not be found
	 */
	@Override
	public TicketMgmt findByPrimaryKey(long ticket_id)
		throws NoSuchTicketMgmtException {

		return findByPrimaryKey((Serializable)ticket_id);
	}

	/**
	 * Returns the ticket mgmt with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ticket_id the primary key of the ticket mgmt
	 * @return the ticket mgmt, or <code>null</code> if a ticket mgmt with the primary key could not be found
	 */
	@Override
	public TicketMgmt fetchByPrimaryKey(long ticket_id) {
		return fetchByPrimaryKey((Serializable)ticket_id);
	}

	/**
	 * Returns all the ticket mgmts.
	 *
	 * @return the ticket mgmts
	 */
	@Override
	public List<TicketMgmt> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ticket mgmts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketMgmtModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket mgmts
	 * @param end the upper bound of the range of ticket mgmts (not inclusive)
	 * @return the range of ticket mgmts
	 */
	@Override
	public List<TicketMgmt> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ticket mgmts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketMgmtModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket mgmts
	 * @param end the upper bound of the range of ticket mgmts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket mgmts
	 */
	@Override
	public List<TicketMgmt> findAll(
		int start, int end, OrderByComparator<TicketMgmt> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ticket mgmts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketMgmtModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket mgmts
	 * @param end the upper bound of the range of ticket mgmts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ticket mgmts
	 */
	@Override
	public List<TicketMgmt> findAll(
		int start, int end, OrderByComparator<TicketMgmt> orderByComparator,
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

		List<TicketMgmt> list = null;

		if (useFinderCache) {
			list = (List<TicketMgmt>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TICKETMGMT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TICKETMGMT;

				sql = sql.concat(TicketMgmtModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TicketMgmt>)QueryUtil.list(
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
	 * Removes all the ticket mgmts from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TicketMgmt ticketMgmt : findAll()) {
			remove(ticketMgmt);
		}
	}

	/**
	 * Returns the number of ticket mgmts.
	 *
	 * @return the number of ticket mgmts
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TICKETMGMT);

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
		return "ticket_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TICKETMGMT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TicketMgmtModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ticket mgmt persistence.
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

		TicketMgmtUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		TicketMgmtUtil.setPersistence(null);

		entityCache.removeCache(TicketMgmtImpl.class.getName());
	}

	@Override
	@Reference(
		target = ATSPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = ATSPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ATSPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_TICKETMGMT =
		"SELECT ticketMgmt FROM TicketMgmt ticketMgmt";

	private static final String _SQL_SELECT_TICKETMGMT_WHERE =
		"SELECT ticketMgmt FROM TicketMgmt ticketMgmt WHERE ";

	private static final String _SQL_COUNT_TICKETMGMT =
		"SELECT COUNT(ticketMgmt) FROM TicketMgmt ticketMgmt";

	private static final String _SQL_COUNT_TICKETMGMT_WHERE =
		"SELECT COUNT(ticketMgmt) FROM TicketMgmt ticketMgmt WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ticketMgmt.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TicketMgmt exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TicketMgmt exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TicketMgmtPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}