<%@ include file="./init.jsp" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="TicketMgmtDB.model.TicketMgmt" %>
<%@ page import="TicketMgmtDB.service.TicketMgmtLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.asset.kernel.model.AssetCategory" %>
<%@ page import="com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil" %>
<%@ page import="com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil" %>
<%@ page import="java.util.List" %>


<%
long ticket_id = ParamUtil.getLong(request, "ticketId");
TicketMgmt ticket = null;

if (ticket_id > 0) {
    ticket = TicketMgmtLocalServiceUtil.fetchTicketMgmt(ticket_id);
}
%>

<div style="max-width:700px; margin: 40px auto; background: #fff; padding: 25px; border-radius: 10px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); font-family: 'Segoe UI', sans-serif;">
    <h2 style="color: #0066cc; text-align: center; margin-bottom: 25px;">Edit Ticket</h2>

<%
List<AssetCategory> assetCategories = AssetCategoryLocalServiceUtil.getChildCategories(57214);
%>
    <portlet:actionURL name="editTicket" var="editTicketURL" />

    <aui:form action="${editTicketURL}" method="post">
        <aui:input name="ticket_id" type="hidden" value="<%= ticket_id %>" />

        <aui:input name="busNumber" label="Bus Number" value="<%= ticket != null ? ticket.getBusNumber() : \"\" %>" />
<aui:select name="fromLocation" >
                <%
            	for(AssetCategory assetCategory : assetCategories){
            	%>
            	<aui:option value="<%=assetCategory.getCategoryId() %>"><%=assetCategory.getName() %></aui:option>
            	<%	
            	}
            	%>
            	</aui:select>
                 <aui:select name="toLocation" >
                <%
            	for(AssetCategory assetCategory : assetCategories){
            	%>
            	<aui:option value="<%=assetCategory.getCategoryId() %>"><%=assetCategory.getName() %></aui:option>
            	<%	
            	}
            	%>
            	</aui:select>
        <aui:input name="journeyDate" label="Journey Date" type="date" value="<%= ticket != null && ticket.getJourneyDate() != null ? new java.text.SimpleDateFormat(\"yyyy-MM-dd\").format(ticket.getJourneyDate()) : \"\" %>" />
        <aui:input name="seatNumber" label="Seat Number" value="<%= ticket != null ? ticket.getSeatNumber() : 0 %>" />
        <aui:input name="fareAmount" label="Fare Amount" value="<%= ticket != null ? ticket.getFareAmount() : 0 %>" />

        <div style="text-align: center; margin-top: 25px;">
            <aui:button type="submit" value="Update Ticket" cssClass="btn btn-primary" />
            
            <portlet:renderURL var="backURL">
                <portlet:param name="jspPage" value="/view.jsp" />
            </portlet:renderURL>
            <a href="${backURL}" style="margin-left: 10px; background-color: #6c757d; color: white; padding: 7px 15px; border-radius: 5px; text-decoration: none;">Cancel</a>
        </div>
    </aui:form>
</div>

<style>
.btn.btn-primary {
    background-color: #0066cc;
    color: white;
    padding: 8px 20px;
    border-radius: 5px;
    border: none;
    cursor: pointer;
}
.btn.btn-primary:hover {
    background-color: #004c99;
}
</style>
