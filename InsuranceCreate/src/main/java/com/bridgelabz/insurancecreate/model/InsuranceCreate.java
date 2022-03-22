package com.bridgelabz.insurancecreate.model;

import com.bridgelabz.insurancecreate.dto.InsuranceCreateDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(
    name = "Insurance"
)
public class InsuranceCreate {
    @Id
    @GeneratedValue
    private Integer consumerInsuranceId;
    private Integer userId;
    private Integer insuranceId;

    public InsuranceCreate(InsuranceCreateDTO dto) {
        this.userId = dto.getUserId();
        this.insuranceId = dto.getInsuranceId();
    }

    public InsuranceCreate(Integer insuranceConsumerId, InsuranceCreateDTO dto) {
        this.consumerInsuranceId = insuranceConsumerId;
        this.userId = dto.getUserId();
        this.insuranceId = dto.getInsuranceId();
    }
}
