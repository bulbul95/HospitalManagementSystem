package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.entity.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer>{

}
