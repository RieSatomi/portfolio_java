//package com.example.demo.repository;
//
//import java.util.List;
//
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Param;
//import org.springframework.stereotype.Repository;
//
//import com.example.demo.model.AttachmentFile2;
//import com.example.demo.model.FileManagement;
//
//@Repository
//@Mapper
//public interface FileManagementRepository2 {
//    List<FileManagement> findAll();
//    void insertFile2(
//    		@Param("fileName2") String fileName2, 
//    		@Param("attachmentFile2") AttachmentFile2 attachmentFile2);
//    FileManagement getFileDataById2(@Param("contents_id") int contents_id); // 新しいメソッド
//}