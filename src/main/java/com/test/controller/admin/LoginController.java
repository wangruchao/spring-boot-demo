package com.test.controller.admin;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.domain.admin.Menu;
import com.test.domain.admin.Role;
import com.test.domain.admin.User;

@Controller
@RequestMapping("/admin")
public class LoginController {

	@GetMapping
	public String home(Model model) {
		SecurityContext ctx = SecurityContextHolder.getContext();
		Authentication auth = ctx.getAuthentication();
		Set<Menu> menus = new HashSet<Menu>();
		if (auth.getPrincipal() instanceof UserDetails) {
			User user = (User) auth.getPrincipal();
			Set<Role> roles = user.getRoles();
			for (Role role : roles) {
				menus.addAll(role.getMenus());
			}
		}
		model.addAttribute("menus", menus);
		// model.addAttribute("menus", menuService.findAll());
		return "/admin/home";
	}

	@GetMapping("/login")
	public String login() {
//		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		SecurityContext ctx = SecurityContextHolder.getContext();
		Authentication auth = ctx.getAuthentication();
		if (auth.getPrincipal() instanceof UserDetails) {
			User user = (User) auth.getPrincipal();
			System.out.println(user.getName());
			// 已经登录跳转到默认首页
			return "redirect:/admin";
		}
		return "/admin/login";
	}
}