package com.narayana.FileUpload.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.narayana.FileUpload.model.FileMetaData;
import com.narayana.FileUpload.repository.FileRepository;

@Component
public class FileService {
	
	//Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "C://UploadLocation//";
    
    @Autowired
    FileRepository fileRepository;
	
	public ResponseEntity<?> uploadFile(MultipartFile uploadfile) {
		if (uploadfile.isEmpty()) {
            return new ResponseEntity("Please select a file!", HttpStatus.OK);
        }

        Path path = Paths.get(UPLOADED_FOLDER + uploadfile.getOriginalFilename());

        try {	
            byte[] bytes = uploadfile.getBytes();
            Files.write(path, bytes);
            FileMetaData fmd = getFileMetaData(path,uploadfile.getOriginalFilename());
			fileRepository.save(fmd);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity("Successfully uploaded - " +
                uploadfile.getOriginalFilename(), new HttpHeaders(), HttpStatus.OK);
		
	}
	
	public FileMetaData getFileMetaData(Path path, String filename) throws IOException {
    	
    	BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
    	
    	FileMetaData fmd = new FileMetaData();
    	
    	SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    	
    	fmd.setFilename(filename);
    	fmd.setSize(Long.toString(attr.size()));
    	fmd.setCreationtime(df.format(attr.creationTime().toMillis()));
    	fmd.setLastaccesstime(df.format(attr.lastAccessTime().toMillis()));
    	fmd.setLastmodifiedtime(df.format(attr.lastModifiedTime().toMillis()));
    	fmd.setIsregularfile(String.valueOf(attr.isRegularFile()));
    	fmd.setIsother(String.valueOf(attr.isOther()));
    		
    	return fmd;
    	
    }

}
