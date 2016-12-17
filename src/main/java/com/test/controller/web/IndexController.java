
package com.test.controller.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.service.web.UserService;

@Controller
public class IndexController {

	@Autowired
	UserService userService;

	@RequestMapping
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
}
