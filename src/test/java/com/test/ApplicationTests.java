package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.common.properties.TestSettings;
import com.test.domain.web.User;
import com.test.mapper.web.UserMapper;
import com.test.repository.web.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	UserRepository userDao;
	@Autowired
	TestSettings   testSettings;
	@Autowired
	UserMapper	   userMapper;

	@Test
	public void contextLoads() {
		User user = userDao.findByName("123123");
		System.out.println(user);
	}

	@Test
	public void testSettings() {
		System.out.println(testSettings.getName());
	}

	@Test
	public void testFindByName() {
		User user = userMapper.findByName("aa");
		System.out.println(user);
	}

	/*
	 * 
	 * Junit基本注解介绍 //在所有测试方法前执行一次，一般在其中写上整体初始化的代码
	 * 
	 * @BeforeClass
	 * 
	 * 
	 * //在所有测试方法后执行一次，一般在其中写上销毁和释放资源的代码
	 * 
	 * @AfterClass
	 * 
	 * 
	 * //在每个测试方法前执行，一般用来初始化方法（比如我们在测试别的方法时，类中与其他测试方法共享的值已经被改变，为了保证测试结果的有效性，我们会在@
	 * Before注解的方法中重置数据）
	 * 
	 * @Before
	 * 
	 * 
	 * //在每个测试方法后执行，在方法执行完成后要做的事情
	 * 
	 * @After
	 * 
	 * 
	 * // 测试方法执行超过1000毫秒后算超时，测试将失败
	 * 
	 * @Test(timeout = 1000)
	 * 
	 * 
	 * // 测试方法期望得到的异常类，如果方法执行没有抛出指定的异常，则测试失败
	 * 
	 * @Test(expected = Exception.class)
	 * 
	 * 
	 * // 执行测试时将忽略掉此方法，如果用于修饰类，则忽略整个类
	 * 
	 * @Ignore(“not ready yet”)
	 * 
	 * 
	 * @Test
	 * 
	 */
}
