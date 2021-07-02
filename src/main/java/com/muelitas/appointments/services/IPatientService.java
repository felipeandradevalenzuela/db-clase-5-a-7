package com.muelitas.appointments.services;

import com.muelitas.appointments.dtos.PatientDTO;

import java.time.LocalDate;
import java.util.List;

public interface IPatientService {

    PatientDTO create(PatientDTO patientRequestDTO);
    List<PatientDTO> findAllByAppointmentDate(LocalDate date);
}
