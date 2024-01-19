package com.ibm.service;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.ibm.model.Employee;
import com.ibm.repository.EmployeeRepository;
import com.ibm.repository.EmployeeRepositoryImpl;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	{
		try {
			employeeRepository = new EmployeeRepositoryImpl();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public List<Employee> getAllEmployees() throws SQLException {
		// TODO Auto-generated method stub
		return employeeRepository.getAllEmployees();
	}

	@Override
	public Boolean insertOneEmployee(Employee emp) throws SQLException {
		emp.setId(generateId());
		return employeeRepository.insertOneEmployee(emp);
		
	}
	
	private Integer generateId(){
		UUID idOne = UUID.randomUUID();
		String str = "" + idOne;
		int uid = str.hashCode();
		String filterStr = "" + uid;
		str = filterStr.replaceAll("-", "");
		int a=Integer.parseInt(str);
		return a;
	}

	@Override
	public Boolean updateEmployeeById(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		return employeeRepository.updateEmployeeById(employee);
	}

	@Override
	public Employee findEmployeeById(int employeeId) throws SQLException {
		// TODO Auto-generated method stub
		return employeeRepository.findEmployeeById(employeeId);
	}

	@Override
	public Boolean deleteEmployeeById(int employeeId) throws SQLException {
		// TODO Auto-generated method stub
		return employeeRepository.deleteEmployeeById(employeeId);
	}

}