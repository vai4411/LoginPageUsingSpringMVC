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
    public Pattern namePattern;
    public Pattern passwordPattern;

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        String path = req.getRequestURI();
        System.out.println("inside filter");
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
