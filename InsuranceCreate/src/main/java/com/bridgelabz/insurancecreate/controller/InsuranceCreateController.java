package com.bridgelabz.insurancecreate.controller;

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

import com.bridgelabz.insurancecreate.dto.InsuranceCreateDTO;
import com.bridgelabz.insurancecreate.dto.ResponseDTO;
import com.bridgelabz.insurancecreate.model.InsuranceCreate;
import com.bridgelabz.insurancecreate.service.IInsuranceCreateService;

@RestController
@RequestMapping({"/insuranceCreate"})
public class InsuranceCreateController {
    @Autowired
    IInsuranceCreateService service;

    public InsuranceCreateController() {
    }
    
    //to register insurance
    @PostMapping({"/register"})
    public ResponseEntity<ResponseDTO> insuranceRegister(@RequestBody InsuranceCreateDTO dto) {
        InsuranceCreate insuranceCreate = this.service.insuranceRegister(dto);
        ResponseDTO response = new ResponseDTO("User Registered to bookstore", insuranceCreate);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    
    //to retrieve list of insurances
    @GetMapping({"/getAll"})
    public ResponseEntity<String> getInsurances() {
        List<InsuranceCreate> insuranceCreate = this.service.getInsurances();
        ResponseDTO response = new ResponseDTO("Users :", insuranceCreate);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    
    //ability to find insurance using insurance id
    @GetMapping({"/findById/{insuranceConsumerId}"})
    public ResponseEntity<ResponseDTO> getById(@PathVariable Integer insuranceConsumerId) {
        InsuranceCreate insuranceCreate = this.service.getById(insuranceConsumerId);
        ResponseDTO response = new ResponseDTO("Requested User : ", insuranceCreate);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    
    //to update existing insurance
    @PutMapping({"/update/{insuranceConsumerId}"})
    public ResponseEntity<ResponseDTO> updateById(@PathVariable Integer insuranceConsumerId, @RequestBody InsuranceCreateDTO dto) {
        InsuranceCreate insuranceCreate = this.service.updateById(insuranceConsumerId, dto);
        ResponseDTO response = new ResponseDTO("Insurance updated : ", insuranceCreate);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    
    //to delete existing insurance
    @DeleteMapping({"/delete/{insuranceConsumerId}"})
    public ResponseEntity<ResponseDTO> deleteById(@PathVariable Integer insuranceConsumerId) {
        ResponseDTO response = new ResponseDTO("Insurance deleted successfully", this.service.deleteById(insuranceConsumerId));
        return new ResponseEntity(response, HttpStatus.OK);
    }
}