package com.example.springSecurity.service;

import com.example.springSecurity.converter.PropertyConverter;
import com.example.springSecurity.dto.PropertyDTO;
import com.example.springSecurity.entity.PropertyEntity;
import com.example.springSecurity.repository.IPropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyService implements IPropertyService {

    @Autowired
    private IPropertyRepo iPropertyRepo;

    @Autowired
    private PropertyConverter propertyConverter ;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

        PropertyEntity pe = propertyConverter.convertDTOtoEntity(propertyDTO) ;
        iPropertyRepo.save(pe);


        propertyDTO = propertyConverter.convertEntityDTO(pe);

        return propertyDTO ;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> listOfProps = (List<PropertyEntity>) iPropertyRepo.findAll();
        List<PropertyDTO> propList = new ArrayList<>() ;
        for (PropertyEntity pe : listOfProps){
            PropertyDTO dto = propertyConverter.convertEntityDTO(pe) ;
            propList.add(dto) ;
        }
        return  propList ;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {

         Optional<PropertyEntity> optionalPropertyEntity = iPropertyRepo.findById(propertyId) ;
         PropertyDTO dto = null ;
         if (optionalPropertyEntity.isPresent()){
             PropertyEntity pe = optionalPropertyEntity.get();
             pe.setTitle(propertyDTO.getTitle());
             pe.setAddress(propertyDTO.getAddress());
             pe.setDescription(propertyDTO.getDescription());
             pe.setOwnerEmail(propertyDTO.getOwnerEmail());
             pe.setOwnerName(propertyDTO.getOwnerName());
             pe.setPrice(propertyDTO.getPrice());

             dto = propertyConverter.convertEntityDTO(pe);
             iPropertyRepo.save(pe);

         }

        return dto;
    }

    @Override
    public PropertyDTO updateDescription(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optionalPropertyEntity = iPropertyRepo.findById(propertyId) ;
        PropertyDTO dto = null ;
        if (optionalPropertyEntity.isPresent()){
            PropertyEntity pe = optionalPropertyEntity.get();
            pe.setDescription(propertyDTO.getDescription());
            dto = propertyConverter.convertEntityDTO(pe);
            iPropertyRepo.save(pe);

        }

        return dto;
    }

    @Override
    public PropertyDTO updatePrice(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optionalPropertyEntity = iPropertyRepo.findById(propertyId) ;
        PropertyDTO dto = null ;
        if (optionalPropertyEntity.isPresent()){
            PropertyEntity pe = optionalPropertyEntity.get();
            pe.setPrice(propertyDTO.getPrice());
            dto = propertyConverter.convertEntityDTO(pe);
            iPropertyRepo.save(pe);

        }

        return dto;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        iPropertyRepo.deleteById(propertyId);
    }


}
