package com.example.jarvis.service;

import com.example.jarvis.entity.AadharData;
import com.example.jarvis.entity.PassportData;

import java.util.Optional;

public interface UserService {
    Optional<String> getAadharById(String idNumber);
    Optional<String> getPassportById(String idNumber);
    Object getUserDataByIdAndType(String idNumber, String idType);
}
