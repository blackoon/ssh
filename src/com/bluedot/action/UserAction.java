package com.bluedot.action;

import org.apache.struts2.ServletActionContext;

import com.bluedot.service.IUserService;
import com.bluedot.vo.User;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	
	private User user;
	private IUserService userService;
	
	public String login() throws Exception {
		if(userService.queryUserInfo(user)) {
			ServletActionContext.getRequest().getSession().setAttribute("username", user.getUsername());
			return "success";
		} else {
			return "fail";
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	
}
