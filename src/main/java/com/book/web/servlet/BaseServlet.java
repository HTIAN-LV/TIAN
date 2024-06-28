package com.book.web.servlet;
import java.io.IOException;
import java.lang.invoke.TypeDescriptor.OfMethod;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
////所有的servlet都要继承此类
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID =1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//设置编码
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html:charset=utf-8");
			//获取请求路径中的方法参数
			String m=request.getParameter("method");
			//获取类
			Class<? extends BaseServlet> clazz =this.getClass();	
			//获取要执行的方法
			 Method method = clazz.getDeclaredMethod(m, HttpServletRequest.class, HttpServletResponse.class);
	            method.setAccessible(true);
	            method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
}
