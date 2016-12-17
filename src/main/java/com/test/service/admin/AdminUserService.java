package com.test.service.admin;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.domain.admin.AdminUser;
import com.test.repository.admin.AdminUserRepository;

@Transactional
@Service
public class AdminUserService {

	@Autowired
	AdminUserRepository adminUserRepository;

	public List<AdminUser> findAll() {
		return adminUserRepository.findAll();
	}

	public void save(AdminUser adminUser) {
		adminUserRepository.save(adminUser);
	}

}