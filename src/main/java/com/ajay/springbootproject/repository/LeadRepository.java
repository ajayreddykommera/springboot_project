package com.ajay.springbootproject.repository;

import com.ajay.springbootproject.entity.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadRepository extends JpaRepository<Lead,Long> {
}
