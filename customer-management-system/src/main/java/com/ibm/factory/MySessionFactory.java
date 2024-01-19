package com.ibm.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ibm.model.Customer;

public class MySessionFactory {
	private static SessionFactory sessionFactory=null;
	static{
		try {
			sessionFactory = new Configuration().configure().addAnnotatedClass(Customer.class).buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static SessionFactory getSessionFactory() throws Exception
	{
		return sessionFactory;
	} 
}
