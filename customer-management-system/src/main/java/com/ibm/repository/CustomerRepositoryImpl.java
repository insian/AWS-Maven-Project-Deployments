package com.ibm.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ibm.factory.MySessionFactory;
import com.ibm.model.Customer;

public class CustomerRepositoryImpl implements CustomerRepository {
	
	private SessionFactory sessionFactory = null;
	private List<Customer> list;
	private Session session = null;
	{
		try {
			sessionFactory = MySessionFactory.getSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Customer insertOneCustomer(Customer cus) throws Exception {
		try{
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			session.persist(cus);
			session.getTransaction().commit();
			return cus;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Customer> getAllCustomers() throws Exception {
		session = sessionFactory.openSession();
		TypedQuery<Customer> query = session.createQuery("FROM Customer C",Customer.class);
		return query.getResultList();
	}

	@Override
	public Customer findCustomerById(int cusId) throws Exception {
		session = sessionFactory.openSession();
		Customer customer = session.find(Customer.class,cusId);
		return customer;
	}
	
	@Override
	public Customer findCustomerByEmail(String cusEmail) throws Exception {
		session = sessionFactory.openSession();
		TypedQuery<Customer> query = session.createQuery("FROM Customer C where C.customerEmail=:e",Customer.class);
		query.setParameter("e",cusEmail);
		list = query.getResultList();
		if(list.size()==1) {
			return list.get(0);
		} else {
			return null;
		}
	}	
	
	@Override
	public Customer updateCustomerById(Customer cus) throws Exception {
		session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.merge(cus);
		session.getTransaction().commit();
		return cus;
	}

	@Override
	public Boolean deleteCustomerById(Customer cus) throws Exception {
		session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.remove(cus);
		session.getTransaction().commit();
		return null;
	}
}
