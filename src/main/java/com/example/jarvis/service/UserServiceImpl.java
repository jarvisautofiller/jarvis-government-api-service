package com.example.jarvis.service;

import com.example.jarvis.entity.AadharData;


import com.example.jarvis.entity.PassportData;
import com.example.jarvis.repository.AadharRepository;
import com.example.jarvis.repository.PassportRepository;
import com.example.jarvis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final AadharRepository aadharRepository;
    private final PassportRepository passportRepository;

    @Autowired
    public UserServiceImpl(AadharRepository aadharRepository, PassportRepository passportRepository) {
        this.aadharRepository = aadharRepository;
        this.passportRepository = passportRepository;
    }

    @Override
    public Optional<AadharData> getAadharById(String idNumber) {
        return Optional.ofNullable(aadharRepository.findByIdNumber(idNumber));
    }

    @Override
    public Optional<PassportData> getPassportById(String idNumber) {
        return Optional.ofNullable(passportRepository.findByIdNumber(idNumber));
    }

    @Override
    public Object getUserDataByIdAndType(String idNumber, String idType) {
        if ("aadhar".equalsIgnoreCase(idType)) {
            return getAadharById(idNumber).orElse(null);
        } else if ("passport".equalsIgnoreCase(idType)) {
            System.out.println(idNumber);
            return getPassportById(idNumber).orElse(null);
        } else {
            throw new IllegalArgumentException("Invalid ID type: must be 'Aadhar' or 'Passport'");
        }
    }
}
