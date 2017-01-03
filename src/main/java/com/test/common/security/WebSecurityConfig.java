package com.test.common.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;// code1
	@Autowired
	@Qualifier("secondaryDS")
	private DataSource dataSource; // code2

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 允许所有用户访问”/”和”/home”
		// http.authorizeRequests().antMatchers("/", "/home").permitAll()
		http.authorizeRequests().antMatchers("/").permitAll()
				// 其他地址的访问均需验证权限
				.anyRequest().authenticated().and().formLogin()
				// 指定登录页是”/login”
				.loginPage("/admin/login").permitAll()
				// 登录成功后可使用loginSuccessHandler()存储用户信息，可选。
				.successHandler(loginSuccessHandler()) // code3
				.defaultSuccessUrl("/admin").permitAll() // 登录后跳转页
				.and().logout().logoutUrl("/admin/logout")
				// 退出登录后的默认网址是”/home”
				.logoutSuccessUrl("/admin/login").permitAll().invalidateHttpSession(true).and()
				// 登录后记住用户，下次自动登录
				// 数据库中必须存在名为persistent_logins的表
				// 建表语句见code15
				.rememberMe().tokenValiditySeconds(1209600)
				// 指定记住登录信息所使用的数据源
				.tokenRepository(tokenRepository());// code4
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/js/**", "/css/**", "/images/**", "/**/favicon.ico");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// 指定密码加密所使用的加密器为passwordEncoder()
		// 需要将密码加密后写入数据库 //code13
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());// code5
		// 不删除凭据，以便记住用户
		auth.eraseCredentials(false);
	}

	// Code5----------------------------------------------
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(4);
	}

	// Code4----------------------------------------------
	@Bean
	public JdbcTokenRepositoryImpl tokenRepository() {
		JdbcTokenRepositoryImpl j = new JdbcTokenRepositoryImpl();
		j.setDataSource(dataSource);
		return j;
	}

	// Code3----------------------------------------------
	@Bean
	public LoginSuccessHandler loginSuccessHandler() {
		return new LoginSuccessHandler();// code6
	}

}