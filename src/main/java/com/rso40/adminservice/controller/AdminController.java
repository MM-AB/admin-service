package com.rso40.adminservice.controller;

import com.rso40.adminservice.dto.AdminRequest;
import com.rso40.adminservice.dto.AdminResponse;
import com.rso40.adminservice.model.Admin;
import com.rso40.adminservice.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/post-user")
    @ResponseStatus(HttpStatus.CREATED)
    public ModelAndView createAdmin(AdminRequest adminRequest){
        System.out.println("Post mapping");
        System.out.println(adminRequest);
        adminService.createAdmin(adminRequest);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new-user");
        return modelAndView;
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView getAllAdmins() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user_list");
        List<AdminResponse> listUsers = adminService.getAllAdmins();
        modelAndView.getModelMap().addAttribute("listUsers",listUsers);
        return modelAndView;
    }

    @GetMapping("")
    public ModelAndView index () {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/new-user")
    public ModelAndView addNewUser(AdminRequest adminRequest){
        //admin.addAttribute("admin", new Admin());
        System.out.println("Get mapping");
        System.out.println(adminRequest);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new-user-form");
        return modelAndView;
    }


}
