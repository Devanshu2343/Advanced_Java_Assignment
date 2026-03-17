package com.example.springSecurity.repository;

import com.example.springSecurity.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

public interface IPropertyRepo extends CrudRepository <PropertyEntity , Long>{

}
