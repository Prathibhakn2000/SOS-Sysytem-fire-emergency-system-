/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package OTP_DB.service.persistence.test;

import OTP_DB.exception.NoSuchSignUpOTPException;

import OTP_DB.model.SignUpOTP;

import OTP_DB.service.SignUpOTPLocalServiceUtil;
import OTP_DB.service.persistence.SignUpOTPPersistence;
import OTP_DB.service.persistence.SignUpOTPUtil;

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
public class SignUpOTPPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED, "OTP_DB.service"));

	@Before
	public void setUp() {
		_persistence = SignUpOTPUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<SignUpOTP> iterator = _signUpOTPs.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SignUpOTP signUpOTP = _persistence.create(pk);

		Assert.assertNotNull(signUpOTP);

		Assert.assertEquals(signUpOTP.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		SignUpOTP newSignUpOTP = addSignUpOTP();

		_persistence.remove(newSignUpOTP);

		SignUpOTP existingSignUpOTP = _persistence.fetchByPrimaryKey(
			newSignUpOTP.getPrimaryKey());

		Assert.assertNull(existingSignUpOTP);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addSignUpOTP();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SignUpOTP newSignUpOTP = _persistence.create(pk);

		newSignUpOTP.setUuid(RandomTestUtil.randomString());

		newSignUpOTP.setGroupId(RandomTestUtil.nextLong());

		newSignUpOTP.setCompanyId(RandomTestUtil.nextLong());

		newSignUpOTP.setUserId(RandomTestUtil.nextLong());

		newSignUpOTP.setUserName(RandomTestUtil.randomString());

		newSignUpOTP.setCreateDate(RandomTestUtil.nextDate());

		newSignUpOTP.setModifiedDate(RandomTestUtil.nextDate());

		newSignUpOTP.setEmail_address(RandomTestUtil.randomString());

		newSignUpOTP.setOTP(RandomTestUtil.randomString());

		newSignUpOTP.setStatus(RandomTestUtil.randomBoolean());

		_signUpOTPs.add(_persistence.update(newSignUpOTP));

		SignUpOTP existingSignUpOTP = _persistence.findByPrimaryKey(
			newSignUpOTP.getPrimaryKey());

		Assert.assertEquals(
			existingSignUpOTP.getUuid(), newSignUpOTP.getUuid());
		Assert.assertEquals(
			existingSignUpOTP.getOtpId(), newSignUpOTP.getOtpId());
		Assert.assertEquals(
			existingSignUpOTP.getGroupId(), newSignUpOTP.getGroupId());
		Assert.assertEquals(
			existingSignUpOTP.getCompanyId(), newSignUpOTP.getCompanyId());
		Assert.assertEquals(
			existingSignUpOTP.getUserId(), newSignUpOTP.getUserId());
		Assert.assertEquals(
			existingSignUpOTP.getUserName(), newSignUpOTP.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingSignUpOTP.getCreateDate()),
			Time.getShortTimestamp(newSignUpOTP.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingSignUpOTP.getModifiedDate()),
			Time.getShortTimestamp(newSignUpOTP.getModifiedDate()));
		Assert.assertEquals(
			existingSignUpOTP.getEmail_address(),
			newSignUpOTP.getEmail_address());
		Assert.assertEquals(existingSignUpOTP.getOTP(), newSignUpOTP.getOTP());
		Assert.assertEquals(
			existingSignUpOTP.isStatus(), newSignUpOTP.isStatus());
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
		SignUpOTP newSignUpOTP = addSignUpOTP();

		SignUpOTP existingSignUpOTP = _persistence.findByPrimaryKey(
			newSignUpOTP.getPrimaryKey());

		Assert.assertEquals(existingSignUpOTP, newSignUpOTP);
	}

	@Test(expected = NoSuchSignUpOTPException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<SignUpOTP> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"fire_SignUpOTP", "uuid", true, "otpId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "email_address", true, "OTP", true,
			"status", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		SignUpOTP newSignUpOTP = addSignUpOTP();

		SignUpOTP existingSignUpOTP = _persistence.fetchByPrimaryKey(
			newSignUpOTP.getPrimaryKey());

		Assert.assertEquals(existingSignUpOTP, newSignUpOTP);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SignUpOTP missingSignUpOTP = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingSignUpOTP);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		SignUpOTP newSignUpOTP1 = addSignUpOTP();
		SignUpOTP newSignUpOTP2 = addSignUpOTP();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSignUpOTP1.getPrimaryKey());
		primaryKeys.add(newSignUpOTP2.getPrimaryKey());

		Map<Serializable, SignUpOTP> signUpOTPs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, signUpOTPs.size());
		Assert.assertEquals(
			newSignUpOTP1, signUpOTPs.get(newSignUpOTP1.getPrimaryKey()));
		Assert.assertEquals(
			newSignUpOTP2, signUpOTPs.get(newSignUpOTP2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, SignUpOTP> signUpOTPs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(signUpOTPs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		SignUpOTP newSignUpOTP = addSignUpOTP();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSignUpOTP.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, SignUpOTP> signUpOTPs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, signUpOTPs.size());
		Assert.assertEquals(
			newSignUpOTP, signUpOTPs.get(newSignUpOTP.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, SignUpOTP> signUpOTPs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(signUpOTPs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		SignUpOTP newSignUpOTP = addSignUpOTP();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSignUpOTP.getPrimaryKey());

		Map<Serializable, SignUpOTP> signUpOTPs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, signUpOTPs.size());
		Assert.assertEquals(
			newSignUpOTP, signUpOTPs.get(newSignUpOTP.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			SignUpOTPLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<SignUpOTP>() {

				@Override
				public void performAction(SignUpOTP signUpOTP) {
					Assert.assertNotNull(signUpOTP);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		SignUpOTP newSignUpOTP = addSignUpOTP();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SignUpOTP.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("otpId", newSignUpOTP.getOtpId()));

		List<SignUpOTP> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		SignUpOTP existingSignUpOTP = result.get(0);

		Assert.assertEquals(existingSignUpOTP, newSignUpOTP);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SignUpOTP.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("otpId", RandomTestUtil.nextLong()));

		List<SignUpOTP> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		SignUpOTP newSignUpOTP = addSignUpOTP();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SignUpOTP.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("otpId"));

		Object newOtpId = newSignUpOTP.getOtpId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("otpId", new Object[] {newOtpId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingOtpId = result.get(0);

		Assert.assertEquals(existingOtpId, newOtpId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SignUpOTP.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("otpId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"otpId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		SignUpOTP newSignUpOTP = addSignUpOTP();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newSignUpOTP.getPrimaryKey()));
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

		SignUpOTP newSignUpOTP = addSignUpOTP();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SignUpOTP.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("otpId", newSignUpOTP.getOtpId()));

		List<SignUpOTP> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(SignUpOTP signUpOTP) {
		Assert.assertEquals(
			signUpOTP.getUuid(),
			ReflectionTestUtil.invoke(
				signUpOTP, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(signUpOTP.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				signUpOTP, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected SignUpOTP addSignUpOTP() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SignUpOTP signUpOTP = _persistence.create(pk);

		signUpOTP.setUuid(RandomTestUtil.randomString());

		signUpOTP.setGroupId(RandomTestUtil.nextLong());

		signUpOTP.setCompanyId(RandomTestUtil.nextLong());

		signUpOTP.setUserId(RandomTestUtil.nextLong());

		signUpOTP.setUserName(RandomTestUtil.randomString());

		signUpOTP.setCreateDate(RandomTestUtil.nextDate());

		signUpOTP.setModifiedDate(RandomTestUtil.nextDate());

		signUpOTP.setEmail_address(RandomTestUtil.randomString());

		signUpOTP.setOTP(RandomTestUtil.randomString());

		signUpOTP.setStatus(RandomTestUtil.randomBoolean());

		_signUpOTPs.add(_persistence.update(signUpOTP));

		return signUpOTP;
	}

	private List<SignUpOTP> _signUpOTPs = new ArrayList<SignUpOTP>();
	private SignUpOTPPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}