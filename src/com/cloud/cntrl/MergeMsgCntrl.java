package com.cloud.cntrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.cloud.dao.MessageDAO;
import com.cloud.domain.Message;

public class MergeMsgCntrl implements Controller{
	
	private MessageDAO messageDao;
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		HttpSession session = request.getSession();
		String msgContent = request.getParameter("txtMsg");
		String imgFile = request.getParameter("imgMsg");
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
//		msg.setId(1);
		msg.setMessage(msgContent);
		msg.setGroupIdList(groupList);
		msg.setStatus("Sent");
		getMessageDao().saveMessage(msg);
		System.out.println(msg.getId());
		return new ModelAndView("CreateMsgPage");
	}
	
	public MessageDAO getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDAO messageDao) {
		this.messageDao = messageDao;
	}
}
