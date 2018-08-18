package com.lijia.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.alibaba.fastjson.JSONObject;
import com.lijia.domain.Msg;
import com.lijia.domain.User;
import com.lijia.service.UserService;
import com.lijia.service.Impl.UserServiceImpl;
import com.lijia.util.MD5Utils;




@WebServlet("/UserRegistServlet")
public class UserRegistServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UserService service = new UserServiceImpl();
			JSONObject obj = new JSONObject();
			//校验验证码
			String val1 = request.getParameter("ValiImg");
			String val2 = (String) request.getSession().getAttribute("valistr");
			if(val1 == null || val2 == null || !val1.equals(val2)) {
				obj.put("msg", Msg.fail().add("ValiImg", "验证码错误"));
				response.getWriter().println(obj.toString());
				return;
			}
			//封装数据
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			
			//将密码用MD5加密
			user.setPassword(MD5Utils.md5(user.getPassword()));
			//调用service注册用户
			Msg msg = service.regist(user);
			if(msg.getState() == 0) {
				obj.put("msg", msg);
				response.getWriter().println(obj.toString());
				return;
			}
			//跳转登录页面
			obj.put("msg", msg);
			response.getWriter().println(obj.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
