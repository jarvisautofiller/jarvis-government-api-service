package com.example.jarvis.repository;

import com.example.jarvis.entity.PassportData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<PassportData, String> {
    PassportData findByIdNumber(String idNumber);
}
