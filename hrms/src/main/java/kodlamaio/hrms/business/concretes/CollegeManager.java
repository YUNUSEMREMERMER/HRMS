package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstacts.CollegeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstacts.CollegeDao;
import kodlamaio.hrms.entities.concretes.College;

@Service
public class CollegeManager implements CollegeService{
	
	private CollegeDao collegeDao;

	@Autowired
	public CollegeManager(CollegeDao collegeDao) {
		this.collegeDao = collegeDao;
	}

	@Override
	public Result add(College college) {
		this.collegeDao.save(college);
		return new SuccessResult("College is added.");
	}

	@Override
	public DataResult<List<College>> getAll() {
		return new SuccessDataResult<List<College>>(this.collegeDao.findAll());
	}

	@Override
	public DataResult<College> getById(int id) {
		return new SuccessDataResult<College>(this.collegeDao.getById(id));
	}

	@Override
	public DataResult<List<College>> getByCandidates_Id(int candidateId) {
		return new SuccessDataResult<List<College>>(this.collegeDao.getByCandidates_Id(candidateId));
	}

	

}
