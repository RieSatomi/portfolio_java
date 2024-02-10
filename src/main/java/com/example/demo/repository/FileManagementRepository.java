package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.FileManagement;

@Repository
public interface FileManagementRepository extends JpaRepository<FileManagement, Integer> {

	List<FileManagement> findByUserId(Integer userId);
	
//    List<FileManagement> findAll();
//    void insertFile(
//    		@Param("title") String title,
//    		@Param("fileName") String fileName, 
//    		@Param("attachmentFile") AttachmentFile attachmentFile,
//    		@Param("description") String description,
//    		@Param("description_2") String description2
//    		);
//    FileManagement getFileDataById(@Param("contents_id") int contents_id);
    
//    void insertFile2(
//    		@Param("fileName2") String fileName2, 
//    		@Param("attachmentFile2") AttachmentFile2 attachmentFile2);
//    FileManagement getFileDataById2(@Param("contents_id") int contents_id); // 新しいメソッド
	
}