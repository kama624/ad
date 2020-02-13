package com.commons;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ad.dto.BoardDto;


@Component("fileUtils")
public class FileUtils {
	private static final String filePath = "C:\\project\\workspace\\file"; // 파일이 저장될 위치
	
	@SuppressWarnings("null")
	public List<Map<String, Object>> parseInsertFileInfo(BoardDto boardDto, MultipartFile[] multipartFiles) throws Exception{
		
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> listMap = null;
		
		int bno = boardDto.getBno();
		
		File file = new File(filePath);
		if(file.exists() == false) {
			file.mkdirs();
		}
		
		for(MultipartFile uploadedFile : multipartFiles) {
//			File file = new File(uploadingDir + uploadedFile.getOriginalFilename());

			if(uploadedFile.isEmpty() == false) {
				originalFileName = uploadedFile.getOriginalFilename();
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
				storedFileName = getRandomString() + originalFileExtension;
				
				file = new File(filePath + storedFileName);
				uploadedFile.transferTo(file);
				listMap = new HashMap<String, Object>();
				listMap.put("BNO", bno);
				listMap.put("ORG_FILE_NAME", originalFileName);
				listMap.put("STORED_FILE_NAME", storedFileName);
				listMap.put("FILE_SIZE", uploadedFile.getSize());
				list.add(listMap);
			}
		}
		return list;
	}
	
	public List<Map<String, Object>> parseUpdateFileInfo(BoardDto boardDto, String[] files, String[] fileNames, MultipartFile[] multipartFiles) throws Exception{ 
		String originalFileName = null; 
		String originalFileExtension = null; 
		String storedFileName = null; 
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> listMap = null; 
		
		
		int bno = boardDto.getBno();
		for(MultipartFile uploadedFile : multipartFiles) {
			if(uploadedFile.isEmpty() == false){ 
				originalFileName = uploadedFile.getOriginalFilename(); 
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf(".")); 
				storedFileName = getRandomString() + originalFileExtension; 
				uploadedFile.transferTo(new File(filePath + storedFileName)); 
				listMap = new HashMap<String,Object>();
				listMap.put("IS_NEW", "Y");
				listMap.put("BNO", bno); 
				listMap.put("ORG_FILE_NAME", originalFileName);
				listMap.put("STORED_FILE_NAME", storedFileName); 
				listMap.put("FILE_SIZE", uploadedFile.getSize()); 
				list.add(listMap); 
			} 
		}
		
		if(files != null && fileNames != null){ 
			for(int i = 0; i<fileNames.length; i++) {
					listMap = new HashMap<String,Object>();
                    listMap.put("IS_NEW", "N");
					listMap.put("FILE_NO", files[i]); 
					list.add(listMap); 
			}
		}
		return list; 
	}
	
	public static String getRandomString() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}