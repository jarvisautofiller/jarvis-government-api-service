package com.example.jarvis.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "AADHAR_DATA")
@Data
public class AadharData {

    @Id
    @Column(name = "ID_NUMBER", nullable = false)
    private String idNumber;

    @Column(name = "FiRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "DOB")
    private String dob;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
}
