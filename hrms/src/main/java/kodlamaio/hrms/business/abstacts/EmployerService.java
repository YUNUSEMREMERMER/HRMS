package kodlamaio.hrms.business.abstacts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService {
	

	DataResult<List<Employer>> getAll();
	
	Result add(Employer employer);
	
	DataResult<Employer> getById(int id); 
	
	Boolean existById(int id);

}
