
package com.test.controller.admin;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.domain.admin.AdminUser;
import com.test.mapper.admin.AdminUserMapper;
import com.test.service.admin.AdminUserService;

@RequestMapping("/admin")
@Controller("/admin")
public class AdminController {

	@Autowired
	private AdminUserService adminUserService;

	@Autowired
	private AdminUserMapper	 adminUserMapper;

	@RequestMapping
	public String view(Map<String, Object> map) {
		map.put("list", adminUserService.findAll());
		return "/admin/list";
	}

	@RequestMapping("/list")
	public String list(Map<String, Object> map) {
		map.put("list", "");
		return "/admin/list";
	}

	@RequestMapping("/page")
	public String page(Map<String, Object> map) {
		map.put("list", adminUserMapper.findAll());
		return "/admin/list";
	}

	@RequestMapping("/save")
	public String save() {
		AdminUser adminUser = new AdminUser();
		adminUser.setName("Angel");
		adminUser.setCreatetime(new Date());
		adminUserService.save(adminUser);
		return "redirect:/admin";
	}

}
