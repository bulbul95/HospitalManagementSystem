package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.entity.Loginreciption;

@Repository
public interface LoginReciptionRepository extends JpaRepository<Loginreciption, Integer>{

}
