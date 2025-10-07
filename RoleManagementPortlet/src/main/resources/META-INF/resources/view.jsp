<%@ include file="./init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ page import="com.liferay.portal.kernel.model.Role" %>
<%@ page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil" %>
<%@ page import="java.util.List" %>

<%
    long companyId = themeDisplay.getCompanyId();
    List<Role> roles = RoleLocalServiceUtil.getRoles(companyId);
%>

<h2>Role Management</h2>

<portlet:actionURL name="/add_role" var="addRoleURL" />
<aui:form action="${addRoleURL}" method="post" name="addRoleForm">
    <aui:input name="roleName" label="Role Name" required="true" />
    <aui:input name="description" label="Description" />
    <aui:button type="submit" value="Add Role" />
</aui:form>

<br/><hr/><br/>

<h3>Existing Roles</h3>

<% if (roles.isEmpty()) { %>
    <p><em>No roles found.</em></p>
<% } else { %>
    <table border="1" cellpadding="8" cellspacing="0" style="width:80%;">
        <tr>
            <th>ID</th><th>Name</th><th>Description</th><th>Type</th><th>Actions</th>
        </tr>
        <% for (Role role : roles) { %>
            <tr>
                <td><%= role.getRoleId() %></td>
                <td><%= role.getName() %></td>
                <td><%= role.getDescription() %></td>
                <td><%= role.getType() == 1 ? "Regular" : "Other" %></td>
                <td>
                    <!-- Edit -->
                    <portlet:renderURL var="editURL">
                        <portlet:param name="mvcPath" value="/updateRole.jsp" />
                        <portlet:param name="roleId" value="<%= String.valueOf(role.getRoleId()) %>" />
                    </portlet:renderURL>
                    <a href="${editURL}">Edit</a> |

                    <!-- Delete -->
                    <portlet:actionURL name="/delete_role" var="deleteRoleURL">
                        <portlet:param name="roleId" value="<%= String.valueOf(role.getRoleId()) %>" />
                    </portlet:actionURL>
                    <a href="${deleteRoleURL}">Delete</a> |

                    <!-- Assign -->
                    <portlet:renderURL var="assignURL">
                        <portlet:param name="mvcPath" value="/assignRole.jsp" />
                        <portlet:param name="roleId" value="<%= String.valueOf(role.getRoleId()) %>" />
                    </portlet:renderURL>
                    <a href="${assignURL}">Assign User</a>
                </td>
            </tr>
        <% } %>
    </table>
<% } %>
