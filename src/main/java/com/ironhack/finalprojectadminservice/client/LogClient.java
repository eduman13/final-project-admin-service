package com.ironhack.finalprojectadminservice.client;

import com.ironhack.finalprojectadminservice.model.logging.Log;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="logging-service")
public interface LogClient {

    @PostMapping("/logging/post_log")
    void postLog(@RequestBody Log log);

}
