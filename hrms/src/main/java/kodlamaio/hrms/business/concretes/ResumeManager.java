package kodlamaio.hrms.business.concretes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstacts.CandidateService;
import kodlamaio.hrms.business.abstacts.CollegeService;
import kodlamaio.hrms.business.abstacts.ExperienceService;
import kodlamaio.hrms.business.abstacts.ImageService;
import kodlamaio.hrms.business.abstacts.LanguageService;
import kodlamaio.hrms.business.abstacts.ResumeService;
import kodlamaio.hrms.business.abstacts.SkillService;
import kodlamaio.hrms.business.abstacts.SocialMediaLinkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstacts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeDto;

@Service
public class ResumeManager implements ResumeService{
	
	private ResumeDao resumeDao;
	private CandidateService candidateService;
	private CollegeService collegeService;
	private ExperienceService experienceService;
	private ImageService imageService;
	private LanguageService languageService;
	private SkillService skillService;
	private SocialMediaLinkService socialMediaLinkService;
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao, CandidateService candidateService, CollegeService collegeService,
			ExperienceService experienceService, ImageService imageService, LanguageService languageService,
			SkillService skillService,SocialMediaLinkService socialMediaLinkService) {
		super();
		this.resumeDao = resumeDao;
		this.candidateService = candidateService;
		this.collegeService = collegeService;
		this.experienceService = experienceService;
		this.imageService = imageService;
		this.languageService = languageService;
		this.skillService = skillService;
		this.socialMediaLinkService = socialMediaLinkService;
	}

	


	@Override
	public DataResult<ResumeDto> getByCandidateId(int candidateId) {
		ResumeDto resumeDto = new ResumeDto();
		//resumeDto.setCandidate(candidateService.getById(candidateId).getData());
		resumeDto.setColleges(collegeService.getByCandidate_Id(candidateId).getData());
		resumeDto.setExperiences(experienceService.getByCandidates_Id(candidateId).getData());
		resumeDto.setImage(imageService.getByUserId(candidateId).getData());
		resumeDto.setLanguages(languageService.getByCandidates_Id(candidateId).getData());
		resumeDto.setSkills(skillService.getByCandidates_Id(candidateId).getData());
		resumeDto.setSocialMediaLinks(socialMediaLinkService.getByCandidates_Id(candidateId).getData());
		
		return new SuccessDataResult<ResumeDto>(resumeDto,"cv görüntülendi");
	}

	@Override
	public Result add(Resume resume) {
		this.resumeDao.save(resume);
		return new SuccessResult("cv kullanıcıya tanımlandı.");
	}
	

}
