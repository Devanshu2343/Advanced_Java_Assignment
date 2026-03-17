package com.example.springSecurity.controller;


import com.example.springSecurity.dto.PropertyDTO;
import com.example.springSecurity.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api2")
public class PropertyController {

    @Autowired
    private IPropertyService iPropertyService ;

    @GetMapping("/homepage")
    public String getHomepage(){
        return "Property Homepage" ;
    }

//    @PostMapping("/Property")
//    public PropertyDTO saveProp (@RequestBody PropertyDTO propertyDTO){
//        iPropertyService.saveProperty(propertyDTO) ;
//
//
//        return propertyDTO ;
//    }

    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> saveProperty (@RequestBody PropertyDTO propertyDTO){

        propertyDTO = iPropertyService.saveProperty(propertyDTO);

        ResponseEntity<PropertyDTO> responseEntity;
        responseEntity = new ResponseEntity<>(propertyDTO , HttpStatus.CREATED);
        return  responseEntity ;
    }

//   http://localhost:9099/api2/getAllprop
    @GetMapping("/getAllprop")
    public ResponseEntity<List<PropertyDTO>> getAllProperties(){
        List<PropertyDTO> propertyDTOList = iPropertyService.getAllProperties();

        ResponseEntity<List<PropertyDTO>> responseEntity ;
        responseEntity = new ResponseEntity<>(propertyDTOList , HttpStatus.OK) ;
        return responseEntity ;
   }


//   http://localhost:9099/api2/updateProp/5
  @PutMapping("/updateProp/{propertyId}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO ,@PathVariable Long propertyId){
        propertyDTO = iPropertyService.updateProperty(propertyDTO , propertyId) ;
      return new ResponseEntity<>(propertyDTO , HttpStatus.OK);
  }

//  http://localhost:9099/api2/updateProp/up-Des/5
  @PatchMapping("/updateProp/up-Des/{propertyId}")
    public ResponseEntity<PropertyDTO> updateDescription (@RequestBody PropertyDTO propertyDTO , @PathVariable Long propertyId){
      propertyDTO = iPropertyService.updateDescription(propertyDTO , propertyId) ;
      return new ResponseEntity<>(propertyDTO , HttpStatus.OK);

  }

    @PatchMapping("/updateProp/up-Price/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePrice (@RequestBody PropertyDTO propertyDTO , @PathVariable Long propertyId){
        propertyDTO = iPropertyService.updatePrice(propertyDTO , propertyId) ;
        return new ResponseEntity<>(propertyDTO , HttpStatus.OK);

    }

    //http://localhost:9099/api2/properties/1
    @DeleteMapping("/properties/{propertyId}")
    public ResponseEntity<Void>  deleteProperty (@PathVariable Long propertyId){
        iPropertyService.deleteProperty(propertyId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
