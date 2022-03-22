package com.bridgelabz.insurancecategory.repository;

import com.bridgelabz.insurancecategory.model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {
}
