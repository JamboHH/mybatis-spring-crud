package com.ah.controller;

import com.ah.pojo.User;
import com.ah.service.UserService;
import com.ah.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateById")
public class UserUpdateController extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        userService = (UserService) ac.getBean("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("id");
        Integer id = Integer.valueOf(ids);
        String name = req.getParameter("name");
        name = new String(name.getBytes("iso-8859-1"), "utf-8");
        String address = req.getParameter("address");
        address = new String(address.getBytes("iso-8859-1"), "utf-8");
        String tel = req.getParameter("tel");
        Integer phone = Integer.valueOf(tel);
        User user = new User(id, name, address, phone);
        int res = userService.updateById(user);
        //req.getRequestDispatcher("/findAll").forward(req, resp);
        resp.sendRedirect("findAll");
    }
}
