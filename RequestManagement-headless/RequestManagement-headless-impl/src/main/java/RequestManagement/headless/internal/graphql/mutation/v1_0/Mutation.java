package RequestManagement.headless.internal.graphql.mutation.v1_0;

import RequestManagement.headless.dto.v1_0.EmrgcyRequest;
import RequestManagement.headless.resource.v1_0.EmrgcyRequestResource;

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

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author prath
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setEmrgcyRequestResourceComponentServiceObjects(
		ComponentServiceObjects<EmrgcyRequestResource>
			emrgcyRequestResourceComponentServiceObjects) {

		_emrgcyRequestResourceComponentServiceObjects =
			emrgcyRequestResourceComponentServiceObjects;
	}

	@GraphQLField(description = "add emergency request")
	public EmrgcyRequest addEmrgcyRequest(
			@GraphQLName("emrgcyRequest") EmrgcyRequest emrgcyRequest)
		throws Exception {

		return _applyComponentServiceObjects(
			_emrgcyRequestResourceComponentServiceObjects,
			this::_populateResourceContext,
			emrgcyRequestResource -> emrgcyRequestResource.addEmrgcyRequest(
				emrgcyRequest));
	}

	@GraphQLField(description = "partially update emergency request")
	public EmrgcyRequest patchEmrgcyRequest(
			@GraphQLName("requestId") Long requestId,
			@GraphQLName("emrgcyRequest") EmrgcyRequest emrgcyRequest)
		throws Exception {

		return _applyComponentServiceObjects(
			_emrgcyRequestResourceComponentServiceObjects,
			this::_populateResourceContext,
			emrgcyRequestResource -> emrgcyRequestResource.patchEmrgcyRequest(
				requestId, emrgcyRequest));
	}

	@GraphQLField(description = "update emergency request")
	public EmrgcyRequest updateEmrgcyRequest(
			@GraphQLName("requestId") Long requestId,
			@GraphQLName("emrgcyRequest") EmrgcyRequest emrgcyRequest)
		throws Exception {

		return _applyComponentServiceObjects(
			_emrgcyRequestResourceComponentServiceObjects,
			this::_populateResourceContext,
			emrgcyRequestResource -> emrgcyRequestResource.updateEmrgcyRequest(
				requestId, emrgcyRequest));
	}

	@GraphQLField(description = "delete emergency request")
	public EmrgcyRequest deleteEmrgcyRequest(
			@GraphQLName("requestId") Long requestId)
		throws Exception {

		return _applyComponentServiceObjects(
			_emrgcyRequestResourceComponentServiceObjects,
			this::_populateResourceContext,
			emrgcyRequestResource -> emrgcyRequestResource.deleteEmrgcyRequest(
				requestId));
	}

	@GraphQLField
	public Response deleteEmrgcyRequestBatch(
			@GraphQLName("requestId") Long requestId,
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_emrgcyRequestResourceComponentServiceObjects,
			this::_populateResourceContext,
			emrgcyRequestResource ->
				emrgcyRequestResource.deleteEmrgcyRequestBatch(
					requestId, callbackURL, object));
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

	private void _populateResourceContext(
			EmrgcyRequestResource emrgcyRequestResource)
		throws Exception {

		emrgcyRequestResource.setContextAcceptLanguage(_acceptLanguage);
		emrgcyRequestResource.setContextCompany(_company);
		emrgcyRequestResource.setContextHttpServletRequest(_httpServletRequest);
		emrgcyRequestResource.setContextHttpServletResponse(
			_httpServletResponse);
		emrgcyRequestResource.setContextUriInfo(_uriInfo);
		emrgcyRequestResource.setContextUser(_user);
		emrgcyRequestResource.setGroupLocalService(_groupLocalService);
		emrgcyRequestResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<EmrgcyRequestResource>
		_emrgcyRequestResourceComponentServiceObjects;

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