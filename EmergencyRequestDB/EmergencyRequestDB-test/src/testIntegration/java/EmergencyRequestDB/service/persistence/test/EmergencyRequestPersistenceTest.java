/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package EmergencyRequestDB.service.persistence.test;

import EmergencyRequestDB.exception.NoSuchEmergencyRequestException;

import EmergencyRequestDB.model.EmergencyRequest;

import EmergencyRequestDB.service.EmergencyRequestLocalServiceUtil;
import EmergencyRequestDB.service.persistence.EmergencyRequestPersistence;
import EmergencyRequestDB.service.persistence.EmergencyRequestUtil;

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
public class EmergencyRequestPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "EmergencyRequestDB.service"));

	@Before
	public void setUp() {
		_persistence = EmergencyRequestUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<EmergencyRequest> iterator = _emergencyRequests.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EmergencyRequest emergencyRequest = _persistence.create(pk);

		Assert.assertNotNull(emergencyRequest);

		Assert.assertEquals(emergencyRequest.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		EmergencyRequest newEmergencyRequest = addEmergencyRequest();

		_persistence.remove(newEmergencyRequest);

		EmergencyRequest existingEmergencyRequest =
			_persistence.fetchByPrimaryKey(newEmergencyRequest.getPrimaryKey());

		Assert.assertNull(existingEmergencyRequest);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addEmergencyRequest();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EmergencyRequest newEmergencyRequest = _persistence.create(pk);

		newEmergencyRequest.setUuid(RandomTestUtil.randomString());

		newEmergencyRequest.setGroupId(RandomTestUtil.nextLong());

		newEmergencyRequest.setCompanyId(RandomTestUtil.nextLong());

		newEmergencyRequest.setUserId(RandomTestUtil.nextLong());

		newEmergencyRequest.setUserName(RandomTestUtil.randomString());

		newEmergencyRequest.setCreateDate(RandomTestUtil.nextDate());

		newEmergencyRequest.setModifiedDate(RandomTestUtil.nextDate());

		newEmergencyRequest.setRequestTitle(RandomTestUtil.randomString());

		newEmergencyRequest.setDescription(RandomTestUtil.randomString());

		newEmergencyRequest.setLocation(RandomTestUtil.randomString());

		newEmergencyRequest.setExactAddress(RandomTestUtil.randomString());

		newEmergencyRequest.setContactNumber(RandomTestUtil.nextLong());

		newEmergencyRequest.setAttachmentPath(RandomTestUtil.randomString());

		newEmergencyRequest.setStatus(RandomTestUtil.randomString());

		newEmergencyRequest.setAllocatedTeamId(RandomTestUtil.nextLong());

		_emergencyRequests.add(_persistence.update(newEmergencyRequest));

		EmergencyRequest existingEmergencyRequest =
			_persistence.findByPrimaryKey(newEmergencyRequest.getPrimaryKey());

		Assert.assertEquals(
			existingEmergencyRequest.getUuid(), newEmergencyRequest.getUuid());
		Assert.assertEquals(
			existingEmergencyRequest.getRequestId(),
			newEmergencyRequest.getRequestId());
		Assert.assertEquals(
			existingEmergencyRequest.getGroupId(),
			newEmergencyRequest.getGroupId());
		Assert.assertEquals(
			existingEmergencyRequest.getCompanyId(),
			newEmergencyRequest.getCompanyId());
		Assert.assertEquals(
			existingEmergencyRequest.getUserId(),
			newEmergencyRequest.getUserId());
		Assert.assertEquals(
			existingEmergencyRequest.getUserName(),
			newEmergencyRequest.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingEmergencyRequest.getCreateDate()),
			Time.getShortTimestamp(newEmergencyRequest.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingEmergencyRequest.getModifiedDate()),
			Time.getShortTimestamp(newEmergencyRequest.getModifiedDate()));
		Assert.assertEquals(
			existingEmergencyRequest.getRequestTitle(),
			newEmergencyRequest.getRequestTitle());
		Assert.assertEquals(
			existingEmergencyRequest.getDescription(),
			newEmergencyRequest.getDescription());
		Assert.assertEquals(
			existingEmergencyRequest.getLocation(),
			newEmergencyRequest.getLocation());
		Assert.assertEquals(
			existingEmergencyRequest.getExactAddress(),
			newEmergencyRequest.getExactAddress());
		Assert.assertEquals(
			existingEmergencyRequest.getContactNumber(),
			newEmergencyRequest.getContactNumber());
		Assert.assertEquals(
			existingEmergencyRequest.getAttachmentPath(),
			newEmergencyRequest.getAttachmentPath());
		Assert.assertEquals(
			existingEmergencyRequest.getStatus(),
			newEmergencyRequest.getStatus());
		Assert.assertEquals(
			existingEmergencyRequest.getAllocatedTeamId(),
			newEmergencyRequest.getAllocatedTeamId());
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
	public void testCountByUserId() throws Exception {
		_persistence.countByUserId(RandomTestUtil.nextLong());

		_persistence.countByUserId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		EmergencyRequest newEmergencyRequest = addEmergencyRequest();

		EmergencyRequest existingEmergencyRequest =
			_persistence.findByPrimaryKey(newEmergencyRequest.getPrimaryKey());

		Assert.assertEquals(existingEmergencyRequest, newEmergencyRequest);
	}

	@Test(expected = NoSuchEmergencyRequestException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<EmergencyRequest> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"Fire_EmergencyRequest", "uuid", true, "requestId", true, "groupId",
			true, "companyId", true, "userId", true, "userName", true,
			"createDate", true, "modifiedDate", true, "requestTitle", true,
			"description", true, "location", true, "exactAddress", true,
			"contactNumber", true, "attachmentPath", true, "status", true,
			"allocatedTeamId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		EmergencyRequest newEmergencyRequest = addEmergencyRequest();

		EmergencyRequest existingEmergencyRequest =
			_persistence.fetchByPrimaryKey(newEmergencyRequest.getPrimaryKey());

		Assert.assertEquals(existingEmergencyRequest, newEmergencyRequest);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EmergencyRequest missingEmergencyRequest =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingEmergencyRequest);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		EmergencyRequest newEmergencyRequest1 = addEmergencyRequest();
		EmergencyRequest newEmergencyRequest2 = addEmergencyRequest();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmergencyRequest1.getPrimaryKey());
		primaryKeys.add(newEmergencyRequest2.getPrimaryKey());

		Map<Serializable, EmergencyRequest> emergencyRequests =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, emergencyRequests.size());
		Assert.assertEquals(
			newEmergencyRequest1,
			emergencyRequests.get(newEmergencyRequest1.getPrimaryKey()));
		Assert.assertEquals(
			newEmergencyRequest2,
			emergencyRequests.get(newEmergencyRequest2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, EmergencyRequest> emergencyRequests =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(emergencyRequests.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		EmergencyRequest newEmergencyRequest = addEmergencyRequest();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmergencyRequest.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, EmergencyRequest> emergencyRequests =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, emergencyRequests.size());
		Assert.assertEquals(
			newEmergencyRequest,
			emergencyRequests.get(newEmergencyRequest.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, EmergencyRequest> emergencyRequests =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(emergencyRequests.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		EmergencyRequest newEmergencyRequest = addEmergencyRequest();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmergencyRequest.getPrimaryKey());

		Map<Serializable, EmergencyRequest> emergencyRequests =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, emergencyRequests.size());
		Assert.assertEquals(
			newEmergencyRequest,
			emergencyRequests.get(newEmergencyRequest.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			EmergencyRequestLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<EmergencyRequest>() {

				@Override
				public void performAction(EmergencyRequest emergencyRequest) {
					Assert.assertNotNull(emergencyRequest);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		EmergencyRequest newEmergencyRequest = addEmergencyRequest();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmergencyRequest.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"requestId", newEmergencyRequest.getRequestId()));

		List<EmergencyRequest> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		EmergencyRequest existingEmergencyRequest = result.get(0);

		Assert.assertEquals(existingEmergencyRequest, newEmergencyRequest);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmergencyRequest.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("requestId", RandomTestUtil.nextLong()));

		List<EmergencyRequest> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		EmergencyRequest newEmergencyRequest = addEmergencyRequest();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmergencyRequest.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("requestId"));

		Object newRequestId = newEmergencyRequest.getRequestId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"requestId", new Object[] {newRequestId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingRequestId = result.get(0);

		Assert.assertEquals(existingRequestId, newRequestId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmergencyRequest.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("requestId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"requestId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		EmergencyRequest newEmergencyRequest = addEmergencyRequest();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newEmergencyRequest.getPrimaryKey()));
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

		EmergencyRequest newEmergencyRequest = addEmergencyRequest();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmergencyRequest.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"requestId", newEmergencyRequest.getRequestId()));

		List<EmergencyRequest> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(EmergencyRequest emergencyRequest) {
		Assert.assertEquals(
			emergencyRequest.getUuid(),
			ReflectionTestUtil.invoke(
				emergencyRequest, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(emergencyRequest.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				emergencyRequest, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected EmergencyRequest addEmergencyRequest() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EmergencyRequest emergencyRequest = _persistence.create(pk);

		emergencyRequest.setUuid(RandomTestUtil.randomString());

		emergencyRequest.setGroupId(RandomTestUtil.nextLong());

		emergencyRequest.setCompanyId(RandomTestUtil.nextLong());

		emergencyRequest.setUserId(RandomTestUtil.nextLong());

		emergencyRequest.setUserName(RandomTestUtil.randomString());

		emergencyRequest.setCreateDate(RandomTestUtil.nextDate());

		emergencyRequest.setModifiedDate(RandomTestUtil.nextDate());

		emergencyRequest.setRequestTitle(RandomTestUtil.randomString());

		emergencyRequest.setDescription(RandomTestUtil.randomString());

		emergencyRequest.setLocation(RandomTestUtil.randomString());

		emergencyRequest.setExactAddress(RandomTestUtil.randomString());

		emergencyRequest.setContactNumber(RandomTestUtil.nextLong());

		emergencyRequest.setAttachmentPath(RandomTestUtil.randomString());

		emergencyRequest.setStatus(RandomTestUtil.randomString());

		emergencyRequest.setAllocatedTeamId(RandomTestUtil.nextLong());

		_emergencyRequests.add(_persistence.update(emergencyRequest));

		return emergencyRequest;
	}

	private List<EmergencyRequest> _emergencyRequests =
		new ArrayList<EmergencyRequest>();
	private EmergencyRequestPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}