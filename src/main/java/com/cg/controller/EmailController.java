package com.cg.controller;


import com.cg.model.Mail;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/email")
public class EmailController {

    @GetMapping
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/email/create");

        List<String> listLanguages = new ArrayList<>();
        listLanguages.add("English");
        listLanguages.add("Vietnamese");
        listLanguages.add("Japanese");
        listLanguages.add("Chines");

        modelAndView.addObject("listLanguages", listLanguages);
        modelAndView.addObject("objEmail", new Mail());

        return modelAndView;
    }


    @PostMapping("/send-info")
    public ModelAndView getInfo(@ModelAttribute("objEmail") Mail mail) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/email/list.jsp");

        modelAndView.addObject("languages", mail.getLanguages());

        return modelAndView;
    }
}
