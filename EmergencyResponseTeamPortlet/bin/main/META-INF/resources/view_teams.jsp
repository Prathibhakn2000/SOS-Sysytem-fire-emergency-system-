<%@ include file="/init.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.model.UserGroup" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<h2>🚨 Emergency Response Teams</h2>
<hr>

<!-- ✅ Add Team Button -->
<div class="mb-3">
    <a href="<%= themeDisplay.getURLPortal() %>/group/guest/~/control_panel/manage?p_p_id=com_liferay_user_groups_admin_web_portlet_UserGroupsAdminPortlet"
       target="_blank"
       class="btn btn-success btn-sm">
        <i class="fa fa-plus"></i> Add Team
    </a>
</div>

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
                <aui:a href="${viewMembersURL}" cssClass="btn btn-primary btn-sm">
                    <i class="fa fa-users"></i> View Members
                </aui:a>
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
