package com.bridgelabz.insurancecreate.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Insurance {
    private Integer insuranceId;
    private String insuranceName;
    private String insuranceStatus;
    private String insuranceScheme;
    private String insuranceCode;
    private String insurancePeriod;
    private LocalDate date = LocalDate.now();
    private LocalTime time = LocalTime.now();
}