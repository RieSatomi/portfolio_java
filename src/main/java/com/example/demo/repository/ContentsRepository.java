package com.example.demo.repository;

//@Repository
//public class ContentsRepository {
//	@Autowired
//	JdbcTemplate jdbcTemplate;
	
	// コンテンツの入力情報をDBに登録するメソッド
//	public boolean insertContents(Contents contents) {
//		String sql = "INSERT INTO CONTENTS2(TITLE, FILE_NAME, FILE, DESCRIPTION, FILE_NAME2, FILE_2, DESCRIPTION_2) VALUES(?, ?, ?, ?, ?, ?, ?)";
//		int result = jdbcTemplate.update(sql, 
//				contents.getTitle(), contents.getFileName(), contents.getFileData(), contents.getDescription(),
//				contents.getFileName2(), contents.getFileData2(), contents.getDescription2());
//		if(result == 0) {
//			return false; // 登録失敗
//		}else {
//			return true; // 登録成功
//		}
//	}
	
	// コンテンツの重複を確認するメソッド
//		public boolean findContents(Contents contents) {
//			String sql = "SELECT COUNT (*) FROM CONTENTS2 WHERE CONTENTS_ID = ?";
//			int result = jdbcTemplate.queryForObject(sql, Integer.class, contents.getContents_Id());
//			if(result == 0) {
//				return true; // 登録可能
//			}else {
//				return false; // 登録不可
//			}
//		}

//		public List<Contents> findAll() {
//			List<Contents> contentsAll = new ArrayList<>();
//		}
		
//}



