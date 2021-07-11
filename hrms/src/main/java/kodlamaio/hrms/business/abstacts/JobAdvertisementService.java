package kodlamaio.hrms.business.abstacts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementForAddDto;

public interface JobAdvertisementService {
	
	DataResult<List<JobAdvertisement>> getAll();

    DataResult<List<JobAdvertisement>> findByIsActiveTrue();

    DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByCreateDate();

    DataResult<List<JobAdvertisement>> finfByIsActiveTrueAndEmployer_Id(int employerId);

    Result add(JobAdvertisementForAddDto jobAdvertisementForAddDto);

    Result changeStatus(int jobadvertisementId, int employerId);

}
