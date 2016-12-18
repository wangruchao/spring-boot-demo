package com.test.mapper.web;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.repository.query.Param;

import com.test.domain.web.User;

/**
 * mybatis http://www.mybatis.org/mybatis-3/zh/java-api.html
 * 
 * @author Administrator
 *
 */
@Mapper
public interface UserMapper {

	@Select("SELECT * FROM USER WHERE NAME = #{name}")
	User findByName(@Param("name") String name);

	@Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
	int insert(@Param("name") String name, @Param("age") Integer age);

	@Select("SELECT * FROM USER")
	List<User> selectAll();

	@Results({ @Result(property = "name", column = "name"), @Result(property = "age", column = "age") })
	@Select("SELECT name, age FROM user")
	List<User> findAll();

	@Update("UPDATE user SET age=#{age} WHERE name=#{name}")
	void update(User user);

	@Delete("DELETE FROM user WHERE id =#{id}")
	void delete(Long id);

	@Insert("INSERT INTO user(name, age) VALUES(#{name}, #{age})")
	int insertByUser(User user);

	@Insert("INSERT INTO user(name, age) VALUES(#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER})")
	int insertByMap(Map<String, Object> map);

}