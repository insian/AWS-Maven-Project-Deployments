package com.ibm.repository;

import java.sql.SQLException;
import java.util.List;

import com.ibm.model.Order;

public interface OrderRepository {
	List<Order> getAllOrders() throws SQLException;
	Boolean insertOneOrder(Order ord) throws SQLException;
	Boolean updateOrderById(Order ord) throws SQLException;
	Order findOrderById(int ordId) throws SQLException;
	Boolean deleteOrderById(int ordId) throws SQLException;
}
