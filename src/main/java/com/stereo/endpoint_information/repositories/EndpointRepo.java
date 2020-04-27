package com.stereo.endpoint_information.repositories;

import com.stereo.endpoint_information.models.Endpoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EndpointRepo extends JpaRepository<Endpoint, Integer> {

    Endpoint findById(long endpoint_id);

}
