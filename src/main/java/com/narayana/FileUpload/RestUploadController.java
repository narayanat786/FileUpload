package com.narayana.FileUpload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.narayana.FileUpload.model.FileMetaData;
import com.narayana.FileUpload.repository.FileRepository;
import com.narayana.FileUpload.service.FileService;

import java.util.List;

@RestController
public class RestUploadController {
    
    @Autowired
    FileRepository fileRepository;
    
    @Autowired
    FileService fileservice;
    
    // Single file upload
    @PostMapping("/api/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadfile) {
       return fileservice.uploadFile(uploadfile);
    }
    
    @GetMapping("api/file/{id}")
    public FileMetaData getMetaData(@PathVariable("id") String id) {
    	return fileRepository.getOne(Integer.parseInt(id));
    }
    
    @GetMapping("api/file/all")
    public List<FileMetaData> getMetaDataForAll() {
    	return fileRepository.findAll();
    }
    
}
