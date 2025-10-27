<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<h3>Team: ${team.name}</h3>

<!-- Add Member Button -->
<portlet:renderURL var="addMemberURL">
    <portlet:param name="mvcRenderCommandName" value="/add_member" />
    <portlet:param name="userGroupId" value="${team.userGroupId}" />
</portlet:renderURL>

<a href="${addMemberURL}" class="btn btn-primary mb-3">
    <i class="icon-plus"></i> Add Member
</a>

<!-- Team Members Table -->
<table class="table table-bordered table-striped">
    <thead class="thead-dark">
        <tr>
            <th>Full Name</th>
            <th>Email</th>
            <th>Screen Name</th>
            <th style="width: 120px;">Action</th>
        </tr>
    </thead>
    <tbody>
        <c:choose>
            <c:when test="${not empty members}">
                <c:forEach var="member" items="${members}">
                    <tr>
                        <td>${member.fullName}</td>
                        <td>${member.emailAddress}</td>
                        <td>${member.screenName}</td>
                        <td>
                            <!-- Delete Member Button -->
                            <portlet:actionURL name="/delete_member" var="deleteMemberURL">
                                <portlet:param name="userId" value="${member.userId}" />
                                <portlet:param name="userGroupId" value="${team.userGroupId}" />
                            </portlet:actionURL>

                            <aui:button type="button"
                                        value="Delete"
                                        cssClass="btn btn-sm btn-danger"
                                        onClick="if(confirm('Are you sure you want to remove this member?')) { location.href='${deleteMemberURL}'; }" />
                        </td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="4" class="text-center text-muted">
                        No members found in this team.
                    </td>
                </tr>
            </c:otherwise>
        </c:choose>
    </tbody>
</table>
