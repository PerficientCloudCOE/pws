package com.cloud.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cloud.domain.Group;

public class GroupDAO {
//	HibernateTemplate template;
	SessionFactory sessionFactory;
	
//	public void setTemplate(HibernateTemplate template) {
//		this.template = template;
//	}

	public void setSessionFactory(SessionFactory sesFactory){
		this.sessionFactory = sesFactory;
	}

	public Object listGroup() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Group.class);
		criteria.setMaxResults(10);
		Object groupList = criteria.list();
		session.close();
		return groupList;
	}

}