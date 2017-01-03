package com.test.repository.admin;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.domain.admin.User;

//@Transactional
public interface SysUserRepository extends JpaRepository<User, Long> {

	public User findByName(String name);

	public User findByNameAndPassword(String name, String password);

}