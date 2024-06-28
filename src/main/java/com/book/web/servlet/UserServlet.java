package com.book.web.servlet;

import com.book.entity.UserDB;
import com.book.service.UserService;
import com.book.utils.MD5;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import com.book.utils.PageTool;
import com.book.utils.PaginationUtils;

@WebServlet({"/user"})
public class UserServlet extends BaseServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService = new UserService();

    public UserServlet() {
    }

    	public void list(HttpServletRequest request, HttpServletResponse response) {
    	    List<UserDB> list = userService.list();
    	    request.setAttribute("ulist", list);
    	    try {
				request.getRequestDispatcher("admin/admin_user.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
}




