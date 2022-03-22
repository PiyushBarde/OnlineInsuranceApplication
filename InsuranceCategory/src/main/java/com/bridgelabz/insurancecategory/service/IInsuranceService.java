package com.bridgelabz.insurancecategory.service;

import com.bridgelabz.insurancecategory.dto.InsuranceDTO;
import com.bridgelabz.insurancecategory.model.Insurance;
import java.util.List;

public interface IInsuranceService {
    Insurance registerInsurance(InsuranceDTO dto);

    List<Insurance> getAll();

    Insurance getById(Integer insuranceId);

    Insurance updateById(Integer insuranceId, InsuranceDTO dto);

    Object deleteById(Integer insuranceId);

    Insurance getByIdAPI(Integer insuranceId);
}