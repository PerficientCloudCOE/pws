package com.cloud.cntrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.cloud.dao.GroupDAO;
import com.cloud.dao.UserDAO;
import com.cloud.domain.Credentials;
import com.cloud.domain.Group;

public class LoginCntrl implements Controller{
	private UserDAO userDao;
	private GroupDAO groupDao;
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
		HttpSession session = request.getSession();
		String userName = request.getParameter("txtUserName");
		String password= request.getParameter("txtPassword");
		session.setAttribute("UserName", userName);
		session.setAttribute("Password", password);
		Map<String, Object> model = new HashMap<String, Object>();
		ArrayList credentials = (ArrayList) getUserDao().findUser(userName, password);
		if(credentials.size()>0){
			model.put("group", Group.class);
			model.put("listGroups", getGroupDao().listGroup());
//			model.put("msg", "Login Successful");
		}
		else
			model.put("msg", "Invalid User");
		return new ModelAndView("resultPage", "msg", model); 
	}
	
	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	public GroupDAO getGroupDao() {
		return groupDao;
	}

	public void setGroupDao(GroupDAO groupDao) {
		this.groupDao = groupDao;
	}
	
}
