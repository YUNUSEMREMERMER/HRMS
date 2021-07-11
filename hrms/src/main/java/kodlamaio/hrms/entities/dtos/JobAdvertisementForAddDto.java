package kodlamaio.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementForAddDto {
	
	private String jobDescription;
    private int minSalary;
    private int maxSalary;
    private int openPositionCount;
    private Date lastApplyDate;
    private Date createDate;
    private boolean isActive;
    private int cityId;
    private int jobPositionId;
    private int employerId;

}
