package com.rso40.adminservice.service;

import com.rso40.adminservice.dto.AdminRequest;
import com.rso40.adminservice.dto.AdminResponse;
import com.rso40.adminservice.model.Admin;
import com.rso40.adminservice.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminService {
    private  final AdminRepository adminRepository;

    public void createAdmin(AdminRequest adminRequest){
        Admin admin = Admin.builder()
                .name(adminRequest.getName())
                .email(adminRequest.getEmail())
                .password(adminRequest.getPassword())
                .address((adminRequest.getAddress()))
                .admin(adminRequest.getAdmin())
                .build();

        adminRepository.save(admin);
        log.info("User {} is saved!", admin.getId());

    }

    public List<AdminResponse> getAllAdmins() {
        List<Admin> admins = adminRepository.findAll();

        return admins.stream().map(this::mapToAdminResponse).toList();
    }

    private AdminResponse mapToAdminResponse(Admin admin) {
        return AdminResponse.builder()
                .id(admin.getId())
                .name(admin.getName())
                .email(admin.getEmail())
                .password(admin.getPassword())
                .address(admin.getAddress())
                .admin(admin.getAdmin())
                .build();

    }
}
