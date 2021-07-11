package kodlamaio.hrms.core.verification.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.verification.abstracts.MernisCheckService;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class MernisCheckManager implements MernisCheckService {

	@Override
	public boolean checkIfRealPerson(User user) {
		
		return true;
	}

}
