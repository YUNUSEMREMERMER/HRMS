package kodlamaio.hrms.dataAccess.abstacts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	
	List<JobAdvertisement> findByIsActiveTrue();

    List<JobAdvertisement> findByIsActiveTrueOrderByCreateDate();

    List<JobAdvertisement> findByIsActiveTrueAndEmployer_Id(int employerId);

    JobAdvertisement findByIdAndEmployer_Id(int jobadvertisementId, int employerId);

}
