<%@ include file="/init.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="com.liferay.portal.kernel.model.UserGroup" %>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.service.UserGroupLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil" %>
<%@ page import="EmergencyRequestDB.model.EmergencyRequest" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%
    List<EmergencyRequest> requests = (List<EmergencyRequest>) request.getAttribute("requests");
    long companyId = themeDisplay.getCompanyId();
    long userId = themeDisplay.getUserId();

    List<UserGroup> allTeams = UserGroupLocalServiceUtil.getUserGroups(companyId);

    boolean canAllocate = RoleLocalServiceUtil.hasUserRole(userId, companyId, "Admin", true)
                        || RoleLocalServiceUtil.hasUserRole(userId, companyId, "Dispatcher", true)
                        || RoleLocalServiceUtil.hasUserRole(userId, companyId, "Team Leader", true);

    boolean isTeamMember = RoleLocalServiceUtil.hasUserRole(userId, companyId, "Team Member", true);

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh:mm a");
%>

<h2>Emergency Request History</h2>


 <table class="table table-bordered table-hover" style="width:80%;">
        <thead class="thead-dark">
        <tr>
            <th>Request ID</th>
            <th>Requester Name</th>
            <th>Title</th>
            <th>Description</th>
            <th>Location</th>
            <th>Contact Number</th>
            <th>Date</th>
            <th>Status</th>
            <th>Allocated Team</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <% 
        if (requests != null && !requests.isEmpty()) {
            for (EmergencyRequest req : requests) {
                String requesterName = "Unknown";
                try {
                    User requester = UserLocalServiceUtil.getUser(req.getUserId());
                    requesterName = requester.getFullName();
                } catch (Exception e) { }
        %>
        <tr>
            <td><%= req.getRequestId() %></td>
            <td><%= requesterName %></td>
            <td><%= req.getRequestTitle() %></td>
            <td><%= (req.getDescription() != null ? req.getDescription() : "—") %></td>
            <td><%= req.getLocation() %></td>
            <td><%= req.getContactNumber() %></td>
            <td><%= (req.getCreateDate() != null ? sdf.format(req.getCreateDate()) : "—") %></td>
            <td><%= req.getStatus() %></td>
            <td>
                <% 
                    long teamId = req.getAllocatedTeamId();
                    if (teamId > 0) {
                        try {
                            UserGroup team = UserGroupLocalServiceUtil.getUserGroup(teamId);
                            out.print(team.getName());
                        } catch (Exception e) {
                            out.print("Unknown Team");
                        }
                    } else {
                        out.print("Not Allocated");
                    }
                %>
            </td>
            <td>
                <%-- 🟢 1. Admin/Dispatcher allocates team --%>
                <%
                    if ("Pending".equalsIgnoreCase(req.getStatus()) && canAllocate) {
                %>
                    <portlet:actionURL name="allocateTeam" var="allocateTeamURL" />
                    <aui:form action="<%= allocateTeamURL %>" method="post">
                        <aui:input name="requestId" type="hidden" value="<%= req.getRequestId() %>" />
                        <aui:select name="teamId" label="Select Team" required="true">
                            <aui:option value="">--Select Team--</aui:option>
                            <% for (UserGroup team : allTeams) { %>
                                <aui:option value="<%= team.getUserGroupId() %>"><%= team.getName() %></aui:option>
                            <% } %>
                        </aui:select>
                        <aui:button type="submit" value="Allocate" />
                    </aui:form>

                <%-- 🟡 2. Team Member updates status --%>
                <%
                    } else if (isTeamMember && "Assigned".equalsIgnoreCase(req.getStatus())) {
                %>
                    <portlet:actionURL name="updateStatus" var="updateStatusURL" />
                    <aui:form action="<%= updateStatusURL %>" method="post">
                        <aui:input name="requestId" type="hidden" value="<%= req.getRequestId() %>" />
                        <aui:select name="status" label="Update Status">
                            <aui:option value="In Progress">In Progress</aui:option>
                            <aui:option value="Completed">Completed</aui:option>
                        </aui:select>
                        <aui:button type="submit" value="Update" />
                    </aui:form>

                <%-- 🔵 3. Admin verifies completed requests --%>
                <%
                    } else if (canAllocate && "Completed".equalsIgnoreCase(req.getStatus())) {
                %>
                    <portlet:actionURL name="verifyRequest" var="verifyRequestURL" />
                    <aui:form action="<%= verifyRequestURL %>" method="post">
                        <aui:input name="requestId" type="hidden" value="<%= req.getRequestId() %>" />
                        <aui:select name="status" label="Verify">
                            <aui:option value="Verified">Verified</aui:option>
                            <aui:option value="Closed">Closed</aui:option>
                        </aui:select>
                        <aui:button type="submit" value="Update" />
                    </aui:form>

                <% 
                    } else {
                        out.print("-");
                    }
                %>
            </td>
        </tr>
        <% 
            } // end for
        } else { 
        %>
            <tr><td colspan="10">No requests found.</td></tr>
        <% } %>
    </tbody>
</table>
