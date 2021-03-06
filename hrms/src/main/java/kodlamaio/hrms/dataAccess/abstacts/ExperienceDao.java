package kodlamaio.hrms.dataAccess.abstacts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Experience;

public interface ExperienceDao extends JpaRepository<Experience,Integer>{
	
	Experience getById(int id);
	
	List<Experience> getByCandidates_Id(int candidatesId);
	
	List<Experience> findByOrderByEndDateDesc();

}
