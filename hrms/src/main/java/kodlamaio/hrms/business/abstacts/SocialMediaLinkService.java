package kodlamaio.hrms.business.abstacts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SocialMediaLink;

public interface SocialMediaLinkService {
	
	Result add (SocialMediaLink socialMediaLinks);
	DataResult<List<SocialMediaLink>> getByCandidates_Id(int candidatesId);

}
