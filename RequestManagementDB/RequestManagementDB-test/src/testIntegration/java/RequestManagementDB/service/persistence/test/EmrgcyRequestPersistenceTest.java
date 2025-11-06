/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package RequestManagementDB.service.persistence.test;

import RequestManagementDB.exception.NoSuchEmrgcyRequestException;

import RequestManagementDB.model.EmrgcyRequest;

import RequestManagementDB.service.EmrgcyRequestLocalServiceUtil;
import RequestManagementDB.service.persistence.EmrgcyRequestPersistence;
import RequestManagementDB.service.persistence.EmrgcyRequestUtil;

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
public class EmrgcyRequestPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "RequestManagementDB.service"));

	@Before
	public void setUp() {
		_persistence = EmrgcyRequestUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<EmrgcyRequest> iterator = _emrgcyRequests.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EmrgcyRequest emrgcyRequest = _persistence.create(pk);

		Assert.assertNotNull(emrgcyRequest);

		Assert.assertEquals(emrgcyRequest.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		EmrgcyRequest newEmrgcyRequest = addEmrgcyRequest();

		_persistence.remove(newEmrgcyRequest);

		EmrgcyRequest existingEmrgcyRequest = _persistence.fetchByPrimaryKey(
			newEmrgcyRequest.getPrimaryKey());

		Assert.assertNull(existingEmrgcyRequest);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addEmrgcyRequest();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EmrgcyRequest newEmrgcyRequest = _persistence.create(pk);

		newEmrgcyRequest.setUuid(RandomTestUtil.randomString());

		newEmrgcyRequest.setCompanyId(RandomTestUtil.nextLong());

		newEmrgcyRequest.setUserId(RandomTestUtil.nextLong());

		newEmrgcyRequest.setUserName(RandomTestUtil.randomString());

		newEmrgcyRequest.setCreateDate(RandomTestUtil.nextDate());

		newEmrgcyRequest.setModifiedDate(RandomTestUtil.nextDate());

		newEmrgcyRequest.setTitle(RandomTestUtil.randomString());

		newEmrgcyRequest.setDescription(RandomTestUtil.randomString());

		newEmrgcyRequest.setLocation(RandomTestUtil.randomString());

		newEmrgcyRequest.setStatus(RandomTestUtil.randomString());

		newEmrgcyRequest.setAssignedTeam(RandomTestUtil.randomString());

		newEmrgcyRequest.setRequesterUserId(RandomTestUtil.nextLong());

		_emrgcyRequests.add(_persistence.update(newEmrgcyRequest));

		EmrgcyRequest existingEmrgcyRequest = _persistence.findByPrimaryKey(
			newEmrgcyRequest.getPrimaryKey());

		Assert.assertEquals(
			existingEmrgcyRequest.getUuid(), newEmrgcyRequest.getUuid());
		Assert.assertEquals(
			existingEmrgcyRequest.getRequestId(),
			newEmrgcyRequest.getRequestId());
		Assert.assertEquals(
			existingEmrgcyRequest.getCompanyId(),
			newEmrgcyRequest.getCompanyId());
		Assert.assertEquals(
			existingEmrgcyRequest.getUserId(), newEmrgcyRequest.getUserId());
		Assert.assertEquals(
			existingEmrgcyRequest.getUserName(),
			newEmrgcyRequest.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingEmrgcyRequest.getCreateDate()),
			Time.getShortTimestamp(newEmrgcyRequest.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingEmrgcyRequest.getModifiedDate()),
			Time.getShortTimestamp(newEmrgcyRequest.getModifiedDate()));
		Assert.assertEquals(
			existingEmrgcyRequest.getTitle(), newEmrgcyRequest.getTitle());
		Assert.assertEquals(
			existingEmrgcyRequest.getDescription(),
			newEmrgcyRequest.getDescription());
		Assert.assertEquals(
			existingEmrgcyRequest.getLocation(),
			newEmrgcyRequest.getLocation());
		Assert.assertEquals(
			existingEmrgcyRequest.getStatus(), newEmrgcyRequest.getStatus());
		Assert.assertEquals(
			existingEmrgcyRequest.getAssignedTeam(),
			newEmrgcyRequest.getAssignedTeam());
		Assert.assertEquals(
			existingEmrgcyRequest.getRequesterUserId(),
			newEmrgcyRequest.getRequesterUserId());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C("", RandomTestUtil.nextLong());

		_persistence.countByUuid_C("null", 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		EmrgcyRequest newEmrgcyRequest = addEmrgcyRequest();

		EmrgcyRequest existingEmrgcyRequest = _persistence.findByPrimaryKey(
			newEmrgcyRequest.getPrimaryKey());

		Assert.assertEquals(existingEmrgcyRequest, newEmrgcyRequest);
	}

	@Test(expected = NoSuchEmrgcyRequestException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<EmrgcyRequest> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"Fire_EmrgcyRequest", "uuid", true, "requestId", true, "companyId",
			true, "userId", true, "userName", true, "createDate", true,
			"modifiedDate", true, "title", true, "description", true,
			"location", true, "status", true, "assignedTeam", true,
			"requesterUserId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		EmrgcyRequest newEmrgcyRequest = addEmrgcyRequest();

		EmrgcyRequest existingEmrgcyRequest = _persistence.fetchByPrimaryKey(
			newEmrgcyRequest.getPrimaryKey());

		Assert.assertEquals(existingEmrgcyRequest, newEmrgcyRequest);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EmrgcyRequest missingEmrgcyRequest = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingEmrgcyRequest);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		EmrgcyRequest newEmrgcyRequest1 = addEmrgcyRequest();
		EmrgcyRequest newEmrgcyRequest2 = addEmrgcyRequest();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmrgcyRequest1.getPrimaryKey());
		primaryKeys.add(newEmrgcyRequest2.getPrimaryKey());

		Map<Serializable, EmrgcyRequest> emrgcyRequests =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, emrgcyRequests.size());
		Assert.assertEquals(
			newEmrgcyRequest1,
			emrgcyRequests.get(newEmrgcyRequest1.getPrimaryKey()));
		Assert.assertEquals(
			newEmrgcyRequest2,
			emrgcyRequests.get(newEmrgcyRequest2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, EmrgcyRequest> emrgcyRequests =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(emrgcyRequests.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		EmrgcyRequest newEmrgcyRequest = addEmrgcyRequest();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmrgcyRequest.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, EmrgcyRequest> emrgcyRequests =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, emrgcyRequests.size());
		Assert.assertEquals(
			newEmrgcyRequest,
			emrgcyRequests.get(newEmrgcyRequest.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, EmrgcyRequest> emrgcyRequests =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(emrgcyRequests.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		EmrgcyRequest newEmrgcyRequest = addEmrgcyRequest();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmrgcyRequest.getPrimaryKey());

		Map<Serializable, EmrgcyRequest> emrgcyRequests =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, emrgcyRequests.size());
		Assert.assertEquals(
			newEmrgcyRequest,
			emrgcyRequests.get(newEmrgcyRequest.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			EmrgcyRequestLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<EmrgcyRequest>() {

				@Override
				public void performAction(EmrgcyRequest emrgcyRequest) {
					Assert.assertNotNull(emrgcyRequest);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		EmrgcyRequest newEmrgcyRequest = addEmrgcyRequest();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmrgcyRequest.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"requestId", newEmrgcyRequest.getRequestId()));

		List<EmrgcyRequest> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		EmrgcyRequest existingEmrgcyRequest = result.get(0);

		Assert.assertEquals(existingEmrgcyRequest, newEmrgcyRequest);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmrgcyRequest.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("requestId", RandomTestUtil.nextLong()));

		List<EmrgcyRequest> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		EmrgcyRequest newEmrgcyRequest = addEmrgcyRequest();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EmrgcyRequest.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("requestId"));

		Object newRequestId = newEmrgcyRequest.getRequestId();

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
			EmrgcyRequest.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("requestId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"requestId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected EmrgcyRequest addEmrgcyRequest() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EmrgcyRequest emrgcyRequest = _persistence.create(pk);

		emrgcyRequest.setUuid(RandomTestUtil.randomString());

		emrgcyRequest.setCompanyId(RandomTestUtil.nextLong());

		emrgcyRequest.setUserId(RandomTestUtil.nextLong());

		emrgcyRequest.setUserName(RandomTestUtil.randomString());

		emrgcyRequest.setCreateDate(RandomTestUtil.nextDate());

		emrgcyRequest.setModifiedDate(RandomTestUtil.nextDate());

		emrgcyRequest.setTitle(RandomTestUtil.randomString());

		emrgcyRequest.setDescription(RandomTestUtil.randomString());

		emrgcyRequest.setLocation(RandomTestUtil.randomString());

		emrgcyRequest.setStatus(RandomTestUtil.randomString());

		emrgcyRequest.setAssignedTeam(RandomTestUtil.randomString());

		emrgcyRequest.setRequesterUserId(RandomTestUtil.nextLong());

		_emrgcyRequests.add(_persistence.update(emrgcyRequest));

		return emrgcyRequest;
	}

	private List<EmrgcyRequest> _emrgcyRequests =
		new ArrayList<EmrgcyRequest>();
	private EmrgcyRequestPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}