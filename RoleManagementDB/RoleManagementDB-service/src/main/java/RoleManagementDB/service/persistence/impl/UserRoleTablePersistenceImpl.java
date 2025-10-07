/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package RoleManagementDB.service.persistence.impl;

import RoleManagementDB.exception.NoSuchUserRoleTableException;

import RoleManagementDB.model.UserRoleTable;
import RoleManagementDB.model.UserRoleTableTable;
import RoleManagementDB.model.impl.UserRoleTableImpl;
import RoleManagementDB.model.impl.UserRoleTableModelImpl;

import RoleManagementDB.service.persistence.UserRoleTablePersistence;
import RoleManagementDB.service.persistence.UserRoleTableUtil;
import RoleManagementDB.service.persistence.impl.constants.firePersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the user role table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = UserRoleTablePersistence.class)
public class UserRoleTablePersistenceImpl
	extends BasePersistenceImpl<UserRoleTable>
	implements UserRoleTablePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UserRoleTableUtil</code> to access the user role table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UserRoleTableImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public UserRoleTablePersistenceImpl() {
		setModelClass(UserRoleTable.class);

		setModelImplClass(UserRoleTableImpl.class);
		setModelPKClass(long.class);

		setTable(UserRoleTableTable.INSTANCE);
	}

	/**
	 * Caches the user role table in the entity cache if it is enabled.
	 *
	 * @param userRoleTable the user role table
	 */
	@Override
	public void cacheResult(UserRoleTable userRoleTable) {
		entityCache.putResult(
			UserRoleTableImpl.class, userRoleTable.getPrimaryKey(),
			userRoleTable);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the user role tables in the entity cache if it is enabled.
	 *
	 * @param userRoleTables the user role tables
	 */
	@Override
	public void cacheResult(List<UserRoleTable> userRoleTables) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (userRoleTables.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (UserRoleTable userRoleTable : userRoleTables) {
			if (entityCache.getResult(
					UserRoleTableImpl.class, userRoleTable.getPrimaryKey()) ==
						null) {

				cacheResult(userRoleTable);
			}
		}
	}

	/**
	 * Clears the cache for all user role tables.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserRoleTableImpl.class);

		finderCache.clearCache(UserRoleTableImpl.class);
	}

	/**
	 * Clears the cache for the user role table.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserRoleTable userRoleTable) {
		entityCache.removeResult(UserRoleTableImpl.class, userRoleTable);
	}

	@Override
	public void clearCache(List<UserRoleTable> userRoleTables) {
		for (UserRoleTable userRoleTable : userRoleTables) {
			entityCache.removeResult(UserRoleTableImpl.class, userRoleTable);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(UserRoleTableImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(UserRoleTableImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new user role table with the primary key. Does not add the user role table to the database.
	 *
	 * @param userRoleId the primary key for the new user role table
	 * @return the new user role table
	 */
	@Override
	public UserRoleTable create(long userRoleId) {
		UserRoleTable userRoleTable = new UserRoleTableImpl();

		userRoleTable.setNew(true);
		userRoleTable.setPrimaryKey(userRoleId);

		return userRoleTable;
	}

	/**
	 * Removes the user role table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userRoleId the primary key of the user role table
	 * @return the user role table that was removed
	 * @throws NoSuchUserRoleTableException if a user role table with the primary key could not be found
	 */
	@Override
	public UserRoleTable remove(long userRoleId)
		throws NoSuchUserRoleTableException {

		return remove((Serializable)userRoleId);
	}

	/**
	 * Removes the user role table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user role table
	 * @return the user role table that was removed
	 * @throws NoSuchUserRoleTableException if a user role table with the primary key could not be found
	 */
	@Override
	public UserRoleTable remove(Serializable primaryKey)
		throws NoSuchUserRoleTableException {

		Session session = null;

		try {
			session = openSession();

			UserRoleTable userRoleTable = (UserRoleTable)session.get(
				UserRoleTableImpl.class, primaryKey);

			if (userRoleTable == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserRoleTableException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(userRoleTable);
		}
		catch (NoSuchUserRoleTableException noSuchEntityException) {
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
	protected UserRoleTable removeImpl(UserRoleTable userRoleTable) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userRoleTable)) {
				userRoleTable = (UserRoleTable)session.get(
					UserRoleTableImpl.class, userRoleTable.getPrimaryKeyObj());
			}

			if (userRoleTable != null) {
				session.delete(userRoleTable);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (userRoleTable != null) {
			clearCache(userRoleTable);
		}

		return userRoleTable;
	}

	@Override
	public UserRoleTable updateImpl(UserRoleTable userRoleTable) {
		boolean isNew = userRoleTable.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(userRoleTable);
			}
			else {
				userRoleTable = (UserRoleTable)session.merge(userRoleTable);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			UserRoleTableImpl.class, userRoleTable, false, true);

		if (isNew) {
			userRoleTable.setNew(false);
		}

		userRoleTable.resetOriginalValues();

		return userRoleTable;
	}

	/**
	 * Returns the user role table with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user role table
	 * @return the user role table
	 * @throws NoSuchUserRoleTableException if a user role table with the primary key could not be found
	 */
	@Override
	public UserRoleTable findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserRoleTableException {

		UserRoleTable userRoleTable = fetchByPrimaryKey(primaryKey);

		if (userRoleTable == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserRoleTableException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return userRoleTable;
	}

	/**
	 * Returns the user role table with the primary key or throws a <code>NoSuchUserRoleTableException</code> if it could not be found.
	 *
	 * @param userRoleId the primary key of the user role table
	 * @return the user role table
	 * @throws NoSuchUserRoleTableException if a user role table with the primary key could not be found
	 */
	@Override
	public UserRoleTable findByPrimaryKey(long userRoleId)
		throws NoSuchUserRoleTableException {

		return findByPrimaryKey((Serializable)userRoleId);
	}

	/**
	 * Returns the user role table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userRoleId the primary key of the user role table
	 * @return the user role table, or <code>null</code> if a user role table with the primary key could not be found
	 */
	@Override
	public UserRoleTable fetchByPrimaryKey(long userRoleId) {
		return fetchByPrimaryKey((Serializable)userRoleId);
	}

	/**
	 * Returns all the user role tables.
	 *
	 * @return the user role tables
	 */
	@Override
	public List<UserRoleTable> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user role tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRoleTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user role tables
	 * @param end the upper bound of the range of user role tables (not inclusive)
	 * @return the range of user role tables
	 */
	@Override
	public List<UserRoleTable> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user role tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRoleTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user role tables
	 * @param end the upper bound of the range of user role tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user role tables
	 */
	@Override
	public List<UserRoleTable> findAll(
		int start, int end,
		OrderByComparator<UserRoleTable> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user role tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserRoleTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user role tables
	 * @param end the upper bound of the range of user role tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user role tables
	 */
	@Override
	public List<UserRoleTable> findAll(
		int start, int end, OrderByComparator<UserRoleTable> orderByComparator,
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

		List<UserRoleTable> list = null;

		if (useFinderCache) {
			list = (List<UserRoleTable>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_USERROLETABLE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_USERROLETABLE;

				sql = sql.concat(UserRoleTableModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<UserRoleTable>)QueryUtil.list(
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
	 * Removes all the user role tables from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserRoleTable userRoleTable : findAll()) {
			remove(userRoleTable);
		}
	}

	/**
	 * Returns the number of user role tables.
	 *
	 * @return the number of user role tables
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_USERROLETABLE);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "userRoleId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_USERROLETABLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UserRoleTableModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user role table persistence.
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

		UserRoleTableUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		UserRoleTableUtil.setPersistence(null);

		entityCache.removeCache(UserRoleTableImpl.class.getName());
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

	private static final String _SQL_SELECT_USERROLETABLE =
		"SELECT userRoleTable FROM UserRoleTable userRoleTable";

	private static final String _SQL_COUNT_USERROLETABLE =
		"SELECT COUNT(userRoleTable) FROM UserRoleTable userRoleTable";

	private static final String _ORDER_BY_ENTITY_ALIAS = "userRoleTable.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No UserRoleTable exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		UserRoleTablePersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}