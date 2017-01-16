package com.cloud.dao;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.cloud.domain.Member;

public class MemberDAO {

	HibernateTemplate template;
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sesFactory){
		this.sessionFactory = sesFactory;
	}
	
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	public void addMember(Member e){
		template.save(e);
	}
}
