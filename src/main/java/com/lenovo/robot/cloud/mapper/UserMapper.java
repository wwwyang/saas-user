package com.lenovo.robot.cloud.mapper;

import java.util.List;

import com.lenovo.robot.cloud.model.User;

/**
 * 
 * @author yangww4
 *
 */
public interface UserMapper {
	/**
	 * 根据id进行软删除
	 * @param userId
	 * @return
	 */
	int deleteByPrimaryKey(String userid);

	/**
	 * 添加
	 * @param record
	 * @return
	 */
	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(String userid);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	List<User> selectList();
}