package com.bl.demo;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.regex.Pattern;

import static java.lang.String.valueOf;

@Component
public class Filter implements javax.servlet.Filter {
//    public Pattern namePattern;
//    public Pattern passwordPattern;

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        String path = req.getRequestURI();
        System.out.println("inside filter");
//        String userName=req.getParameter("name");
//        String actualPassword = req.getParameter("password");
//        namePattern = namePattern.compile("^[A-Z][A-Za-z]{2,}");
//        passwordPattern = passwordPattern.compile("(?=.*[A-Z].*)(?=.*[0-9].*)([a-zA-Z0-9]{4,}[!@#$%^&*()_+][a-zA-Z0-9]{3,})");
//        if(path.contains("login"))
//        {
//
//            /**+
//             * Checking Condition For Username And Password Should Having Proper Length In Login Page
//             */
//
//            if(userName !=null  && userName.trim().length()<3 &&
//                    actualPassword !=null && actualPassword.trim().length()<8) {
//                AlertMessages.loginFailMassage(res);
//                RequestDispatcher rd=req.getRequestDispatcher("login");
//                rd.include(req,res);
//            }
//            else
//                filterChain.doFilter(req, res);
//        }
//        else
//        if (path.contains("register")) {
//            System.out.println("Inside Register");
//            String email=req.getParameter("email");
//            String confirmPassword = req.getParameter("confirmPassword");
//            System.out.println(email+" "+confirmPassword);
//            /**+
//             * Checking Condition For Username And Password Should Having Proper Pattern Format In Registration Page
//             */
//
////            if (namePattern.matches(valueOf(namePattern), userName) && passwordPattern.matches(valueOf(passwordPattern), actualPassword)
////                    && actualPassword.equals(confirmPassword) && email.trim().length()>9)
//                filterChain.doFilter(req, res);
//            else {
//                AlertMessages.registrationFailMassage(res);
//                RequestDispatcher rd=req.getRequestDispatcher("/register");
//                rd.include(req,res);
//            }
//        }
//        else
        if (path.contains("welcome")) {
            System.out.println("inside welcome filter");
            HttpSession session = req.getSession(false);
            System.out.println("inside filter" + session);
            String id =(String) session.getAttribute("id");
            System.out.println("inside filter" + id);
            if (null == session || null == id) {
                RequestDispatcher rd=req.getRequestDispatcher("/");
                rd.forward(req,res);
            }
            else
                filterChain.doFilter(req, res);
        }
        else
            filterChain.doFilter(req, res);
    }

    @Override
    public void destroy() {
    }
}
