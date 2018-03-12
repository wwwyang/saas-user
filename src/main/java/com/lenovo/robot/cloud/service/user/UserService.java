package com.lenovo.robot.cloud.service.user;

import java.util.List;

import com.lenovo.robot.cloud.model.User;

/**
 * 
 * @author yangww4
 *
 */
public interface UserService {
	
	int insert(User user);

	int update(User user);

	User selectByPrimaryKey(String userid);

	List<User> selectList(int pageNum, int pageSize);

	int delete(String userid);
}
