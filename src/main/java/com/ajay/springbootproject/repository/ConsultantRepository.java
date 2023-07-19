package com.ajay.springbootproject.repository;

import com.ajay.springbootproject.entity.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultantRepository extends JpaRepository<Consultant,Long> {
}
