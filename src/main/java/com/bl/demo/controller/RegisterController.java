package com.bl.demo.controller;

import com.bl.demo.alert.AlertMessages;
import com.bl.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class RegisterController {

    @Autowired
    IUserService userService;

    @RequestMapping(path = "/registerServlet",method = RequestMethod.POST)
    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int entryStatus = userService.registerProcess(request, response);
        if (entryStatus > 0) {
            AlertMessages.registerSuccessfulMessage(response);
            RequestDispatcher rd = request.getRequestDispatcher("/login");
            rd.include(request, response);
        } else {
            AlertMessages.databaseErrorMassage(response);
            RequestDispatcher rd = request.getRequestDispatcher("/register");
            rd.include(request, response);
        }
    }
}
