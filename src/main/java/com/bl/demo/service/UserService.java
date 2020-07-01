package com.bl.demo.service;

import com.bl.demo.dao.UserDAO;
import com.bl.demo.dao.UserDAOImp;
import com.bl.demo.model.User;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

import static java.lang.String.valueOf;

@Service
public class UserService implements IUserService {

    public String loginProcess(Model model, HttpServletRequest request) {
        UserDAO userDAO = new UserDAOImp();
        String userName = request.getParameter("name");
        String password = request.getParameter("password");
        User user = userDAO.getUser(userName, password);
        boolean isSuccess = false;
        String view;
        if (user != null && user.getName() != null) {
            isSuccess = true;
            HttpSession session = request.getSession(true);
            session.setMaxInactiveInterval(15 * 60);
            session.setAttribute("name", user.getName());
            session.setAttribute("email", user.getEmail());
            session.setAttribute("date", user.getDatetime());
            session.setAttribute("isSuccess", isSuccess);
            view = "welcome";
        } else {
            model.addAttribute("isError", true);
            view = "login";
        }
        return view;
    }

    public int registerProcess(HttpServletRequest request, HttpServletResponse response) {
        Pattern namePattern = null;
        Pattern passwordPattern = null;
        int entryStatus = 0;
        String userName = request.getParameter("name");
        String actualPassword = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String email = request.getParameter("email");
        namePattern = namePattern.compile("^[A-Z][A-Za-z]{2,}");
        passwordPattern = passwordPattern.compile("(?=.*[A-Z].*)(?=.*[0-9].*)([a-zA-Z0-9]{4,}[!@#$%^&*()_+][a-zA-Z0-9]{3,})");
        if (namePattern.matches(valueOf(namePattern), userName) && passwordPattern.matches(valueOf(passwordPattern), actualPassword)
                && actualPassword.equals(confirmPassword) && email.trim().length() > 9) {
            try {
                UserDAO userDAO = new UserDAOImp();
                User user = new User();
                user.setName(userName);
                user.setPassword(actualPassword);
                user.setEmail(email);
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                user.setDatetime(dtf.format(LocalDateTime.now()));
                entryStatus = userDAO.insertUser(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return entryStatus;
    }
}