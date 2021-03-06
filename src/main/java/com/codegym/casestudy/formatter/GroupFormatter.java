//package com.codegym.casestudy.formatter;
//
//import com.codegym.casestudy.model.Group;
//import com.codegym.casestudy.service.GroupService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.format.Formatter;
//import org.springframework.stereotype.Component;
//
//import java.text.ParseException;
//import java.util.Locale;
//
//
//@Component
//public class GroupFormatter implements Formatter<Group> {
//
//    private GroupService groupService;
//
//    @Autowired
//    public GroupFormatter(GroupService groupService) {
//        this.groupService = groupService;
//    }
//
//    @Override
//    public Group parse(String text, Locale locale) throws ParseException {
//        return groupService.findById(Long.parseLong(text));
//    }
//
//    @Override
//    public String print(Group object, Locale locale) {
//        return "[" + object.getId() + ", " +object.getName() + "]";
//    }
//}