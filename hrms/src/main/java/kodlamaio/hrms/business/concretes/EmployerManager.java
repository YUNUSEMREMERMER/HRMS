package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstacts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.verification.abstracts.EmailCheckService;
import kodlamaio.hrms.core.verification.abstracts.HrmsCheckService;
import kodlamaio.hrms.dataAccess.abstacts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private EmailCheckService emailCheckService;
	private HrmsCheckService hrmsCheckService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,EmailCheckService emailCheckService,HrmsCheckService hrmsCheckService) {
		super();
		this.employerDao = employerDao;
		this.emailCheckService = emailCheckService;
		this.hrmsCheckService = hrmsCheckService;
	}
	
	
	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "İş verenler listelendi");
	}
	@Override
	public Result add(Employer employer) {
		
		 if(employer.getCompanyName().isEmpty() || employer.getEmail().isEmpty()
				 || employer.getPassword().isEmpty() || employer.getPhoneNumber().isEmpty()
				 || employer.getWebAddress().isEmpty()) {
			 return new ErrorResult("Tüm alanları doldurunuz!");
		 }
		 
		 else if(!checkEmail(employer.getEmail())) {
			 return new ErrorResult("Email kullanılmaktadır!");
		 }
		 
		 else if(!this.emailCheckService.CheckIfRealEmail(employer)) {
			 return new ErrorResult("Email geçerli değil!");
		 }
		 
		 else if(!this.hrmsCheckService.checkIfConfirmHrms(employer)) {
			 return new ErrorResult("Hrms personeli onaylamadı!");
		 }
		 
		 this.employerDao.save(employer);
		 return new SuccessResult("Kayıt başarılı");
		
		
	}
	
	@Override
    public Boolean existById(int id) {
        boolean employer = this.employerDao.existsById(id);
        if (!employer)
            return false;
        return true;
    }
	
	@Override
    public DataResult<Employer> getById(int id) {
        Employer employer = this.employerDao.getById(id);
        if (employer.equals(null))
            return new ErrorDataResult<Employer>();
        return new SuccessDataResult<Employer>(employer);
    }
	
	
	private boolean checkEmail(String email) {
		if(this.employerDao.getByEmail(email) == null) {
			return true;
		}
		return false;
	}

}
