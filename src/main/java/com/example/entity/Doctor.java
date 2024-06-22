package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Doctor {

    @Id
    private Long doctorId;

    private String doctorName;

    private String city;

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(getDoctorId(), doctor.getDoctorId()) && Objects.equals(getDoctorName(), doctor.getDoctorName()) && Objects.equals(getCity(), doctor.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDoctorId(), getDoctorName(), getCity());
    }
}
