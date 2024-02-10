package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Users;
import com.example.demo.repository.AccountRepository;

/*
import java.util.List;

import com.example.demo.entity.LoginUser;
import com.example.demo.entity.Mutter;
import com.example.demo.entity.RegisterUser;

public interface UsersService {
	//ログインフォームに入力されたuser_idとpassがDBに存在するか確認
	RegisterUser logicCheck(LoginUser loginUser);
	boolean registerAccount(RegisterUser registerUser);
	
	// 退会処理
	boolean deleteAccount(RegisterUser registerUser);
	// つぶやき処理
	List<Mutter>findAll();
	boolean create(Mutter mutter);
}
*/

@Service
public class UsersService {
	
	@Autowired
	private AccountRepository usersRepository;
	
	public void saveAccount(Users user) {
		usersRepository.save(user);
	}

	public boolean deleteAccount(Integer id) {
		usersRepository.deleteById(id);
		return true;
	}

	public Users findAccount(int id, String pass) {
		return usersRepository.findByIdAndPassword(id, pass);
	}

	public List<Users> findAll() {
		return usersRepository.findAll();
	}
	
}