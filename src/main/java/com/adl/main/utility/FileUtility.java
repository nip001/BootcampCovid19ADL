package com.adl.main.utility;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

public class FileUtility {

	public static void saveFile(MultipartFile multipartFile, String uploadDir,String fileName) throws IOException {
		Path uploadPath = Paths.get(uploadDir);
		if(!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		
		try (InputStream inputStream = multipartFile.getInputStream()){

			Path filePath = uploadPath.resolve(fileName);
			Files.copy(inputStream,filePath,StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO: handle exception
			throw new IOException("Error " + fileName , e);
		}
	}
}
