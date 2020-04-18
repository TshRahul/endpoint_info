package com.stereo.endpoint_information.controllers;

import com.stereo.endpoint_information.models.Endpoint;
import com.stereo.endpoint_information.services.EndpointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EndpointController {

    @Autowired
    private EndpointService endpointService;

    @GetMapping("/endpoint")
    public List<Endpoint> getEndpoint(){
        return endpointService.getAllEndpoints();
    }

    @PostMapping("/endpoint")
    public Endpoint addEndpoint(@RequestBody Endpoint endpoint){

        return endpointService.addEndpoint(endpoint);

    }


}
