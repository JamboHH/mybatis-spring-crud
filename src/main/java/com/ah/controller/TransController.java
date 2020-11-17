package com.ah.controller;

import com.ah.pojo.Trans;
import com.ah.service.TransService;
import com.ah.service.impl.TransServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/trans")
public class TransController extends HttpServlet {
    private TransService transService;

    @Override
    public void init() throws ServletException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        transService = (TransService) ac.getBean("transService");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accounts = req.getParameter("account");
        Integer account = Integer.valueOf(accounts);
        String moneys = req.getParameter("money");
        Integer money = Integer.valueOf(moneys);
        String sourceName = req.getParameter("sourceName");
        sourceName = new String(sourceName.getBytes("iso-8859-1"), "utf-8");
        String targetName = req.getParameter("targetName");
        targetName = new String(targetName.getBytes("iso-8859-1"), "utf-8");
        Trans trans = new Trans(sourceName, targetName, money);
        if (account >= money) {
            transService.transMoney(trans);
            resp.sendRedirect("findAll");
        } else {
            req.getRequestDispatcher("/err.jsp").forward(req, resp);
        }
    }
}
