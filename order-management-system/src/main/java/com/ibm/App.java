package com.ibm;

import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.ibm.model.Customer;
import com.ibm.model.Order;
import com.ibm.service.CustomerOrderService;
import com.ibm.service.CustomerOrderServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
	private static CustomerOrderService cusOrService;
    static {
    	cusOrService = new CustomerOrderServiceImpl();
    }
    private static BufferedReader br =new BufferedReader(new InputStreamReader(in));
	
	public static void main( String[] args )
    {
    	Customer cus = new Customer();
    	Order ord = new Order();
    	
    	//Insert One Customer
    	/*try {
    		System.out.println("Enter Customer Name");
    		cus.setCustomerName(br.readLine());
    		System.out.println("Enter Order Type");
    		ord.setOrderType(br.readLine());
    		System.out.println("Enter Order Price");
    		ord.setOrderPrice(Double.parseDouble(br.readLine()));
    		System.out.println("Enter is the the confirmed?(true/false) ");
    		ord.setIsConfirmed(Boolean.valueOf(br.readLine()));
    		cus.setOrder(ord);
    		cus = cusOrService.insertCustomerOrder(cus);
    		if(cus==null) {
    			System.out.println("Not Inserted");
    		} else {
    			System.out.println("Insertion Successful");
    		}
    	} catch (Exception e) {
			// TODO: handle exception
    		e.printStackTrace();
		}*/
    	
    	//Get All CustomerOrder
    	/*try {
			for (Customer c: cusOrService.getAllCustomerOrders()) {
				System.out.println(c);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}*/
        
    	//Find Customer by Customer ID
    	/*try {
			System.out.println("Enter Customer Id");
			cus=cusOrService.findByCustomerId(br.readLine());
			if(cus==null) {
				System.out.println("Inavlid ID");
			} else {
				System.out.println(cus);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
    	
    	//Update Customer By Id
    	try {
			System.out.println("Enter Customer Id");
			cus=cusOrService.findByCustomerId(br.readLine());
			if(cus==null) {
				System.out.println("Invalid id");
			}else{
				System.out.println("Enter Customer Name");
	        	cus.setCustomerName(br.readLine());
	        	ord.setOrderId(cus.getOrder().getOrderId());
	        	System.out.println("Enter Order Type");
	        	ord.setOrderType(br.readLine());
	        	System.out.println("Enter Order Price");
	        	ord.setOrderPrice(Double.parseDouble(br.readLine()));
	        	System.out.println("Enter is the order confirmed?(true/false)");
	        	ord.setIsConfirmed(Boolean.parseBoolean(br.readLine()));
	        	cus.setOrder(ord);
	        	cusOrService.updateByCustomerId(cus);
	        	System.out.println(cus);
			};
		} catch (Exception e){
			e.printStackTrace();
		}
    	
    	//Delete a Record By  Customer Id
    	try {
    		System.out.println("Enter Customer Id");
    		cus=cusOrService.findByCustomerId(br.readLine());
    		if(cus==null) {
    			System.out.println("Invalid id");
    		}else{
            	cusOrService.deleteByCustomerId(cus);
            	System.out.println("Successful deletion");
    		};
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
