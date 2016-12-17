package com.test.jdbc;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.test.domain.web.User;

@Transactional
@Service
public class UserJdbcTemplate {

	@Autowired
	@Qualifier("primaryJdbcTemplate")
	JdbcTemplate jdbcTemplate;

	public List<User> getJdbcList() {
		return jdbcTemplate.query("select * from `user`", new BeanPropertyRowMapper<User>(User.class));
	}

	public int insert() {
		String sql = "insert into `user`(name,createtime) values(?,?)";
		return jdbcTemplate.update(sql, new Object[] { "jdbc", new Date() });
	}

}