package com.stereo.endpoint_information.services;

import com.stereo.endpoint_information.models.Endpoint;

import java.util.List;

public interface EndpointService {

    List<Endpoint> getAllEndpoints();
    Endpoint addEndpoint(Endpoint endpoint);
    Endpoint updateStatus(Endpoint endpoint);
    Endpoint updateEnvironment(long id, String environment);
    String deleteEndpoint(long id);
    Endpoint isBad(long id, String isBad);
}
