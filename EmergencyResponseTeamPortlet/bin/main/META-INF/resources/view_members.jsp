<%@ include file="/init.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Font Awesome for icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
<h2>👥 Team Members</h2>
<hr>

<table class="table table-bordered table-hover">
    <thead class="table-light">
        <tr>
            <th>Member Name</th>
            <th>Email</th>
        </tr>
    </thead>
    <tbody>
        <%
            List<User> members = (List<User>) request.getAttribute("members");
            if (members != null && !members.isEmpty()) {
                for (User member : members) {
        %>
        <tr>
            <td><%= member.getFullName() %></td>
            <td><%= member.getEmailAddress() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="2" class="text-center text-muted">No members found.</td>
        </tr>
        <%
            }
        %>
    </tbody>
</table>

<portlet:renderURL var="backURL">
    <portlet:param name="mvcRenderCommandName" value="/view_teams" />
</portlet:renderURL>

<aui:a href="${backURL}" cssClass="btn btn-secondary btn-sm">← Back to Teams</aui:a>
