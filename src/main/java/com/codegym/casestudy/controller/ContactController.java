package com.codegym.casestudy.controller;

import com.codegym.casestudy.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/contact")
    public String list(Model model) {
        model.addAttribute("contacts", contactService.findAll());
        return "list";
    }
}