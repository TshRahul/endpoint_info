package com.stereo.endpoint_information.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EndpointController {

    @GetMapping("/endpoint")
    public String addEndpoint(){
        return "test controller";
    }


}
