package kodlamaio.hrms.business.abstacts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.User;

public interface UserService {
	
	DataResult<List<User>> getAll();
	
	Result add(User user);
	
	Result delete(User user);
	
	DataResult<User> getById(int id);


}
