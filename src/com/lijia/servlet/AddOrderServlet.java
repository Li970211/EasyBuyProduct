package com.lijia.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lijia.domain.Cart;
import com.lijia.domain.Order;
import com.lijia.domain.OrderListForm;
import com.lijia.domain.Product;
import com.lijia.service.OrderService;
import com.lijia.service.ProductInfoService;
import com.lijia.service.Impl.OrderServiceImpl;
import com.lijia.service.Impl.ProductInfoServiceImpl;


@WebServlet("/AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderService orderService = new OrderServiceImpl();
		ProductInfoService productInfoService = new ProductInfoServiceImpl();
		Order order = new Order();
		//用户id
		int userId = Integer.parseInt(request.getParameter("userId"));
		//订单编号
		order.setOrderId(UUID.randomUUID().toString());
		//获取订单计算金额
		List<Cart> cart = orderService.getCartByUserId(userId);
		double cost = 0;//商品的单价
		int num = 0;//商品的数量
		double sumCost = 0;//总消费
		//订单详细
		List<OrderListForm> list = new ArrayList<>();
		OrderListForm orderListForm = null;
		
		for (Cart cartList : cart) {
			orderListForm = new OrderListForm();
			cost = cartList.getCost();
			num = cartList.getQuantity();
			sumCost += (cost*num);
			orderListForm.setProductId(cartList.getProductId());
			orderListForm.setQuantity(cartList.getQuantity());
			Product product = productInfoService.findProdctById(cartList.getProductId());
			orderListForm.setProduct(product);
			orderListForm.setCost(sumCost);
			orderListForm.setOrderId(order.getOrderId());
			list.add(orderListForm);
		}
		order.setCreateTime(new Date().toLocaleString());
		order.setUserId(userId);
		order.setCost(sumCost);
		order.setList(list);
		//调用service中的添加订单的方法
		orderService.addOrder(order);
		request.getSession().setAttribute("orderListForm", order.getList());
		//清空购物车
		orderService.clearCart(userId);
		request.getSession().removeAttribute("cart");
		request.getRequestDispatcher("/BuyCar_Two.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

