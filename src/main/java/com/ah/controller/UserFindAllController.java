package com.ah.controller;

import com.ah.pojo.User;
import com.ah.service.UserService;
import com.ah.service.impl.UserServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findAll")
public class UserFindAllController extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        userService = (UserService) ac.getBean("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pages = req.getParameter("page");
        Integer page = pages != null ? Integer.valueOf(pages) : 1;
        PageHelper pageHelper = new PageHelper();
        pageHelper.startPage(page, 5);
        List<User> list = userService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        req.setAttribute("list", list);
        req.setAttribute("pageInfo", pageInfo);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
