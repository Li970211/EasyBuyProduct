package com.lijia.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lijia.domain.News;
import com.lijia.service.NewsService;
import com.lijia.service.Impl.NewsServiceImpl;


@WebServlet("/NewsDetailedServlet")
public class NewsDetailedServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取新闻id
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		NewsService service = new NewsServiceImpl();
		//根据id查询新闻的信息
		News news = service.getNewsById(id);
		List<News> sumNews = service.getAllNews();
		request.setAttribute("news", news);
		request.setAttribute("sumNews", sumNews);
		//请求转发到页面
		request.getRequestDispatcher("/newList.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
