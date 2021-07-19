package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstacts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.verification.abstracts.EmailCheckService;
import kodlamaio.hrms.core.verification.abstracts.MernisCheckService;
import kodlamaio.hrms.dataAccess.abstacts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{
	
	private CandidateDao candidateDao;
	private MernisCheckService mernisCheckService;
	private EmailCheckService emailCheckService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao,MernisCheckService mernisCheckService,EmailCheckService emailCheckService) {
		this.candidateDao = candidateDao;
		this.mernisCheckService = mernisCheckService;
		this.emailCheckService = emailCheckService;
	}
 
	@Override
	public DataResult<List<Candidate>> getAll() {
		
		return new SuccessDataResult<List<Candidate>>(candidateDao.findAll(),"Data Listelendi"); 
	}
	
	@Override
	public DataResult<Candidate> getById(int id) {
		
        return new SuccessDataResult<Candidate>(candidateDao.findById(id));
        
	}

	@Override
	public Result add(Candidate candidate) {
		
		if(candidate.getFirstName().isEmpty() || candidate.getLastName().isEmpty()
				|| candidate.getEmail().isEmpty() || candidate.getPassword().isEmpty()
				|| candidate.getNationalIdentity().isEmpty() || candidate.getBirthYear() == 0)
		{
			
			return new ErrorResult("Tüm alanları doldurunuz!");
		}
		
		else if(!checkEmail(candidate.getEmail())) {
			return new ErrorResult("Email kullanılmaktadır!");
		}
		
		else if(!checkNationalIdentity(candidate.getNationalIdentity())) {
			return new ErrorResult("TC kimlik numarası kullanılmaktadır!");
		}
		
		else if(!this.mernisCheckService.checkIfRealPerson(candidate)) {
			return new ErrorResult("Mernis doğrulamasından geçemedi!");
		}
		
		else if(!this.emailCheckService.CheckIfRealEmail(candidate)) {
			return new ErrorResult("Email gerçek değil!");
		}
		else {
		this.candidateDao.save(candidate);
		return new SuccessResult("Kayıt başarılı");
		}
		
		
	}
	
	
	
	private boolean checkEmail(String email) {
		if (this.candidateDao.getByEmail(email) == null) {
			return true;
		}
		return false;
	}
	
	private boolean checkNationalIdentity(String nationalIdentity) {
		if(this.candidateDao.getByNationalIdentity(nationalIdentity) == null) {
			return true;
		}
		return false;
	}

	
	
	

}
