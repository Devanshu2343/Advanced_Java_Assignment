//package com.example.demo.service;
//
//import com.example.demo.entity.Shipment;
//import com.example.demo.exception.ResourceNotFoundException;
//import com.example.demo.repository.IShipmentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ShipmentService implements  IShipmentService{
//    @Autowired
//    private IShipmentRepository shipmentRepository ;
//
//    @Override
//    public Shipment createShipment(Shipment shipment) {
//        return shipmentRepository.save(shipment);
//    }
//
////    @Override
////    public Shipment getShipment(Long id) {
////        return shipmentRepository.findById(id).orElse(null);
////    }
//
//    @Override
//    public Shipment getShipment(Long id) {
//
//        return shipmentRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found with id: " + id));
//    }
//
//    @Override
//    public List<Shipment> getAllShipments() {
//        return shipmentRepository.findAll();
//    }
//
//    @Override
//    public Shipment updateShipment(Long id, Shipment shipment) {
//        shipment.setId(id);
//        return  shipmentRepository.save(shipment);
//    }
//
//    @Override
//    public void deleteShipment(Long id) {
//        shipmentRepository.deleteById(id);
//
//    }
//
//    @Override
//    public Page<Shipment> getShipments(Pageable pageable) {
//        return shipmentRepository.findAll(pageable);
//    }
//
//    @Override
//    public List<Shipment> filterShipments(String status, String warehouseName) {
//        return shipmentRepository.findShipmentsByStatusAndWarehouse(status, warehouseName);
//    }
//
//    @Override
//    public List<Object[]> shipmentCountPerWarehouse() {
//        return shipmentRepository.countShipmentsPerWarehouse();
//    }
//
//    @Override
//    public List<Shipment> getShipmentsWithLatestEvent() {
//        return shipmentRepository.findShipmentsWithLatestEvent();
//    }
//
//
//
//
//}


package com.example.demo.service;

import com.example.demo.entity.Shipment;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.exception.ShipmentProcessingException;
import com.example.demo.repository.IShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShipmentService implements IShipmentService {

    @Autowired
    private IShipmentRepository shipmentRepository;

    @Override
    @Transactional
    public Shipment createShipment(Shipment shipment) {

        if (shipment.getTrackingNumber() == null || shipment.getTrackingNumber().isEmpty()) {
            throw new ValidationException("Tracking number cannot be empty");
        }

        try {
            return shipmentRepository.save(shipment);
        } catch (Exception e) {
            throw new ShipmentProcessingException("Error while creating shipment");
        }
    }

    @Override
    public Shipment getShipment(Long id) {

        return shipmentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Shipment not found with id: " + id));
    }

    @Override
    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    @Override
    @Transactional
    public Shipment updateShipment(Long id, Shipment shipment) {

        Shipment existing = shipmentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Shipment not found with id: " + id));

        existing.setTrackingNumber(shipment.getTrackingNumber());
        existing.setStatus(shipment.getStatus());
        existing.setCustomerEmailId(shipment.getCustomerEmailId());
        existing.setWarehouse(shipment.getWarehouse());

        try {
            return shipmentRepository.save(existing);
        } catch (Exception e) {
            throw new ShipmentProcessingException("Error while updating shipment");
        }
    }

    @Override
    public void deleteShipment(Long id) {

        Shipment shipment = shipmentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Shipment not found with id: " + id));

        shipmentRepository.delete(shipment);
    }

    @Override
    public Page<Shipment> getShipments(Pageable pageable) {
        return shipmentRepository.findAll(pageable);
    }

    @Override
    public List<Shipment> filterShipments(String status, String warehouseName) {
        return shipmentRepository.findShipmentsByStatusAndWarehouse(status, warehouseName);
    }

    @Override
    public List<Object[]> shipmentCountPerWarehouse() {
        return shipmentRepository.countShipmentsPerWarehouse();
    }

    @Override
    public List<Shipment> getShipmentsWithLatestEvent() {
        return shipmentRepository.findShipmentsWithLatestEvent();
    }
}