
package acme.features.anonymous.investorRecord;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investorRecords.InvestorRecord;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractShowService;

@Service
public class AnonymousInvestorRecordShowFiveStarsService implements AbstractShowService<Anonymous, InvestorRecord> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AnonymousInvestorRecordRepository repository;


	@Override
	public boolean authorise(final Request<InvestorRecord> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<InvestorRecord> request, final InvestorRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "sector", "invStatement", "stars");
	}

	@Override
	public InvestorRecord findOne(final Request<InvestorRecord> request) {
		assert request != null;

		Collection<InvestorRecord> list;

		list = this.repository.findManyAll();
		InvestorRecord result = list.stream().filter(x -> x.getStars() == 5).findFirst().get();

		return result;
	}
}
