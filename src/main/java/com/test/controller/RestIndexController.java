
package com.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestIndexController {

	@GetMapping("/")
	public String hello() {
		return "Hello World!";
	}

}
