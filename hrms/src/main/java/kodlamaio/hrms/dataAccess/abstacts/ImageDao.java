package kodlamaio.hrms.dataAccess.abstacts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Image;

public interface ImageDao extends JpaRepository<Image,Integer>{
	
	Image getByUser_Id(int userId);

}
