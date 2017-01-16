package com.cloud.cntrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.cloud.action.PublishMessageAction;
import com.cloud.dao.GroupDAO;
import com.cloud.dao.MessageDAO;
import com.cloud.dao.UserDAO;
import com.cloud.domain.Group;
import com.cloud.domain.Message;

public class MergeMsgCntrl implements Controller{
	
	private MessageDAO messageDao;
	private GroupDAO groupDao;
	private UserDAO userDao;

	@Autowired
	PublishMessageAction publishMessageAction;
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		HttpSession session = request.getSession();
		String msgContent = request.getParameter("txtMsg");
		String groups[] = (String[]) session.getAttribute("groups");
		String groupList = "";
		if (groups != null) {
		    System.out.println("groups are: ");
		    for (String group : groups) {
		    	if(groupList.equals(""))
		    		groupList = group;
		    	else
		    		groupList = groupList + " , " +group;
		        System.out.println("\t" + groupList);
		    }
		}
		
		Message msg = new Message();
		msg.setMessage(msgContent);
		msg.setGroupIdList(groupList);
		msg.setStatus("Sent");
		msg.setMailId(getUserDao().getUserMailId((String)session.getAttribute("UserName")));
		getMessageDao().saveMessage(msg);
		System.out.println(msg.getId());
		String result = publishMessageAction.publishMessageToQueue(msg);

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("msg", result);
		model.put("group", Group.class);
		model.put("listGroups", getGroupDao().listGroup());
		
		return new ModelAndView("resultPage","msg",model);
	}
	
	public MessageDAO getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDAO messageDao) {
		this.messageDao = messageDao;
	}
	public GroupDAO getGroupDao() {
		return groupDao;
	}

	public void setGroupDao(GroupDAO groupDao) {
		this.groupDao = groupDao;
	}

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
}
