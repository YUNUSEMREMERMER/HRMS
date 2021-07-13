package kodlamaio.hrms.dataAccess.abstacts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.College;

public interface CollegeDao extends JpaRepository<College,Integer>{
	
	College getById(int id);
	
    List<College> getByCandidate_Id(int candidateId);
    
    //@Query("select new kodlamaio.hrms.entities.concretes.College From colleges Order By graduated_date DESC")
    List<College>  getByOrderByGraduatedDate();

}
