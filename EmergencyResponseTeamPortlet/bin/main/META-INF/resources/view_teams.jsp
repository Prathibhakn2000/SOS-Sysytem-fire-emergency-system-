<%@ include file="/init.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.model.UserGroup" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Font Awesome for icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
<h2>🚨 Emergency Response Teams</h2>
<hr>

<table class="table table-bordered table-hover">
    <thead class="table-light">
        <tr>
            <th>Team Name</th>
            <th>View Members</th>
        </tr>
    </thead>
    <tbody>
        <%
            List<UserGroup> teams = (List<UserGroup>) request.getAttribute("teams");
            if (teams != null && !teams.isEmpty()) {
                for (UserGroup teamObj : teams) {
        %>
        <tr>
            <td><%= teamObj.getName() %></td>
            <td>
                <portlet:renderURL var="viewMembersURL">
                    <portlet:param name="mvcRenderCommandName" value="/view_members" />
                    <portlet:param name="teamId" value="<%= String.valueOf(teamObj.getUserGroupId()) %>" />
                </portlet:renderURL>
                <aui:a href="${viewMembersURL}" cssClass="btn btn-primary btn-sm">View Members</aui:a>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="2" class="text-center text-muted">No teams found.</td>
        </tr>
        <%
            }
        %>
    </tbody>
</table>
