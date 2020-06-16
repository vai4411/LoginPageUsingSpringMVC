package com.bl.demo.controller;

import com.bl.demo.alert.AlertMessages;
import com.bl.demo.database.DBConnection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

import static java.lang.String.valueOf;

@Controller
@RequestMapping("/registerServlet")
public class RegisterController {

    @RequestMapping(method = RequestMethod.GET)
    public void register(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Pattern namePattern = null;
        Pattern passwordPattern = null;
        String userName = request.getParameter("name");
        String actualPassword = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String email = request.getParameter("email");
        namePattern = namePattern.compile("^[A-Z][A-Za-z]{2,}");
        passwordPattern = passwordPattern.compile("(?=.*[A-Z].*)(?=.*[0-9].*)([a-zA-Z0-9]{4,}[!@#$%^&*()_+][a-zA-Z0-9]{3,})");
        if (namePattern.matches(valueOf(namePattern), userName) && passwordPattern.matches(valueOf(passwordPattern), actualPassword)
                && actualPassword.equals(confirmPassword) && email.trim().length() > 9) {
            int n = 0;
            try {
                n = DBConnection.setEntries(userName, actualPassword, email.toLowerCase());
                DBConnection.closeConnection();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            if (n > 0) {
                AlertMessages.registerSuccessfulMessage(response);
                RequestDispatcher rd = request.getRequestDispatcher("/login");
                rd.include(request, response);
            } else {
                AlertMessages.databaseErrorMassage(response);
                RequestDispatcher rd = request.getRequestDispatcher("/register");
                rd.include(request, response);
            }
        }
        else {
            AlertMessages.registrationFailMassage(response);
            RequestDispatcher rd = request.getRequestDispatcher("/register");
            rd.include(request, response);
        }
    }
}
