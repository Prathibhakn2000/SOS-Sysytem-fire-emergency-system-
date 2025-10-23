<%@ include file="./init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>


<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>

<%
    long teamId = ParamUtil.getLong(request, "teamId");
%>

<h3>Add New Member</h3>
<hr>

<portlet:actionURL var="addMemberActionURL" name="/add_member" />

<aui:form action="${addMemberActionURL}" method="post">
    <aui:input name="teamId" type="hidden" value="<%= teamId %>" />

    <aui:input name="firstName" label="First Name" required="true" />
    <aui:input name="lastName" label="Last Name" required="true" />
     <aui:input name="screenName" label="Screen Name" required="true" />
    <aui:input name="emailAddress" label="Email" required="true" />
    <aui:input name="password" label="Password" type="password" required="true" />

    <aui:button type="submit" value="Add Member" />
</aui:form>
