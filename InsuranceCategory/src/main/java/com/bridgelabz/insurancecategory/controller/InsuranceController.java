package com.bridgelabz.insurancecategory.controller;

import com.bridgelabz.insurancecategory.dto.InsuranceDTO;
import com.bridgelabz.insurancecategory.dto.ResponseDTO;
import com.bridgelabz.insurancecategory.model.Insurance;
import com.bridgelabz.insurancecategory.service.IInsuranceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/insurance"})
public class InsuranceController {
    @Autowired
    IInsuranceService service;

    public InsuranceController() {
    }
    
    //to create insurance
    @PostMapping({"/register"})
    public ResponseEntity<ResponseDTO> registerUser(@RequestBody InsuranceDTO dto) {
        Insurance insurance = this.service.registerInsurance(dto);
        ResponseDTO response = new ResponseDTO("User Registered to bookstore", insurance);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    
    //to retrieve all created insurance
    @GetMapping({"/getAll"})
    public ResponseEntity<String> getAll() {
        List<Insurance> insurance = this.service.getAll();
        ResponseDTO response = new ResponseDTO("Users :", insurance);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    
    //to find existing insurance
    @GetMapping({"/findById/{insuranceId}"})
    public ResponseEntity<ResponseDTO> getById(@PathVariable Integer insuranceId) {
        Insurance insurance = this.service.getById(insuranceId);
        ResponseDTO response = new ResponseDTO("Requested Insurance : ", insurance);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    
    //to update existing insurance by id
    @PutMapping({"/update/{insuranceId}"})
    public ResponseEntity<ResponseDTO> updateById(@PathVariable Integer insuranceId, @RequestBody InsuranceDTO dto) {
        Insurance insurance = this.service.updateById(insuranceId, dto);
        ResponseDTO response = new ResponseDTO("Insurance updated : ", insurance);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    
    //to delete insurance by id
    @DeleteMapping({"/delete/{insuranceId}"})
    public ResponseEntity<ResponseDTO> deleteById(@PathVariable Integer insuranceId) {
        ResponseDTO response = new ResponseDTO("Insurance deleted successfully", this.service.deleteById(insuranceId));
        return new ResponseEntity(response, HttpStatus.OK);
    }
    
    //---------------------Rest template-----------------------//
    
    @GetMapping({"/getByIdAPI/{insuranceId}"})
    public Insurance getByIdAPI(@PathVariable Integer insuranceId) {
        Insurance insurance = this.service.getByIdAPI(insuranceId);
        return insurance;
    }
}
