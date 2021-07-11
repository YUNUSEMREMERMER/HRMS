package kodlamaio.hrms.dataAccess.abstacts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate,Integer>{
	
	Candidate getByEmail(String email);
	Candidate getByNationalIdentity(String nationalIdentity);

}
