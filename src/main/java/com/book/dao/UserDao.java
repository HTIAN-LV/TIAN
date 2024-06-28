package com.book.dao;

import com.book.entity.UserDB;
import com.book.utils.C3p0Tool;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import com.book.utils.PageTool;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.tomcat.jni.Pool;


public class UserDao {
    QueryRunner queryRunner = new QueryRunner(C3p0Tool.getDataSource());
    BeanProcessor bean = new GenerousBeanProcessor();
    RowProcessor processor;

    public UserDao() {
        this.processor = new BasicRowProcessor(this.bean);
    }

    public List<UserDB> list() {
        String sql = "select * from library ";
        try {
            return queryRunner.query(sql, new BeanListHandler<UserDB>(UserDB.class,processor));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public UserDB login(String account, String password) {
        String sql = "select * from library where name = ？ and state = ？";
        Object[] params = new Object[]{account, password};

        try {
            return (UserDB)this.queryRunner.query(sql, new BeanHandler(UserDB.class, this.processor), params);
        } catch (SQLException var6) {
            var6.printStackTrace();
            return null;
        }
    }
    public PageTool<UserDB> list(String currentPage, String pageSize, Integer order) {
        try {
            StringBuffer listSql = new StringBuffer("select * ");
            StringBuffer countSql = new StringBuffer("select count(*) ");
            StringBuffer sql = new StringBuffer("from library");
            if (order != null && order == 1) {
                sql.append(" where role = 1 order by times desc");
            }

            Long total = (Long)this.queryRunner.query(countSql.append(sql).toString(), new ScalarHandler());
            PageTool<UserDB> pageTools = new PageTool(total.intValue(), currentPage, pageSize);
            sql.append(" limit ?,?");
            List<UserDB> list = (List)this.queryRunner.query(listSql.append(sql).toString(), new BeanListHandler(UserDB.class, this.processor), new Object[]{pageTools.getStartIndex(), pageTools.getPageSize()});
            pageTools.setRows(list);
            System.out.println(pageTools);
            return pageTools;
        } catch (SQLException var10) {
            var10.printStackTrace();
            return new PageTool(0, currentPage, pageSize);
        }
    }


}
