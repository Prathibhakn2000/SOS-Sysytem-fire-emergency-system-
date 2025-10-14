<%@ include file="/init.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.liferay.portal.kernel.model.UserGroup" %>
<%@ page import="com.liferay.portal.kernel.service.UserGroupLocalServiceUtil" %>
<%@ page import="EmergencyRequestDB.model.EmergencyRequest" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Font Awesome for icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
 

<h2>🚨 Emergency Requests</h2>
<hr>

<%
    List<EmergencyRequest> requests = (List<EmergencyRequest>) request.getAttribute("requests");
    long companyId = themeDisplay.getCompanyId();
    long userId = themeDisplay.getUserId();

    // Get all teams
    List<UserGroup> allTeams = UserGroupLocalServiceUtil.getUserGroups(companyId);

    // Check if current user is admin/dispatcher/team leader
    boolean canAllocate = false;
    try {
        canAllocate = com.liferay.portal.kernel.service.RoleLocalServiceUtil.hasUserRole(
            userId, companyId, "Admin", true)
            || com.liferay.portal.kernel.service.RoleLocalServiceUtil.hasUserRole(
            userId, companyId, "Dispatcher", true)
            || com.liferay.portal.kernel.service.RoleLocalServiceUtil.hasUserRole(
            userId, companyId, "Team Leader", true);
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

<table class="table table-bordered table-striped">
    <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Location</th>
            <th>Status</th>
            <th>Allocated Team</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
    <%
        for (EmergencyRequest req : requests) {
            // Filter nearest teams **inside request loop**
            List<UserGroup> nearestTeams = new ArrayList<>();
            for (UserGroup team : allTeams) {
                Object attr = team.getExpandoBridge().getAttribute("Teamlocation", false);
                if (attr != null && attr instanceof String[]) {
                    String[] locations = (String[]) attr;
                    for (String loc : locations) {
                        if (loc != null && loc.equalsIgnoreCase(req.getLocation())) {
                            nearestTeams.add(team);
                            break;
                        }
                    }
                }
            }
    %>
        <tr>
            <td><%= req.getRequestId() %></td>
            <td><%= req.getRequestTitle() %></td>
            <td><%= req.getLocation() %></td>
            <td><%= req.getStatus() %></td>
            <td>
                <%
                    if (req.getAllocatedTeamId() > 0) {
                        try {
                            out.print(UserGroupLocalServiceUtil.getUserGroup(req.getAllocatedTeamId()).getName());
                        } catch (Exception e) {
                            out.print("Unknown");
                        }
                    } else {
                        out.print("Not Assigned");
                    }
                %>
            </td>
            <td>
                <%
                    if ("Pending".equalsIgnoreCase(req.getStatus()) && canAllocate) {
                %>
                    <portlet:actionURL name="allocateTeam" var="allocateTeamURL" />

                    <aui:form action="<%= allocateTeamURL %>" method="post">
                        <aui:input name="requestId" type="hidden" value="<%= req.getRequestId() %>" />

                        <aui:select name="teamId" label="Select Nearest Team" required="true">
                            <aui:option value="">--Select Team--</aui:option>
                            <% for (UserGroup team : nearestTeams) { %>
                                <aui:option value="<%= team.getUserGroupId() %>"><%= team.getName() %></aui:option>
                            <% } %>
                        </aui:select>

                        <aui:button type="submit" value="Allocate" />
                    </aui:form>
                <%
                    } else if (!canAllocate) {
                        out.print("⛔ Not Authorized");
                    } else {
                        out.print("✅ Already Assigned");
                    }
                %>
            </td>
        </tr>
    <%
        }
    %>
    </tbody>
</table>
