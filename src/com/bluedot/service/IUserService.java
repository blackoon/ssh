package com.bluedot.service;

import java.util.List;

import com.bluedot.vo.User;

public interface IUserService {
	public void insertUser(User user);
	public void deleteUser(String id);
	public void updateUser(User user);
	public List<User> queryAllUser();
	public User queryUserById();
	public boolean queryUserInfo(User user);
}
