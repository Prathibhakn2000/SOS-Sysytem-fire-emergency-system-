<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>



<portlet:actionURL name="/user/add_user" var="signupActionURL" />

<aui:form action="<%= signupActionURL %>" method="post" name="signupForm" autocomplete="off">
  
    <aui:input name="firstName" label="First Name" />
    <aui:input name="lastName" label="Last Name" />
    <aui:input name="screenName" label="Screen Name" />
    <aui:input name="emailAddress" label="Email" />
    <aui:input type="password" name="password" label="Password" />
    <aui:button type="submit" value="Register" />
</aui:form>
