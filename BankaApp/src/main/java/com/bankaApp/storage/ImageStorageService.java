package com.bankaApp.storage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageStorageService {

	@Autowired
	private ImageStorageRepository imageStorageRepository;
	
	public String getImageType(String fileName) {
		ImageStorage imageStorage = imageStorageRepository.findByName(fileName);
		return imageStorage.getType();
	} 
	
	public String uploadImage(MultipartFile file) throws IOException {
		ImageStorage imageStorage = new ImageStorage();
		imageStorage.setName(file.getOriginalFilename());
		imageStorage.setType(file.getContentType());
		imageStorage.setImage(ImageStorageUtils.compressImage(file.getBytes()));
		imageStorage.setFileSize(file.getSize() / 1024);
		imageStorage = imageStorageRepository.save(imageStorage);
				
		if(imageStorage == null) {
			return null;
		}else {
			return imageStorage.getName();	
		}
	}
	
	public byte[] downloadImage(String fileName) {
        ImageStorage imageStorage = imageStorageRepository.findByName(fileName);
        byte[] image = ImageStorageUtils.decompressImage(imageStorage.getImage());
        return image;
    }
	
	public List<byte[]> downloadImages() {
        List<ImageStorage> imagesStorage = imageStorageRepository.findAll();
        List<byte[]> images = new ArrayList<byte[]>();
        for(ImageStorage i : imagesStorage) {
            byte[] image = ImageStorageUtils.decompressImage(i.getImage());
            images.add(image);
        }
        return images;
    }
	
	public byte[] downloadImagesAsZip() throws IOException {

        List<ImageStorage> imagesData = imageStorageRepository.findAll();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream)) {
            for (ImageStorage image : imagesData) {
                byte[] imageData = ImageStorageUtils.decompressImage(image.getImage());

                ZipEntry zipEntry = new ZipEntry(image.getName());
                zipOutputStream.putNextEntry(zipEntry);

                zipOutputStream.write(imageData);
                zipOutputStream.closeEntry();
            }
        }

        return byteArrayOutputStream.toByteArray();
    }



}
