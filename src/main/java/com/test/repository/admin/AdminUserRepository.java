package com.test.repository.admin;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.domain.admin.AdminUser;

//@Transactional
public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {

	public AdminUser findByName(String name);

}