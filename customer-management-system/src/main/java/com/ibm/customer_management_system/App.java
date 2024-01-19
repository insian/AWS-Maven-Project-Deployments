package com.ibm.customer_management_system;

import static java.lang.System.in;
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.ibm.model.Customer;
import com.ibm.service.CustomerService;
import com.ibm.service.CustomerServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
	private static CustomerService cusService;
	static {
		cusService = new CustomerServiceImpl();
	}
	private static BufferedReader br =new BufferedReader(new InputStreamReader(in));
	
    public static void main( String[] args )
    {
    	Customer cus = new Customer();
    	
    	//Insert One Customer
    	/*try {
    		out.println("Enter Customer Name");
        	cus.setCustomerName(br.readLine());
        	out.println("Enter Customer Address");
        	cus.setCustomerAddress(br.readLine());
        	out.println("Enter Customer Email");
        	cus.setCustomerEmail(br.readLine());
        	cusService.insertOneCustomer(cus);
        	out.println(cus);
        	
    	} catch(Exception e){
    		out.println("Email already exists");
    	}*/
    	
    	//Get All Customer
    	/*try {
        	for(Customer c: cusService.getAllCustomers()) {
        		out.println(c);
        	}
    	} catch(Exception e) {
    		e.printStackTrace();
    	}*/
    	
    	//Find Customer by Customer ID
    	/*try {
    		out.println("Enter Customer Id");
        	cus=cusService.findCustomerById(Integer.parseInt(br.readLine()));
    		if(cus==null) {
    			out.println("Invalid id");
    		}else{
    			out.println(cus);
    		};
    	} catch (Exception e) {
			e.printStackTrace();
		}*/
    	
    	//Find Customer by Email ID
    	try {
    		out.println("Enter email id");
			cus = cusService.findCustomerByEmail(br.readLine());
			if(cus==null) {
				out.println("Email Not found");
			} else {
				out.println(cus);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    	//Update A Customer By Id
    	/*try {
    		out.println("Enter Customer Id");
    		cus=cusService.findCustomerById(Integer.parseInt(br.readLine()));
    		if(cus==null) {
    			out.println("Invalid id");
    		}else{
    			out.println("Enter Customer Name");
            	cus.setCustomerName(br.readLine());
            	out.println("Enter Customer Address");
            	cus.setCustomerAddress(br.readLine());
            	out.println("Enter Customer Email");
            	cus.setCustomerEmail(br.readLine());
            	cusService.updateCustomerById(cus);
            	out.println(cus);
    		};
    	} catch (Exception e){
    		out.println("Email Already exists");
    	}*/
    	
		//Delete a Customer By Id
    	/*try {
    		/*out.println("Enter Customer Id");
    		cus=cusService.findCustomerById(Integer.parseInt(br.readLine()));
    		if(cus==null) {
    			out.println("Invalid id");
    		}else{
            	cusService.deleteCustomerById(cus);
            	out.println("Successful deletion");
    		};
		} catch (Exception e) {
			e.printStackTrace();
		}*/
    	
    }
}
