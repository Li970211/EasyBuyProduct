package com.lijia.dao.Impl;

import java.sql.Date;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.lijia.dao.OrderDao;
import com.lijia.domain.Order;
import com.lijia.domain.OrderListForm;
import com.lijia.util.getDB_c3p0;

public class OrderDaoImpl implements OrderDao {

	@Override
	public void addOrder(Order order) {
		String sql = "INSERT INTO easybuy_order VALUES(?,?,null,?,?)";
		QueryRunner runner = new QueryRunner(getDB_c3p0.getDatasourse());
		try {
			// time=order.getCreateTime().getTime();
			//Date datetime = new Date(time);
			runner.update(sql, 
					order.getOrderId(),
					order.getUserId(),
					order.getCreateTime(),
					order.getCost()
					);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void addOrderListForm(OrderListForm orderListForm) {
		String sql = "INSERT INTO easybuy_order_detail VALUES(?,?,?,?)";
		QueryRunner runner = new QueryRunner(getDB_c3p0.getDatasourse());
		try {
			runner.update(sql, 
					orderListForm.getOrderId(),
					orderListForm.getProductId(),
					orderListForm.getQuantity(),
					orderListForm.getCost()
					);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateOrderById(String orderId, String address) {
		String sql = "UPDATE easybuy_order SET userAddress =  ?,cost = cost + 15 WHERE orderId = ?";
		QueryRunner runner = new QueryRunner(getDB_c3p0.getDatasourse());
		try {
			runner.update(sql, 
					address,
					orderId
					);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Order getOrderById(String orderId) {
		String sql = "SELECT * FROM easybuy_order WHERE orderId = ?";
		QueryRunner runner = new QueryRunner(getDB_c3p0.getDatasourse());
		try {
			return runner.query(sql, new BeanHandler<Order>(Order.class),orderId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
