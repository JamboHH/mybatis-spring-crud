package com.ah.controller;

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

@WebServlet("/deleteById")
public class UserDeleteByIdController extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        userService = (UserService) ac.getBean("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("id");
        Integer id = Integer.valueOf(ids);
        int res = userService.deleteById(id);
        if (res == 1) {
            resp.sendRedirect("findAll");
        } else {
            req.getRequestDispatcher("/err.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
