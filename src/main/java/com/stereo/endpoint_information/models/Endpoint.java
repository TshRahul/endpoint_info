package com.stereo.endpoint_information.models;

import javax.persistence.*;

@Entity
@Table(name = "ENDPOINTS")
public class Endpoint {

    @Id
    @Column(name = "endpoint_id")
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long endpoint_id;

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

    public Endpoint() {}

    public Endpoint(long endpoint_id, String endpoint_name, boolean is_occupied, String occupied_by, String occupied_for, boolean is_deleted) {
        this.endpoint_id = endpoint_id;
        this.endpoint_name = endpoint_name;
        this.is_occupied = is_occupied;
        this.occupied_by = occupied_by;
        this.occupied_for = occupied_for;
        this.is_deleted = is_deleted;
    }

    public long getEndpoint_id() {
        return endpoint_id;
    }

    public void setEndpoint_id(long endpoint_id) {
        this.endpoint_id = endpoint_id;
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

    @Override
    public String toString() {
        return "Endpoint{" +
                "endpoint_id=" + endpoint_id +
                ", endpoint_name='" + endpoint_name + '\'' +
                ", is_occupied=" + is_occupied +
                ", occupied_by='" + occupied_by + '\'' +
                ", occupied_for='" + occupied_for + '\'' +
                ", is_deleted=" + is_deleted +
                '}';
    }
}
