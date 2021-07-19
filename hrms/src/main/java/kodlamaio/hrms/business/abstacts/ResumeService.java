package kodlamaio.hrms.business.abstacts;



import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeDto;

public interface ResumeService {
		
    DataResult<ResumeDto> getByCandidateId(int candidateId);
	
	Result add(Resume resume);
	

}
