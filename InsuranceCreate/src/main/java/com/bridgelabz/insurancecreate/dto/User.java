package com.bridgelabz.insurancecreate.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer userId;
    private String fullName;
    private String permanentAddress;
    private String temporaryAddress;
    private long mobileNumber;
    private String email;
    private int age;
    private String occupation;
    private String familyBackground;
    private String kyc;
    private String healthCondition;
    private String vehicleData;
    private LocalDate date = LocalDate.now();
    private LocalTime time = LocalTime.now();
}