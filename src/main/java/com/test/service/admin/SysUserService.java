package com.test.service.admin;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.domain.admin.User;
import com.test.repository.admin.SysUserRepository;

@Transactional
@Service
public class SysUserService {

	@Autowired
	SysUserRepository sysUserRepository;

	public User findByName(String name) {
		return sysUserRepository.findByName(name);
	}

	public User login(String name, String password) {
		return sysUserRepository.findByNameAndPassword(name, password);
	}

	public List<User> findAll() {
		return sysUserRepository.findAll();
	}

	public User create(User user) {
		return sysUserRepository.save(user);
	}

	public User findById(Long id) {
		return sysUserRepository.findOne(id);
	}

	public User update(User user) {
		return sysUserRepository.save(user);
	}

	public void delete(Long id) {
		sysUserRepository.delete(id);
	}

}