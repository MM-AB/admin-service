package com.rso40.adminservice.controller;

import org.springframework.ui.Model;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rso40.adminservice.dto.AdminRequest;
import com.rso40.adminservice.dto.AdminResponse;
import com.rso40.adminservice.dto.ProductReq;
import com.rso40.adminservice.dto.ProductRes;
import com.rso40.adminservice.model.Admin;
import com.rso40.adminservice.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import java.util.List;


//@RestController
@Controller
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public String index (Model model) {
        //ModelAndView modelAndView = new ModelAndView();
        //modelAndView.setViewName("index");
        return "index";
    }

    /*@GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView index () {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }*/

    @PostMapping("/post-user")
    @ResponseStatus(HttpStatus.CREATED)
    public String createAdmin(Model model, AdminRequest adminRequest){
        //System.out.println("Post mapping");
        //System.out.println(adminRequest);
        adminService.createAdmin(adminRequest);
        //ModelAndView modelAndView = new ModelAndView();
        //modelAndView.setViewName("newuser");
        return "newuser";
    }

    /*@PostMapping("/post-user")
    @ResponseStatus(HttpStatus.CREATED)
    public ModelAndView createAdmin(AdminRequest adminRequest){
        //System.out.println("Post mapping");
        //System.out.println(adminRequest);
        adminService.createAdmin(adminRequest);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("newuser");
        return modelAndView;
    }*/

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public String getAllAdmins(Model model) {
        //ModelAndView modelAndView = new ModelAndView();
        //modelAndView.setViewName("userlist");
        List<AdminResponse> listUsers = adminService.getAllAdmins();
        model.addAttribute("listUsers",listUsers);
        return "userlist";
    }

    /*@GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView getAllAdmins() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userlist");
        List<AdminResponse> listUsers = adminService.getAllAdmins();
        modelAndView.getModelMap().addAttribute("listUsers",listUsers);
        return modelAndView;
    }*/


    @GetMapping("/new-user")
    @ResponseStatus(HttpStatus.OK)
    public String addNewUser(Model model, AdminRequest adminRequest){
        //admin.addAttribute("admin", new Admin());
        //System.out.println("Get mapping");
        //System.out.println(adminRequest);
        //ModelAndView modelAndView = new ModelAndView();
        //modelAndView.setViewName("newuserform");
        return "newuserform";
    }

    /*@GetMapping("/new-user")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView addNewUser(AdminRequest adminRequest){
        //admin.addAttribute("admin", new Admin());
        //System.out.println("Get mapping");
        //System.out.println(adminRequest);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("newuserform");
        return modelAndView;
    }*/

    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public String getAllProducts(Model model){
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        //ModelAndView modelAndView = new ModelAndView();

        ResponseEntity<ProductRes[]> resResponseEntity = restTemplate.getForEntity("http://localhost:8083/product", ProductRes[].class);
        List<ProductRes> productRes = mapper.convertValue(resResponseEntity.getBody(), new TypeReference<List<ProductRes>>() {});

        //System.out.println("Get mapping");
        //System.out.println(productRes);

        //modelAndView.setViewName("productlist");
        model.addAttribute("productRes",productRes);
        return "productlist";
    }

    /*@GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView getAllProducts(){
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        ModelAndView modelAndView = new ModelAndView();

        ResponseEntity<ProductRes[]> resResponseEntity = restTemplate.getForEntity("http://localhost:8083/product", ProductRes[].class);
        List<ProductRes> productRes = mapper.convertValue(resResponseEntity.getBody(), new TypeReference<List<ProductRes>>() {});

        //System.out.println("Get mapping");
        //System.out.println(productRes);

        modelAndView.setViewName("productlist");
        modelAndView.getModelMap().addAttribute("productRes",productRes);
        return modelAndView;
    }*/

    @GetMapping("/new-product")
    @ResponseStatus(HttpStatus.OK)
    public String addNewProduct(Model model, ProductReq productReq){
        //System.out.println("Get mapping");
        //System.out.println(productReq);
        //ModelAndView modelAndView = new ModelAndView();
        //modelAndView.setViewName("newproductform");
        return "newproductform";
    }

    /*@GetMapping("/new-product")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView addNewProduct(ProductReq productReq){
        //System.out.println("Get mapping");
        //System.out.println(productReq);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("newproductform");
        return modelAndView;
    }*/

    /*@PostMapping("/post-product")
    @ResponseStatus(HttpStatus.CREATED)
    public ModelAndView createProduct(ProductReq productReq){
        ModelAndView modelAndView = new ModelAndView();
        RestTemplate restTemplate = new RestTemplate();

        //System.out.println("Post mapping");
        //System.out.println(productReq);

        ResponseEntity<ProductReq> result = restTemplate.postForEntity("http://localhost:8083/product", productReq, ProductReq.class);

        modelAndView.setViewName("newproduct");
        return modelAndView;
    }*/

    @PostMapping("/post-product")
    @ResponseStatus(HttpStatus.CREATED)
    public String createProduct(Model model, ProductReq productReq){
        RestTemplate restTemplate = new RestTemplate();

        //System.out.println("Post mapping");
        //System.out.println(productReq);

        ResponseEntity<ProductReq> result = restTemplate.postForEntity("http://localhost:8083/product", productReq, ProductReq.class);

        //modelAndView.setViewName("newproduct");
        return "newproduct";
    }


}
