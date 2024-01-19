package com.ibm.service;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.ibm.model.Order;
import com.ibm.repository.OrderRepository;
import com.ibm.repository.OrderRepositoryImpl;

public class OrderServiceImpl implements OrderService{
	private OrderRepository orderRepo;
	{
		try {
			orderRepo = new OrderRepositoryImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Order> getAllOrders() throws SQLException {
		// TODO Auto-generated method stub
		return orderRepo.getAllOrders();
	}

	@Override
	public Boolean insertOneOrder(Order ord) throws SQLException {
		ord.setOrderID(generateId());
		return orderRepo.insertOneOrder(ord);
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
	public Boolean updateOrderById(Order ord) throws SQLException {
		// TODO Auto-generated method stub
		return orderRepo.updateOrderById(ord);
	}

	@Override
	public Order findOrderById(int ordId) throws SQLException {
		// TODO Auto-generated method stub
		return orderRepo.findOrderById(ordId);
	}

	@Override
	public Boolean deleteOrderById(int ordId) throws SQLException {
		// TODO Auto-generated method stub
		return orderRepo.deleteOrderById(ordId);
	}
}
