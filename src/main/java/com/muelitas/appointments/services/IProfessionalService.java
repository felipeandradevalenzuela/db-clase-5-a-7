package com.muelitas.appointments.services;

import com.muelitas.appointments.dtos.ProfessionalDTO;

import java.time.LocalDate;
import java.util.List;

public interface IProfessionalService {

    ProfessionalDTO create(ProfessionalDTO professionalDTO);

    List<ProfessionalDTO> findByAppointmentsDateAndCountGreaterThan(LocalDate date, Long quantity);
}
