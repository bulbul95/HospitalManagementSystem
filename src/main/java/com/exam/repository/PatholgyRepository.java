package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.entity.Patholgy;

@Repository
public interface PatholgyRepository extends JpaRepository<Patholgy, Integer>{

}
