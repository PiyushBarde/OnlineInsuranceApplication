package com.bridgelabz.insurancecategory.model;

import com.bridgelabz.insurancecategory.dto.InsuranceDTO;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(
    name = "Insurance_details"
)
@Entity
public class Insurance {
    @Id
    @GeneratedValue
    private Integer insuranceId;
    private String insuranceName;
    private String insuranceStatus;
    private String insuranceScheme;
    private String insuranceCode;
    private String insurancePeriod;
    private LocalDate date = LocalDate.now();
    private LocalTime time = LocalTime.now();

    public Insurance(InsuranceDTO dto) {
        this.insuranceName = dto.getInsuranceName();
        this.insuranceStatus = dto.getInsuranceStatus();
        this.insuranceScheme = dto.getInsuranceScheme();
        this.insuranceCode = dto.getInsuranceCode();
        this.insurancePeriod = dto.getInsurancePeriod();
    }

    public Insurance() {
    }

    public Insurance(Integer insuranceId, InsuranceDTO dto) {
        this.insuranceId = insuranceId;
        this.insuranceName = dto.getInsuranceName();
        this.insuranceStatus = dto.getInsuranceStatus();
        this.insuranceScheme = dto.getInsuranceScheme();
        this.insuranceCode = dto.getInsuranceCode();
        this.insurancePeriod = dto.getInsurancePeriod();
    }
}