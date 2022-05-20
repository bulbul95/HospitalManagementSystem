package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.entity.Covidtest;

@Repository
public interface CovidTestRepository extends JpaRepository<Covidtest, Integer> {

}
