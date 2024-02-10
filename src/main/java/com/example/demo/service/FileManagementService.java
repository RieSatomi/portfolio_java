package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FileManagement;
import com.example.demo.repository.FileManagementRepository;

@Service
public class FileManagementService {
	
	@Autowired 
	private FileManagementRepository fileManagementRepository;
	
//    public List<FileManagement> findAll();
//    public void insertFile(MultipartFile uploadFile,Contents contents);
////    public void insertFile2(MultipartFile uploadFile2);
//    public FileManagement getFileData(int contents_id);
//    public FileManagement getFileData2(int contents_id); // getFileData2を追加
	
	
	public void saveImage(FileManagement fileManagement) {
		fileManagementRepository.save(fileManagement);
	}

	public void deleteImage(Integer id) {
		fileManagementRepository.deleteById(id);
	}

	public FileManagement getImage(Integer id) {
		return fileManagementRepository.findById(id).get();
	}

	public List<FileManagement> fileManagementList() {
		return fileManagementRepository.findAll();
	}
	
	public List<FileManagement> fileManagementListByUser(Integer userId) {
		return fileManagementRepository.findByUserId(userId);
	}
}

