 <%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="signup.caption"/></b>
</p>


<%-- <portlet:renderURL var="signupURL">
    <portlet:param name="mvcRenderCommandName" value="/user/add_user" />
</portlet:renderURL>


<div>
    <h2>Welcome!</h2>
    <p>Don't have an account? 
        <a href="<%= signupURL %>">Sign Up here</a>
    </p>
</div>  --%>


<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="java.util.List" %>


<h2>All Users</h2>

<table class="table table-bordered table-hover">
    <thead>
        <tr>
            <th>UserId</th>
            <th>Full Name</th>
            <th>Email</th>
            <th>Screen Name</th>
        </tr>
    </thead>
    <tbody>
       <%
List<User> users = (List<User>) request.getAttribute("users");
if (users != null && !users.isEmpty()) {
    for (User u : users) {
%>
<tr>
    <td><%= u.getUserId() %></td>
    <td><%= u.getFullName() %></td>
    <td><%= u.getEmailAddress() %></td>
    <td><%= u.getScreenName() %></td>
</tr>
<%
    }
} else {
%>
<tr><td colspan="4">No users found.</td></tr>
<%
}
%>

    </tbody>
</table>

<portlet:renderURL var="signupURL">
    <portlet:param name="mvcRenderCommandName" value="/user/add_user" />
</portlet:renderURL>

<aui:button-row>
    <aui:button 
        value="Add User" 
        onClick="<%= signupURL %>" 
        cssClass="btn btn-primary btn-lg rounded-pill shadow-sm px-4" 
    />
</aui:button-row>


<%-- <portlet:renderURL var="viewUsersURL">
    <portlet:param name="mvcRenderCommandName" value="/user/view_users" />
</portlet:renderURL>

<aui:button value="View All Users" onClick="<%= viewUsersURL %>" />
 --%>

