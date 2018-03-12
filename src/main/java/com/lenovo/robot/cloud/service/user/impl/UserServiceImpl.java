package com.lenovo.robot.cloud.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.lenovo.robot.cloud.mapper.UserMapper;
import com.lenovo.robot.cloud.model.User;
import com.lenovo.robot.cloud.service.user.UserService;

/**
 * 
 * @author yangww4
 *
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public int insert(User user) {
		return userMapper.insertSelective(user);
	}

	/**
	 * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
	 * <p>
	 * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
	 * <p>
	 * pageNum 开始页数
	 * <p>
	 * pageSize 每页显示的数据条数
	 */
	@Override
	public List<User> selectList(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return userMapper.selectList();
	}

}
