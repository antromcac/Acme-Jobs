
package acme.features.anonymous.companyRecords;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.companyRecords.CompanyRecords;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousCompanyRecordsRepository extends AbstractRepository {

	@Query("select a from CompanyRecords a where a.id =?1")
	CompanyRecords findOnebyId(int id);

	@Query("select a from CompanyRecords a")
	Collection<CompanyRecords> findManyAll();

}
