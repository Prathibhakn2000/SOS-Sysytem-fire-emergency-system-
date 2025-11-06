package TicketMgmtSystemPortlet.portlet;

import TicketMgmtSystemPortlet.constants.TicketMgmtSystemPortletKeys;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date; // ✅ fixed import
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import TicketMgmtDB.model.TicketMgmt;
import TicketMgmtDB.service.TicketMgmtLocalServiceUtil;

/**
 * @author prath
 */
@Component(
    property = {
        "com.liferay.portlet.display-category=category.sample",
        "com.liferay.portlet.header-portlet-css=/css/main.css",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.display-name=TicketMgmtSystem",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.view-template=/view.jsp",
        "javax.portlet.name=" + TicketMgmtSystemPortletKeys.TICKETMGMTSYSTEM,
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user"
    },
    service = Portlet.class
)
public class TicketMgmtSystemPortlet extends MVCPortlet {
	 private static final Log
	    log = LogFactoryUtil.getLog(TicketMgmtSystemPortlet.class);

	
    public void addTicket(ActionRequest actionRequest, ActionResponse actionResponse)
            throws PortletException, java.io.IOException { 
    	
    
    	 String busNumber = ParamUtil.getString(actionRequest, "busNumber");
    	    String fromLocationId = ParamUtil.getString(actionRequest, "fromLocation");
    	    String toLocationId = ParamUtil.getString(actionRequest, "toLocation");
    	    Date journeyDate = ParamUtil.getDate(actionRequest, "journeyDate", new SimpleDateFormat("yyyy-MM-dd"));
    	    int seatNumber = ParamUtil.getInteger(actionRequest, "seatNumber");
    	    long fareAmount = ParamUtil.getLong(actionRequest, "fareAmount");

    	    // ✅ Convert category IDs → category names
    	    String fromLocation = "";
    	    String toLocation = "";

    	    try {
    	        if (Validator.isNotNull(fromLocationId)) {
    	            AssetCategory fromCat = AssetCategoryLocalServiceUtil.fetchAssetCategory(Long.parseLong(fromLocationId));
    	            if (fromCat != null) {
    	                fromLocation = fromCat.getName();
    	            }
    	        }

    	        if (Validator.isNotNull(toLocationId)) {
    	            AssetCategory toCat = AssetCategoryLocalServiceUtil.fetchAssetCategory(Long.parseLong(toLocationId));
    	            if (toCat != null) {
    	                toLocation = toCat.getName();
    	            }
    	        }
    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    }

    	    TicketMgmt ticketMgmt = TicketMgmtLocalServiceUtil.createTicketMgmt(0);

    	    ticketMgmt.setBusNumber(busNumber);
    	    ticketMgmt.setFromLocation(fromLocation); // ✅ Save category name
    	    ticketMgmt.setToLocation(toLocation);     // ✅ Save category name

    	    if (journeyDate != null) {
    	        ticketMgmt.setJourneyDate(new java.sql.Date(journeyDate.getTime()));
    	    }

    	    ticketMgmt.setSeatNumber(seatNumber);
    	    ticketMgmt.setFareAmount(fareAmount);

    	    TicketMgmtLocalServiceUtil.addTicketMgmt(ticketMgmt);
    	}
    

    public void editTicket(ActionRequest actionRequest, ActionResponse actionResponse)
            throws IOException, PortletException, java.text.ParseException {

        log.info("Editing ticket data...");

        long ticketId = ParamUtil.getLong(actionRequest, "ticket_id");

        log.info("Ticket ID: " + ticketId);

        String busNumber = ParamUtil.getString(actionRequest, "busNumber");
        String fromLocation = ParamUtil.getString(actionRequest, "fromLocation");
        String toLocation = ParamUtil.getString(actionRequest, "toLocation");

        // ✅ Proper date parsing with SimpleDateFormat (instead of ParamUtil.getDate)
        String journeyDateStr = ParamUtil.getString(actionRequest, "journeyDate");
        Date journeyDate = null;
        if (Validator.isNotNull(journeyDateStr)) {
		    journeyDate = new SimpleDateFormat("yyyy-MM-dd").parse(journeyDateStr);
		}

        int seatNumber = ParamUtil.getInteger(actionRequest, "seatNumber");
        long fareAmount = ParamUtil.getLong(actionRequest, "fareAmount");

        // ✅ Fetch record from DB
        TicketMgmt ticketMgmt = TicketMgmtLocalServiceUtil.fetchTicketMgmt(ticketId);

        if (ticketMgmt != null) {
            ticketMgmt.setBusNumber(busNumber);
            ticketMgmt.setFromLocation(fromLocation);
            ticketMgmt.setToLocation(toLocation);
            ticketMgmt.setJourneyDate(journeyDate);
            ticketMgmt.setSeatNumber(seatNumber);
            ticketMgmt.setFareAmount(fareAmount);
	
    	
    	TicketMgmt  ticketMgmt1=TicketMgmtLocalServiceUtil.updateTicketMgmt(ticketMgmt);
    log.info("Data Saved");
    

        }
    }
    
    
    public void deleteTicket(ActionRequest actionRequest, ActionResponse actionResponse)
            throws IOException, PortletException, PortalException {

        long ticket_id = ParamUtil.getLong(actionRequest, "ticket_id");

        TicketMgmt ticketMgmt = TicketMgmtLocalServiceUtil.fetchTicketMgmt(ticket_id);

        if (ticketMgmt != null) {
        	TicketMgmtLocalServiceUtil.deleteTicketMgmt(ticket_id);
        }
    }

}
