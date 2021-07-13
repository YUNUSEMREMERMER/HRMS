package kodlamaio.hrms.business.abstacts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Experience;

public interface ExperienceService {
	
	Result add(Experience experience);
	
	DataResult<List<Experience>> getAll();
	
	DataResult<Experience> getById(int id);
	
	DataResult<List<Experience>> getByCandidates_Id(int candidateId);
	
	DataResult<List<Experience>> findByOrderByEndDateDesc();

}
