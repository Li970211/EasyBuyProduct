package com.lijia.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lijia.domain.Cart;
import com.lijia.domain.Category;
import com.lijia.domain.Page;
import com.lijia.domain.Product;
import com.lijia.domain.User;
import com.lijia.service.Categoryservice;
import com.lijia.service.NewsService;
import com.lijia.service.ProductInfoService;
import com.lijia.service.UserService;
import com.lijia.service.Impl.NewsServiceImpl;
import com.lijia.service.Impl.ProductInfoServiceImpl;
import com.lijia.service.Impl.UserServiceImpl;
import com.lijia.service.Impl.categoryserviceImpl;

@WebServlet("/categoryservlet")
public class categoryservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获得一级列表
		Categoryservice cs = new categoryserviceImpl();
		List<Category> listfirst = cs.findfirstcategory();
		
		for (Category first : listfirst) {
			// 获得二级列表
			int id = first.getId();
			List<Category> secondcategory = cs.findchild(id);
			
			first.setList(secondcategory);
			List<Product> findallproduct = cs.findallproduct(id);
			first.setProducts(findallproduct);
			// 获得三级列表
			for (Category second : secondcategory) {
				int id1 = second.getId();
				List<Category> list = cs.findchild(id1);
				second.setList(list);
			}
		}

		HttpSession session = request.getSession();
		session.setAttribute("listcategory", listfirst);
		User user = (User) request.getSession().getAttribute("user");
		if(user!=null) {
			//用户登录进来就去查询其的购物车记录
			UserService userService = new UserServiceImpl();
			List<Cart> cart =  userService.getCartByUserId(user.getId());
			//遍历list查询商品
			ProductInfoService proService = new ProductInfoServiceImpl();
			for (Cart cartList : cart) {
				Product product = proService.findProdctById(cartList.getProductId());
				cartList.setProduct(product);
			}
			request.getSession().setAttribute("cart", cart);
		}
		//查询最新的5条新闻
		NewsService service = new NewsServiceImpl();
		Page newlist = service.newsPageInfo(1, 5);
		request.setAttribute("newlist", newlist);
		// 分发转向
		request.getRequestDispatcher("/Index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}



