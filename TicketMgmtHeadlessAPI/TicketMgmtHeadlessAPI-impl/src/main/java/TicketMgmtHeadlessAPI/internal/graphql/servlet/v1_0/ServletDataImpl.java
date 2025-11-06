package TicketMgmtHeadlessAPI.internal.graphql.servlet.v1_0;

import TicketMgmtHeadlessAPI.internal.graphql.mutation.v1_0.Mutation;
import TicketMgmtHeadlessAPI.internal.graphql.query.v1_0.Query;

import TicketMgmtHeadlessAPI.resource.v1_0.TicketMgmtResource;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author prath
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setTicketMgmtResourceComponentServiceObjects(
			_ticketMgmtResourceComponentServiceObjects);

		Query.setTicketMgmtResourceComponentServiceObjects(
			_ticketMgmtResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/TicketMgmtHeadlessAPI-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<TicketMgmtResource>
		_ticketMgmtResourceComponentServiceObjects;

}