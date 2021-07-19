package kodlamaio.hrms.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstacts.ResumeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeDto;

@RestController
@RequestMapping(value= "api/resumes")
public class ResumesController {
	
	private ResumeService resumeService;
    
	@Autowired
	public ResumesController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody Resume resume) {
		
		return this.resumeService.add(resume);
	}
	
	@GetMapping("/getbycandidateıd")
	public DataResult<ResumeDto> getByCandidateId(int candidateId) {
		
		return this.resumeService.getByCandidateId(candidateId);
	}
	
	
	
	
}
