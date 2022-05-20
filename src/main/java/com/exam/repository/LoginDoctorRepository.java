package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.entity.Logindoctor;

@Repository
public interface LoginDoctorRepository extends JpaRepository<Logindoctor, Integer>{

}
