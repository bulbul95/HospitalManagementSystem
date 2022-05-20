package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.entity.Covid;

@Repository
public interface CovidRepository extends JpaRepository<Covid, Integer>{

}
