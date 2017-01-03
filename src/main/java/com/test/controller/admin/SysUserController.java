
package com.test.controller.admin;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.domain.admin.Role;
import com.test.domain.admin.User;
import com.test.service.admin.RoleService;
import com.test.service.admin.SysUserService;

@RequestMapping("/admin/user")
@Controller
public class SysUserController {

	private final static BCryptPasswordEncoder bc = new BCryptPasswordEncoder(4);

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private RoleService roleService;

	@GetMapping
	public String view(Model model) {
		model.addAttribute("list", sysUserService.findAll());
		return "/admin/user/list";
	}

	@GetMapping("/toadd")
	public String toadd(Model model) {
		model.addAttribute("roles", roleService.findAll());
		model.addAttribute("user", new User());
		return "/admin/user/add";
	}

	@GetMapping("/add")
	public String add(@Valid User user, BindingResult result, Model model) {
		// 有错误信息.
		model.addAttribute("roles", roleService.findAll());
		model.addAttribute("user", user);
		if (result.hasErrors()) {
			return "/admin/user/add";
		}
		user.setPassword(bc.encode(user.getPassword()));
		sysUserService.create(user);
		return "redirect:/admin/user";
	}

	@GetMapping("/{id}/toedit")
	public String toedit(@PathVariable("id") Long id, Model model) {
		User user = sysUserService.findById(id);
		user.setPassword("");
		model.addAttribute("roles", roleService.findAll());
		model.addAttribute("user", user);
		return "/admin/user/edit";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam("id") Long id,
			@RequestParam(value = "roleids", required = false, defaultValue = "") Long[] roleids, Model model) {
		// 有错误信息.
		model.addAttribute("roles", roleService.findAll());
		User user = sysUserService.findById(id);
		model.addAttribute("user", user);
		Set<Role> roles = new HashSet<Role>();
		for (Long roleid : roleids) {
			roles.add(roleService.findById(roleid));
		}
		user.setRoles(roles);
		sysUserService.update(user);
		return "redirect:/admin/user";
	}

	@GetMapping("/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		sysUserService.delete(id);
		return "redirect:/admin/user";
	}

}
