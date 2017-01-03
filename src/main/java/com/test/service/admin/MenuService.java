package com.test.service.admin;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.domain.admin.Menu;
import com.test.repository.admin.MenuRepository;

@Transactional
@Service
public class MenuService {

	@Autowired
	MenuRepository menuRepository;

	public List<Menu> findAll() {
		return menuRepository.findAll();
	}

	public Menu create(Menu menu) {
		return menuRepository.save(menu);
	}

	public Menu findById(Long id) {
		return menuRepository.findOne(id);
	}

	public Menu update(Menu menu) {
		return menuRepository.save(menu);
	}

	public void delete(Long id) {
		menuRepository.delete(id);
	}

}