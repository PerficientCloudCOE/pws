package com.cloud.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.cloud.domain.Message;

public class MessageDAO {
	
	HibernateTemplate template;
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sesFactory){
		this.sessionFactory = sesFactory;
	}
	
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	public void saveMessage(Message e){
		template.save(e);
	}

}
