package com.example.jarvis.utils;

import com.jarvis.encryption.AesGcmUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EncryptionConfig {

    @Value("${encryption.key}")
    private String secretKey;

    @Bean
    public AesGcmUtil aesGcmUtil() {
        return new AesGcmUtil(secretKey.getBytes());
    }
}

