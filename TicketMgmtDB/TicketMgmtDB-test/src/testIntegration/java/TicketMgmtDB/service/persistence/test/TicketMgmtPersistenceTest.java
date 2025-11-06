/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package TicketMgmtDB.service.persistence.test;

import TicketMgmtDB.exception.NoSuchTicketMgmtException;

import TicketMgmtDB.model.TicketMgmt;

import TicketMgmtDB.service.TicketMgmtLocalServiceUtil;
import TicketMgmtDB.service.persistence.TicketMgmtPersistence;
import TicketMgmtDB.service.persistence.TicketMgmtUtil;

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
public class TicketMgmtPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "TicketMgmtDB.service"));

	@Before
	public void setUp() {
		_persistence = TicketMgmtUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<TicketMgmt> iterator = _ticketMgmts.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		TicketMgmt ticketMgmt = _persistence.create(pk);

		Assert.assertNotNull(ticketMgmt);

		Assert.assertEquals(ticketMgmt.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		TicketMgmt newTicketMgmt = addTicketMgmt();

		_persistence.remove(newTicketMgmt);

		TicketMgmt existingTicketMgmt = _persistence.fetchByPrimaryKey(
			newTicketMgmt.getPrimaryKey());

		Assert.assertNull(existingTicketMgmt);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addTicketMgmt();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		TicketMgmt newTicketMgmt = _persistence.create(pk);

		newTicketMgmt.setUuid(RandomTestUtil.randomString());

		newTicketMgmt.setGroupId(RandomTestUtil.nextLong());

		newTicketMgmt.setCompanyId(RandomTestUtil.nextLong());

		newTicketMgmt.setUserId(RandomTestUtil.nextLong());

		newTicketMgmt.setUserName(RandomTestUtil.randomString());

		newTicketMgmt.setCreateDate(RandomTestUtil.nextDate());

		newTicketMgmt.setModifiedDate(RandomTestUtil.nextDate());

		newTicketMgmt.setBusNumber(RandomTestUtil.randomString());

		newTicketMgmt.setFromLocation(RandomTestUtil.randomString());

		newTicketMgmt.setToLocation(RandomTestUtil.randomString());

		newTicketMgmt.setJourneyDate(RandomTestUtil.nextDate());

		newTicketMgmt.setSeatNumber(RandomTestUtil.nextInt());

		newTicketMgmt.setFareAmount();

		_ticketMgmts.add(_persistence.update(newTicketMgmt));

		TicketMgmt existingTicketMgmt = _persistence.findByPrimaryKey(
			newTicketMgmt.getPrimaryKey());

		Assert.assertEquals(
			existingTicketMgmt.getUuid(), newTicketMgmt.getUuid());
		Assert.assertEquals(
			existingTicketMgmt.getTicket_id(), newTicketMgmt.getTicket_id());
		Assert.assertEquals(
			existingTicketMgmt.getGroupId(), newTicketMgmt.getGroupId());
		Assert.assertEquals(
			existingTicketMgmt.getCompanyId(), newTicketMgmt.getCompanyId());
		Assert.assertEquals(
			existingTicketMgmt.getUserId(), newTicketMgmt.getUserId());
		Assert.assertEquals(
			existingTicketMgmt.getUserName(), newTicketMgmt.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingTicketMgmt.getCreateDate()),
			Time.getShortTimestamp(newTicketMgmt.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingTicketMgmt.getModifiedDate()),
			Time.getShortTimestamp(newTicketMgmt.getModifiedDate()));
		Assert.assertEquals(
			existingTicketMgmt.getBusNumber(), newTicketMgmt.getBusNumber());
		Assert.assertEquals(
			existingTicketMgmt.getFromLocation(),
			newTicketMgmt.getFromLocation());
		Assert.assertEquals(
			existingTicketMgmt.getToLocation(), newTicketMgmt.getToLocation());
		Assert.assertEquals(
			Time.getShortTimestamp(existingTicketMgmt.getJourneyDate()),
			Time.getShortTimestamp(newTicketMgmt.getJourneyDate()));
		Assert.assertEquals(
			existingTicketMgmt.getSeatNumber(), newTicketMgmt.getSeatNumber());
		Assert.assertEquals(
			existingTicketMgmt.getFareAmount(), newTicketMgmt.getFareAmount());
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
		TicketMgmt newTicketMgmt = addTicketMgmt();

		TicketMgmt existingTicketMgmt = _persistence.findByPrimaryKey(
			newTicketMgmt.getPrimaryKey());

		Assert.assertEquals(existingTicketMgmt, newTicketMgmt);
	}

	@Test(expected = NoSuchTicketMgmtException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<TicketMgmt> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"ATS_TicketMgmt", "uuid", true, "ticket_id", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "busNumber", true, "fromLocation", true,
			"toLocation", true, "journeyDate", true, "seatNumber", true,
			"fareAmount", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		TicketMgmt newTicketMgmt = addTicketMgmt();

		TicketMgmt existingTicketMgmt = _persistence.fetchByPrimaryKey(
			newTicketMgmt.getPrimaryKey());

		Assert.assertEquals(existingTicketMgmt, newTicketMgmt);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		TicketMgmt missingTicketMgmt = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingTicketMgmt);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		TicketMgmt newTicketMgmt1 = addTicketMgmt();
		TicketMgmt newTicketMgmt2 = addTicketMgmt();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTicketMgmt1.getPrimaryKey());
		primaryKeys.add(newTicketMgmt2.getPrimaryKey());

		Map<Serializable, TicketMgmt> ticketMgmts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, ticketMgmts.size());
		Assert.assertEquals(
			newTicketMgmt1, ticketMgmts.get(newTicketMgmt1.getPrimaryKey()));
		Assert.assertEquals(
			newTicketMgmt2, ticketMgmts.get(newTicketMgmt2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, TicketMgmt> ticketMgmts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(ticketMgmts.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		TicketMgmt newTicketMgmt = addTicketMgmt();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTicketMgmt.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, TicketMgmt> ticketMgmts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, ticketMgmts.size());
		Assert.assertEquals(
			newTicketMgmt, ticketMgmts.get(newTicketMgmt.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, TicketMgmt> ticketMgmts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(ticketMgmts.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		TicketMgmt newTicketMgmt = addTicketMgmt();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTicketMgmt.getPrimaryKey());

		Map<Serializable, TicketMgmt> ticketMgmts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, ticketMgmts.size());
		Assert.assertEquals(
			newTicketMgmt, ticketMgmts.get(newTicketMgmt.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			TicketMgmtLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<TicketMgmt>() {

				@Override
				public void performAction(TicketMgmt ticketMgmt) {
					Assert.assertNotNull(ticketMgmt);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		TicketMgmt newTicketMgmt = addTicketMgmt();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			TicketMgmt.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"ticket_id", newTicketMgmt.getTicket_id()));

		List<TicketMgmt> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		TicketMgmt existingTicketMgmt = result.get(0);

		Assert.assertEquals(existingTicketMgmt, newTicketMgmt);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			TicketMgmt.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("ticket_id", RandomTestUtil.nextLong()));

		List<TicketMgmt> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		TicketMgmt newTicketMgmt = addTicketMgmt();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			TicketMgmt.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("ticket_id"));

		Object newTicket_id = newTicketMgmt.getTicket_id();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"ticket_id", new Object[] {newTicket_id}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingTicket_id = result.get(0);

		Assert.assertEquals(existingTicket_id, newTicket_id);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			TicketMgmt.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("ticket_id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"ticket_id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		TicketMgmt newTicketMgmt = addTicketMgmt();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newTicketMgmt.getPrimaryKey()));
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

		TicketMgmt newTicketMgmt = addTicketMgmt();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			TicketMgmt.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"ticket_id", newTicketMgmt.getTicket_id()));

		List<TicketMgmt> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(TicketMgmt ticketMgmt) {
		Assert.assertEquals(
			ticketMgmt.getUuid(),
			ReflectionTestUtil.invoke(
				ticketMgmt, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(ticketMgmt.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				ticketMgmt, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected TicketMgmt addTicketMgmt() throws Exception {
		long pk = RandomTestUtil.nextLong();

		TicketMgmt ticketMgmt = _persistence.create(pk);

		ticketMgmt.setUuid(RandomTestUtil.randomString());

		ticketMgmt.setGroupId(RandomTestUtil.nextLong());

		ticketMgmt.setCompanyId(RandomTestUtil.nextLong());

		ticketMgmt.setUserId(RandomTestUtil.nextLong());

		ticketMgmt.setUserName(RandomTestUtil.randomString());

		ticketMgmt.setCreateDate(RandomTestUtil.nextDate());

		ticketMgmt.setModifiedDate(RandomTestUtil.nextDate());

		ticketMgmt.setBusNumber(RandomTestUtil.randomString());

		ticketMgmt.setFromLocation(RandomTestUtil.randomString());

		ticketMgmt.setToLocation(RandomTestUtil.randomString());

		ticketMgmt.setJourneyDate(RandomTestUtil.nextDate());

		ticketMgmt.setSeatNumber(RandomTestUtil.nextInt());

		ticketMgmt.setFareAmount();

		_ticketMgmts.add(_persistence.update(ticketMgmt));

		return ticketMgmt;
	}

	private List<TicketMgmt> _ticketMgmts = new ArrayList<TicketMgmt>();
	private TicketMgmtPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}