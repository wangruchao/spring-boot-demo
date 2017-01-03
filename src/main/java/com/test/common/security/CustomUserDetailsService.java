package com.test.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.test.domain.admin.User;
import com.test.service.admin.SysUserService;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired // 数据库服务类
	private SysUserService suserService;// code7

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// User对应数据库中的用户表，是最终存储用户和密码的表，可自定义
		// 本例使用User中的name作为用户名:
		User user = suserService.findByName(username);
		if (user == null) {
			throw new UsernameNotFoundException("用户 " + username + " 不存在");
		}
		// SecurityUser实现UserDetails并将SUser的Email映射为username
		return new SecurityUser(user); // code9
	}
}