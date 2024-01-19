package com.ibm;

import static java.lang.System.in;
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ibm.model.Employee;
import com.ibm.service.EmployeeService;
import com.ibm.service.EmployeeServiceImpl;

public class App {
	private static EmployeeService employeeService;
	static {
		employeeService = new EmployeeServiceImpl();
	}
	private static Scanner scanner = new Scanner(in);
	private static BufferedReader br=new BufferedReader(new InputStreamReader(in));

	public static void main(String[] args) {
		int choice = -1;
		
		do {
			choice=-1;
			out.println("1 : Show All Employees");
        	out.println("2 : Insert One Employee");
        	out.println("3 : Find Employee By ID");
        	out.println("4 : Update Employee By ID");
        	out.println("5 : Delete Employee By ID");
        	out.println("0 : to exit");
        	out.println("Please select the option:");
        	
        	try {
        		choice = scanner.nextInt();
        	}
        	catch (Exception e) {
        		scanner.next();
        	}
        	
        	switch(choice) {
        	case 1: //Show All Employees
        		List<Employee> employees=null;
				try {
					employees = employeeService.getAllEmployees();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(employees!=null) {
					for (Employee e : employees) {
	    				out.println(e);
	    			}
				}
				else {
					out.println("No Records Found");
				}
        		break;
        	case 2:
        		Employee employee = new Employee();
        		Boolean inserted = false;
        		try {
        			out.print("enter first name: ");
        			employee.setFirst_name(scanner.next());
        			out.print("enter last name: ");
        			employee.setLast_name(scanner.next());
        			out.print("enter email: ");
        			employee.setEmail(scanner.next());
        			inserted = employeeService.insertOneEmployee(employee);
        		}
        		catch (Exception e2) {
        			// TODO: handle exception
        			e2.printStackTrace();
        		}
        		if(inserted) {
        			out.println("Insertion Successful");
        			out.println(employee);
        		}
        		else {
        			out.println("Insertion Unsucessful");
        		}
        		break;
        	case 3:
        		out.print("Enter employee id: ");
        		Employee employee2=null;
				try {
					employee2 = employeeService.findEmployeeById(scanner.nextInt());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					scanner.next();
					out.println("Invalid ID type...");
				} 
    			if (employee2 == null) {
    				out.println("Invalid ID...");
    			} else {
    				out.println(employee2);
    			}
        		break;
        	case 4:
        		out.print("Enter employee id: ");
        		Employee employee3=null;
        		Boolean updated=false;
				try {
					employee3 = employeeService.findEmployeeById(scanner.nextInt());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					scanner.next();
					out.println("Invalid ID type...");
				}
    			if (employee3 == null) {
    				out.println("Invalid ID...");
    			} else {
    				try {
    					out.print("enter new first name: ");
        				String fName = br.readLine();
        				out.print("enter new last name: ");
        				String lName = br.readLine();
        				out.print("enter email: ");
        				String email = br.readLine();
        				if (fName.length() > 0) {
        					employee3.setFirst_name(fName);    					
        				}
        				if (lName.length() > 0) {
        					employee3.setLast_name(lName);
        				}
        				if (email.length() > 0) {
        					employee3.setEmail(email);
        				}
        				updated = employeeService.updateEmployeeById(employee3);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
    				if(updated) {
    					out.println("Updation Successful");
    					out.println(employee3);
    				}else {
    					out.println("Updation Unsuccessful...");
    				}
    			}
        		break;
        	case 5:
        		out.print("Enter employee id: ");
        		Employee employee4=null;
        		Boolean deleted = false;
				try {
					employee4 = employeeService.findEmployeeById(scanner.nextInt());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					scanner.next();
					out.println("Invalid ID type...");
				}
    			if (employee4 == null) {
    				out.println("Invalid ID...");
    			} else {
    				try {
    					deleted = employeeService.deleteEmployeeById(employee4.getId());
    				} catch (SQLException e) {
    					e.printStackTrace();
    				}
    				if(deleted) {
    					out.println("Deletion Successful");
    				}
    				else {
    					out.println("Deletion Unsuccessful");
    				}
    			}
        		break;
        	case 0:
        		out.println("Thank You");
        		break;
        	default:
        		out.println("Invalid option");
        		break;
        	}
        	
		} while (choice!=0);
		
		
		

	}
}