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
public class ProductReq {

    private String name;
    private String description;
    private String restaurant;
    private String address;
    private BigDecimal price;
}
