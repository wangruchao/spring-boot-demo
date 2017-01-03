package com.test.repository.admin;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.domain.admin.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}