package com.test.mapper.admin;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.test.domain.admin.AdminUser;
import com.test.mapper.admin.provider.AdminUserDynaSqlProvider;

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

	/**
	 * 动态sql
	 * 
	 * @param adminUser
	 * @return
	 */
	@UpdateProvider(type = AdminUserDynaSqlProvider.class, method = "update")
	int update(AdminUser adminUser);

	@InsertProvider(type = AdminUserDynaSqlProvider.class, method = "insert")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(AdminUser adminUser);

	@DeleteProvider(type = AdminUserDynaSqlProvider.class, method = "delete")
	int delete(Long id);

}