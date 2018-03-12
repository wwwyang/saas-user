package com.lenovo.robot.cloud.service;

import java.util.List;

public interface IService<T> {

	int insert(T t);

	int update(T t);

	T selectByPrimaryKey(String id);

	List<T> selectList(int pageNum, int pageSize);

	int delete(String userid);
}
