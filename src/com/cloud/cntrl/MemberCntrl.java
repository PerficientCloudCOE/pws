package com.cloud.cntrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.cloud.dao.GroupDAO;
import com.cloud.dao.MemberDAO;
import com.cloud.domain.Group;
import com.cloud.domain.Member;

public class MemberCntrl implements Controller{
	private MemberDAO memberDao;
	private GroupDAO groupDao;
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
		int groupId = Integer.parseInt(request.getParameter("groups"));
		String firstName = request.getParameter("firstname");
		String lastName= request.getParameter("lastname");
		String email = request.getParameter("email");
		String mobNo= request.getParameter("mobNo");
		
		Member member = new Member();
		member.setGroupId(groupId);
		member.setFirstName(firstName);
		member.setLastName(lastName);
		member.setEmail(email);
		member.setMobNo(mobNo);
		
		getMemberDao().addMember(member);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("group", Group.class);
		model.put("listGroups", getGroupDao().listGroup());
		
		return new ModelAndView("resultPage", "msg" ,model);
	}

	public MemberDAO getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}

	public GroupDAO getGroupDao() {
		return groupDao;
	}

	public void setGroupDao(GroupDAO groupDao) {
		this.groupDao = groupDao;
	}
}
