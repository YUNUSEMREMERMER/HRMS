package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstacts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstacts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{
	
	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		
		return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll());
	}

	@Override
	public Result add(JobPosition jobPosition) {
		
		if(!CheckTitle(jobPosition.getTitle())) {
			return new ErrorResult("Title tekrar edemez!");
		}
		
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("Pozisyon eklendi.");
		
	}
	
	
	@Override
	public DataResult<JobPosition> getById(int id) {
        JobPosition jobPosition = this.jobPositionDao.getById(id);
        if (jobPosition == null)
            return new ErrorDataResult<JobPosition>();
        return new SuccessDataResult<JobPosition>(jobPosition);
    }
	
	
	
	
	private boolean CheckTitle(String title) {
		if(this.jobPositionDao.getByTitle(title) == null) {
			return true;
		}
		return false;
	}

	

}
