<%@ include file="./init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@ page import="com.liferay.portal.kernel.model.Role" %>
<%@ page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil" %>
<%@ page import="java.util.List" %>

<%
    long companyId = themeDisplay.getCompanyId();
    List<Role> roles = RoleLocalServiceUtil.getRoles(companyId);
%>

<h2 class="mb-4 text-center">Role Management</h2>

<!-- Center the Add Role Card -->
<div class="d-flex justify-content-center">
    <div class="card p-4 shadow-sm mb-4" style="max-width: 500px; width: 100%;">
        <h4 class="mb-3 text-center">Add New Role</h4>
        <portlet:actionURL name="/add_role" var="addRoleURL" />
        <aui:form action="<%= addRoleURL %>" method="post" name="addRoleForm">
            <aui:input name="roleName" label="Role Name" required="true" />
            <aui:input name="description" label="Description" />
            <div class="text-center mt-3">
                <aui:button type="submit" cssClass="btn btn-primary" value="Add Role" />
            </div>
        </aui:form>
    </div>
</div>

<hr/>

<h3 class="mb-3">Existing Roles</h3>

<% if (roles.isEmpty()) { %>
    <p><em>No roles found.</em></p>
<% } else { %>
    <table class="table table-bordered table-hover" style="width:80%; margin: auto;">
        <thead class="thead-dark">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Type</th>
                <th style="width: 25%;">Actions</th>
            </tr>
        </thead>
        <tbody>
        <% for (Role role : roles) { %>
            <tr>
                <td><%= role.getRoleId() %></td>
                <td><%= role.getName() %></td>
                <td><%= role.getDescription() %></td>
                <td><%= role.getType() == 1 ? "Regular" : "Other" %></td>
                <td>
                    <!-- Edit Button -->
                    <portlet:renderURL var="editURL">
                        <portlet:param name="mvcPath" value="/updateRole.jsp" />
                        <portlet:param name="roleId" value="<%= String.valueOf(role.getRoleId()) %>" />
                    </portlet:renderURL>
                    <a href="<%= editURL %>" class="btn btn-sm btn-primary">
                        <i class="icon-edit"></i> Edit
                    </a>

                    <!-- Delete Button -->
                    <portlet:actionURL name="/delete_role" var="deleteRoleURL">
                        <portlet:param name="roleId" value="<%= String.valueOf(role.getRoleId()) %>" />
                    </portlet:actionURL>
                    <a href="<%= deleteRoleURL %>"
                       class="btn btn-sm btn-primary"
                       onclick="return confirm('Are you sure you want to delete this role?');">
                        <i class="icon-trash"></i> Delete
                    </a>

                    <!-- Assign User Button -->
                    <portlet:renderURL var="assignURL">
                        <portlet:param name="mvcPath" value="/assignRole.jsp" />
                        <portlet:param name="roleId" value="<%= String.valueOf(role.getRoleId()) %>" />
                    </portlet:renderURL>
                    <a href="<%= assignURL %>" class="btn btn-sm btn-primary">
                        <i class="icon-user"></i> Assign
                    </a>
                </td>
            </tr>
        <% } %>
        </tbody>
    </table>
<% } %>
