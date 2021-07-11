package kodlamaio.hrms.core.verification.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.verification.abstracts.HrmsCheckService;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class HrmsCheckManager  implements HrmsCheckService{
	
	@Override
	public boolean checkIfConfirmHrms(User user) {
		
		return true;
	}

}
