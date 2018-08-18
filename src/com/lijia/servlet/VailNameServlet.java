package com.lijia.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.lijia.domain.Msg;
import com.lijia.service.UserService;
import com.lijia.service.Impl.UserServiceImpl;


@WebServlet("/VailNameServlet")
public class VailNameServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService service = new UserServiceImpl();
		String loginName = request.getParameter("loginName");
		JSONObject obj = new JSONObject();
		//如果用户名已经存在
		if(service.hashName(loginName)) {
			obj.put("faile", "用户名已存在");
		}else {
			obj.put("success", "用户名可以使用");
		}
		
		response.getWriter().println(obj.toString());
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
