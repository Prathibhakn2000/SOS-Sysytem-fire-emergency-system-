<%-- <%@ include file="/init.jsp" %>

<portlet:defineObjects />

<portlet:actionURL name="/send_otp" var="sendOtpURL" />
<aui:form action="${sendOtpURL}" method="post">

    <!-- Carry userId and token forward -->
    <aui:input type="hidden" name="userId" value="${param.userId}" />
    <aui:input type="hidden" name="token" value="${param.token}" />

    <aui:input name="emailAddress" type="text" label="Enter Email" required="true" />

    <aui:button type="submit" value="Send OTP" />
</aui:form>
 --%>