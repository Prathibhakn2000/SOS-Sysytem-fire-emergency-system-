<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>Team: ${team.name}</h3>

<portlet:renderURL var="addMemberURL">
    <portlet:param name="mvcRenderCommandName" value="/add_member" />
    <portlet:param name="userGroupId" value="${team.userGroupId}" />
</portlet:renderURL>

<a href="${addMemberURL}" class="btn btn-primary">Add Member</a>
<br><br>

<table class="table table-striped">
    <thead>
        <tr>
            <th>Full Name</th>
            <th>Email</th>
            <th>Screen Name</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="member" items="${members}">
            <tr>
                <td>${member.fullName}</td>
                <td>${member.emailAddress}</td>
                <td>${member.screenName}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
