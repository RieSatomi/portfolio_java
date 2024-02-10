package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Mutter;
import com.example.demo.repository.MutterRepository;

@Service
public class MutterService {
	// つぶやき処理
//		List<Mutter>findAll();
//		boolean create(Mutter mutter);
	@Autowired
	MutterRepository mutterRepository;
	
	public void saveMutter(Mutter mutter) {
		mutterRepository.save(mutter);
	}
	
	public boolean deleteMutter(int id) {
		mutterRepository.deleteById(id);
		return true;
	}
	
	public List<Mutter> findAllMutters() {
		return mutterRepository.findAll();
	}
	
}
