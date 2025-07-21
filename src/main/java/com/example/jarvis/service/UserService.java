package com.example.jarvis.service;

import com.example.jarvis.entity.AadharData;
import com.example.jarvis.entity.PassportData;

import java.util.Optional;

public interface UserService {
    Optional<AadharData> getAadharById(String idNumber);
    Optional<PassportData> getPassportById(String idNumber);
    Object getUserDataByIdAndType(String idNumber, String idType);
}
