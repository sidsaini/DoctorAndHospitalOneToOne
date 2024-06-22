package com.example.controller;

import com.example.dto.DoctorDTO;
import com.example.dto.HospitalDTO;
import com.example.exception.MedicalException;
import com.example.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Medical")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private Environment environment;

    @PostMapping("/hospital")
    public ResponseEntity<String> addHospital(@RequestBody HospitalDTO hospitalDTO) {
        Integer hospitalId = hospitalService.addHospital(hospitalDTO);
        String hospitalAddedSuccessfully = environment.getProperty("UserInterface.HOSPITAL_ADDED") + " : " + hospitalId;

        return new ResponseEntity<>(hospitalAddedSuccessfully, HttpStatus.CREATED);
    }
    @GetMapping("/hospital/{hospitalId}")
    public ResponseEntity<HospitalDTO> getHospital(@PathVariable Integer hospitalId) throws MedicalException  {
        HospitalDTO hospitalDTO = hospitalService.getHospital(hospitalId);
       return new ResponseEntity<>(hospitalDTO, HttpStatus.OK);
    }

    @DeleteMapping("/hospital/{hospitalId}")
    public ResponseEntity<String> deleteHospital(@PathVariable Integer hospitalId) throws MedicalException {
        Integer deleteHospitalId = hospitalService.deleteHospital(hospitalId);
        String deleteHospitalSuccessfully = environment.getProperty("UserInterface.HOSPITAL_DELETED") + "  :  " + deleteHospitalId;
        return new ResponseEntity<>(deleteHospitalSuccessfully, HttpStatus.OK);
    }

    @PutMapping("/hospital/{hospitalId}")
    public ResponseEntity<String> updateDoctor(@PathVariable Integer hospitalId, @RequestBody DoctorDTO doctorDTO) throws MedicalException {
        Integer updatedoctor = hospitalService.updatedoctor(hospitalId, doctorDTO);
        String hospitalUpdateSuccessfully = environment.getProperty("UserInterface.HOSPITAL_UPDATED") + "  :  " + updatedoctor;
        return new ResponseEntity<>(hospitalUpdateSuccessfully, HttpStatus.OK);

    }
}
