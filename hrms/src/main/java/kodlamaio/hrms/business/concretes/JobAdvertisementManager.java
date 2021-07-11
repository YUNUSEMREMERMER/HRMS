package kodlamaio.hrms.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstacts.CityService;
import kodlamaio.hrms.business.abstacts.EmployerService;
import kodlamaio.hrms.business.abstacts.JobAdvertisementService;
import kodlamaio.hrms.business.abstacts.JobPositionService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstacts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementForAddDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{
	
	private JobAdvertisementDao jobAdvertisementDao;
    private JobPositionService jobPositionService;
    private CityService cityService;
    private EmployerService employerService;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, JobPositionService jobPositionService, CityService cityService,EmployerService employerService) {
        this.jobAdvertisementDao = jobAdvertisementDao;
        this.jobPositionService = jobPositionService;
        this.cityService = cityService;
        this.employerService = employerService;
    }

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		 return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), "Listelendi");
	}

	@Override
    public DataResult<List<JobAdvertisement>> findByIsActiveTrue() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrue());
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByCreateDate() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrueOrderByCreateDate());
    }

    @Override
    public DataResult<List<JobAdvertisement>> finfByIsActiveTrueAndEmployer_Id(int employerId) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrueAndEmployer_Id(employerId));
    }

	@Override
	public Result add(JobAdvertisementForAddDto jobAdvertisement) {
		 Result businessRules = BusinessRules.run(
	                isJobPositionValid(jobAdvertisement.getJobPositionId()),
	                isJobDescriptionValid(jobAdvertisement.getJobDescription()),
	                isCityValid(jobAdvertisement.getCityId()),
	                isOpenPositionValid(jobAdvertisement.getOpenPositionCount()),
	                isEndDateValid(jobAdvertisement.getLastApplyDate()),
	                isEmployerExist(jobAdvertisement.getEmployerId())
	        );
		 
	        if (businessRules != null)
	            return businessRules;


	        JobAdvertisement jobAdvertisementToAdd = new JobAdvertisement(
	                jobAdvertisement.getJobDescription(),
	                jobAdvertisement.getMinSalary(),
	                jobAdvertisement.getMaxSalary(),
	                jobAdvertisement.getOpenPositionCount(),
	                jobAdvertisement.getLastApplyDate(),
	                new Date(),
	                jobAdvertisement.isActive()
	        );

	        jobAdvertisementToAdd.setCity(this.cityService.getById(jobAdvertisement.getCityId()).getData());
	        jobAdvertisementToAdd.setJobPosition(this.jobPositionService.getById(jobAdvertisement.getJobPositionId()).getData());
	        jobAdvertisementToAdd.setEmployer(this.employerService.getById(jobAdvertisement.getEmployerId()).getData());
	        this.jobAdvertisementDao.save(jobAdvertisementToAdd);

	        return new SuccessResult("İş ilanı başarılı bir şekilde oluşturuldu.");
	}
	
	
	
	@Override
	public Result changeStatus(int jobadvertisementId, int employerId) {
		JobAdvertisement jobAdvertisementToUpdate = this.jobAdvertisementDao.findByIdAndEmployer_Id(jobadvertisementId, employerId);
        if (jobAdvertisementToUpdate == null)
            return new ErrorResult("Bu kriterlere uyan bir iş ilanı bulamadı. Böyle bir iş ilanı yok veya bu iş ilanı bu şirkete ait değil");
        jobAdvertisementToUpdate.setActive(!jobAdvertisementToUpdate.isActive());
        this.jobAdvertisementDao.save(jobAdvertisementToUpdate);
        return new SuccessResult("Belirtilen iş ilanı " + (jobAdvertisementToUpdate.isActive() ? "aktif" : "pasif") + " hale getirildi.");
	}
	
	
	
	private Result isJobPositionValid(int id) {
        if (id <= 0)
            return new ErrorResult("İş pozisyonu doğru girilmedi.");
        if (this.jobPositionService.getById(id).getData() == null)
            return new ErrorResult("Böyle bir iş pozisyonu yok.");
        return new SuccessResult();
    }

    private Result isJobDescriptionValid(String jobDescription) {
        if (jobDescription == null || jobDescription.equals(""))
            return new ErrorResult("İş açıklaması doğru girilemedi");
        return new SuccessResult();
    }

    private Result isCityValid(int id) {
        if (id <= 0)
            return new ErrorResult("Şehir doğru girilemedi.");
        if (this.cityService.getById(id).getData() == null)
            return new ErrorResult("Böyle bir şehir bulunmamaktadır.");
        return new SuccessResult();
    }

    private Result isOpenPositionValid(int count) {
        if (count <= 0)
            return new ErrorResult("Açık iş pozisyonu 0 ve 0'dan küçük olamaz.");
        return new SuccessResult();
    }

    private Result isEndDateValid(Date endDate) {
        if (new Date().compareTo(endDate) > 0)
            return new ErrorResult("Son başvuru tarihi iş ilanı tarihinden önce olamaz.");
        return new SuccessResult();
    }
    
    private Result isEmployerExist(int employerId) {
    	
    	if (!this.employerService.existById(employerId))
            return new ErrorResult("Böyle bir iş veren firma yok.");
    	return new SuccessResult();
    	
    }
	
	

}
