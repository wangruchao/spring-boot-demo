package com.test.mapper.admin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.test.domain.admin.AdminUser;

/**
 * mybatis http://www.mybatis.org/mybatis-3/zh/java-api.html
 * 
 * @author Administrator
 *
 */
@Mapper
public interface AdminUserMapper {

	@Select("SELECT * FROM adminuser")
	List<AdminUser> findAll();

}