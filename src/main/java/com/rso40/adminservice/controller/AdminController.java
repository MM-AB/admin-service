package com.rso40.adminservice.controller;

import com.rso40.adminservice.dto.AdminRequest;
import com.rso40.adminservice.dto.AdminResponse;
import com.rso40.adminservice.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createAdmin(@RequestBody AdminRequest adminRequest){
        adminService.createAdmin(adminRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AdminResponse> getAllAdmins(){
        return adminService.getAllAdmins();
    }


}
