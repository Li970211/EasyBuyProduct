package com.lijia.service.Impl;

import java.util.List;

import com.lijia.dao.OrderDao;
import com.lijia.dao.Productdao;
import com.lijia.dao.UserDao;
import com.lijia.dao.Impl.OrderDaoImpl;
import com.lijia.dao.Impl.ProductdaoImpl;
import com.lijia.dao.Impl.UserDaoImpl;
import com.lijia.domain.Cart;
import com.lijia.domain.Order;
import com.lijia.domain.OrderListForm;
import com.lijia.service.OrderService;
import com.lijia.service.ProductInfoService;

public class OrderServiceImpl implements OrderService {
	private UserDao userdao = new UserDaoImpl();
	private OrderDao orderdao = new OrderDaoImpl();
	private Productdao productdao = new ProductdaoImpl();
	
	@Override
	public List<Cart> getCartByUserId(int userId) {
		return userdao.getCartByUserId(userId);
	}

	@Override
	public void addOrder(Order order) {
		orderdao.addOrder(order);
		//生成订单项
		for (OrderListForm orderListForm : order.getList()) {
			orderdao.addOrderListForm(orderListForm);
			//删除商品对应的数量
			productdao.delProductNum(orderListForm.getProductId(),orderListForm.getQuantity());
		}
	}

	@Override
	public void clearCart(int userId) {
		productdao.clearCart(userId);
	}

	@Override
	public void updateOrderById(String orderId, String address) {
		orderdao.updateOrderById(orderId,address);
		
	}

	@Override
	public Order getOrderById(String orderId) {
		return orderdao.getOrderById(orderId);
	}

	

}
