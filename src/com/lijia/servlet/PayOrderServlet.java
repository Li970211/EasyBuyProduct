package com.lijia.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lijia.domain.Order;
import com.lijia.domain.OrderListForm;
import com.lijia.service.OrderService;
import com.lijia.service.Impl.OrderServiceImpl;


@WebServlet("/PayOrderServlet")
public class PayOrderServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderService service = new OrderServiceImpl();
		//获取订单编号和地址信息
		String orderId = request.getParameter("orderId");
		String address = request.getParameter("address");
		//调用service的方法，填入地址
		service.updateOrderById(orderId,address);
		Order order = service.getOrderById(orderId);
		request.getSession().setAttribute("order",order);
		response.sendRedirect(request.getContextPath()+"/BuyCar_Three.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
