package kodlamaio.hrms.dataAccess.abstacts;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hrms.entities.concretes.JobPosition;


public interface JobPositionDao extends JpaRepository<JobPosition,Integer>{
	
	JobPosition getByTitle(String title);

}
