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

@WebServlet("/ChangNumServlet")
public class ChangNumServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户的id
		User user = (User) request.getSession().getAttribute("user");
		Integer userId = user.getId();
		ProductInfoService service = new ProductInfoServiceImpl();
		//获取要购买商品的id 
		String idStr = request.getParameter("id");
		int buyNum = Integer.parseInt(request.getParameter("buyNum"));//购买数量
		int id = Integer.parseInt(idStr);
		Product product = service.findProdctById(id);
		if(product == null) {
			throw new RuntimeException("找不到该商品");
		}else {
			service.updateCartProdNum(userId,product,buyNum);
		}
		
		request.getRequestDispatcher("/ShowCartServlet").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
