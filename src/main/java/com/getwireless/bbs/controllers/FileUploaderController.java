package com.getwireless.bbs.controllers;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("*")
@RequestMapping("/upload")
public class FileUploaderController {
	

	
	private final Path rootLocation = Paths.get("src/main/resources/images");

	   @PostMapping("/savefile")
	   public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
	      String message;
	      try {
	         try {
	            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
	         } catch (Exception e) {
	        	 e.printStackTrace();
	            throw new RuntimeException("FAIL!");
	         }
	         

	         message = "Successfully uploaded!";
	         return ResponseEntity.status(HttpStatus.OK).body(message);
	      } catch (Exception e) {
	    	  e.printStackTrace();
	         message = "Failed to upload!";
	         return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
	      }
	   }
	   
	   
	   
	   @RequestMapping(value = "/image/{name}", method = RequestMethod.GET,
	            produces = MediaType.IMAGE_JPEG_VALUE)

	    public ResponseEntity<byte[]> getImage(@PathVariable String name) throws IOException {
	    	
	    	
	    	
	    	
	       ClassPathResource imgFile = new ClassPathResource("/image/"+name);

	      
	        byte[] bytes =StreamUtils.copyToByteArray(imgFile.getInputStream());
	        
	        return ResponseEntity
	                .ok()
	                .contentType(MediaType.IMAGE_JPEG)
	                .body(bytes);
		
		
		
	        
	        
	    }
	    
	    

}
