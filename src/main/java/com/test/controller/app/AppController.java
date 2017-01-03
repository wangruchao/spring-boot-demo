
package com.test.controller.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.test.domain.web.User;
import com.test.service.web.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RequestMapping("/app")
@RestController
@Api(tags = { "V1" }, description = "手机接口")
public class AppController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "测试手机Hello World!")
	@GetMapping
	public String hello() {
		return "Hello World!";
	}

	@GetMapping("json")
	@ApiOperation(tags = "V2", value = "测试-json", notes = "json更多说明")
	// @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true,
	// dataType = "User")
	// @ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "用户ID",
	// required = true, dataType = "Long"),
	// @ApiImplicitParam(name = "pageNo", value = "页数", required = true,
	// dataType = "Long"),
	// @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true,
	// dataType = "User") })
	public List<User> json(
			@ApiParam(required = true, name = "pageNo", value = "页数") @RequestParam(value = "pageNo") int pageNo) {
		return userService.findAll();
	}

	@PostMapping("add")
	@ApiOperation(notes = "add", value = "添加文件")
	public List<User> add(
			@ApiParam(required = true, name = "file", value = "文件") @RequestParam("file") MultipartFile file,
			@ApiParam(required = true, name = "user", value = "用户实体类") User user) {
		return userService.findAll();
	}

	@PostMapping("file")
	@ApiOperation(value = "添加一个文件")
	public List<User> file(
			@ApiParam(required = true, name = "file", value = "文件") @RequestParam("file") MultipartFile file,
			@ApiParam(required = true, name = "user", value = "用户实体类") User user) {
		return userService.findAll();
	}

}
