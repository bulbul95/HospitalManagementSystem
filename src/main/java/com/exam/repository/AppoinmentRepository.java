package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.entity.Appoinment;

@Repository
public interface AppoinmentRepository extends JpaRepository<Appoinment, Integer>{

}
