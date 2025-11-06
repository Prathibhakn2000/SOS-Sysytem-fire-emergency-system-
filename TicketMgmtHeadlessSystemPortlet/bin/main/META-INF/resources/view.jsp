<%@ include file="/init.jsp" %>

<h3><b>🎟 Ticket Management (Headless API)</b></h3>

<!-- Add Ticket Form -->
<form id="addTicketForm">
    <label>Bus Number:</label>
    <input type="text" id="busNumber" required><br><br>

    <label>From:</label>
    <input type="text" id="fromLocation" required><br><br>

    <label>To:</label>
    <input type="text" id="toLocation" required><br><br>

    <label>Journey Date:</label>
    <input type="date" id="journeyDate" required><br><br>

    <label>Seat Number:</label>
    <input type="text" id="seatNumber" required><br><br>

    <label>Fare:</label>
    <input type="number" id="fareAmount" required><br><br>

    <button type="submit">Add Ticket</button>
</form>

<hr>

<!-- Ticket List -->
<div id="ticketList" style="margin-top: 20px;"></div>

<script>
$(document).ready(function(){

    const resourceURL = '<%= renderResponse.createResourceURL() %>';

    // ✅ Load all tickets (GET)
    function loadTickets() {
        $.ajax({
            url: resourceURL,
            type: 'GET',
            dataType: 'json',
            success: function(data) {
                let html = "<table border='1' cellpadding='5'>" +
                           "<tr>" +
                           "<th>ID</th><th>Bus</th><th>From</th><th>To</th>" +
                           "<th>Date</th><th>Seat</th><th>Fare</th>" +
                           "</tr>";

                if (data && data.items && data.items.length > 0) {
                    data.items.forEach(ticket => {
                        html += `<tr>
                            <td>${ticket.ticketId || ''}</td>
                            <td>${ticket.busNumber || ''}</td>
                            <td>${ticket.fromLocation || ''}</td>
                            <td>${ticket.toLocation || ''}</td>
                            <td>${ticket.journeyDate ? ticket.journeyDate.substring(0,10) : ''}</td>
                            <td>${ticket.seatNumber || ''}</td>
                            <td>${ticket.fareAmount || ''}</td>
                        </tr>`;
                    });
                } else {
                    html += "<tr><td colspan='7'>No tickets found</td></tr>";
                }

                html += "</table>";
                $("#ticketList").html(html);
            },
            error: function(err) {
                $("#ticketList").html("<p style='color:red;'>Failed to load tickets.</p>");
                console.error("❌ Error loading:", err);
            }
        });
    }

    // ✅ Add Ticket (POST)
    $("#addTicketForm").on("submit", function(e){
        e.preventDefault();

        const ticketData = {
            busNumber: $("#busNumber").val(),
            fromLocation: $("#fromLocation").val(),
            toLocation: $("#toLocation").val(),
            journeyDate: $("#journeyDate").val(),
            seatNumber: $("#seatNumber").val(),
            fareAmount: parseFloat($("#fareAmount").val())
        };

        $.ajax({
            url: resourceURL,
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(ticketData),
            success: function(){
                alert("✅ Ticket added successfully!");
                loadTickets();
                $("#addTicketForm")[0].reset();
            },
            error: function(err){
                alert("❌ Failed to add ticket.");
                console.error(err);
            }
        });
    });

    // Load on page load
    loadTickets();
});
</script>
