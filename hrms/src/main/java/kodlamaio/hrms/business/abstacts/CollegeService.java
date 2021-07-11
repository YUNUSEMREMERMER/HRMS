package kodlamaio.hrms.business.abstacts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.College;

public interface CollegeService {
	
	Result add(College college);
	
	DataResult<List<College>> getAll();
	
	DataResult<College> getById(int id);
	
	DataResult<List<College>> getByCandidates_Id(int candidateId);

}
