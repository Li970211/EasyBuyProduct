package com.lijia.service;

import java.util.List;

import com.lijia.domain.Cart;
import com.lijia.domain.Order;

public interface OrderService {
	/**
	 * 根据用户id查询购物车的记录计算金额
	 * @param userId
	 * @return
	 */
	List<Cart> getCartByUserId(int userId);
	/**
	 *  添加订单
	 * @param order
	 */
	void addOrder(Order order);
	/**
	 * 根据用户的id清空购物车
	 * @param userId
	 */
	void clearCart(int userId);
	/**
	 * 根据订单编号，更新订单
	 * @param orderId 订单编号
	 * @param address 用户输入的地址
	 */
	void updateOrderById(String orderId, String address);
	/**
	  * 根据订单id查询订单
	 * @param orderId 订单id
	 * @return 
	 */
	Order getOrderById(String orderId);

}
