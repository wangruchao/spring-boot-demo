package com.test.service.admin;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.domain.admin.Role;
import com.test.repository.admin.RoleRepository;

@Transactional
@Service
public class RoleService {

	@Autowired
	RoleRepository roleRepository;

	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	public Role create(Role role) {
		return roleRepository.save(role);
	}

	public Role findById(Long id) {
		return roleRepository.findOne(id);
	}

	public Role update(Role role) {
		return roleRepository.save(role);
	}

	public void delete(Long id) {
		roleRepository.delete(id);
	}

}