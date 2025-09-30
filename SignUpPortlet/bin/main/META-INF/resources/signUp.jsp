<%@ include file="/init.jsp" %>

<portlet:actionURL name="/user/add_user" var="signupActionURL" />

<aui:form action="${signupActionURL}" method="post" name="signupForm" autocomplete="off">
    <aui:input name="firstName" label="First Name" />
    <aui:input name="lastName" label="Last Name" />
    <aui:input name="screenName" label="Screen Name" />
    <aui:input name="emailAddress" label="Email" autocomplete="off" />
    <aui:input type="password" name="password" label="Password" autocomplete="new-password" />
    <aui:button type="submit" value="Sign Up" />
</aui:form>
