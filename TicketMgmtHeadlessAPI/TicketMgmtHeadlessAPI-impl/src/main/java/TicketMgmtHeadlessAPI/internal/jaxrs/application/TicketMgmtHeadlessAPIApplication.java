package TicketMgmtHeadlessAPI.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author prath
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false",
		"osgi.jaxrs.application.base=/TicketMgmtHeadlessAPI",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=TicketMgmtHeadlessAPI"
	},
	service = Application.class
)
@Generated("")
public class TicketMgmtHeadlessAPIApplication extends Application {
}