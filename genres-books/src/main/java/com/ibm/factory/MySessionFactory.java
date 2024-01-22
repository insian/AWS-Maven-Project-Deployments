package com.ibm.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ibm.model.Book;
import com.ibm.model.Genre;

public class MySessionFactory {
	private static SessionFactory sessionFactory=null;
	static{
		try {
			sessionFactory = new Configuration().configure().addAnnotatedClass(Genre.class).addAnnotatedClass(Book.class).buildSessionFactory();
	    } catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static SessionFactory getSessionFactory() throws Exception
	{
		return sessionFactory;
	} 
}
