package com.ibm.repository;

import java.util.List;

import com.ibm.model.Customer;

public interface CustomerRepository {
	Customer insertOneCustomer(Customer cus) throws Exception;
	List<Customer> getAllCustomers() throws Exception;
	Customer findCustomerById(int cusId) throws Exception;
	Customer findCustomerByEmail(String cusEmail) throws Exception;
	Customer updateCustomerById(Customer cus) throws Exception;
	Boolean deleteCustomerById(Customer cus) throws Exception;
}
