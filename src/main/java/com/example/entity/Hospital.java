package com.example.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hospitalId;

    private String hospitalName;

    @Column(name = "emailid")
    private String emailId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id", unique = true)
    private Doctor doctor;

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hospital hospital = (Hospital) o;
        return Objects.equals(getHospitalId(), hospital.getHospitalId()) && Objects.equals(getHospitalName(), hospital.getHospitalName()) && Objects.equals(getEmailId(), hospital.getEmailId()) && Objects.equals(getDoctor(), hospital.getDoctor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHospitalId(), getHospitalName(), getEmailId(), getDoctor());
    }
}
