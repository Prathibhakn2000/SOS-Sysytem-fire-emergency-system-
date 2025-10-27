<%@ include file="/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Font Awesome -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<%
    // --- Access restriction and role check ---
    com.liferay.portal.kernel.model.User currentUser = themeDisplay.getUser();

    boolean isAdmin = currentUser.getRoles().stream().anyMatch(role ->
        role.getName().equalsIgnoreCase("Administrator") ||
        role.getName().equalsIgnoreCase("Admin")
    );

    boolean isTeamMember = currentUser.getRoles().stream().anyMatch(role ->
        role.getName().equalsIgnoreCase("Team Member")
    );

    boolean isRequester = !isAdmin && !isTeamMember;
%>

<!-- ========================= REQUESTER VIEW ========================= -->
<% if (isRequester) { %>

<portlet:actionURL name="submitEmergencyRequest" var="submitURL" />
<portlet:renderURL var="historyURL">
    <portlet:param name="mvcRenderCommandName" value="/view_requests" />
</portlet:renderURL>

<div class="container mt-5">
    <div class="text-center mb-4">
        <h2 >Emergency Request Form</h2>
        <p class="text-muted">Submit your emergency details below</p>
    </div>
<div class="card shadow p-4" style="border-radius: 15px;">
    <aui:form action="<%= submitURL %>" method="post" enctype="multipart/form-data">
        <aui:fieldset label="Request Details">
            <div class="row mb-3">
                <div class="col-md-6">
                    <aui:input name="requestTitle" label="Request Title" required="true" />
                </div>
                <div class="col-md-6">
                    <aui:input name="location" label="Location/Area" required="true" placeholder="e.g., Silkboard, Bangalore" />
                </div>

                <div class="col-md-6 mt-3">
                    <aui:input name="exactAddress" label="Exact Incident Address" required="true" placeholder="Street, Landmark, etc." />
                </div>

                <!-- ✅ Added Contact Number field -->
                <div class="col-md-6 mt-3">
                    <aui:input name="contactNumber" label="Contact Number" required="true" placeholder="Enter your mobile number" />
                </div>
            </div>

            <div class="mb-3">
                <aui:input name="description" type="textarea" label="Description" required="true" />
            </div>

            <div class="mb-3">
                <aui:input name="attachment" type="file" label="Upload Attachment (optional)" />
            </div>

            <div class="text-center mt-4">
                <aui:button type="submit" value="Submit Request" cssClass="btn btn-primary" />
                <aui:button type="reset" value="Reset" cssClass="btn btn-secondary ml-2" />
            </div>
        </aui:fieldset>
    </aui:form>
</div>


    <div class="text-center mt-4">
        <a href="<%= historyURL %>" class="btn btn-outline-primary">
            <i class="icon-list"></i> View My Submitted Requests
        </a>
    </div>
</div>

<!-- ========================= ADMIN VIEW ========================= -->
<% } else if (isAdmin) { %>

<div class="container mt-5">
    <div class="text-center mb-4">
        <h2 >All Emergency Requests</h2>
        <p class="text-muted">Admin can manage and assign teams</p>
    </div>

    <portlet:renderURL var="adminViewURL">
        <portlet:param name="mvcRenderCommandName" value="/view_requests" />
    </portlet:renderURL>

    <div class="text-center">
        <a href="<%= adminViewURL %>" class="btn btn-primary">
            <i class="fa fa-list"></i> View All Requests
        </a>
    </div>
</div>

<!-- ========================= TEAM MEMBER VIEW ========================= -->
<% } else if (isTeamMember) { %>

<div class="container mt-5">
    <div class="text-center mb-4">
        <h2>Assigned Emergency Requests</h2>
        <p class="text-muted">View and update your assigned requests</p>
    </div>

    <portlet:renderURL var="teamViewURL">
        <portlet:param name="mvcRenderCommandName" value="/view_requests" />
    </portlet:renderURL>

    <div class="text-center">
        <a href="<%= teamViewURL %>" class="btn btn-primary">
            <i class="fa fa-tasks"></i> View My Assigned Requests
        </a>
    </div>
</div>

<% } %>

<style>
    .container { max-width: 800px; }
    .card { background-color: #ffffff; border: 1px solid #e0e0e0; }
    .aui-field-input-text, .aui-field-input-textarea { border-radius: 8px; }
    a.btn-outline-primary, a.btn-primary { border-radius: 8px; padding: 10px 20px; }
</style>
