//用户业务层

package com.book.service;
import com.book.utils.PageTool;
import com.book.dao.UserDao;
import com.book.entity.UserDB;
import java.util.List;

public class UserService {
    private UserDao userDao = new UserDao();

    public UserService() {
    }

    public UserDB login(String account, String password) {
        return this.userDao.login(account, password);
    }
    public List<UserDB> list() {
        return  this.userDao.list(); 
    }
    public PageTool<UserDB> list(String currentPage, String pageSize, Integer order) {
        return this.userDao.list(currentPage, pageSize, order);
    }
}

