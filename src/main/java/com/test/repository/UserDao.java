package com.test.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.domain.User;

@Transactional
public interface UserDao extends JpaRepository<User, Long> {

	public User findByName(String name);

}