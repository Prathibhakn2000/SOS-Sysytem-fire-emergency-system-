package TicketMgmtHeadlessAPI.internal.graphql.mutation.v1_0;

import TicketMgmtHeadlessAPI.dto.v1_0.TicketMgmt;

import TicketMgmtHeadlessAPI.resource.v1_0.TicketMgmtResource;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author prath
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setTicketMgmtResourceComponentServiceObjects(
		ComponentServiceObjects<TicketMgmtResource>
			ticketMgmtResourceComponentServiceObjects) {

		_ticketMgmtResourceComponentServiceObjects =
			ticketMgmtResourceComponentServiceObjects;
	}

	@GraphQLField(description = "Book a new ticket")
	public TicketMgmt addTicket(
			@GraphQLName("ticketMgmt") TicketMgmt ticketMgmt)
		throws Exception {

		return _applyComponentServiceObjects(
			_ticketMgmtResourceComponentServiceObjects,
			this::_populateResourceContext,
			ticketMgmtResource -> ticketMgmtResource.addTicket(ticketMgmt));
	}

	@GraphQLField(description = "Update existing ticket details")
	public TicketMgmt updateTicket(
			@GraphQLName("ticketMgmt") TicketMgmt ticketMgmt)
		throws Exception {

		return _applyComponentServiceObjects(
			_ticketMgmtResourceComponentServiceObjects,
			this::_populateResourceContext,
			ticketMgmtResource -> ticketMgmtResource.updateTicket(ticketMgmt));
	}

	@GraphQLField(description = "Delete ticket by ID")
	public TicketMgmt deleteTicket(@GraphQLName("ticketId") Long ticketId)
		throws Exception {

		return _applyComponentServiceObjects(
			_ticketMgmtResourceComponentServiceObjects,
			this::_populateResourceContext,
			ticketMgmtResource -> ticketMgmtResource.deleteTicket(ticketId));
	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(TicketMgmtResource ticketMgmtResource)
		throws Exception {

		ticketMgmtResource.setContextAcceptLanguage(_acceptLanguage);
		ticketMgmtResource.setContextCompany(_company);
		ticketMgmtResource.setContextHttpServletRequest(_httpServletRequest);
		ticketMgmtResource.setContextHttpServletResponse(_httpServletResponse);
		ticketMgmtResource.setContextUriInfo(_uriInfo);
		ticketMgmtResource.setContextUser(_user);
		ticketMgmtResource.setGroupLocalService(_groupLocalService);
		ticketMgmtResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<TicketMgmtResource>
		_ticketMgmtResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}