package com.poly.service.impl;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.poly.service.UploadService;
@Service
public class UploadServiceImpl implements UploadService{
	@Autowired
	ServletContext app;
	
	@Override
	public File save(MultipartFile file,String folder) {
		File dir = new File("C:/JAVA4/J6Store/src/main/resources/static/assets/images");
		if(!dir.exists()) {
			dir.mkdirs();
		}
		String s = System.currentTimeMillis() + file.getOriginalFilename();
		String name = Integer.toHexString(s.hashCode()) + s.substring(s.lastIndexOf("."));
		try {
			File savedFile = new File(dir,name);
			file.transferTo(savedFile);
			System.out.print(savedFile.getAbsolutePath());
			return savedFile;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

}
