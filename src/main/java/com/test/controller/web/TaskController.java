
package com.test.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.task.Task;

@Controller
public class TaskController {

	@Autowired
	Task task;

	@ResponseBody
	@RequestMapping("/task")
	public String task() throws Exception {
		long start = System.currentTimeMillis();
		task.doTaskOne();
		task.doTaskTwo();
		task.doTaskThree();
		long end = System.currentTimeMillis();
		System.out.println("总任务，耗时：" + (end - start) + "毫秒");
		return "task";
	}
}
