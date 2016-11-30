package com.cloud.cntrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.cloud.dao.GroupDAO;

public class CreateMsgCntrl implements Controller{
	private GroupDAO groupDao;
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("UserName");
		System.out.println("UserName = "+userName);
		String groups[] = request.getParameterValues("groupChBox");
		session.setAttribute("groups", groups);
		 
		if (groups != null) {
		    System.out.println("groups are: ");
		    for (String group : groups) {
		        System.out.println("\t" + group);
		    }
		}
		
		return new ModelAndView("CreateMsgPage");
	}
	
	public GroupDAO getGroupDao() {
		return groupDao;
	}

	public void setGroupDao(GroupDAO groupDao) {
		this.groupDao = groupDao;
	}
}
