package com.test.repository.admin;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.domain.admin.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {

}