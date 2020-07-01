package com.bl.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class WelcomeController {

    @RequestMapping(path = "",method = RequestMethod.POST)
    public String login() {
        return "login";
    }

    @RequestMapping(path = "/register",method = RequestMethod.POST)
    public String register() {
        return "register";
    }

    @RequestMapping(path = "/welcome",method = RequestMethod.POST)
    public String welcome(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        session.setAttribute("isSuccess",false);
        return "welcome";
    }

    @RequestMapping(path = "/login",method = RequestMethod.POST)
    public String loginProcess() {
        return "login";
    }

}
