package com.stereo.endpoint_information.dao;

import com.stereo.endpoint_information.exceptions.BadRequestException;
import com.stereo.endpoint_information.exceptions.RecordAlreadyPresentException;
import com.stereo.endpoint_information.exceptions.RecordNotFoundException;
import com.stereo.endpoint_information.models.Endpoint;
import com.stereo.endpoint_information.repositories.EndpointRepo;
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

    @Autowired
    private EndpointRepo endpointRepo;

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
        endpoint.setEnvironment(endpoint.getEnvironment());
        endpoint.setIs_deleted(false);
        currentSession.saveOrUpdate(endpoint);
        currentSession.close();
        return endpoint;
    }

    @Override
    public Endpoint update(Endpoint endpoint) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = null;
        try {
            query = currentSession.createSQLQuery(baseUtils.getValuesFromPropertyFile("isEndPointExists").replace("%endpointId%",
                    endpoint.getEndpoint_id() + ""));
        } catch(Exception e){
            e.printStackTrace();
        }
        assert query != null;
        List isEndpointPresent = query.getResultList();
        if(isEndpointPresent.get(0).toString().equals("false")) {
            throw new RecordNotFoundException("The endpoint with name: " + endpoint.getEndpoint_name() + " is not present");
        }
        Query update_query;
        try {
            if(endpoint.isIs_occupied()){
                update_query = currentSession.createSQLQuery(baseUtils.getValuesFromPropertyFile("makeEndpointOccupied").replace("%occupiedBy%", endpoint.getOccupied_by())
                .replace("%occupiedFor%", endpoint.getOccupied_for()).replace("%endpointId%", endpoint.getEndpoint_id() + "").replace("%environment%", endpoint.getEnvironment()));
            } else {
                update_query = currentSession.createSQLQuery(baseUtils.getValuesFromPropertyFile("makeEndpointUnOccupied").replace("%endpointId%", endpoint.getEndpoint_id() + ""));

            }
            assert update_query != null;
            update_query.executeUpdate();
        } catch(Exception e){
            e.printStackTrace();
        }

    return endpoint;
    }

    @Override
    public String delete(long  id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = null;
        try {
            query = currentSession.createSQLQuery(baseUtils.getValuesFromPropertyFile("isEndPointExists").replace("%endpointId%",
                    id + ""));
        } catch(Exception e){
            e.printStackTrace();
        }
        assert query != null;
        List isEndpointPresent = query.getResultList();
        if(isEndpointPresent.get(0).toString().equals("false")) {
            throw new RecordNotFoundException("The endpoint with id: " + id + " is not present");
        }
        try {

           Query delete_query = currentSession.createSQLQuery(baseUtils.getValuesFromPropertyFile("deleteEndpoint").replace("%endpointId%",
                   id + ""));
           delete_query.executeUpdate();
        } catch(Exception e){
            e.printStackTrace();
        }

        return "endpoint with id: " + id + " is deleted successfully";
    }

    @Override
    public Endpoint updateEnvironment(long id, String environment) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = null;
        try {
            query = currentSession.createSQLQuery(baseUtils.getValuesFromPropertyFile("isEndPointExists").replace("%endpointId%",
                    id + ""));
        } catch(Exception e){
            e.printStackTrace();
        }
        assert query != null;
        List isEndpointPresent = query.getResultList();
        if(isEndpointPresent.get(0).toString().equals("false")) {
            throw new RecordNotFoundException("The endpoint with id: " + id + " is not present");
        }

        try {
            Query update_query = currentSession.createSQLQuery(baseUtils.getValuesFromPropertyFile("updateEnvironmentOfEndpoint").replace("%environment%", environment).replace("%endpointId%",
                    id + ""));
            update_query.executeUpdate();
        } catch(Exception e){
            e.printStackTrace();
        }

        return endpointRepo.findById(id);
    }

    @Override
    public Endpoint isBad(long id, String isBad) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = null;
        try {
            query = currentSession.createSQLQuery(baseUtils.getValuesFromPropertyFile("isEndPointExists").replace("%endpointId%",
                    id + ""));
        } catch(Exception e){
            e.printStackTrace();
        }
        assert query != null;
        List isEndpointPresent = query.getResultList();
        if(isEndpointPresent.get(0).toString().equals("false")) {
            throw new RecordNotFoundException("The endpoint with id: " + id + " is not present");
        }

        try {
            Query update_query = currentSession.createSQLQuery(baseUtils.getValuesFromPropertyFile("updateIsBad").replace("%isBad%", isBad).replace("%endpointId%",
                    id + ""));
            update_query.executeUpdate();
        } catch(Exception e){
            e.printStackTrace();
        }
        return endpointRepo.findById(id);
    }

}
