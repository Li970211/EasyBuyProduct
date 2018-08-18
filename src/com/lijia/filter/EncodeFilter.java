package com.lijia.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;



public class EncodeFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//解决请求乱码
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		httpServletRequest.setCharacterEncoding("utf-8");
		//处理响应乱码
		response.setContentType("text/html;charset=utf-8");
		chain.doFilter(httpServletRequest, response);
		
		
	}

	@Override
	public void destroy() {
		
	}


}
