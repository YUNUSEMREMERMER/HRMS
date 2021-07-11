package kodlamaio.hrms.entities.concretes;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "job_description")
    private String jobDescription;

    @Column(name = "min_salary")
    private int minSalary;

    @Column(name = "max_salary")
    private int maxSalary;

    @Column(name = "open_position_count")
    private int openPositionCount;

    @Column(name = "last_apply_date")
    private Date lastApplyDate;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "is_active")
    private boolean isActive;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "employer_id")
    private Employer employer;
    
    public JobAdvertisement(String jobDescription, int minSalary, int maxSalary, int openPositionCount,
            Date lastApplyDate, Date createDate, boolean isActive) {
    		this.jobDescription = jobDescription;
    		this.minSalary = minSalary;
    		this.maxSalary = maxSalary;
    		this.openPositionCount = openPositionCount;
    		this.lastApplyDate = lastApplyDate;
    		this.createDate = createDate;
    		this.isActive = isActive;
    }

}
