<%@ include file="/init.jsp" %>

<portlet:renderURL var="viewTeamsURL">
    <portlet:param name="mvcRenderCommandName" value="/view_teams" />
</portlet:renderURL>

<script>
    // Automatically redirect to the main teams page
    window.location.href = "<%= viewTeamsURL %>";
</script>
