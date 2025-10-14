<%@ include file="/init.jsp" %>

<%
    // When the portlet first loads, we’ll navigate to /view_teams
%>

<portlet:renderURL var="viewTeamsURL">
    <portlet:param name="mvcRenderCommandName" value="/view_teams" />
</portlet:renderURL>

<script>
    // Automatically redirect to view_teams page when this view.jsp is loaded
    window.location.href = "<%= viewTeamsURL %>";
</script>

<!-- Optional message if JS is disabled -->
<noscript>
    <div class="alert alert-info mt-3">
        Please <strong>enable JavaScript</strong> to view the Emergency Response Teams list.<br>
        <a href="<%= viewTeamsURL %>" class="btn btn-primary btn-sm mt-2">Go to Teams Page</a>
    </div>
</noscript>
