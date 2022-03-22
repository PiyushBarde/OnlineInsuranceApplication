package com.bridgelabz.insurancecreate.service;

import com.bridgelabz.insurancecreate.dto.InsuranceCreateDTO;
import com.bridgelabz.insurancecreate.model.InsuranceCreate;
import java.util.List;

public interface IInsuranceCreateService {
    InsuranceCreate insuranceRegister(InsuranceCreateDTO dto);

    List<InsuranceCreate> getInsurances();

    InsuranceCreate getById(Integer insuranceConsumerId);

    InsuranceCreate updateById(Integer insuranceConsumerId, InsuranceCreateDTO dto);

    InsuranceCreate deleteById(Integer insuranceConsumerId);
}

