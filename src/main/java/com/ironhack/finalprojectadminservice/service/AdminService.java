package com.ironhack.finalprojectadminservice.service;

import com.ironhack.finalprojectadminservice.client.DoctorClient;
import com.ironhack.finalprojectadminservice.client.UserClient;
import com.ironhack.finalprojectadminservice.model.dto.DoctorDTO;
import com.ironhack.finalprojectadminservice.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    UserClient userClient;

    @Autowired
    DoctorClient doctorClient;

    public void createDoctorWithUser(DoctorDTO doctorDTO) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserDTO userDTO = new UserDTO();
            userDTO.setUsername(doctorDTO.getName());
            userDTO.setPassword(passwordEncoder.encode(doctorDTO.getName().toLowerCase()));
            userDTO.setUsername(doctorDTO.getName().toLowerCase());
        UserDTO userCreated = userClient.createUser(userDTO);
        doctorDTO.setId(userCreated.getId());
        doctorClient.createDoctor(doctorDTO);
    }
}
