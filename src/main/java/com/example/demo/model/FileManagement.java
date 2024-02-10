package com.example.demo.model;


import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.VarbinaryJdbcType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "contents2")
public class FileManagement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contents_id;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column
    private String title;
	
	@Column(name = "file_name")
    private String fileName;
	
	//@Lob varbinaryの二つのアノテーションによって画像をデータベースに保存
	@Lob
	@JdbcType(VarbinaryJdbcType.class)
	@Column(name = "file")
    private byte[] fileData;
	
	@Column
    private String description;
	
	@Column(name = "file_name_2")
    private String fileName2;
	
	@Lob
	@JdbcType(VarbinaryJdbcType.class)
	@Column(name = "file_2")
    private byte[] fileData2;
	
	@Column(name = "description_2")
    private String description2;
    

//    public int getContents_Id() {
//        return contents_id;
//    }
//    public void setContents_Id(int contents_id) {
//        this.contents_id = contents_id;
//    }
//    public String getFileName() {
//        return fileName;
//    }
//    public void setFileName(String fileName) {
//        this.fileName = fileName;
//    }
//    
//    public String getTitle() {
//        return title;
//    }
//    public void setTitle(String title) {
//        this.title = title;
//    }
//    
//    
//    public byte[] getFileData() {
//        return fileData;
//    }
//    public void setFileData(byte[]fileData) {
//        this.fileData = fileData;
//    }
//    
//    public String getDescription() {
//        return description;
//    }
//    
//    public void setDescription(String description) {
//        this.description = description;
//    }
//    
//    
//    public String getFileName2() {
//        return fileName2;
//    }
//    public void setFileName2(String fileName2) {
//        this.fileName2 = fileName2;
//    }
//    public InputStream getFileData2() {
//        return fileData2;
//    }
//    public void setFileData2(InputStream fileData2) {
//        this.fileData = fileData2;
//    }
//    
//    public String getDescription2() {
//        return description2;
//    }
//    
//    public void setDescription2(String description2) {
//        this.description2 = description2;
//    }
//    
}