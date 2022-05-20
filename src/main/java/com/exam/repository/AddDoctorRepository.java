package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.entity.Adddoctor;
@Repository
public interface AddDoctorRepository extends JpaRepository<Adddoctor, Integer>{

}
