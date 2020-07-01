package com.bl.demo.controller;

import com.bl.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private IUserService userService;

    @RequestMapping(path = "/loginServlet",method = RequestMethod.POST)
    public String login(Model model, HttpServletRequest request) {
        return userService.loginProcess(model,request);
    }
}
