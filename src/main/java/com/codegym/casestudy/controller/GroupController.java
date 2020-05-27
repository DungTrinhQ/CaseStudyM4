//package com.codegym.casestudy.controller;
//
//import com.codegym.casestudy.model.Group;
//import com.codegym.casestudy.service.GroupService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.Optional;
//
//@Controller
//public class GroupController {
//    @Autowired
//    private GroupService groupService;
//
//    @GetMapping("/groups")
//    public ModelAndView listGroups(){
//        Iterable<Group> groups = groupService.findAll();
//        ModelAndView modelAndView = new ModelAndView("/group/list");
//        modelAndView.addObject("groups", groups);
//        return modelAndView;
//    }
//
//    @GetMapping("/create-group")
//    public ModelAndView showCreateForm(){
//        ModelAndView modelAndView = new ModelAndView("/group/create");
//        modelAndView.addObject("group", new Group());
//        return modelAndView;
//    }
//
//    @PostMapping("/create-group")
//    public ModelAndView saveProvince(@ModelAttribute("group") Group group){
//        groupService.save(group);
//
//        ModelAndView modelAndView = new ModelAndView("/group/create");
//        modelAndView.addObject("group", new Group());
//        modelAndView.addObject("message", "New group created successfully");
//        return modelAndView;
//    }
//
//    @GetMapping("/edit-group/{id}")
//    public ModelAndView showEditForm(@PathVariable Long id){
//        Optional<Group> group = groupService.findById(id);
//        if(group != null) {
//            ModelAndView modelAndView = new ModelAndView("/group/edit");
//            modelAndView.addObject("group", group);
//            return modelAndView;
//
//        }else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("/edit-group")
//    public ModelAndView updateGroup(@ModelAttribute("group") Group group){
//        groupService.save(group);
//        ModelAndView modelAndView = new ModelAndView("/group/edit");
//        modelAndView.addObject("group", group);
//        modelAndView.addObject("message", "Group updated successfully");
//        return modelAndView;
//    }
//
//    @GetMapping("/delete-group/{id}")
//    public ModelAndView showDeleteForm(@PathVariable Long id){
//        Optional<Group> group = groupService.findById(id);
//        if(group != null) {
//            ModelAndView modelAndView = new ModelAndView("/group/delete");
//            modelAndView.addObject("group", group);
//            return modelAndView;
//
//        }else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("/delete-group")
//    public String deleteProvince(@ModelAttribute("group") Group group){
//        groupService.remove(group.getId());
//        return "redirect:groups";
//    }
//}
