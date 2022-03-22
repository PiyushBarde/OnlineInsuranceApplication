package com.bridgelabz.insurancecategory.service;

import com.bridgelabz.insurancecategory.dto.InsuranceDTO;
import com.bridgelabz.insurancecategory.exceptions.InsuranceException;
import com.bridgelabz.insurancecategory.model.Insurance;
import com.bridgelabz.insurancecategory.repository.InsuranceRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceService implements IInsuranceService {
    @Autowired
    InsuranceRepository repo;

    public InsuranceService() {
    }
    
    //to register insurance
    public Insurance registerInsurance(InsuranceDTO dto) {
        Insurance insurance = new Insurance(dto);
        this.repo.save(insurance);
        return insurance;
    }

    //to retrieve list of insurances
    public List<Insurance> getAll() {
        List<Insurance> list = this.repo.findAll();
        if (list.isEmpty()) {
            throw new InsuranceException("There are no Insurance added");
        } else {
            return list;
        }
    }

    //to retrieve insurance using insurance Id
    public Insurance getById(Integer insuranceId) {
        Optional<Insurance> insurance = this.repo.findById(insuranceId);
        if (insurance.isEmpty()) {
            throw new InsuranceException("There are no users with given id");
        } else {
            return (Insurance)insurance.get();
        }
    }

    //API service used for update service
    public Insurance updateById(Integer insuranceId, InsuranceDTO dto) {
        Optional<Insurance> matcher = this.repo.findById(insuranceId);
        if (matcher.isEmpty()) {
            throw new InsuranceException("Insurance is not found");
        } else {
            Insurance insurance = new Insurance(insuranceId, dto);
            return insurance;
        }
    }
    
    //to delete existing insurance
    public Insurance deleteById(Integer insuranceId) {
        Optional<Insurance> insurance = this.repo.findById(insuranceId);
        if (insurance.isEmpty()) {
            throw new InsuranceException("Invalid insuranceId..please input valid insuranceId");
        } else {
            this.repo.deleteById(insuranceId);
            return (Insurance)insurance.get();
        }
    }

    //--------------------------REST Template API-----------------------------------//
    
    public Insurance getByIdAPI(Integer insuranceId) {
        Optional<Insurance> insurance = this.repo.findById(insuranceId);
        if (insurance.isEmpty()) {
            throw new InsuranceException("There are no users with given id");
        } else {
            return (Insurance)insurance.get();
        }
    }
}
