package com.example.jarvis.repository;

import com.example.jarvis.entity.AadharData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AadharRepository extends JpaRepository<AadharData, String> {
    AadharData findByIdNumber(String idNumber);
}
