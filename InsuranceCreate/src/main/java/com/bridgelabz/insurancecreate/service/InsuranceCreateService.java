package com.bridgelabz.insurancecreate.service;

import com.bridgelabz.insurancecreate.dto.InsuranceCreateDTO;
import com.bridgelabz.insurancecreate.exception.InsuranceException;
import com.bridgelabz.insurancecreate.exception.UserException;
import com.bridgelabz.insurancecreate.model.InsuranceCreate;
import com.bridgelabz.insurancecreate.repository.InsuranceCreateRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InsuranceCreateService implements IInsuranceCreateService {
	
    @Autowired
    InsuranceCreateRepository repo;
    
    @Autowired
    RestTemplate restTemplate;
    
    //checks if userID and isuranceID is valid and registers
    public InsuranceCreate insuranceRegister(InsuranceCreateDTO dto) {
        Object user = this.restTemplate.getForObject("http://localhost:9000/user/getByIdAPI/" + dto.getUserId(), Object.class, new Object[0]);
        if (user.equals(null)) {
            throw new UserException("UserID not found");
        } 
        else 
        {
            Object insuranceProof = this.restTemplate.getForObject("http://localhost:9001/insurance/getByIdAPI/" + dto.getInsuranceId(), Object.class, new Object[0]);
            if 
            (insuranceProof.equals(null)) {
                throw new InsuranceException("InsuranceID not found");
            } 
            else 
            {
                InsuranceCreate insurance = new InsuranceCreate(dto);
                repo.save(insurance);
                return insurance;
            }
        }
    }
    
    //to retrieve list of insurances
    public List<InsuranceCreate> getInsurances() {
        List<InsuranceCreate> list = this.repo.findAll();
        if (list.isEmpty()) {
            throw new InsuranceException("There are no Insurance added");
        } else {
            return list;
        }
    }
    
    //to retrieve insruance using insurance creation Id
    public InsuranceCreate getById(Integer insuranceConsumerId) {
        Optional<InsuranceCreate> insurance = this.repo.findById(insuranceConsumerId);
        if (insurance.isEmpty()) {
            throw new InsuranceException("There is no Insurance with given id");
        } else {
            return (InsuranceCreate)insurance.get();
        }
    }
    
    //API service used for update service
    public InsuranceCreate updateById(Integer insuranceConsumerId, InsuranceCreateDTO dto) {
    	Object user = this.restTemplate.getForObject("http://localhost:9000/user/getByIdAPI/" + dto.getUserId(), Object.class);
        if (user.equals(null)) {
            throw new UserException("UserID not found");
        }
        Object insuranceProof = this.restTemplate.getForObject("http://localhost:9001/insurance/getByIdAPI/" + dto.getInsuranceId(), Object.class);
        if (insuranceProof.equals(null)) {
            throw new InsuranceException("InsuranceID not found");
        }
        Optional<InsuranceCreate> matcher = this.repo.findById(insuranceConsumerId);
        if (matcher.isEmpty()) {
            throw new InsuranceException("Insurance is not found");
        } else {
            InsuranceCreate insurance = new InsuranceCreate(insuranceConsumerId, dto);
            repo.save(insurance);
            return insurance;
        }
    }
    
    //to delete existing insurance
    public InsuranceCreate deleteById(Integer insuranceConsumerId) {
        Optional<InsuranceCreate> insurance = this.repo.findById(insuranceConsumerId);
        if (insurance.isEmpty()) {
            throw new InsuranceException("Invalid insuranceConsumerId..please input valid insuranceConsumerId");
        } else {
            this.repo.deleteById(insuranceConsumerId);
            return (InsuranceCreate)insurance.get();
        }
    }
}