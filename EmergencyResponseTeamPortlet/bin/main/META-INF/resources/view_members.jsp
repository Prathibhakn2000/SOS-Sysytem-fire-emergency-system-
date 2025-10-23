<%@ include file="/init.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="javax.portlet.PortletRequest" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%
    // ✅ Get teamId safely (from request attribute or URL parameter)
    long teamId = 0;

    Object teamIdAttr = request.getAttribute("teamId");
    if (teamIdAttr != null) {
        teamId = (Long) teamIdAttr;
    } else {
        teamId = ParamUtil.getLong(request, "teamId", 0);
    }

    System.out.println("DEBUG: teamId in view_members.jsp = " + teamId);

    // ✅ Get team members (added from render command)
    List<User> members = (List<User>) request.getAttribute("members");
%>

<h2>👥 Team Members</h2>
<hr>

<!-- ✅ Add Member Button -->
<div class="mb-3 d-flex justify-content-between">
    <portlet:renderURL var="addMemberURL">
        <portlet:param name="mvcRenderCommandName" value="/add_member" />
        <portlet:param name="teamId" value="<%= String.valueOf(teamId) %>" />
    </portlet:renderURL>

    <button type="button" class="btn btn-success btn-sm" onclick="location.href='${addMemberURL}'">
        <i class="fa fa-user-plus"></i> Add Member
    </button>
</div>

<!-- ✅ Members Table -->
<table class="table table-bordered table-hover">
    <thead class="table-light">
        <tr>
            <th>Member Name</th>
            <th>Email</th>
        </tr>
    </thead>
    <tbody>
        <%
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
