<%@ include file="./init.jsp" %>

<%
long userId = (long) request.getAttribute("userId");
String token = (String) request.getAttribute("token");
%>

<div class="container">
    <h2>Enter OTP</h2>

    <aui:form action="<%= renderResponse.createActionURL() %>" method="post">
        <aui:input type="hidden" name="userId" value="<%= userId %>" />
        <aui:input type="hidden" name="token" value="<%= token %>" />

        <aui:input name="otp" label="Enter OTP" />
        <aui:button type="submit" value="Verify OTP" />
    </aui:form>
</div>