package com.ibm.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ibm.factory.MyFactory;
import com.ibm.model.Employee;

public class EmployeeRepositoryImpl implements EmployeeRepository {

	private Connection connection = null;
	private List<Employee> list = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private PreparedStatement preparedStatement = null;
	{
		try {
			connection = MyFactory.getMyConnection();
			statement=connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Database Connection not done");
		}
	}

	
	@Override
	public List<Employee> getAllEmployees() throws SQLException {
		list = new ArrayList<Employee>();
		resultSet=statement.executeQuery("select * from employees");
		while(resultSet.next())
		{
			list.add(new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)));			
		}
		return list;
	}
	
	@Override
	public Boolean insertOneEmployee(Employee emp) throws SQLException {
		// TODO Auto-generated method stub
		preparedStatement = connection.prepareStatement("insert into employees(employee_id, first_name, last_name, email) values(?,?,?,?)");
		preparedStatement.setInt(1, emp.getId());
		preparedStatement.setString(2, emp.getFirst_name());
		preparedStatement.setString(3, emp.getLast_name());
		preparedStatement.setString(4, emp.getEmail());
		try {
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
			return false;
		} 
	}

	@Override
	public Boolean updateEmployeeById(Employee employee) throws SQLException {
		preparedStatement=connection.prepareStatement("update employees set first_name=?,last_name=?,email=? where employee_id=?");
		preparedStatement.setString(1, employee.getFirst_name());
		preparedStatement.setString(2, employee.getLast_name());
		preparedStatement.setString(3, employee.getEmail());
		preparedStatement.setInt(4, employee.getId());
		try {
			preparedStatement.executeUpdate();
			return true;
		} catch(SQLException e){
			return false;
		}
	}

	@Override
	public Employee findEmployeeById(int employeeId) throws SQLException {
		Employee tempEmployee = null;
		preparedStatement = connection.prepareStatement("select * from employees where employee_id=?");
		preparedStatement.setInt(1, employeeId);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			tempEmployee = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),resultSet.getString(4));
		}
		return tempEmployee;
	}

	@Override
	public Boolean deleteEmployeeById(int employeeId) throws SQLException {
		// TODO Auto-generated method stub
		preparedStatement = connection.prepareStatement("delete from employees where employee_id=?");
		preparedStatement.setInt(1, employeeId);
		int result = preparedStatement.executeUpdate();
		if(result>0) {
			return true;
		}
		else {
			return false;
		}
	}


}