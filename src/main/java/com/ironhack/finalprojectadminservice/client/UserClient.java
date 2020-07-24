package com.ironhack.finalprojectadminservice.client;

import com.ironhack.finalprojectadminservice.model.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="edge-service", url="https://final-project-edge-service.herokuapp.com/")
public interface UserClient {

    @PostMapping("/user/create_user")
    UserDTO createUser(@RequestBody UserDTO userDTO);
}
