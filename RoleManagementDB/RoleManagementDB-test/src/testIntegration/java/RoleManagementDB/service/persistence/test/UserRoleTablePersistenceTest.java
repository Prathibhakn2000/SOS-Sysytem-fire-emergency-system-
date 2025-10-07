/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package RoleManagementDB.service.persistence.test;

import RoleManagementDB.exception.NoSuchUserRoleTableException;

import RoleManagementDB.model.UserRoleTable;

import RoleManagementDB.service.UserRoleTableLocalServiceUtil;
import RoleManagementDB.service.persistence.UserRoleTablePersistence;
import RoleManagementDB.service.persistence.UserRoleTableUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class UserRoleTablePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "RoleManagementDB.service"));

	@Before
	public void setUp() {
		_persistence = UserRoleTableUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<UserRoleTable> iterator = _userRoleTables.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		UserRoleTable userRoleTable = _persistence.create(pk);

		Assert.assertNotNull(userRoleTable);

		Assert.assertEquals(userRoleTable.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		UserRoleTable newUserRoleTable = addUserRoleTable();

		_persistence.remove(newUserRoleTable);

		UserRoleTable existingUserRoleTable = _persistence.fetchByPrimaryKey(
			newUserRoleTable.getPrimaryKey());

		Assert.assertNull(existingUserRoleTable);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addUserRoleTable();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		UserRoleTable newUserRoleTable = _persistence.create(pk);

		newUserRoleTable.setUserId(RandomTestUtil.nextLong());

		newUserRoleTable.setRoleId(RandomTestUtil.nextLong());

		_userRoleTables.add(_persistence.update(newUserRoleTable));

		UserRoleTable existingUserRoleTable = _persistence.findByPrimaryKey(
			newUserRoleTable.getPrimaryKey());

		Assert.assertEquals(
			existingUserRoleTable.getUserRoleId(),
			newUserRoleTable.getUserRoleId());
		Assert.assertEquals(
			existingUserRoleTable.getUserId(), newUserRoleTable.getUserId());
		Assert.assertEquals(
			existingUserRoleTable.getRoleId(), newUserRoleTable.getRoleId());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		UserRoleTable newUserRoleTable = addUserRoleTable();

		UserRoleTable existingUserRoleTable = _persistence.findByPrimaryKey(
			newUserRoleTable.getPrimaryKey());

		Assert.assertEquals(existingUserRoleTable, newUserRoleTable);
	}

	@Test(expected = NoSuchUserRoleTableException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<UserRoleTable> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"UserRoleTable", "userRoleId", true, "userId", true, "roleId",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		UserRoleTable newUserRoleTable = addUserRoleTable();

		UserRoleTable existingUserRoleTable = _persistence.fetchByPrimaryKey(
			newUserRoleTable.getPrimaryKey());

		Assert.assertEquals(existingUserRoleTable, newUserRoleTable);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		UserRoleTable missingUserRoleTable = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingUserRoleTable);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		UserRoleTable newUserRoleTable1 = addUserRoleTable();
		UserRoleTable newUserRoleTable2 = addUserRoleTable();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newUserRoleTable1.getPrimaryKey());
		primaryKeys.add(newUserRoleTable2.getPrimaryKey());

		Map<Serializable, UserRoleTable> userRoleTables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, userRoleTables.size());
		Assert.assertEquals(
			newUserRoleTable1,
			userRoleTables.get(newUserRoleTable1.getPrimaryKey()));
		Assert.assertEquals(
			newUserRoleTable2,
			userRoleTables.get(newUserRoleTable2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, UserRoleTable> userRoleTables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(userRoleTables.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		UserRoleTable newUserRoleTable = addUserRoleTable();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newUserRoleTable.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, UserRoleTable> userRoleTables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, userRoleTables.size());
		Assert.assertEquals(
			newUserRoleTable,
			userRoleTables.get(newUserRoleTable.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, UserRoleTable> userRoleTables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(userRoleTables.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		UserRoleTable newUserRoleTable = addUserRoleTable();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newUserRoleTable.getPrimaryKey());

		Map<Serializable, UserRoleTable> userRoleTables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, userRoleTables.size());
		Assert.assertEquals(
			newUserRoleTable,
			userRoleTables.get(newUserRoleTable.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			UserRoleTableLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<UserRoleTable>() {

				@Override
				public void performAction(UserRoleTable userRoleTable) {
					Assert.assertNotNull(userRoleTable);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		UserRoleTable newUserRoleTable = addUserRoleTable();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			UserRoleTable.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"userRoleId", newUserRoleTable.getUserRoleId()));

		List<UserRoleTable> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		UserRoleTable existingUserRoleTable = result.get(0);

		Assert.assertEquals(existingUserRoleTable, newUserRoleTable);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			UserRoleTable.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"userRoleId", RandomTestUtil.nextLong()));

		List<UserRoleTable> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		UserRoleTable newUserRoleTable = addUserRoleTable();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			UserRoleTable.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("userRoleId"));

		Object newUserRoleId = newUserRoleTable.getUserRoleId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"userRoleId", new Object[] {newUserRoleId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingUserRoleId = result.get(0);

		Assert.assertEquals(existingUserRoleId, newUserRoleId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			UserRoleTable.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("userRoleId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"userRoleId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected UserRoleTable addUserRoleTable() throws Exception {
		long pk = RandomTestUtil.nextLong();

		UserRoleTable userRoleTable = _persistence.create(pk);

		userRoleTable.setUserId(RandomTestUtil.nextLong());

		userRoleTable.setRoleId(RandomTestUtil.nextLong());

		_userRoleTables.add(_persistence.update(userRoleTable));

		return userRoleTable;
	}

	private List<UserRoleTable> _userRoleTables =
		new ArrayList<UserRoleTable>();
	private UserRoleTablePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}