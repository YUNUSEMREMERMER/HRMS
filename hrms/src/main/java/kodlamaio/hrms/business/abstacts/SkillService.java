package kodlamaio.hrms.business.abstacts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Skill;

public interface SkillService {
	
	Result add(Skill skills);
	
	DataResult<List<Skill>> getAll();
	
	DataResult<Skill> getById(int id);
	
	DataResult<List<Skill>> getByCandidates_Id(int candidatesId);

}
