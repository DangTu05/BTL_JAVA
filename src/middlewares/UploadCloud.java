package middlewares;

import java.io.File;
import java.util.Map;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import Configs.CloudinaryConfig;

public class UploadCloud {
	public static String upload(File imageFile) throws Exception {
		Map uploadResult = CloudinaryConfig.getCloudinary().uploader().upload(imageFile, ObjectUtils.emptyMap());
		return uploadResult.get("secure_url").toString();
	}
}
