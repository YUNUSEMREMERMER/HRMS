package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstacts.ImageService;
import kodlamaio.hrms.business.abstacts.UserService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Image;
import kodlamaio.hrms.entities.concretes.User;

@CrossOrigin
@RestController
@RequestMapping("/api/images")
public class ImagesController {
	
	private ImageService imageService;
	private UserService userService;
	
	@Autowired
	public ImagesController(ImageService imageService, UserService userService) {
		this.imageService = imageService;
		this.userService = userService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestParam(value = "id") int id, @RequestParam(value = "imageFile") MultipartFile imageFile) {
		User user = this.userService.getById(id).getData();
		Image image = new Image();
		image.setUser(user);
		return this.imageService.add(image, imageFile);
		
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		
		return this.imageService.delete(id);
	}

}
