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
    public List<Endpoint> getAllEndpoints() {
        return endpoint_obj.get();
    }

    @Override
    public Endpoint addEndpoint(Endpoint endpoint) {
      return  endpoint_obj.save(endpoint);
    }

    @Override
    public Endpoint deleteEndpoint(long id) {
        return null;
    }
}
