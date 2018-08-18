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
 * 删除购物车单个商品
 * @author 李嘉
 *
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户的id
		User user = (User) request.getSession().getAttribute("user");
		Integer userId = user.getId();
		//获取商品id
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		System.out.println(id);
		ProductInfoService service = new ProductInfoServiceImpl();
		Product product = service.findProdctById(id);
		System.out.println(product);
		
		service.deleteCartProduct(userId,product);
		 
		request.getRequestDispatcher("/ShowCartServlet").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
