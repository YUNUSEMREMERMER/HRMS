package kodlamaio.hrms.core.verification.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.verification.abstracts.EmailCheckService;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class EmailCheckManager implements EmailCheckService{
	
	@Override
	public boolean CheckIfRealEmail(User user) {
		
		return true;
	}

}
