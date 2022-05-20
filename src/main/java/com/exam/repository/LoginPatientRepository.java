package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.entity.Loginpatient;

@Repository
public interface LoginPatientRepository extends JpaRepository<Loginpatient, Integer>{

}
