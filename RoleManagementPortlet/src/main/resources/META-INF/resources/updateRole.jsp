<%@ include file="/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.model.Role" %>
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

// ✅ Use themeDisplay from init.jsp
String description = "";
if (role != null) {
    description = role.getDescription(themeDisplay.getLocale()); // no redeclaration
}
%>

<% if (role == null) { %>
    <div style="color:red;">Role not found.</div>
<% } else { %>
    <portlet:actionURL name="/update_role" var="updateRoleURL" />
    <form action="${updateRoleURL}" method="post">
        <input type="hidden" name="<portlet:namespace />roleId" value="<%= role.getRoleId() %>" />
        Role Name:
        <input type="text" name="<portlet:namespace />roleName" value="<%= role.getName() %>" required /><br/><br/>
        Description:
        <input type="text" name="<portlet:namespace />description" value="<%= description %>" /><br/><br/>
        <input type="submit" value="Update Role" />
    </form>
<% } %>
