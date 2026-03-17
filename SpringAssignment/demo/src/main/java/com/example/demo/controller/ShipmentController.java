package com.example.demo.controller;

import com.example.demo.entity.Shipment;
import com.example.demo.repository.IShipmentRepository;
import com.example.demo.service.IShipmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {

    @Autowired
    private IShipmentService shipmentService;

    @PostMapping
    public Shipment createShipment(@RequestBody Shipment shipment) {
        return shipmentService.createShipment(shipment);
    }

    @GetMapping("/{id}")
    public Shipment getShipment(@PathVariable Long id) {
        return shipmentService.getShipment(id);
    }

    @GetMapping("/all")
    public List<Shipment> getAllShipments() {
        return shipmentService.getAllShipments();
    }

    @GetMapping
    public Page<Shipment> getShipments(Pageable pageable) {
        return shipmentService.getShipments(pageable);
    }

    @PutMapping("/{id}")
    public Shipment updateShipment(@PathVariable Long id, @RequestBody Shipment shipment) {
        return shipmentService.updateShipment(id, shipment);
    }

    @DeleteMapping("/{id}")
    public void deleteShipment(@PathVariable Long id) {
        shipmentService.deleteShipment(id);
    }

    @GetMapping("/filter")
    public List<Shipment> filterShipments(
            @RequestParam String status,
            @RequestParam String warehouse) {

        return shipmentService.filterShipments(status, warehouse);
    }

    @GetMapping("/warehouse-count")
    public List<Object[]> shipmentCountPerWarehouse() {
        return shipmentService.shipmentCountPerWarehouse();
    }

    @GetMapping("/with-latest-event")
    public List<Shipment> getShipmentsWithLatestEvent() {
        return shipmentService.getShipmentsWithLatestEvent();
    }
}