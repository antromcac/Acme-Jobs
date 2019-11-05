
package acme.features.authenticated.requests;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requestss.Requests;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedRequestsListService implements AbstractListService<Authenticated, Requests> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AuthenticatedRequestsRepository repository;


	// AbstractListService<Administrator, Shout> interface --------------------

	@Override
	public boolean authorise(final Request<Requests> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Requests> request, final Requests entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "moment", "deadline", "title");//atributos del modelo al listado(los que apareceran en el listado)
	}

	@Override
	public Collection<Requests> findMany(final Request<Requests> request) {
		assert request != null;

		Collection<Requests> result;

		result = this.repository.findManyAll();

		return result;
	}
}
