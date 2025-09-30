<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="otp.caption"/></b>
</p>





<%
long userId = (long) renderRequest.getAttribute("userId");
String token = (String) renderRequest.getAttribute("token");
%>

<div class="container">
    <h2>Enter OTP</h2>
    
  <portlet:actionURL var="verifyOtpURL" name="/verify/otp" />
    
    <aui:form action="<%= verifyOtpURL %>" method="post">
        <aui:input type="hidden" name="userId" value="<%= userId %>" />
        <aui:input type="hidden" name="token" value="<%= token %>" />

        <aui:input name="otp" label="Enter OTP" required="true" />

        <aui:button type="submit" value="Verify OTP" />
    </aui:form>
</div>
