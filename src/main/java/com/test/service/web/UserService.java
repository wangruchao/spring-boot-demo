package com.test.service.web;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.domain.web.User;
import com.test.jdbc.UserJdbcTemplate;
import com.test.repository.web.UserRepository;

@Transactional
@Service
public class UserService {

	@Autowired
	UserJdbcTemplate userJdbcTemplate;

	@Autowired
	UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public List<User> getJdbcList() {
		return userJdbcTemplate.getJdbcList();
	}

	public int insert() {
		return userJdbcTemplate.insert();
	}

}