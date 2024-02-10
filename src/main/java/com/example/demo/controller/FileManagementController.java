package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.FileManagement;
import com.example.demo.model.Users;
import com.example.demo.repository.FileManagementRepository;
import com.example.demo.service.FileManagementService;
import com.example.demo.service.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class FileManagementController {

    @Autowired
    FileManagementService fileManagementService;
    
    @Autowired
	UsersService usersService;
	
	@Autowired
	HttpSession session;
	
//	@Autowired
//    ContentsService contentsservice;
	
	@Autowired
	FileManagementRepository repository;

    @GetMapping("fileUp")
    public String showIndexPage(Model model) {
        List<FileManagement> contents = fileManagementService.fileManagementList();
        model.addAttribute("contents", contents);
        return "fileUp";
    }

    @PostMapping("fileUpRegist")
    public String postFile(
    		@RequestParam("file") MultipartFile uploadFile,
    		@RequestParam("file_2") MultipartFile uploadFile2, 
    		@RequestParam("title") String title, 
    		@RequestParam("description") String description,
    		@RequestParam("description2") String description2,
    		ModelMap model)throws IOException {
    	
    	System.out.println(title);
    	System.out.println(description);
    	System.out.println(description2);
    	
    	// バイト配列のまま保存する
    	byte[] content = uploadFile.getBytes();
    	byte[] content2 = uploadFile2.getBytes();
    	
    	// ログインしているユーザーのIDを取得する
    	Users user = (Users) session.getAttribute("user");
    	System.out.println(user.getId());
    	
    	FileManagement record = new FileManagement();
    	record.setFileData(content);
    	record.setFileData2(content2);
    	record.setUserId(user.getId());
    	
    	record.setTitle(title);
    	record.setDescription(description);
    	record.setDescription2(description2);
    	
    	fileManagementService.saveImage(record);
    	
    	session.setAttribute("user", user);
    	
    	//model.addAttribute("user", user.getId());
    	
    	return "redirect:login";
    	
    }
    

//    @GetMapping("/{contents_id}")
//    public void download(@PathVariable("contents_id") int contents_id, HttpServletResponse res) throws IOException {
//        FileManagement file = fileManagementService.getFileData(contents_id);
//        if (file.getFileData() != null) {
//            res.setContentType("application/octet-stream;charset=UTF-8");
//            String fileName = file.getFileName();
//            res.setHeader("Content-Disposition", "attachment;filename=\"" + URLEncoder.encode(fileName, "UTF-8") + "\"");
//            IOUtils.copy(file.getFileData(), res.getOutputStream());
//        } else {
//            res.setStatus(404);
//        }
//        
//        FileManagement file_2 = fileManagementService.getFileData(contents_id);
//        if (file_2.getFileData() != null) {
//            res.setContentType("application/octet-stream;charset=UTF-8");
//            String fileName = file_2.getFileName();
//            res.setHeader("Content-Disposition", "attachment;filename=\"" + URLEncoder.encode(fileName, "UTF-8") + "\"");
//            IOUtils.copy(file_2.getFileData(), res.getOutputStream());
//        } else {
//            res.setStatus(404);
//        }
//    }
    
    
    
    // データベースからID指定したデータを持ってきたい
//    @GetMapping("/data/{id}")
//    public String getDataById(@PathVariable int contents_id, Model model) {
//        // データベースから指定されたIDのデータを取得するロジック
//        FileManagement data = repository.getFileDataById(contents_id);
//        System.out.println(data);
//        
//        model.addAttribute("data", data); // HTMLにデータを渡す
//        return "contents"; // 表示するHTMLテンプレート
//    }
    
// // 画像データをBase64エンコードするメソッド
//    public String encodeImage(byte[] imageByteArray) {
//        return Base64.getEncoder().encodeToString(imageByteArray);
//    }
    
}