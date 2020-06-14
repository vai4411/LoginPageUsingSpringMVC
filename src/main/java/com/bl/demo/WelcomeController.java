package com.bl.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

@Controller
public class WelcomeController {

    @RequestMapping(path = "",method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(path = "/register",method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(path = "/welcome",method = RequestMethod.GET)
    public String welcome(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        session.setAttribute("isSuccess",false);
        return "welcome";
    }

}
