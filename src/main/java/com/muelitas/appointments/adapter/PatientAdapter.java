package com.muelitas.appointments.adapter;

import com.muelitas.appointments.dtos.PatientDTO;
import com.muelitas.appointments.models.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientAdapter {

    public PatientDTO entityToDTO(Patient patient) {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(patient.getId());
        patientDTO.setFirstName(patient.getFirstName());
        patientDTO.setLastName(patient.getLastName());

        return patientDTO;
    }

    public Patient dtoToEntity(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());

        return patient;
    }

}
