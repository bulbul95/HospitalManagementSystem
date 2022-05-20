package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.entity.Addpatient;
@Repository
public interface AddPatientRepository extends JpaRepository<Addpatient, Integer>{

}
