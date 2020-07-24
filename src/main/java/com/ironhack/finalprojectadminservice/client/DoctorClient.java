package com.ironhack.finalprojectadminservice.client;

import com.ironhack.finalprojectadminservice.model.dto.DoctorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="doctor-service")
public interface DoctorClient {

    @PostMapping("/doctor/create_doctor")
    void createDoctor(@RequestBody DoctorDTO doctorDTO);

}
