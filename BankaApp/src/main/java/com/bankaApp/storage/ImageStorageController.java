package com.bankaApp.storage;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@CrossOrigin(origins="http://localhost:4200") 
@RequestMapping("/api/image")
public class ImageStorageController {
    @Autowired
	private ImageStorageService imageStorageService;
    
    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file)  {
    	String image=null;
    	try {
			 image=imageStorageService.uploadImage(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return ResponseEntity.ok(image);
    }
    
    @GetMapping("/{fileName}")
    public ResponseEntity<?> downloadImage(@PathVariable String fileName){
        byte[] imageData =imageStorageService.downloadImage(fileName);
        String type=imageStorageService.getImageType(fileName);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf(type)).body(imageData);
    }
    
    @GetMapping("/all")
    public ResponseEntity<?> downloadImages() {
        List<byte[]> imagesData = imageStorageService.downloadImages();
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/jpeg")).body(imagesData.get(0));
    }
    
    @GetMapping("/images")
    public ResponseEntity<?> downloadImage() {
        List<byte[]> imagesData = imageStorageService.downloadImages();
        List<String> base64Images = imagesData.stream()
            .map(imageData -> Base64.getEncoder().encodeToString(imageData))
            .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK)
                             .contentType(MediaType.APPLICATION_JSON)
                             .body(base64Images);
    }
    
    @GetMapping("/zip/images")
    public ResponseEntity<byte[]> downloadImagesZip() {
        try {
            byte[] zipData = imageStorageService.downloadImagesAsZip();

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType("application/zip"))
                    .header("Content-Disposition", "attachment; filename=\"images.zip\"")
                    .body(zipData);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error generating ZIP file.".getBytes());
        }
    }
}
