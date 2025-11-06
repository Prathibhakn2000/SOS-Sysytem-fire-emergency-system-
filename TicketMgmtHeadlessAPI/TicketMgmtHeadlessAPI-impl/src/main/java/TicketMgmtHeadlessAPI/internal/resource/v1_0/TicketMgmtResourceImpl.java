package TicketMgmtHeadlessAPI.internal.resource.v1_0;

import TicketMgmtHeadlessAPI.dto.v1_0.TicketMgmt;
import TicketMgmtHeadlessAPI.resource.v1_0.TicketMgmtResource;

import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.access.control.AccessControlled;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;


@Component(
    properties = "OSGI-INF/liferay/rest/v1_0/ticket-mgmt.properties",
    scope = org.osgi.service.component.annotations.ServiceScope.PROTOTYPE,
    service = TicketMgmtResource.class
)
@AccessControlled(guestAccessEnabled = true)
public class TicketMgmtResourceImpl extends BaseTicketMgmtResourceImpl {

    private static final Log _log = LogFactoryUtil.getLog(TicketMgmtResourceImpl.class);

    @Reference
    private TicketMgmtDB.service.TicketMgmtLocalService _ticketMgmtLocalService;

    @AccessControlled(guestAccessEnabled = true)
    @Override
    public Page<TicketMgmt> getTickets() throws Exception {
        List<TicketMgmtDB.model.TicketMgmt> tickets = _ticketMgmtLocalService.getTicketMgmts(-1, -1);
        List<TicketMgmt> ticketDTOs = tickets.stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
        return Page.of(ticketDTOs);
    }

    @Override
    public TicketMgmt addTicket(TicketMgmt dto) throws Exception {
        TicketMgmtDB.model.TicketMgmt ticket = _ticketMgmtLocalService.createTicketMgmt(0);
        ticket.setGroupId(dto.getGroupId());
        ticket.setCompanyId(dto.getCompanyId());
        ticket.setUserId(dto.getUserId());
        ticket.setUserName(dto.getUserName());
        ticket.setBusNumber(dto.getBusNumber());

        // Convert category IDs to names before saving
        String fromLocationName = "";
        String toLocationName = "";
        try {
            AssetCategory fromCategory = AssetCategoryLocalServiceUtil.getAssetCategory(Long.parseLong(dto.getFromLocation()));
            fromLocationName = fromCategory.getName();
        } catch (Exception e) {
            fromLocationName = dto.getFromLocation(); // fallback
        }

        try {
            AssetCategory toCategory = AssetCategoryLocalServiceUtil.getAssetCategory(Long.parseLong(dto.getToLocation()));
            toLocationName = toCategory.getName();
        } catch (Exception e) {
            toLocationName = dto.getToLocation(); // fallback
        }

        ticket.setFromLocation(fromLocationName);
        ticket.setToLocation(toLocationName);

        ticket.setJourneyDate(dto.getJourneyDate());
        ticket.setSeatNumber(dto.getSeatNumber());
        ticket.setFareAmount(dto.getFareAmount());

        ticket = _ticketMgmtLocalService.addTicketMgmt(ticket);
        return toDTO(ticket);
    }


    @Override
    public TicketMgmt updateTicket(TicketMgmt dto) throws Exception {
        TicketMgmtDB.model.TicketMgmt ticket = _ticketMgmtLocalService.getTicketMgmt(dto.getTicketId());
        ticket.setBusNumber(dto.getBusNumber());
        ticket.setFromLocation(dto.getFromLocation());
        ticket.setToLocation(dto.getToLocation());
        ticket.setJourneyDate(dto.getJourneyDate());
        ticket.setSeatNumber(dto.getSeatNumber());
        ticket.setFareAmount(dto.getFareAmount());
        ticket.setModifiedDate(dto.getModifiedDate());

        ticket = _ticketMgmtLocalService.updateTicketMgmt(ticket);
        return toDTO(ticket);
    }

    @Override
    public TicketMgmt deleteTicket(Long ticketId) throws Exception {
        TicketMgmtDB.model.TicketMgmt deleted = _ticketMgmtLocalService.deleteTicketMgmt(ticketId);
        return toDTO(deleted);
    }

    private TicketMgmt toDTO(TicketMgmtDB.model.TicketMgmt entity) {
        TicketMgmt dto = new TicketMgmt();

        dto.setTicketId(entity.getTicket_id());
        dto.setGroupId(entity.getGroupId());
        dto.setCompanyId(entity.getCompanyId());
        dto.setUserId(entity.getUserId());
        dto.setUserName(entity.getUserName());
        dto.setBusNumber(entity.getBusNumber());
        dto.setFromLocation(entity.getFromLocation());
        dto.setToLocation(entity.getToLocation());
        dto.setJourneyDate(entity.getJourneyDate());
        dto.setSeatNumber(entity.getSeatNumber());
        dto.setFareAmount(entity.getFareAmount());
        dto.setCreateDate(entity.getCreateDate());
        dto.setModifiedDate(entity.getModifiedDate());
        return dto;
    }

	@Override
	public void setContextBatchUnsafeBiConsumer(
			UnsafeBiConsumer<Collection<TicketMgmt>, UnsafeFunction<TicketMgmt, TicketMgmt, Exception>, Exception> contextBatchUnsafeBiConsumer) {
		// TODO Auto-generated method stub
		
	}
}
