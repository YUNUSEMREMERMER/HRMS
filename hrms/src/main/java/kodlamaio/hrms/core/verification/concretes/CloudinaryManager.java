package kodlamaio.hrms.core.verification.concretes;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.verification.abstracts.ImageUploadService;

@Service
public class CloudinaryManager implements ImageUploadService{
	
	private Cloudinary cloudinary;
	
	public CloudinaryManager() {

		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dmw4vaqp8",
				"api_key", "877944823144253",
				"api_secret", "NbLspx54yibeRqgvO9aUwi8ljOg"));
	}
	
	

	@Override
	@SuppressWarnings("rawtypes")
	public DataResult<Map> uploadImageFile(MultipartFile imageFile) {
		
		try {
		      
			@SuppressWarnings("unchecked")
			Map<String, String> resultMap =(Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());

            return new SuccessDataResult<>(resultMap);

        } 
		catch (IOException e) {
            e.printStackTrace();

        }
        return new ErrorDataResult<>();
	}
	
	
}
