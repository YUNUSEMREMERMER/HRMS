package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstacts.SocialMediaLinkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstacts.SocialMediaLinkDao;
import kodlamaio.hrms.entities.concretes.SocialMediaLink;

@Service
public class SocialMediaLinkManager implements SocialMediaLinkService{
	
	private SocialMediaLinkDao socialMediaLinkDao;
	
	@Autowired
	public SocialMediaLinkManager(SocialMediaLinkDao socialMediaLinksDao) {
		super();
		this.socialMediaLinkDao = socialMediaLinksDao;
	}

	@Override
	public Result add(SocialMediaLink socialMediaLinks) {
		this.socialMediaLinkDao.save(socialMediaLinks);
		return new SuccessResult("Social media link is added.");
	}

	@Override
	public DataResult<List<SocialMediaLink>> getByCandidates_Id(int candidatesId) {
		return new SuccessDataResult<List<SocialMediaLink>>(this.socialMediaLinkDao.getByCandidates_Id(candidatesId));

	}

}
