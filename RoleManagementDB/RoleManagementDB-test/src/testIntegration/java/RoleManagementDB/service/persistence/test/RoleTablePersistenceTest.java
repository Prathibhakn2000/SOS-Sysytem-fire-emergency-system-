/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package RoleManagementDB.service.persistence.test;

import RoleManagementDB.exception.NoSuchRoleTableException;

import RoleManagementDB.model.RoleTable;

import RoleManagementDB.service.RoleTableLocalServiceUtil;
import RoleManagementDB.service.persistence.RoleTablePersistence;
import RoleManagementDB.service.persistence.RoleTableUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
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
public class RoleTablePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "RoleManagementDB.service"));

	@Before
	public void setUp() {
		_persistence = RoleTableUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<RoleTable> iterator = _roleTables.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RoleTable roleTable = _persistence.create(pk);

		Assert.assertNotNull(roleTable);

		Assert.assertEquals(roleTable.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		RoleTable newRoleTable = addRoleTable();

		_persistence.remove(newRoleTable);

		RoleTable existingRoleTable = _persistence.fetchByPrimaryKey(
			newRoleTable.getPrimaryKey());

		Assert.assertNull(existingRoleTable);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addRoleTable();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RoleTable newRoleTable = _persistence.create(pk);

		newRoleTable.setUuid(RandomTestUtil.randomString());

		newRoleTable.setGroupId(RandomTestUtil.nextLong());

		newRoleTable.setCompanyId(RandomTestUtil.nextLong());

		newRoleTable.setUserId(RandomTestUtil.nextLong());

		newRoleTable.setUserName(RandomTestUtil.randomString());

		newRoleTable.setCreateDate(RandomTestUtil.nextDate());

		newRoleTable.setModifiedDate(RandomTestUtil.nextDate());

		newRoleTable.setRoleName(RandomTestUtil.randomString());

		newRoleTable.setDescription(RandomTestUtil.randomString());

		_roleTables.add(_persistence.update(newRoleTable));

		RoleTable existingRoleTable = _persistence.findByPrimaryKey(
			newRoleTable.getPrimaryKey());

		Assert.assertEquals(
			existingRoleTable.getUuid(), newRoleTable.getUuid());
		Assert.assertEquals(
			existingRoleTable.getRoleId(), newRoleTable.getRoleId());
		Assert.assertEquals(
			existingRoleTable.getGroupId(), newRoleTable.getGroupId());
		Assert.assertEquals(
			existingRoleTable.getCompanyId(), newRoleTable.getCompanyId());
		Assert.assertEquals(
			existingRoleTable.getUserId(), newRoleTable.getUserId());
		Assert.assertEquals(
			existingRoleTable.getUserName(), newRoleTable.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingRoleTable.getCreateDate()),
			Time.getShortTimestamp(newRoleTable.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingRoleTable.getModifiedDate()),
			Time.getShortTimestamp(newRoleTable.getModifiedDate()));
		Assert.assertEquals(
			existingRoleTable.getRoleName(), newRoleTable.getRoleName());
		Assert.assertEquals(
			existingRoleTable.getDescription(), newRoleTable.getDescription());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUUID_G() throws Exception {
		_persistence.countByUUID_G("", RandomTestUtil.nextLong());

		_persistence.countByUUID_G("null", 0L);

		_persistence.countByUUID_G((String)null, 0L);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C("", RandomTestUtil.nextLong());

		_persistence.countByUuid_C("null", 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		RoleTable newRoleTable = addRoleTable();

		RoleTable existingRoleTable = _persistence.findByPrimaryKey(
			newRoleTable.getPrimaryKey());

		Assert.assertEquals(existingRoleTable, newRoleTable);
	}

	@Test(expected = NoSuchRoleTableException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<RoleTable> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"fire_RoleTable", "uuid", true, "roleId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "roleName", true, "description", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		RoleTable newRoleTable = addRoleTable();

		RoleTable existingRoleTable = _persistence.fetchByPrimaryKey(
			newRoleTable.getPrimaryKey());

		Assert.assertEquals(existingRoleTable, newRoleTable);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RoleTable missingRoleTable = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingRoleTable);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		RoleTable newRoleTable1 = addRoleTable();
		RoleTable newRoleTable2 = addRoleTable();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRoleTable1.getPrimaryKey());
		primaryKeys.add(newRoleTable2.getPrimaryKey());

		Map<Serializable, RoleTable> roleTables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, roleTables.size());
		Assert.assertEquals(
			newRoleTable1, roleTables.get(newRoleTable1.getPrimaryKey()));
		Assert.assertEquals(
			newRoleTable2, roleTables.get(newRoleTable2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, RoleTable> roleTables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(roleTables.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		RoleTable newRoleTable = addRoleTable();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRoleTable.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, RoleTable> roleTables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, roleTables.size());
		Assert.assertEquals(
			newRoleTable, roleTables.get(newRoleTable.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, RoleTable> roleTables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(roleTables.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		RoleTable newRoleTable = addRoleTable();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRoleTable.getPrimaryKey());

		Map<Serializable, RoleTable> roleTables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, roleTables.size());
		Assert.assertEquals(
			newRoleTable, roleTables.get(newRoleTable.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			RoleTableLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<RoleTable>() {

				@Override
				public void performAction(RoleTable roleTable) {
					Assert.assertNotNull(roleTable);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		RoleTable newRoleTable = addRoleTable();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RoleTable.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("roleId", newRoleTable.getRoleId()));

		List<RoleTable> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		RoleTable existingRoleTable = result.get(0);

		Assert.assertEquals(existingRoleTable, newRoleTable);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RoleTable.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("roleId", RandomTestUtil.nextLong()));

		List<RoleTable> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		RoleTable newRoleTable = addRoleTable();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RoleTable.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("roleId"));

		Object newRoleId = newRoleTable.getRoleId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("roleId", new Object[] {newRoleId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingRoleId = result.get(0);

		Assert.assertEquals(existingRoleId, newRoleId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RoleTable.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("roleId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"roleId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		RoleTable newRoleTable = addRoleTable();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newRoleTable.getPrimaryKey()));
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromDatabase()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(true);
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromSession()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(false);
	}

	private void _testResetOriginalValuesWithDynamicQuery(boolean clearSession)
		throws Exception {

		RoleTable newRoleTable = addRoleTable();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RoleTable.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("roleId", newRoleTable.getRoleId()));

		List<RoleTable> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(RoleTable roleTable) {
		Assert.assertEquals(
			roleTable.getUuid(),
			ReflectionTestUtil.invoke(
				roleTable, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(roleTable.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				roleTable, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected RoleTable addRoleTable() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RoleTable roleTable = _persistence.create(pk);

		roleTable.setUuid(RandomTestUtil.randomString());

		roleTable.setGroupId(RandomTestUtil.nextLong());

		roleTable.setCompanyId(RandomTestUtil.nextLong());

		roleTable.setUserId(RandomTestUtil.nextLong());

		roleTable.setUserName(RandomTestUtil.randomString());

		roleTable.setCreateDate(RandomTestUtil.nextDate());

		roleTable.setModifiedDate(RandomTestUtil.nextDate());

		roleTable.setRoleName(RandomTestUtil.randomString());

		roleTable.setDescription(RandomTestUtil.randomString());

		_roleTables.add(_persistence.update(roleTable));

		return roleTable;
	}

	private List<RoleTable> _roleTables = new ArrayList<RoleTable>();
	private RoleTablePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}