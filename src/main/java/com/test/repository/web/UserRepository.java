package com.test.repository.web;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.test.domain.web.User;

//@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByName(String name);

	@Modifying
	@Query("update User m set m.name=?1 where m.id=?2")
	public void update(String name, Long id);

}