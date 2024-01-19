package com.ibm.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ibm.factory.MyFactory;
import com.ibm.model.Order;
import com.ibm.model.OrderType;

public class OrderRepositoryImpl implements OrderRepository {

	private Connection connection = null;
	private List<Order> list = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private PreparedStatement preparedStatement = null;
	{
		try {
			connection = MyFactory.getMyConnection();
			statement = connection.createStatement();
			list = new ArrayList<Order>();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Database Connection not done");
		}
	}
	
	@Override
	public List<Order> getAllOrders() throws SQLException {
		// TODO Auto-generated method stub
		resultSet = statement.executeQuery("select * from orders");
		while(resultSet.next()) {
			list.add(new Order(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),OrderType.valueOf(resultSet.getString(4))));
		}
		return list;
	}

	@Override
	public Boolean insertOneOrder(Order ord) throws SQLException {
		// TODO Auto-generated method stub
		preparedStatement = connection.prepareStatement("insert into orders(order_id, order_name, order_date, order_type) values(?,?,?,?)");
		preparedStatement.setInt(1, ord.getOrderID());
		preparedStatement.setString(2, ord.getOrderName());
		preparedStatement.setString(3, ord.getOrderDate());
		preparedStatement.setString(4, ord.getOrderTypes().toString());
		try {
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Boolean updateOrderById(Order ord) throws SQLException {
		preparedStatement = connection.prepareStatement("update orders set order_name=?,order_date=?, order_type=? where order_id=?");
		preparedStatement.setString(1, ord.getOrderName());
		preparedStatement.setString(2, ord.getOrderDate());
		preparedStatement.setString(3, ord.getOrderTypes().toString());
		preparedStatement.setInt(4, ord.getOrderID());
		try {
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public Order findOrderById(int ordId) throws SQLException {
		Order tempOrder = null;
		preparedStatement = connection.prepareStatement("select * from orders where order_id=?");
		preparedStatement.setInt(1, ordId);
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			tempOrder = new Order(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),OrderType.valueOf(resultSet.getString(4)));
		}
		return tempOrder;
	}

	@Override
	public Boolean deleteOrderById(int ordId) throws SQLException {
		preparedStatement = connection.prepareStatement("delete from orders where order_id=?");
		preparedStatement.setInt(1, ordId);
		int result = preparedStatement.executeUpdate();
		if(result>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
