package com.test.controller.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(basePackages = "com.test.controller.web")
public class WebExceptionHandler {

	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public Map<String, Object> defaultErrorHandler(HttpServletRequest req, Exception e) {
		e.printStackTrace();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("e", e.getMessage());
		return map;
	}

}
