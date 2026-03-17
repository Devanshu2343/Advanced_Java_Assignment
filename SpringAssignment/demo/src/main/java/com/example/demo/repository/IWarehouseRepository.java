package com.example.demo.repository;

import com.example.demo.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWarehouseRepository extends JpaRepository<Warehouse, Long> {


}
