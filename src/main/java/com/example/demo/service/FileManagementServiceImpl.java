package com.example.demo.service;

//@Service
//public class FileManagementServiceImpl implements FileManagementService {
//    @Autowired
//    FileManagementRepository repository;
//    
////    @Autowired
////    FileManagementRepository2 repository2;
//
//    public List<FileManagement> findAll() {
//    	List<FileManagement> contentsResult = repository.findAll();
//    	return contentsResult;
//    }
//    
//    
//    
//
//    public void insertFile(MultipartFile uploadFile, Contents contents) {
//        String title = contents.getTitle();
//        String fileName = uploadFile.getOriginalFilename();
//        InputStream inputstream = null;
//		String description = contents.getDescription();
//		String description2 = contents.getDescription2();
//        AttachmentFile attachmentFile = null;
//        try {
//            inputstream = uploadFile.getInputStream();
//            attachmentFile = new AttachmentFile(uploadFile.getSize(), inputstream);
//
//			repository.insertFile(title,fileName, attachmentFile,description, description2);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (inputstream != null) {
//                try {
//                    inputstream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
    
//    public void insertFile2(MultipartFile uploadFile) {
//        String fileName2 = uploadFile.getOriginalFilename();
//        InputStream inputstream = null;
//        AttachmentFile2 attachmentFile2 = null; // 新しいAttachmentFile2のインスタンスを作成
//        try {
//            inputstream = uploadFile.getInputStream();
//            attachmentFile2 = new AttachmentFile2(uploadFile.getSize(), inputstream);
//
//            repository.insertFile2(fileName2,attachmentFile2);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (inputstream != null) {
//                try {
//                    inputstream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

//    public FileManagement getFileData(int contents_id) {
//        return repository.getFileDataById(contents_id);
//    }
//    
//    public FileManagement getFileData2(int contents_id) {
//        // コンテンツIDを使ってファイルデータを取得する処理を実装する
//        return repository.getFileDataById(contents_id);
//    }
    

//}