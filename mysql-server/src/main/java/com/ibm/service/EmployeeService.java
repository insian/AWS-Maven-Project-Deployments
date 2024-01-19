package com.ibm.service;

import java.sql.SQLException;
import java.util.List;

import com.ibm.model.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees() throws SQLException;
	Boolean insertOneEmployee(Employee emp) throws SQLException;
	Boolean updateEmployeeById(Employee employee) throws SQLException;
	Employee findEmployeeById(int employeeId) throws SQLException;
	Boolean deleteEmployeeById(int employeeId) throws SQLException;
}
