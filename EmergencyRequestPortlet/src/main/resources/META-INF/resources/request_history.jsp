<%@ include file="/init.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.model.UserGroup" %>
<%@ page import="com.liferay.portal.kernel.service.UserGroupLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil" %>
<%@ page import="EmergencyRequestDB.model.EmergencyRequest" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Font Awesome for icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<h2>🚨 Emergency Requests</h2>
<hr>

<%
    // Fetch request list from controller
    List<EmergencyRequest> requests = (List<EmergencyRequest>) request.getAttribute("requests");

    long companyId = themeDisplay.getCompanyId();
    long userId = themeDisplay.getUserId();

    // Get all available teams from backend
    List<UserGroup> allTeams = UserGroupLocalServiceUtil.getUserGroups(companyId);

    // Check if current user has authority to allocate teams
    boolean canAllocate = false;
    try {
        canAllocate =
            RoleLocalServiceUtil.hasUserRole(userId, companyId, "Admin", true) ||
            RoleLocalServiceUtil.hasUserRole(userId, companyId, "Dispatcher", true) ||
            RoleLocalServiceUtil.hasUserRole(userId, companyId, "Team Leader", true);
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

<table class="table table-bordered table-striped">
    <thead style="background-color: #f8f9fa;">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Description</th> <!-- ✅ Added Description Column -->
            <th>Location</th>
            <th>Status</th>
            <th>Allocated Team</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
    <%
        if (requests != null && !requests.isEmpty()) {
            for (EmergencyRequest req : requests) {
    %>
        <tr>
            <td><%= req.getRequestId() %></td>
            <td><%= req.getRequestTitle() %></td>
            <td><%= req.getDescription() != null ? req.getDescription() : "—" %></td> <!-- ✅ Display description -->
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

                    <aui:form action="<%= allocateTeamURL %>" method="post" cssClass="d-flex align-items-center">
                        <aui:input name="requestId" type="hidden" value="<%= req.getRequestId() %>" />

                        <aui:select name="teamId" label="Select Team" required="true">
                            <aui:option value="">--Select Team--</aui:option>
                            <% for (UserGroup team : allTeams) { %>
                                <aui:option value="<%= team.getUserGroupId() %>"><%= team.getName() %></aui:option>
                            <% } %>
                        </aui:select>

                        <aui:button type="submit" value="Allocate" cssClass="btn btn-primary btn-sm" />
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
        } else {
    %>
        <tr>
            <td colspan="7" class="text-center">No emergency requests found.</td>
        </tr>
    <%
        }
    %>
    </tbody>
</table>
