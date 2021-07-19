package kodlamaio.hrms.dataAccess.abstacts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Resume;

public interface ResumeDao extends  JpaRepository<Resume, Integer>{
	
	List<Resume> getByCandidate_Id(int candidateId);

}
