package com.example.springSecurity.service;

import com.example.springSecurity.dto.PropertyDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IPropertyService {
    PropertyDTO saveProperty (PropertyDTO propertyDTO) ;

    List<PropertyDTO> getAllProperties() ;

    PropertyDTO updateProperty (PropertyDTO propertyDTO , Long propertyId) ;

    PropertyDTO updateDescription ( PropertyDTO propertyDTO , Long propertyId) ;
    PropertyDTO updatePrice ( PropertyDTO propertyDTO ,  Long propertyId) ;

    void  deleteProperty (Long propertyId) ;
}
