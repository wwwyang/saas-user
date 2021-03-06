package com.lenovo.robot.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lenovo.robot.cloud.constance.SystemConstance;
import com.lenovo.robot.cloud.model.User;
import com.lenovo.robot.cloud.service.user.UserService;

/**
 * 用户模块
 * <p>
 * 注解类型介绍: 组合注解(RequestMapping的变形)
 * 
 * @GetMapping = @RequestMapping(method = RequestMethod.GET)
 * @PostMapping = @RequestMapping(method = RequestMethod.POST)
 * @PutMapping = @RequestMapping(method = RequestMethod.PUT)
 * @DeleteMapping = @RequestMapping(method = RequestMethod.DELETE)
 * 
 * @author yangww4
 * 
 */
@Controller
@RequestMapping(value = "/users")
public class UserController {
	@Autowired
	private UserService userService;

	@ResponseBody
	@PostMapping(produces = { "application/json;charset=UTF-8" })
	public int insert(User user) {
		return userService.insert(user);
	}

	@ResponseBody
	@GetMapping(value = "/{pageNum}/{pageSize}", produces = { "application/json;charset=UTF-8" })
	public Object selectList(@PathVariable int pageNum, @PathVariable int pageSize) {

		if (pageSize == 0) {
			pageSize = SystemConstance.PAGE_SIZE;
		}

		return userService.selectList(pageNum, pageSize);
	}

	@ResponseBody
	@GetMapping(value = "/{userid}", produces = { "application/json;charset=UTF-8" })
	public Object selectList(@PathVariable String userid) {

		return userService.selectByPrimaryKey(userid);
	}

	@ResponseBody
	@DeleteMapping(value = "/{userid}", produces = { "application/json;charset=UTF-8" })
	public int delete(@PathVariable String userid) {

		return userService.delete(userid);
	}

	@ResponseBody
	@PutMapping(produces = { "application/json;charset=UTF-8" })
	public int update(User user) {

		return userService.update(user);
	}
}
