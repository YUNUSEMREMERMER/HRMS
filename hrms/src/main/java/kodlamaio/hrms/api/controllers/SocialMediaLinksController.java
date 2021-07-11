package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstacts.SocialMediaLinkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SocialMediaLink;

@RestController
@RequestMapping("/api/socialMediaLinks")
public class SocialMediaLinksController {
	
	private SocialMediaLinkService socialMediaLinkService;

	@Autowired
	public SocialMediaLinksController(SocialMediaLinkService socialMediaLinkService) {
		super();
		this.socialMediaLinkService = socialMediaLinkService;
	}
	
	@PostMapping("/add")
	public Result add(SocialMediaLink socialMediaLink) {
		return this.socialMediaLinkService.add(socialMediaLink);
	}
	
	@GetMapping("/getByCandidates_Id")
	public DataResult<List<SocialMediaLink>> getByCandidates_Id(int candidatesId){
		return this.socialMediaLinkService.getByCandidates_Id(candidatesId);
	}

}
