<%@ include file="/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<liferay-theme:defineObjects />

<%
    // Get values from renderRequest attributes
    Long userId = (Long) renderRequest.getAttribute("userId");
    String token = (String) renderRequest.getAttribute("token");

    if (userId == null) {
        userId = 0L;
    }
    if (token == null) {
        token = "";
    }
%>

<liferay-ui:success key="otp-sent" message="A verification email with OTP has been sent. Please check your inbox." />
<liferay-ui:error key="otp-send-failed" message="Failed to send OTP. Please try again later." />

<div class="send-otp-container">
    <h2>Email Verification</h2>
    <p>Please confirm your registered email to receive OTP.</p>


    
    <portlet:actionURL var="sendOtpURL" name="/verify/email" />
    
    <aui:form action="<%= sendOtpURL %>" method="post">
        <aui:input type="hidden" name="userId" value="<%= userId %>" />
        <aui:input type="hidden" name="token" value="<%= token %>" />

        <aui:input name="email" label="Enter your Email" required="true" type="text" />

        <aui:button cssClass="send-otp-btn" type="submit" value="Send OTP" />
    </aui:form>
</div>
