package kodlamaio.hrms.business.abstacts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CoverLetter;

public interface CoverLetterService {

	Result add(CoverLetter coverLetter);
	DataResult<CoverLetter> getByCandidates_Id(int candidatesId);
}
