package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Shipment {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  long id ;
    private String trackingNumber ;
    private  String status  ;
    private String customerEmailId  ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomerEmailId() {
        return customerEmailId;
    }

    public void setCustomerEmailId(String customerEmailId) {
        this.customerEmailId = customerEmailId;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public List<TrackingEvent> getTrackingEvents() {
        return trackingEvents;
    }

    public void setTrackingEvents(List<TrackingEvent> trackingEvents) {
        this.trackingEvents = trackingEvents;
    }

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse ;

    @OneToMany(mappedBy = "shipment")
    private List<TrackingEvent> trackingEvents ;

}
