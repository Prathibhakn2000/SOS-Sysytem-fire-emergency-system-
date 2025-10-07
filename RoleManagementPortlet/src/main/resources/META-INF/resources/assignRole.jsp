<%@ include file="/init.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="com.liferay.portal.kernel.model.Role" %>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%
long roleId = ParamUtil.getLong(request, "roleId");
Role role = null;

try {
    role = RoleLocalServiceUtil.getRole(roleId);
} catch (Exception e) {
    role = null;
}

List<User> users = UserLocalServiceUtil.getUsers(-1, -1); // fetch all users
%>

<% if (role == null) { %>
    <div style="color:red;">Role not found or deleted (ID: <%= roleId %>).</div>
<% } else { %>
    <h3>Assign User to Role: <%= role.getName() %></h3>

    <portlet:actionURL name="/assign_user_to_role" var="assignUserURL" />
    <form action="${assignUserURL}" method="post">
        <input type="hidden" name="<portlet:namespace />roleId" value="<%= role.getRoleId() %>" />
        <label>Select User:</label>
        <select name="<portlet:namespace />userId" required>
            <option value="">--Select User--</option>
            <% for(User u : users) { %>
                <option value="<%= u.getUserId() %>"><%= u.getFullName() %> (<%= u.getScreenName() %>)</option>
            <% } %>
        </select>
        <br/><br/>
        <input type="submit" value="Assign User" />
    </form>

    <portlet:renderURL var="backURL">
        <portlet:param name="mvcPath" value="/view.jsp" />
    </portlet:renderURL>
    <a href="${backURL}">Back to Role List</a>
<% } %>
