/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package RoleManagementDB.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link RoleTableLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RoleTableLocalService
 * @generated
 */
public class RoleTableLocalServiceWrapper
	implements RoleTableLocalService, ServiceWrapper<RoleTableLocalService> {

	public RoleTableLocalServiceWrapper() {
		this(null);
	}

	public RoleTableLocalServiceWrapper(
		RoleTableLocalService roleTableLocalService) {

		_roleTableLocalService = roleTableLocalService;
	}

	/**
	 * Adds the role table to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RoleTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param roleTable the role table
	 * @return the role table that was added
	 */
	@Override
	public RoleManagementDB.model.RoleTable addRoleTable(
		RoleManagementDB.model.RoleTable roleTable) {

		return _roleTableLocalService.addRoleTable(roleTable);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleTableLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new role table with the primary key. Does not add the role table to the database.
	 *
	 * @param roleId the primary key for the new role table
	 * @return the new role table
	 */
	@Override
	public RoleManagementDB.model.RoleTable createRoleTable(long roleId) {
		return _roleTableLocalService.createRoleTable(roleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleTableLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the role table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RoleTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param roleId the primary key of the role table
	 * @return the role table that was removed
	 * @throws PortalException if a role table with the primary key could not be found
	 */
	@Override
	public RoleManagementDB.model.RoleTable deleteRoleTable(long roleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleTableLocalService.deleteRoleTable(roleId);
	}

	/**
	 * Deletes the role table from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RoleTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param roleTable the role table
	 * @return the role table that was removed
	 */
	@Override
	public RoleManagementDB.model.RoleTable deleteRoleTable(
		RoleManagementDB.model.RoleTable roleTable) {

		return _roleTableLocalService.deleteRoleTable(roleTable);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _roleTableLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _roleTableLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _roleTableLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _roleTableLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleManagementDB.model.impl.RoleTableModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _roleTableLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleManagementDB.model.impl.RoleTableModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _roleTableLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _roleTableLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _roleTableLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public RoleManagementDB.model.RoleTable fetchRoleTable(long roleId) {
		return _roleTableLocalService.fetchRoleTable(roleId);
	}

	/**
	 * Returns the role table matching the UUID and group.
	 *
	 * @param uuid the role table's UUID
	 * @param groupId the primary key of the group
	 * @return the matching role table, or <code>null</code> if a matching role table could not be found
	 */
	@Override
	public RoleManagementDB.model.RoleTable fetchRoleTableByUuidAndGroupId(
		String uuid, long groupId) {

		return _roleTableLocalService.fetchRoleTableByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _roleTableLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _roleTableLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _roleTableLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _roleTableLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleTableLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the role table with the primary key.
	 *
	 * @param roleId the primary key of the role table
	 * @return the role table
	 * @throws PortalException if a role table with the primary key could not be found
	 */
	@Override
	public RoleManagementDB.model.RoleTable getRoleTable(long roleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleTableLocalService.getRoleTable(roleId);
	}

	/**
	 * Returns the role table matching the UUID and group.
	 *
	 * @param uuid the role table's UUID
	 * @param groupId the primary key of the group
	 * @return the matching role table
	 * @throws PortalException if a matching role table could not be found
	 */
	@Override
	public RoleManagementDB.model.RoleTable getRoleTableByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roleTableLocalService.getRoleTableByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the role tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleManagementDB.model.impl.RoleTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role tables
	 * @param end the upper bound of the range of role tables (not inclusive)
	 * @return the range of role tables
	 */
	@Override
	public java.util.List<RoleManagementDB.model.RoleTable> getRoleTables(
		int start, int end) {

		return _roleTableLocalService.getRoleTables(start, end);
	}

	/**
	 * Returns all the role tables matching the UUID and company.
	 *
	 * @param uuid the UUID of the role tables
	 * @param companyId the primary key of the company
	 * @return the matching role tables, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<RoleManagementDB.model.RoleTable>
		getRoleTablesByUuidAndCompanyId(String uuid, long companyId) {

		return _roleTableLocalService.getRoleTablesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of role tables matching the UUID and company.
	 *
	 * @param uuid the UUID of the role tables
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of role tables
	 * @param end the upper bound of the range of role tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching role tables, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<RoleManagementDB.model.RoleTable>
		getRoleTablesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<RoleManagementDB.model.RoleTable> orderByComparator) {

		return _roleTableLocalService.getRoleTablesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of role tables.
	 *
	 * @return the number of role tables
	 */
	@Override
	public int getRoleTablesCount() {
		return _roleTableLocalService.getRoleTablesCount();
	}

	/**
	 * Updates the role table in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RoleTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param roleTable the role table
	 * @return the role table that was updated
	 */
	@Override
	public RoleManagementDB.model.RoleTable updateRoleTable(
		RoleManagementDB.model.RoleTable roleTable) {

		return _roleTableLocalService.updateRoleTable(roleTable);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _roleTableLocalService.getBasePersistence();
	}

	@Override
	public RoleTableLocalService getWrappedService() {
		return _roleTableLocalService;
	}

	@Override
	public void setWrappedService(RoleTableLocalService roleTableLocalService) {
		_roleTableLocalService = roleTableLocalService;
	}

	private RoleTableLocalService _roleTableLocalService;

}