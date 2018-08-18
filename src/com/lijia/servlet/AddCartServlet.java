package com.lijia.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lijia.domain.Cart;
import com.lijia.domain.Product;
import com.lijia.domain.User;
import com.lijia.service.ProductInfoService;
import com.lijia.service.UserService;
import com.lijia.service.Impl.ProductInfoServiceImpl;
import com.lijia.service.Impl.UserServiceImpl;


@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductInfoService service = new ProductInfoServiceImpl();
		//获取用户id
		int userId = Integer.parseInt(request.getParameter("userId"));
		//获取要购买商品的id 
		String idStr = request.getParameter("prodId");
		int BuyNum = Integer.parseInt(request.getParameter("BuyNum"));//购买数量
		int prodId = Integer.parseInt(idStr);
		Product product = service.findProdctById(prodId);
		if(product == null) {
			throw new RuntimeException("找不到该商品");
		}else {
			service.addCart(userId, product, BuyNum);
		}
		
		request.getRequestDispatcher("/ShowCartServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
