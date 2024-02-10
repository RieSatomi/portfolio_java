package com.example.demo.repository;
/*
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Mutter;

@Repository
public class MutterRepository {

//	private static final List<Mutter> mutterList = null;
	@Autowired
	JdbcTemplate jdbcTemplate;
	AccountRepository repository;
	
	
	// Mutterのつぶやき情報の取得
	public List<Mutter>findAll() {
		List<Mutter> mutterAll = new ArrayList<>();
		
		String sql = "SELECT MUTTER_ID, NAME, TEXT FROM MUTTERS ORDER BY MUTTER_ID DESC";
		List<Map<String, Object>> mutterMap = jdbcTemplate.queryForList(sql);
		
		if(mutterMap.size() != 0 && mutterMap != null) {
			for(Map<String,Object> mutterList : mutterMap) {
				int mutter_Id = (int) mutterList.get("mutter_Id");
				String name = (String) mutterList.get("name");
				String text = (String) mutterList.get("text");
				Mutter mutter = new Mutter(mutter_Id,name,text);
				mutterAll.add(mutter);
			}return mutterAll;
		}
		return null;
	}
	
	
	
	// Mutterにつぶやき情報を保存するメソッド
	public boolean create(Mutter mutter) {
		String sql = "INSERT INTO MUTTERS(NAME, TEXT) VALUES(?, ?)";
		int result = jdbcTemplate.update(sql, mutter.getName(), mutter.getText());
		if(result == 1) {
			return true; // 可能
		}else {
			return false; // 不可
		}
	}
}
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Mutter;

@Repository
public interface MutterRepository extends JpaRepository<Mutter,Integer>{}

