package com.bl.demo.controller;

import com.bl.demo.model.User;
import com.bl.demo.model.UserDAO;
import com.bl.demo.service.UserDAOImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/loginServlet")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String login(Model model, HttpServletRequest request) {
        UserDAO userDAO = new UserDAOImp();
        String userName = request.getParameter("name");
        String password = request.getParameter("password");
        User user = userDAO.getUser(userName,password);
        System.out.println(user.getName());
        boolean isSuccess = false;
        String view = "login";
            if(user != null && user.getName() != null) {
                isSuccess = true;
                HttpSession  session = request.getSession(true);
                session.setMaxInactiveInterval(15 * 60);
                session.setAttribute("name",user.getName());
                session.setAttribute("email",user.getEmail());
                session.setAttribute("date",user.getDatetime());
                session.setAttribute("isSuccess",isSuccess);
                view = "welcome";
            }
            else {
                model.addAttribute("isError",true);
                view = "login";
            }
        return view;
    }
}
