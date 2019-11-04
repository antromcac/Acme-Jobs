
package acme.features.authenticated.requests;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.requestss.Requests;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedRequestsRepository extends AbstractRepository {

	@Query("select r from Requests r where r.id =?1")
	Requests findOnebyId(int id);

	@Query("select r from Requests r")
	Collection<Requests> findManyAll();

}
