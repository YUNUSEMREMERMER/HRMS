package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstacts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.User;

@RestController
@RequestMapping("api/users")
public class UsersController {
	
	private UserService userService;
	
	@Autowired
	public UsersController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/getall")
	public DataResult<List<User>> getAll(){
		return userService.getAll();
	}
	 
	@PostMapping("/add")
	public Result add(@RequestBody User user){
		return userService.add(user);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody User user){
		return userService.delete(user);
	}
	
	@GetMapping("/getbyid")
	public DataResult<User> getById(int id){
		return userService.getById(id);
	}
	
}
