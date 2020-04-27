package com.stereo.endpoint_information.services;

import com.stereo.endpoint_information.dao.EndpointDao;
import com.stereo.endpoint_information.models.Endpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EndpointServiceImpl implements EndpointService {

    @Autowired
    private EndpointDao endpoint_obj;


    @Override
    @Transactional
    public List<Endpoint> getAllEndpoints() {
        return endpoint_obj.get();
    }

    @Override
    @Transactional
    public Endpoint addEndpoint(Endpoint endpoint) {
      return  endpoint_obj.save(endpoint);
    }

    @Override
    @Transactional
    public Endpoint updateStatus(Endpoint endpoint) {
        return endpoint_obj.update(endpoint);
    }

    @Override
    @Transactional
    public Endpoint updateEnvironment(long id, String environment) {
        return endpoint_obj.updateEnvironment(id,  environment);
    }

    @Override
    @Transactional
    public String deleteEndpoint(long id) {
        return endpoint_obj.delete(id);
    }

    @Override
    @Transactional
    public Endpoint isBad(long id, String isBad) {
       return endpoint_obj.isBad(id, isBad);
    }
}
