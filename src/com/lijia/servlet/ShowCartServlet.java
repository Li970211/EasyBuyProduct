package com.lijia.servlet;

import java.io.IOException;
import java.util.List;

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


@WebServlet("/ShowCartServlet")
public class ShowCartServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService = new UserServiceImpl();
		ProductInfoService service = new ProductInfoServiceImpl();
		//获取用户
		User user = (User) request.getSession().getAttribute("user");
		//根据用户id查询购物车记录
		List<Cart> cart =  userService.getCartByUserId(user.getId());
		if(cart != null) {
			for (Cart cartList : cart) {
				Product product1 = service.findProdctById(cartList.getProductId());
				cartList.setProduct(product1);
			}
		}
		request.getSession().setAttribute("cart", cart);
		response.sendRedirect(request.getContextPath()+"/BuyCar.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
