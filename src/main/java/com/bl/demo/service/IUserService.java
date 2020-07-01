package com.bl.demo.service;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IUserService {
    String loginProcess(Model model, HttpServletRequest request);
    int registerProcess(HttpServletRequest request, HttpServletResponse response);
}
