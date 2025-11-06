package RequestManagement.headless.internal.graphql.servlet.v1_0;

import RequestManagement.headless.internal.graphql.mutation.v1_0.Mutation;
import RequestManagement.headless.internal.graphql.query.v1_0.Query;
import RequestManagement.headless.resource.v1_0.EmrgcyRequestResource;

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
		Mutation.setEmrgcyRequestResourceComponentServiceObjects(
			_emrgcyRequestResourceComponentServiceObjects);

		Query.setEmrgcyRequestResourceComponentServiceObjects(
			_emrgcyRequestResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/RequestManagement-headless-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<EmrgcyRequestResource>
		_emrgcyRequestResourceComponentServiceObjects;

}