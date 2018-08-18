package com.lijia.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lijia.domain.Product;
import com.lijia.domain.User;
import com.lijia.service.ProductInfoService;
import com.lijia.service.Impl.ProductInfoServiceImpl;

/**
 * 
 * 清空购物车
 * @author 李嘉
 *
 */
@WebServlet("/ClearCarServlet")
public class ClearCarServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductInfoService service = new ProductInfoServiceImpl();
		//获取用户的id
		User user = (User) request.getSession().getAttribute("user");
		Integer userId = user.getId();
		//清空购物车
		service.clearCart(userId);
		//请求转发到ShowCartServlet
		request.getRequestDispatcher("/ShowCartServlet").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
