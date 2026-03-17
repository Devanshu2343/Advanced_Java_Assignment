package com.example.demo.service;

import com.example.demo.entity.Shipment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IShipmentService {
    Shipment createShipment (Shipment shipment) ;

    Shipment getShipment (Long id) ;

    List<Shipment> getAllShipments() ;

    Shipment updateShipment(Long id  , Shipment shipment) ;

    void deleteShipment (Long id ) ;

    Page<Shipment> getShipments(Pageable pageable);

    List<Shipment> filterShipments(String status, String warehouseName);

    List<Object[]> shipmentCountPerWarehouse();

    List<Shipment> getShipmentsWithLatestEvent();
}
