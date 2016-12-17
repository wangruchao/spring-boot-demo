package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.domain.web.User;
import com.test.repository.web.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	UserRepository userDao;

	@Test
	public void contextLoads() {
		User user = userDao.findByName("123123");
		System.out.println(user);
	}
	
}
