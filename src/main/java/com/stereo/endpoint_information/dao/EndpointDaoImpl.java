package com.stereo.endpoint_information.dao;

import com.stereo.endpoint_information.exceptions.BadRequestException;
import com.stereo.endpoint_information.exceptions.RecordAlreadyPresentException;
import com.stereo.endpoint_information.models.Endpoint;
import com.stereo.endpoint_information.utilities.BaseUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Repository
public class EndpointDaoImpl implements EndpointDao {

    @Autowired
    private EntityManager entityManager;

    private BaseUtils baseUtils = new BaseUtils();

    @Override
    public List<Endpoint> get() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Endpoint> query = null;
        try {
            query = currentSession.createQuery(baseUtils.getValuesFromPropertyFile("getAllEndpoints"), Endpoint.class);
        } catch(Exception e){
            e.printStackTrace();
        }
        assert query != null;
        return query.getResultList();
    }

    @Override
    public Endpoint save(Endpoint endpoint) {
        if(endpoint.getEndpoint_name().isEmpty() || endpoint.getEndpoint_name().trim().length() == 0){
            throw new BadRequestException("Empty name of endpoint is not excepted");
        }

        Session currentSession = entityManager.unwrap(Session.class);
        List isEndpointPresent = null;
        try {
            Query query = currentSession.createSQLQuery(baseUtils.getValuesFromPropertyFile("isEndpointAlreadyExits").replace("%endpointName%",
                    endpoint.getEndpoint_name()));

            isEndpointPresent = query.getResultList();
        } catch(Exception e){
            e.printStackTrace();
        }

        assert isEndpointPresent != null;
        if(isEndpointPresent.get(0).toString().equals("true")) {
            throw new RecordAlreadyPresentException("The endpoint with name: " + endpoint.getEndpoint_name() + " is already present. Please give other name");
        }

        endpoint.setIs_occupied(false);
        endpoint.setIs_deleted(false);
        currentSession.saveOrUpdate(endpoint);
        currentSession.close();
        return endpoint;
    }

    @Override
    public Endpoint delete(long endpoint_id) {
        return null;
    }
}
