package com.lijia.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.lijia.domain.Cart;
import com.lijia.domain.Msg;
import com.lijia.domain.User;
import com.lijia.service.UserService;
import com.lijia.service.Impl.UserServiceImpl;
import com.lijia.util.MD5Utils;


@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService service = new UserServiceImpl();
		//创建JSONObj对象
		JSONObject  obj = new JSONObject();
		//获取数据并校验
		String username = request.getParameter("loginName");
		String pwd = request.getParameter("password");
		String password = MD5Utils.md5(pwd);
		//调用service根据用户名和密码查找用户的方法
		User user = service.findUserByNameAndPwd(username,password);
		//用户不存在返回到登录界面
		if(user == null) {
			obj.put("msg",Msg.fail().add("loginMsg", "用户名或者密码不正确"));
			response.getWriter().println(obj.toString());
			return;
		}
		//将用户名存入session带到主页面中显示
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		//处理记住用户名密码信息
		if("true".equals(request.getParameter("flag"))) {
			//cookie中文会乱码，这里进行编码
			Cookie remname = new Cookie("remname", URLEncoder.encode(user.getLoginName()+"-"+pwd,"utf-8"));
			remname.setPath("/");
			remname.setMaxAge(60*60*3);//3个小时
			response.addCookie(remname);
		}else {
			//如果用户没有勾选用户名则删除记住用户名的cookie
			Cookie renNameC = new Cookie("remname", "");
			renNameC.setPath("/");
			renNameC.setMaxAge(0);
			response.addCookie(renNameC);
		}
		
		obj.put("msg", Msg.success().add("user", user));
		response.getWriter().println(obj.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
