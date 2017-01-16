package com.cloud.cntrl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.cloud.dao.RegisterDAO;


public class RegisterCntrl implements Controller {
	private static final long serialversionUID=0;
	private RegisterDAO RegisterDao;

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
	
		HttpSession session = request.getSession();
		SimpleDateFormat sdfDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now=new Date();
		String userName=request.getParameter("userName");
		String password1=request.getParameter("password1");
		String email=request.getParameter("email");
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String role=request.getParameter("role");
		String date= sdfDate.format(now);
		session.setAttribute("UserName", userName);
		session.setAttribute("password1", password1);
		session.setAttribute("email", email);
		session.setAttribute("firstname", firstname);
		session.setAttribute("lastname", lastname);
		session.setAttribute("role", role);
		
		RegisterDao.addUserDetails(userName, password1, email, firstname, lastname, role, date);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("msg", "Registeration Successfull");
		return new ModelAndView("Success", "msg", model);
	}
			
		public RegisterDAO getRegisterDao() {
			return RegisterDao;
		}
		public void setRegisterDao(RegisterDAO RegisterDao) {
			this.RegisterDao = RegisterDao;
		}
	
	

}
