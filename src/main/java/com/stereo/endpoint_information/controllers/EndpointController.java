package com.stereo.endpoint_information.controllers;

import com.stereo.endpoint_information.models.Endpoint;
import com.stereo.endpoint_information.services.EndpointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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

    @PatchMapping("/endpoint")
    public Endpoint updateStatus(@RequestBody Endpoint endpoint){
       return endpointService.updateStatus(endpoint);
    }

    @PatchMapping("/endpoint/updateEnvironment/{id}")
    public Endpoint updateEnvironment(@PathVariable long id, @RequestBody String env){
        return endpointService.updateEnvironment(id, env);
    }

    @PatchMapping("/endpoint/isBad/{id}")
    public Endpoint isBad(@PathVariable long id, @RequestBody String isBad){
        return endpointService.isBad(id, isBad);
    }

    @DeleteMapping("/endpoint/{id}")
    public String deleteEndpoint(@PathVariable long id){
        return endpointService.deleteEndpoint(id);
    }


}
