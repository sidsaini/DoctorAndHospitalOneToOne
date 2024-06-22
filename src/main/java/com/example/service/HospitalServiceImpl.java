package com.example.service;

import com.example.dto.DoctorDTO;
import com.example.dto.HospitalDTO;
import com.example.entity.Doctor;
import com.example.entity.Hospital;
import com.example.exception.MedicalException;
import com.example.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public Integer addHospital(HospitalDTO hospitalDTO)
    {
        Hospital hospital = new Hospital();

        hospital.setHospitalId(hospitalDTO.getHospitalId());
        hospital.setHospitalName(hospitalDTO.getHospitalName());
        hospital.setEmailId(hospitalDTO.getEmailId());

        Doctor doctor = new Doctor();
        
        doctor.setDoctorId(hospitalDTO.getDoctor().getDoctorId());
        doctor.setDoctorName(hospitalDTO.getDoctor().getDoctorName());
        doctor.setCity(hospitalDTO.getDoctor().getCity());
        hospital.setDoctor(doctor);
        hospitalRepository.save(hospital);
        return hospital.getHospitalId();
        
    }

    @Override
    public HospitalDTO getHospital(Integer hospitalId) throws MedicalException {
        Optional<Hospital> optional = hospitalRepository.findById(hospitalId);
        Hospital hospital = optional.orElseThrow(() -> new MedicalException("Service.INVALID_HOSPITALID"));

        HospitalDTO hospitalDTO = new HospitalDTO();

        hospitalDTO.setHospitalId(hospital.getHospitalId());
        hospitalDTO.setHospitalName(hospital.getHospitalName());
        hospitalDTO.setEmailId(hospital.getEmailId());

        DoctorDTO doctorDTO = new DoctorDTO();

        doctorDTO.setDoctorId(hospital.getDoctor().getDoctorId());
        doctorDTO.setDoctorName(hospital.getDoctor().getDoctorName());
        doctorDTO.setCity(hospital.getDoctor().getCity());
        hospitalDTO.setDoctor(doctorDTO);

        return hospitalDTO;
    }

    @Override
    public Integer deleteHospital(Integer hospitalId) throws MedicalException {
        Optional<Hospital> optional = hospitalRepository.findById(hospitalId);
        Hospital hospital = optional.orElseThrow(() -> new MedicalException("Service.INVALID_HOSPITALID"));
        hospitalRepository.delete(hospital);
        return hospital.getHospitalId();
    }

    @Override
    public Integer updatedoctor(Integer hospitalId, DoctorDTO doctorDTO) throws MedicalException {
        Optional<Hospital> optional = hospitalRepository.findById(hospitalId);
        Hospital hospital = optional.orElseThrow(() -> new MedicalException("UserInterface.HOSPITAL_UPDATED"));
        Doctor doctor = hospital.getDoctor();

        doctor.setDoctorId(doctorDTO.getDoctorId());
        doctor.setDoctorName(doctorDTO.getDoctorName());
        doctor.setCity(doctorDTO.getCity());
        hospital.setDoctor(doctor);
        hospitalRepository.save(hospital);

        return hospital.getHospitalId();
    }
}
