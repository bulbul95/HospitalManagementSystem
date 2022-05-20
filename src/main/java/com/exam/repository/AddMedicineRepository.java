package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.entity.Addmedicine;
@Repository
public interface AddMedicineRepository extends JpaRepository<Addmedicine, Integer> {

}
