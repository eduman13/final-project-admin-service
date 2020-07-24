package com.ironhack.finalprojectadminservice.service;

import com.ironhack.finalprojectadminservice.client.DoctorClient;
import com.ironhack.finalprojectadminservice.client.UserClient;
import com.ironhack.finalprojectadminservice.model.dto.DoctorDTO;
import com.ironhack.finalprojectadminservice.model.dto.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class AdminServiceTest {

    @Autowired
    AdminService adminService;

    @MockBean
    DoctorClient doctorClient;

    @MockBean
    UserClient userClient;

    private UserDTO userCreated;
    private DoctorDTO doctorDTO;

    @BeforeEach
    void setUp() {
        userCreated = new UserDTO();
            userCreated.setId((long) 1);
            userCreated.setUsername("eduardo");
            userCreated.setPassword("eduardo");
        doctorDTO = new DoctorDTO();
            doctorDTO.setId((long) 45);
            doctorDTO.setName("Eduardo");
            doctorDTO.setSurnames("García Espeso");
            doctorDTO.setSchoolNumber("676876545455T");
            doctorDTO.setStreet("Avenida de Ámerica");
            doctorDTO.setPortal(20);
            doctorDTO.setNumber(5);

        when(userClient.createUser(any(UserDTO.class))).thenReturn(userCreated);
    }

    @Test
    void createDoctorWithUser() {
        adminService.createDoctorWithUser(doctorDTO);
    }
}