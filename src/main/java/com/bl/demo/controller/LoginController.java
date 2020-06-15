package com.bl.demo.controller;

import com.bl.demo.database.DBConnection;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.ResultSet;

@Controller
@RequestMapping("/loginServlet")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String login(Model model, HttpServletRequest request) {
        String userName = request.getParameter("name");
        String password = request.getParameter("password");
        boolean isSuccess = false;
        String view = "login";
        try{
            ResultSet rs = DBConnection.getEntries(userName,password);
            String email="";
            String id="";
            String date="";
            while(rs.next())
            {
                isSuccess=true;
                email=rs.getString("email");
                id=rs.getString("id");
                date=rs.getString("date");
            }
            DBConnection.closeStatement();
            DBConnection.closeConnection();
            if(isSuccess) {
                HttpSession  session = request.getSession(true);
                session.setMaxInactiveInterval(15 * 60);
                session.setAttribute("name",userName);
                session.setAttribute("email",email);
                session.setAttribute("id",id);
                session.setAttribute("date",date);
                session.setAttribute("isSuccess",isSuccess);
                view = "welcome";
            }
            else {
                model.addAttribute("isError",true);
                view = "login";
            }
        }catch(Exception e){
            model.addAttribute("isError",true);
            view = "login";
        }
        return view;
    }
}
