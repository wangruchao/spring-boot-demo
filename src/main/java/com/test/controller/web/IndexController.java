
package com.test.controller.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.test.domain.web.User;
import com.test.mapper.web.UserMapper;
import com.test.service.web.UserService;

@RequestMapping("/")
@Controller
public class IndexController {

	@Autowired
	UserService	userService;
	@Autowired
	UserMapper	userMapper;

	@GetMapping
	public String index(Map<String, Object> map) {
		map.put("hello", "index...");
		return "/index";
	}

	@RequestMapping("/list")
	public String getList(Map<String, Object> map) {
		map.put("hello", userService.getJdbcList());
		return "/index";
	}

	@RequestMapping("/insert")
	public String insert() {
		userService.insert();
		return "redirect:/list";
	}

	@RequestMapping("/page")
	public String likeName(@RequestParam(value = "pageNo", defaultValue = "0") int pageNo, Map<String, Object> map) {
		PageHelper.startPage(pageNo, 1);
		List<User> list = userMapper.selectAll();
		map.put("hello", list.get(0));
		return "/index";
	}
}
