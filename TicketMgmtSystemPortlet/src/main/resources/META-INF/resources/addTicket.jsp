<%@ include file="./init.jsp" %>
<%@ page import="com.liferay.asset.kernel.model.AssetCategory" %>
<%@ page import="com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil" %>
<%@ page import="com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil" %>
<%@ page import="java.util.List" %>



<portlet:actionURL name="addTicket" var="bookTicketURL" />

<div class="ticket-card-container">
    <div class="card booking-card">
        <h2 class="card-title">Bus Ticket Booking</h2>
        
<%
List<AssetCategory> assetCategories = AssetCategoryLocalServiceUtil.getChildCategories(57214);
%>

        <aui:form action="<%= bookTicketURL %>" method="post" name="fm">
            <aui:fieldset>
                <aui:input name="busNumber" label="Bus Number" type="text" required="true" />
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
                <aui:input name="journeyDate" label="Journey Date" type="date" required="true" />
                <aui:input name="seatNumber" label="Seat Number" type="text" required="true" />
                <aui:input name="fareAmount" label="Fare Amount (₹)" type="number" step="0.01" required="true" />

                <aui:button-row>
                    <aui:button type="submit" value="Book Ticket" cssClass="btn-primary" />
                </aui:button-row>
            </aui:fieldset>
        </aui:form>
    </div>
</div>

<style>
/* 🎟️ Card container */
.ticket-card-container {
    display: flex;
    justify-content: center;
    align-items: flex-start;
    margin-top: 50px;
    padding: 20px;
}

/* 🪄 Bigger booking card */
.booking-card {
    background: #ffffff;
    border-radius: 16px;
    box-shadow: 0 6px 20px rgba(0, 0, 0, 0.12);
    padding: 50px 60px;
    width: 100%;
    max-width: 750px;  /* ⬅️ Increased width */
    min-height: 600px; /* ⬅️ Increased height */
    transition: transform 0.25s ease, box-shadow 0.25s ease;
}

.booking-card:hover {
    transform: translateY(-5px);
    box-shadow: 0 8px 24px rgba(0, 0, 0, 0.18);
}

/* 🏷️ Title */
.card-title {
    font-size: 26px;
    font-weight: 650;
    color: #004c99;
    margin-bottom: 35px;
    text-align: center;
}

/* 📋 Form fields */
.aui-field-wrapper-content {
    margin-bottom: 18px;
}

/* 🎨 Buttons */
.btn-primary {
    background-color: #007bff !important;
    color: white !important;
    border-radius: 8px;
    padding: 10px 24px !important;
    font-size: 16px;
    border: none;
    transition: background 0.3s ease;
}
.btn-primary:hover {
    background-color: #0056b3 !important;
}

/* 🧱 Fieldset cleanup */
fieldset.aui-fieldset {
    border: none !important;
    padding: 0;
}
</style>
