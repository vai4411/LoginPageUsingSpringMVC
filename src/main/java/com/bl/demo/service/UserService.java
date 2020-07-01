package com.bl.demo.service;

import com.bl.demo.dao.UserDAO;
import com.bl.demo.dao.UserDAOImp;
import com.bl.demo.model.User;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class UserService implements IUserService {

    public String loginProcess(Model model, HttpServletRequest request) {
        UserDAO userDAO = new UserDAOImp();
        String userName = request.getParameter("name");
        String password = request.getParameter("password");
        User user = userDAO.getUser(userName,password);
        boolean isSuccess = false;
        String view;
        if(user != null && user.getName() != null) {
            isSuccess = true;
            HttpSession session = request.getSession(true);
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
