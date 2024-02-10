/*
 * package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LoginUser;
import com.example.demo.entity.Mutter;
import com.example.demo.entity.RegisterUser;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.MutterRepository;

@Service // DIの対象であること
public class UsersServiceImpl implements UsersService {
	//AccoutRepositoryを使用できるようにする
	@Autowired
	AccountRepository repository;
	// mutterRepositoryを使用できるようにする。
	@Autowired
	MutterRepository mutterRepository;
	
	//ログインフォームに入力されたuser_idとpassがDBに存在するか確認/DBに存在していれば画面に表示するためのnameを返す
	@Override
	public RegisterUser logicCheck(LoginUser loginUser) {
		RegisterUser result = repository.findAccount(loginUser);
		return result;
	}
	
	//ログインフォームに入力されたuser_idとpassがDBに存在するか確認(ResisterUser型を受け取る)
	@Override
	public boolean registerAccount(RegisterUser registerUser) {
		boolean result = repository.findAccount(registerUser);
		if(result) {
			if(repository.insertAccount(registerUser)) {
				return true;
			}
		}
		return false;
	}
	
	// アカウントの削除、退会の処理
	@Override
	public boolean deleteAccount(RegisterUser registerUser) {
		boolean result = repository.deleteAccount(registerUser);
		return result;
	}
	
	
	// muttersのimpl
	@Override
	public List<Mutter>findAll() {
		List<Mutter> mutterResult = mutterRepository.findAll();
		return mutterResult;
	}
	
	@Override
	public boolean create(Mutter mutter) {
		boolean mutterResult = mutterRepository.create(mutter);
		return mutterResult;
	}
	
}
*/