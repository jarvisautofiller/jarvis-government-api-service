package com.example.jarvis.service;

import com.example.jarvis.entity.AadharData;


import com.example.jarvis.entity.PassportData;
import com.example.jarvis.repository.AadharRepository;
import com.example.jarvis.repository.PassportRepository;
import com.example.jarvis.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jarvis.encryption.AesGcmUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final AadharRepository aadharRepository;
    private final PassportRepository passportRepository;
    @Autowired
    private AesGcmUtil aesGcmUtil;
    @Autowired
    public UserServiceImpl(AadharRepository aadharRepository, PassportRepository passportRepository) {
        this.aadharRepository = aadharRepository;
        this.passportRepository = passportRepository;
    }

    @Override
    public Optional<String> getAadharById(String idNumber) {
        Optional<AadharData> aadharData=  Optional.ofNullable(aadharRepository.findByIdNumber(idNumber));
        if (aadharData == null) return Optional.empty();

        try {
            ObjectMapper mapper = new ObjectMapper();
            String aJson = mapper.writeValueAsString(aadharData);
            String aEncrypted = aesGcmUtil.encrypt(aJson);
            return Optional.of(aEncrypted);
        } catch (Exception e) {
            throw new RuntimeException("Failed to encrypt AadharData", e);
        }
    }

    @Override
    public Optional<String> getPassportById(String idNumber) {
        Optional<PassportData> passportData = Optional.ofNullable(passportRepository.findByIdNumber(idNumber));
        if (passportData == null) return Optional.empty();

        try {
            ObjectMapper mapper = new ObjectMapper();
            String pJson = mapper.writeValueAsString(passportData);
            String pEncrypted = aesGcmUtil.encrypt(pJson);
            return Optional.of(pEncrypted);
        } catch (Exception e) {
            throw new RuntimeException("Failed to encrypt AadharData", e);
        }
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
