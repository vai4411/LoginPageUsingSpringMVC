package com.bl.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @RequestMapping(path = "/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.setAttribute("user",null);
        session.invalidate();
        return "login";
    }
}
