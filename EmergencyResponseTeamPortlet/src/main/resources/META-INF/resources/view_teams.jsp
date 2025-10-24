
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Emergency Response Teams</h2>

<portlet:actionURL var="addTeamURL">
    <portlet:param name="mvcRenderCommandName" value="/view_teams" />
</portlet:actionURL>

<a href="/group/control_panel/manage?p_p_id=com_liferay_user_groups_admin_web_portlet_UserGroupsAdminPortlet"
   class="btn btn-primary">Add Team</a>

<br><br>
<table class="table table-bordered">
    <thead>
        <tr>
            <th>Team Name</th>
            <th>Description</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="team" items="${userGroups}">
            <tr>
                <td>${team.name}</td>
                <td>${team.description}</td>
                <td>
                    <portlet:renderURL var="viewMembersURL">
                        <portlet:param name="mvcRenderCommandName" value="/view_members" />
                        <portlet:param name="userGroupId" value="${team.userGroupId}" />
                    </portlet:renderURL>
                    <a href="${viewMembersURL}" class="btn btn-primary">View Members</a>
                </td>
            </tr>
        </c:forEach>
        
        
    </tbody>
</table>


