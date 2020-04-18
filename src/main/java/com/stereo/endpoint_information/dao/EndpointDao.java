package com.stereo.endpoint_information.dao;

import com.stereo.endpoint_information.models.Endpoint;

import java.util.List;

public interface EndpointDao {

    List<Endpoint> get();
    Endpoint save(Endpoint endpoint);
    Endpoint update(Endpoint endpoint);
    String delete(long id);
 }
