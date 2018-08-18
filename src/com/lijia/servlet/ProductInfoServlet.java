package com.lijia.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lijia.domain.Product;
import com.lijia.service.ProductInfoService;
import com.lijia.service.Impl.ProductInfoServiceImpl;

/**
 * 商品信息的servlet,点击商品图片跳转到商品详细页面
 * @author 李嘉
 *
 */
@WebServlet("/ProductInfoServlet")
public class ProductInfoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductInfoService proService = new ProductInfoServiceImpl();
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		Product product =proService.findProdctById(id);
		if(product == null) {
			throw new RuntimeException("没有找到对应的商品");
		}
		request.getSession().setAttribute("p", product);
		//response.sendRedirect(request.getContextPath()+"/Product.jsp");
		request.getRequestDispatcher("/Product.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

