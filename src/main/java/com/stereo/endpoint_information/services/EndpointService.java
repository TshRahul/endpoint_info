package com.stereo.endpoint_information.services;

import com.stereo.endpoint_information.models.Endpoint;

import java.util.List;

public interface EndpointService {

    List<Endpoint> getAllEndpoints();
    Endpoint addEndpoint(Endpoint endpoint);
    Endpoint deleteEndpoint(long id);
}
