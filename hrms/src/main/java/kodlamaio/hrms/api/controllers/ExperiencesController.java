package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstacts.ExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Experience;

@RestController
@RequestMapping("/api/experiences")
public class ExperiencesController {
	
	private ExperienceService experienceService;

	@Autowired
	public ExperiencesController(ExperienceService experienceService) {
		this.experienceService = experienceService;
	}
	
	@PostMapping("/add")
	public Result add (@RequestBody Experience experience) {
		return this.experienceService.add(experience);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Experience>> getAll(){
		return this.experienceService.getAll();
	}
	
	@GetMapping("/getByCandidates_Id")
	public DataResult<List<Experience>> getByCandidates_Id(int candidatesId){
		return this.experienceService.getByCandidates_Id(candidatesId);
	}
	
	@GetMapping("/findByOrderByEndDateDesc")
	public DataResult<List<Experience>> findByOrderByEndDateDesc(){
		return this.experienceService.findByOrderByEndDateDesc();
	}

}
