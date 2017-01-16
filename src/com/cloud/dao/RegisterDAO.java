package com.cloud.dao;

import org.hibernate.HibernateException;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cloud.domain.Register;
import com.cloud.domain.User;
import com.cloud.domain.UserAccess;
public class RegisterDAO {
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sesFactory){
		this.sessionFactory = sesFactory;
	}

	public void addUserDetails(String userName,String password1,String email,String firstname,String lastname,String role,String date){
		try{
						
			Session session=sessionFactory.openSession();
			
			Transaction transaction =session.beginTransaction();
			
			User register=new User();
			register.setUserId(userName);
			
			register.setEmail(email);
			register.setFirstname(firstname);
			register.setLastname(lastname);
			register.setRole(role);
			register.setDate(date);
			
			
			//int id = register.getId();
			
			
			//Integer id=(Integer) session.save(register);
			
					//(Integer) register.getId();
			
			session.save(register);
			transaction.commit();
			session.close();
			
			saveCredentials(register.getId(),password1);
//			saveCredentials(register.getId(),password1,session,register);
			
			//System.out.println("\n\n User Details are Saved!!! \n"+id);
		}catch (HibernateException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.out.println("error");
		}
	}
	
	void saveCredentials(int userId, String password){
		Session session=sessionFactory.openSession();
		
		Transaction transaction =session.beginTransaction();
		UserAccess useraccess=new UserAccess();
//		useraccess.setUser(user);
		useraccess.setUserId(userId);
		useraccess.setPassword1(password);
		session.save(useraccess);
		transaction.commit();
		session.close();
	}

}
