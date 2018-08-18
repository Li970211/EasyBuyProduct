package com.lijia.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lijia.domain.News;
import com.lijia.domain.Page;
import com.lijia.service.NewsService;
import com.lijia.service.Impl.NewsServiceImpl;
/**
  * 处理新闻信息
 * @author 李嘉
 *
 */
@WebServlet("/NewsInfoServlet")
public class NewsInfoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewsService service = new NewsServiceImpl();
		//获取当前页码
		int nowpage = Integer.parseInt(request.getParameter("nowpage"));
		//设置页码显示记录数
		int newscount = 5;
		//调用service查询分页的新闻数据
		Page page = service.newsPageInfo(nowpage,newscount);
		//存入request域中,带到newList.jsp页面中进行显示
		request.setAttribute("page", page);
		//查询所有的新闻信息
		List<News> sumNews = service.getAllNews();
		request.setAttribute("sumNews", sumNews);
		request.getRequestDispatcher("/newList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
