package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.domain.User;
import com.test.repository.UserDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTests {

	@Autowired
	UserDao userDao;

	@Test
	public void contextLoads() {
		User user = userDao.findByName("wang");
		System.out.println(user);
	}

}
