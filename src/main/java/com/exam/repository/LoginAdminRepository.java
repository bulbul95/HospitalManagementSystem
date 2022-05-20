package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.entity.Loginadmin;

@Repository
public interface LoginAdminRepository extends JpaRepository<Loginadmin, Integer> {

}
