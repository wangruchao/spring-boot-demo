
package com.test.controller.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/app")
@RestController
public class RestIndexController {

	@GetMapping
	public String hello() {
		return "Hello World!";
	}

}
