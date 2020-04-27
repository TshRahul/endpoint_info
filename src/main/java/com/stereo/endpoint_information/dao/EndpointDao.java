package com.stereo.endpoint_information.dao;

import com.stereo.endpoint_information.models.Endpoint;

import java.util.List;

public interface EndpointDao {

    List<Endpoint> get();
    Endpoint save(Endpoint endpoint);
    Endpoint update(Endpoint endpoint);
    Endpoint updateEnvironment(long id, String environment);
    String delete(long id);
    Endpoint isBad(long id, String isBad);
 }
