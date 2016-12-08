package com.cloud.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.cloud.domain.Credentials;
import com.cloud.domain.User;

public class UserDAO {
//	HibernateTemplate template;
	SessionFactory sessionFactory;
	
//	public void setTemplate(HibernateTemplate template) {
//		this.template = template;
//	}

	public void setSessionFactory(SessionFactory sesFactory){
		this.sessionFactory = sesFactory;
	}

	public Object findUser(String userName, String password) {
		int userID = findUserID(userName);
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Credentials.class);
		criteria.add(Restrictions.eq("userId", userID));
		criteria.add(Restrictions.eq("password", password));
		Object userList = criteria.list();
		session.close();
		return userList;
	}
	
	public int findUserID(String userName){
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userId", userName));
		List userList = criteria.list();
		session.close();
		int userId = 0;
		if(userList.size()>0){
			for(Object us : userList){
				User user = (User) us;
				userId = user.getId();
			}
		}
		return userId;
	}
}
