package com.ibm.service;

import java.util.List;

import com.ibm.model.Customer;
import com.ibm.repository.CustomerRepository;
import com.ibm.repository.CustomerRepositoryImpl;

public class CustomerServiceImpl implements CustomerService {
	private CustomerRepository cusRepo;
	{
		try {
			cusRepo = new CustomerRepositoryImpl();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public Customer insertOneCustomer(Customer cus) throws Exception {
		// TODO Auto-generated method stub
		return cusRepo.insertOneCustomer(cus);
	}

	@Override
	public List<Customer> getAllCustomers() throws Exception {
		// TODO Auto-generated method stub
		return cusRepo.getAllCustomers();
	}

	@Override
	public Customer findCustomerById(int cusId) throws Exception {
		// TODO Auto-generated method stub
		return cusRepo.findCustomerById(cusId);
	}

	@Override
	public Customer findCustomerByEmail(String cusEmail) throws Exception {
		// TODO Auto-generated method stub
		return cusRepo.findCustomerByEmail(cusEmail);
	}	
	
	@Override
	public Customer updateCustomerById(Customer cus) throws Exception {
		// TODO Auto-generated method stub
		return cusRepo.updateCustomerById(cus);
	}

	@Override
	public Boolean deleteCustomerById(Customer cus) throws Exception {
		// TODO Auto-generated method stub
		return cusRepo.deleteCustomerById(cus);
	}
}
