package com.lijia.dao;

import com.lijia.domain.Order;
import com.lijia.domain.OrderListForm;

public interface OrderDao {
	/**
	 * 添加订单
	 * @param order
	 */
	void addOrder(Order order);
	/**
	 * 生成订单详细
	 * @param orderListForm
	 */
	void addOrderListForm(OrderListForm orderListForm);
	/**
	 * 根据订单id更新订单 的地址
	 * @param orderId 订单id
	 * @param address 地址
	 */
	void updateOrderById(String orderId, String address);
	/**
	 * 根据订单的id的查询订单
	 * @param orderId 订单id
	 */
	Order getOrderById(String orderId);

}
