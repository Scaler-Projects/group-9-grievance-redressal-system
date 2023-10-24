package com.scaler.adminmanagementservice.controllers;

import com.scaler.adminmanagementservice.dtos.GenericAdminDto;
import com.scaler.adminmanagementservice.services.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController implements AdminOperations{

    private AdminService adminService;

    public AdminController(AdminService adminService){

        this.adminService = adminService;
    }



    @GetMapping("{id}")
    public GenericAdminDto getAdminById(@PathVariable("id") Long id) {

        return adminService.getAdminById(id);
    }


    @GetMapping
    public List<GenericAdminDto> getAllAdmins(){

        return adminService.getAllAdmins();
    }


    @PostMapping
    public GenericAdminDto createAdmin(@RequestBody GenericAdminDto admin) {

        return adminService.createAdmin(admin);
    }


    @DeleteMapping("{id}")
    public GenericAdminDto deleteAdmin(@PathVariable("id") Long id){

        return adminService.deleteAdminById(id);
    }


    @PutMapping("{id}")
    public GenericAdminDto updateById(@PathVariable("id") Long id,@RequestBody GenericAdminDto admin){
        return adminService.updateProduct(id,admin);
    }
}
