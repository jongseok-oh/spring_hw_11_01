package com.ssafy.hw.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.hw.dto.SearchCondition;
import com.ssafy.hw.dto.User;
import com.ssafy.hw.model.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepo userRepo;
	
	@Autowired
	public void setUserRepo(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	
	public UserRepo getUserRepo() {
		return this.userRepo;
	}
	
	@Override
	@Transactional
	public int insert(User user) {
		/*
		// 사용자 정보를 등록한다.
		userRepo.insert(user);
		// 고의로 예외를 발생시키는 코드를 삽입한다.
		// 트랜잭션 처리가 되면 에외 발생시 롤백된다.
		// 트랜잭션 처리가 되지 않으면 그대로 DB에 반영된다.
		int err = 1/0;
		*/
		
		return userRepo.insert(user);
	}

	@Override
	@Transactional
	public int delete(String id) {
		return userRepo.delete(id);
	}

	@Override
	@Transactional
	public int update(User user) {
		return userRepo.update(user);
	}

	@Override
	public User searchById(String id) {
		return userRepo.searchById(id);
	}

	@Override
	public List<User> selectAll() {
		return userRepo.selectAll();
	}

	@Override
	public List<User> searchByName(String name) {
		return userRepo.searchByName(name);
	}

	@Override
	public List<User> searchByCondition(SearchCondition con) {
		
		return userRepo.searchByCondition(con);
	}

}
