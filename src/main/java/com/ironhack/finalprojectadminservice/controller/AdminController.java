package com.ironhack.finalprojectadminservice.controller;

import com.ironhack.finalprojectadminservice.model.dto.DoctorDTO;
import com.ironhack.finalprojectadminservice.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/user/doctor/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody DoctorDTO doctorDTO) {
        adminService.createDoctorWithUser(doctorDTO);
    }
}
