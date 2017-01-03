//package com.test.common.security;
//
//import java.io.Serializable;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.PermissionEvaluator;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Component;
//
//import com.test.domain.admin.User;
//import com.test.service.admin.RoleService;
//import com.test.service.admin.SysUserService;
//
//@Component
//public class MyPermissionEvaluator implements PermissionEvaluator {
//
//	@Autowired
//	private SysUserService loginService;
//
//	@Autowired
//	private RoleService roleService;
//
//	@Override
//	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
//		String username = authentication.getName();
//		User user = loginService.findByName(username);
//		return roleService.authorized(user.getId(), targetDomainObject.toString(), permission.toString());
//	}
//
//	@Override
//	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
//			Object permission) {
//		// not supported
//		return false;
//	}
//
//}
