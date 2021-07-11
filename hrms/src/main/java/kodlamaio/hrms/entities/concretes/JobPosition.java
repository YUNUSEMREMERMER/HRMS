package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity // tüm tablo nesnelerinin soyut sınıflarını olusturuyor.
@Table(name="job_positions") // bu nesnenın veri tabanındaki karşılığını tanımlıyor

@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class JobPosition {
	
	
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	
	@Column(name="title")
	String title;
	
	@OneToMany(mappedBy = "jobPosition", fetch = FetchType.LAZY)
    private List<JobAdvertisement> jobAdvertisements;

}
