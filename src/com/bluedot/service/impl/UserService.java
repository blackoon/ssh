package com.bluedot.service.impl;

import java.util.List;

import com.bluedot.dao.IBaseDao;
import com.bluedot.service.IUserService;
import com.bluedot.vo.User;

public class UserService implements IUserService{
	
	IBaseDao<User,String> userDao; 
	
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		
	}

	public void insertUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public List<User> queryAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public User queryUserById() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean queryUserInfo(User user) {
		String hql = "select count(u.username) from User as u where u.username=? and u.password=?";
		Object[] param = new Object[]{user.getUsername(), user.getPassword()};
		int x = Integer.parseInt(userDao.queryByHql(hql, param).get(0).toString());
		if(x>0) {
			return true;
		} else {
			return false;
		}
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public IBaseDao<User, String> getUserDao() {
		return userDao;
	}

	public void setUserDao(IBaseDao<User, String> userDao) {
		this.userDao = userDao;
	}
	
	
}
