
package com.test.controller.admin;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
	private AdminUserMapper adminUserMapper;

//	@RequestMapping
//	public String view(Map<String, Object> map) {
//		map.put("list", adminUserService.findAll());
//		return "/admin/list";
//	}

	@RequestMapping("/list")
	public String list(Map<String, Object> map) {
		map.put("list", "11");
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

	@RequestMapping("/toadd")
	public String toadd(@Valid AdminUser AdminUser, BindingResult result, Model model) {
		model.addAttribute("adminUser", new AdminUser());
		return "/admin/add";
	}

	@RequestMapping("/add")
	public String add(@Valid AdminUser AdminUser, BindingResult result, Model model) {
		// 有错误信息.
		model.addAttribute("adminUser", AdminUser);
		if (result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				System.out.println(error.getCode() + "---" + error.getArguments() + "---" + error.getDefaultMessage()
						+ "---" + error.getObjectName());
				for (Object o : error.getArguments()) {
					System.out.println(o);
				}

			}
			return "/admin/add";
		}
		return "admin/list";
	}
}
