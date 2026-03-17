package com.example.demo.repository;

import com.example.demo.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IShipmentRepository extends JpaRepository<Shipment , Long> {


    @Query(value = "SELECT * FROM shipment s JOIN warehouse w ON s.warehouse_id = w.id WHERE s.status = ?1 AND w.name LIKE %?2%", nativeQuery = true)
    List<Shipment> findShipmentsByStatusAndWarehouse(String status, String warehouseName);


    @Query(value = "SELECT w.name, COUNT(s.id) FROM shipment s JOIN warehouse w ON s.warehouse_id = w.id GROUP BY w.id", nativeQuery = true)
    List<Object[]> countShipmentsPerWarehouse();

    @Query("SELECT s FROM Shipment s JOIN FETCH s.trackingEvents te WHERE te.timeStamp = (SELECT MAX(t.timeStamp) FROM TrackingEvent t WHERE t.shipment.id = s.id)")
    List<Shipment> findShipmentsWithLatestEvent();
}
