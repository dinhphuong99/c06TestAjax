package com.cg.controller;

import com.cg.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public ModelAndView getList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/list");

        User user = new User();


        return modelAndView;
    }
}
