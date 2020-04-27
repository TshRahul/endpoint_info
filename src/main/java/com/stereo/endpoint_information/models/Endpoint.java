package com.stereo.endpoint_information.models;

import javax.persistence.*;

@Entity
@Table(name = "ENDPOINTS")
public class Endpoint {

    @Id
    @Column(name = "endpoint_id")
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "endpoint_name")
    private String endpoint_name;

    @Column(name = "is_occupied")
    private boolean is_occupied;

    @Column(name = "occupied_by")
    private String occupied_by;

    @Column(name = "occupied_for")
    private String occupied_for;

    @Column(name = "is_deleted")
    private boolean is_deleted;

    @Column(name = "environment")
    private String environment;

    @Column(name = "isbad")
    private boolean isBad;

    public Endpoint() {}

    public Endpoint(long endpoint_id, String endpoint_name, boolean is_occupied, String occupied_by, String occupied_for, boolean is_deleted, String environment, boolean isBad) {
        this.id = endpoint_id;
        this.endpoint_name = endpoint_name;
        this.is_occupied = is_occupied;
        this.occupied_by = occupied_by;
        this.occupied_for = occupied_for;
        this.is_deleted = is_deleted;
        this.environment = environment;
        this.isBad = isBad;
    }

    public long getEndpoint_id() {
        return id;
    }

    public void setEndpoint_id(long id) {
        this.id = id;
    }

    public String getEndpoint_name() {
        return endpoint_name;
    }

    public void setEndpoint_name(String endpoint_name) {
        this.endpoint_name = endpoint_name;
    }

    public boolean isIs_occupied() {
        return is_occupied;
    }

    public void setIs_occupied(boolean is_occupied) {
        this.is_occupied = is_occupied;
    }

    public String getOccupied_by() {
        return occupied_by;
    }

    public void setOccupied_by(String occupied_by) {
        this.occupied_by = occupied_by;
    }

    public String getOccupied_for() {
        return occupied_for;
    }

    public void setOccupied_for(String occupied_for) {
        this.occupied_for = occupied_for;
    }

    public boolean isIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public boolean isBad() {
        return isBad;
    }

    public void setBad(boolean bad) {
        isBad = bad;
    }

    @Override
    public String toString() {
        return "Endpoint{" +
                "endpoint_id=" + id +
                ", endpoint_name='" + endpoint_name + '\'' +
                ", is_occupied=" + is_occupied +
                ", occupied_by='" + occupied_by + '\'' +
                ", occupied_for='" + occupied_for + '\'' +
                ", is_deleted=" + is_deleted +
                ", is_deleted=" + environment +
                ", isBad=" + isBad +
                '}';
    }
}
