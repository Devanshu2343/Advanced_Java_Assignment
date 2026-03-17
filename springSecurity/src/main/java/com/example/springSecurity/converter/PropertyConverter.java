package com.example.springSecurity.converter;

import com.example.springSecurity.dto.PropertyDTO;
import com.example.springSecurity.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity convertDTOtoEntity(PropertyDTO propertyDTO){
        PropertyEntity pe = new PropertyEntity();
        pe.setTitle(propertyDTO.getTitle());
        pe.setAddress(propertyDTO.getAddress());
        pe.setDescription(propertyDTO.getDescription());
        pe.setOwnerEmail(propertyDTO.getOwnerEmail());
        pe.setOwnerName(propertyDTO.getOwnerName());
        pe.setPrice(propertyDTO.getPrice());

        return pe;
    }

    public PropertyDTO convertEntityDTO(PropertyEntity propertyEntity ){
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setId(propertyEntity.getId());
        propertyDTO.setTitle(propertyEntity.getTitle());
        propertyDTO.setAddress(propertyEntity.getAddress());
        propertyDTO.setDescription(propertyEntity.getDescription());
        propertyDTO.setOwnerName(propertyEntity.getOwnerName());
        propertyDTO.setOwnerEmail(propertyEntity.getOwnerEmail());
        propertyDTO.setPrice(propertyEntity.getPrice());

       return propertyDTO;
    }

}
