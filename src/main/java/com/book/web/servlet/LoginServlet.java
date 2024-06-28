package com.book.web.servlet;

import com.book.entity.UserDB;
import com.book.service.UserService;
import com.book.utils.MD5;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({"/login"})
//public class LoginServlet extends BaseServlet {
//    private static final long serialVersionUID = 1L;
//    private UserService userService = new UserService();
//
//    public LoginServlet() {
//    }
//    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String account = request.getParameter("account");
//        String password = request.getParameter("password");
//        HttpSession session = request.getSession();
//        UserDB userDB = this.userService.login(account, MD5.valueOf(password));
//        if (userDB == null) {
//            request.setAttribute("msg", "账号密码错误");
//            request.getRequestDispatcher("login.jsp").forward(request, response);
//        } else { 
//            session.setAttribute("userDB", userDB);
//           request.getRequestDispatcher("index.jsp").forward(request, response);
//       }
//
//     }
//}

public class LoginServlet extends BaseServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService = new UserService();

    public LoginServlet() {
    }
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 删除对用户输入的验证逻辑
    	String account = request.getParameter("account");
    	 String password = request.getParameter("password");
    	HttpSession session = request.getSession();
    	UserDB userDB = this.userService.login(account,password);
    	session.setAttribute("userDB", userDB);
        request.getRequestDispatcher("index.jsp").forward(request, response); // 无论输入什么都跳转到index.jsp
    }
}


