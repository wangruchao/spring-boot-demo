package com.test.mapper.admin.provider;

import org.apache.ibatis.jdbc.SQL;

import com.test.domain.admin.AdminUser;

public class AdminUserDynaSqlProvider {

	public String insert(final AdminUser adminUser) {
		return new SQL() {
			{
				INSERT_INTO("adminuser");
				if (adminUser.getName() != null) {
					VALUES("NAME", "#{name}");
				}
			}
		}.toString();
	}

	public String update(final AdminUser adminUser) {
		return new SQL() {
			{
				UPDATE("adminuser");
				if (adminUser.getName() != null) {
					SET("NAME = #{name}");
				}
				WHERE("id = #{id}");
			}
		}.toString();
	}

	public String delete(Long id) {
		return new SQL() {
			{
				DELETE_FROM("adminuser");
				WHERE("id = #{id}");
			}
		}.toString();
	}
}