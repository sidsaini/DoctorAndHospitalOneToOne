package com.example.service;

import com.example.dto.DoctorDTO;
import com.example.dto.HospitalDTO;
import com.example.exception.MedicalException;

public interface HospitalService {

    public Integer addHospital(HospitalDTO hospitalDTO);

    public HospitalDTO getHospital(Integer hospitalId) throws MedicalException;

    public Integer deleteHospital(Integer hospitalId) throws MedicalException;

    public Integer updatedoctor(Integer hospitalId, DoctorDTO doctorDTO) throws MedicalException;
}
