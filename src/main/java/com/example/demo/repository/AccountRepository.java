package com.example.demo.repository;



/*
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.LoginUser;
import com.example.demo.entity.RegisterUser;

@Repository
public class AccountRepository {
	@Autowired //JdbcTemplateクラスのインスタンスの注入
	JdbcTemplate jdbcTemplate;
	
	public RegisterUser findAccount(LoginUser loginUser) {
		String sql = "SELECT * FROM USERS WHERE USER_ID = ? AND PASSWORD = ?";
		
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql, loginUser.getUser_Id(), loginUser.getPass());

		if(resultList.size() != 0 && resultList != null) {
			for(Map<String,Object> result : resultList) {
				int user_Id = (int) result.get("user_Id");
				String pass = (String) result.get("password");
				String name = (String) result.get("name");
				int age = (int) result.get("age");
				String mail = (String) result.get("mail");
				RegisterUser registerUser = new RegisterUser(user_Id,pass,mail,name,age);
				return registerUser;
			}
		}
		return null;
	}
	
	
	// アカウントの重複を確認するメソッド
	public boolean findAccount(RegisterUser registerUser) {
		String sql = "SELECT COUNT (*) FROM USERS WHERE USER_ID = ?";
		int result = jdbcTemplate.queryForObject(sql, Integer.class, registerUser.getUser_Id());
		if(result == 0) {
			return true; // 登録可能
		}else {
			return false; // 登録不可
		}
	}
	
	// 新規登録時の入力情報をDBに登録するメソッド
	public boolean insertAccount(RegisterUser registerUser) {
		String sql = "INSERT INTO USERS(USER_ID, PASSWORD, MAIL, NAME, AGE) VALUES(?, ?, ?, ?, ?)";
		int result = jdbcTemplate.update(sql,registerUser.getUser_Id(), registerUser.getPass(), registerUser.getMail(), registerUser.getName(), registerUser.getAge());
		if(result == 0) {
			return false; // 登録失敗
		}else {
			return true; // 登録成功
		}
	}
		
		
	 // 登録内容の削除
	public boolean deleteAccount(RegisterUser registerUser) {
		String sql = "DELETE FROM USERS WHERE USER_ID = ?";
		int result = jdbcTemplate.update(sql,registerUser.getUser_Id());
		if(result == 0) {
			return false; // 削除失敗
		}else {
			return true; // 削除成功
		}
	}
}
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Users;

@Repository
public interface AccountRepository extends JpaRepository<Users, Integer>{

	 public Users findByIdAndPassword(int id, String pass);
}
