package com.rso40.adminservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminResponse {

    private  String id;
    private String name;
    private String email;
    private String password;
    private String address;
    private BigDecimal admin;
}
