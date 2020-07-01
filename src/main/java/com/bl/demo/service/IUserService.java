package com.bl.demo.service;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

public interface IUserService {
    String loginProcess(Model model, HttpServletRequest request);
}
