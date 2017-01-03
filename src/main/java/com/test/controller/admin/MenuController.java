
package com.test.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.domain.admin.Menu;
import com.test.service.admin.MenuService;

@RequestMapping("/admin/menu")
@Controller
public class MenuController {

	@Autowired
	private MenuService menuService;

	@GetMapping
	public String view(Model model) {
		model.addAttribute("list", menuService.findAll());
		return "/admin/menu/list";
	}

	@GetMapping("/toadd")
	public String toadd(Model model) {
		model.addAttribute("menu", new Menu());
		return "/admin/menu/add";
	}

	@GetMapping("/add")
	public String add(@Valid Menu menu, BindingResult result, Model model) {
		// 有错误信息.
		model.addAttribute("menu", menu);
		if (result.hasErrors()) {
			return "/admin/menu/add";
		}
		menuService.create(menu);
		return "redirect:/admin/menu";
	}

	@GetMapping("/{id}/toedit")
	public String toedit(@PathVariable("id") Long id, Model model) {
		Menu menu = menuService.findById(id);
		model.addAttribute("menu", menu);
		return "/admin/menu/edit";
	}

	@GetMapping("/edit")
	public String edit(@Valid Menu menu, BindingResult result, Model model) {
		// 有错误信息.
		model.addAttribute("menu", menu);
		if (result.hasErrors()) {
			return "/admin/menu/edit";
		}
		menuService.update(menu);
		return "redirect:/admin/menu";
	}

	@GetMapping("/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		menuService.delete(id);
		return "redirect:/admin/menu";
	}

}
