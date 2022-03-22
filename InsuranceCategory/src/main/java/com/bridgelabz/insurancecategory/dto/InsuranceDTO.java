package com.bridgelabz.insurancecategory.dto;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceDTO {
    @NotEmpty(
        message = "insuranceName must be filled"
    )
    private String insuranceName;
    @NotEmpty(
        message = "insuranceStatus must be filled (ACTIVE/PASSIVE)"
    )
    private String insuranceStatus;
    @NotEmpty(
        message = "insuranceScheme must be filled"
    )
    private String insuranceScheme;
    @NotEmpty(
        message = "insuranceCode must be Provided"
    )
    private String insuranceCode;
    @NotEmpty(
        message = "insurancePeriod must be Provided"
    )
    private String insurancePeriod;
}