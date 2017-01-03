
package com.test.controller.admin;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.domain.admin.Menu;
import com.test.domain.admin.Role;
import com.test.service.admin.MenuService;
import com.test.service.admin.RoleService;

@RequestMapping("/admin/role")
@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;
	@Autowired
	private MenuService menuService;

	@GetMapping
	public String view(Model model) {
		model.addAttribute("list", roleService.findAll());
		return "/admin/role/list";
	}

	@GetMapping("/toadd")
	public String toadd(Model model) {
		model.addAttribute("role", new Role());
		return "/admin/role/add";
	}

	@GetMapping("/add")
	public String add(@Valid Role role, BindingResult result, Model model) {
		// 有错误信息.
		model.addAttribute("role", role);
		if (result.hasErrors()) {
			return "/admin/role/add";
		}
		roleService.create(role);
		return "redirect:/admin/role";
	}

	@GetMapping("/{id}/toedit")
	public String toedit(@PathVariable("id") Long id, Model model) {
		Role role = roleService.findById(id);
		model.addAttribute("role", role);
		List<Menu> menus = menuService.findAll();
		model.addAttribute("menus", menus);
		return "/admin/role/edit";
	}

	@GetMapping("/edit")
	public String edit(@Valid Role role,
			@RequestParam(value = "menuids", required = false, defaultValue = "") Long[] menuids,
			BindingResult result, Model model) {
		// 有错误信息.
		model.addAttribute("menus", menuService.findAll());
		model.addAttribute("role", role);
		if (result.hasErrors()) {
			return "/admin/role/edit";
		}
		Set<Menu> menus = new HashSet<>();
		for (Long menuid : menuids) {
			menus.add(menuService.findById(menuid));
		}
		role.setMenus(menus);
		roleService.update(role);
		return "redirect:/admin/role";
	}

	@GetMapping("/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		roleService.delete(id);
		return "redirect:/admin/role";
	}

}
