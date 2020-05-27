package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.Contact;

import com.codegym.casestudy.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;

//    @Autowired
//    private GroupService groupService;
//
//    @ModelAttribute("groups")
//    public Iterable<Group> groups(){
//        return groupService.findAll();
//    }

//    @GetMapping("/contact")
//    public String list(Model model) {
//        model.addAttribute("contacts", contactService.findAll());
//        return "list";
//    }
//@GetMapping("/contact")
//public ModelAndView listCustomers(Pageable pageable){
//    Page<Contact> contacts = contactService.findAll(pageable);
//    ModelAndView modelAndView = new ModelAndView("list");
//    modelAndView.addObject("contacts", contacts);
//    return modelAndView;
//}

    @GetMapping("/contact/search")
    public String search(@RequestParam("term") String term, Model model) {
        if (StringUtils.isEmpty(term)) {
            return "redirect:/contact";
        }

        model.addAttribute("contacts", contactService.search(term));
        return "list";
    }

    @GetMapping("/contact/add")
    public String add(Model model) {
        model.addAttribute("contact", new Contact());
        return "form";
    }

    @PostMapping("/contact/save")
    public String save(@Valid Contact contact, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "form";
        }
        contactService.save(contact);
        redirect.addFlashAttribute("successMessage", "Saved contact successfully!");
        return "redirect:/contact";
    }

    @GetMapping("/contact/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("contact", contactService.findOne(id));
        return "form";
    }

    @GetMapping("/contact/{id}/delete")
    public String delete(@PathVariable long id, RedirectAttributes redirect) {
        contactService.delete(id);
        redirect.addFlashAttribute("successMessage", "Deleted contact successfully!");
        return "redirect:/contact";
    }

    @GetMapping("/contact")
    public ModelAndView showContacts(@RequestParam(defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page,10, Sort.Direction.ASC,"name");
        Page<Contact> contacts = contactService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("contacts",contacts);
        return modelAndView;
    }
}
