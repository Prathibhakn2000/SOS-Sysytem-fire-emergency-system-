<%@ page import="java.util.*" %>
<%@ page import="TicketMgmtDB.model.TicketMgmt" %>
<%@ page import="TicketMgmtDB.service.TicketMgmtLocalServiceUtil" %>
<%@ page import="com.liferay.asset.kernel.model.AssetCategory" %>
<%@ page import="com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil" %>
<%@ include file="/init.jsp" %>

<div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 15px;">
    <h2 style="margin: 0; font-size: 22px;">Bus Ticket List</h2>

    <portlet:renderURL var="addTicketURL">
        <portlet:param name="jspPage" value="/addTicket.jsp" />
    </portlet:renderURL>

    <a href="${addTicketURL}" class="btn btn-primary btn-sm">Add New Ticket</a>
</div>

<div class="table-responsive">
    <table class="table table-bordered table-hover compact-table">
        <thead class="thead-dark">
            <tr>
                <th>Bus No.</th>
                <th>From</th>
                <th>To</th>
                <th>Date</th>
                <th>Seat</th>
                <th>Fare</th>
                <th style="width: 120px;">Actions</th>
            </tr>
        </thead>
        <tbody>
            <%
            List<TicketMgmt> tickets = new ArrayList<>(TicketMgmtLocalServiceUtil.getTicketMgmts(-1, -1));
            Collections.reverse(tickets);


                if (tickets != null && !tickets.isEmpty()) {
                    Collections.reverse(tickets); // show latest first

                    for (TicketMgmt ticket : tickets) {
                        String fromLocationName = "";
                        String toLocationName = "";

                        try {
                            // ✅ Fetch From Location name from category ID
                            String fromIdStr = ticket.getFromLocation();
                            if (fromIdStr != null && !fromIdStr.trim().isEmpty()) {
                                try {
                                    long fromId = Long.parseLong(fromIdStr);
                                    AssetCategory fromCat = AssetCategoryLocalServiceUtil.fetchAssetCategory(fromId);
                                    if (fromCat != null) {
                                        fromLocationName = fromCat.getName();
                                    }
                                } catch (NumberFormatException e) {
                                    fromLocationName = fromIdStr; // fallback if stored as text
                                }
                            }

                            // ✅ Fetch To Location name from category ID
                            String toIdStr = ticket.getToLocation();
                            if (toIdStr != null && !toIdStr.trim().isEmpty()) {
                                try {
                                    long toId = Long.parseLong(toIdStr);
                                    AssetCategory toCat = AssetCategoryLocalServiceUtil.fetchAssetCategory(toId);
                                    if (toCat != null) {
                                        toLocationName = toCat.getName();
                                    }
                                } catch (NumberFormatException e) {
                                    toLocationName = toIdStr; // fallback if stored as text
                                }
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
            %>
                        <tr>
                            <td><%= ticket.getBusNumber() %></td>
                            <td><%= fromLocationName %></td>
                            <td><%= toLocationName %></td>
                            <td><%= ticket.getJourneyDate() %></td>
                            <td><%= ticket.getSeatNumber() %></td>
                            <td><%= ticket.getFareAmount() %></td>
                            <td>
                                <!-- Edit Button -->
                                <portlet:renderURL var="editTicketURL">
                                    <portlet:param name="jspPage" value="/editTicket.jsp" />
                                    <portlet:param name="ticketId" value="<%= String.valueOf(ticket.getTicket_id()) %>" />
                                </portlet:renderURL>
                                <a href="${editTicketURL}" class="btn btn-success btn-xs">Edit</a>

                                <!-- Delete Button -->
                                <portlet:actionURL name="deleteTicket" var="deleteTicketURL">
                                    <portlet:param name="ticket_id" value="<%= String.valueOf(ticket.getTicket_id()) %>" />
                                </portlet:actionURL>
                                <a href="${deleteTicketURL}" 
                                   class="btn btn-danger btn-xs"
                                   onclick="return confirm('Are you sure you want to delete this ticket?');">
                                    Delete
                                </a>
                            </td>
                        </tr>
            <%
                    }
                } else {
            %>
                    <tr>
                        <td colspan="7" class="text-center text-muted">No tickets found</td>
                    </tr>
            <%
                }
            %>
        </tbody>
    </table>
</div>

<style>
/* Compact table styling */
.compact-table {
    font-size: 13px;
    margin-top: 5px;
}

.compact-table th, 
.compact-table td {
    padding: 6px 10px !important;
    vertical-align: middle;
}

.table thead {
    background-color: #0066cc;
    color: white;
}

.table-bordered {
    border: 1px solid #ddd;
}

.table-hover tbody tr:hover {
    background-color: #f1f7ff;
}

/* Buttons */
.btn {
    border-radius: 4px;
    font-weight: 500;
    text-decoration: none;
    transition: all 0.2s ease;
}

.btn-xs {
    padding: 3px 8px;
    font-size: 12px;
}
</style>
