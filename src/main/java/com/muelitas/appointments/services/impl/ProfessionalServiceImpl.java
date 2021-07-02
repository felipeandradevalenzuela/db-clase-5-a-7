package com.muelitas.appointments.services.impl;

import com.muelitas.appointments.adapter.AppointmentAdapter;
import com.muelitas.appointments.adapter.ProfessionalAdapter;
import com.muelitas.appointments.dtos.ProfessionalDTO;
import com.muelitas.appointments.models.Appointment;
import com.muelitas.appointments.models.Professional;
import com.muelitas.appointments.models.Specialty;
import com.muelitas.appointments.repositories.IAppointmentRepository;
import com.muelitas.appointments.repositories.IProfessionalRepository;
import com.muelitas.appointments.repositories.ISpecialtyRepository;
import com.muelitas.appointments.services.IProfessionalService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class ProfessionalServiceImpl implements IProfessionalService {

    private final IProfessionalRepository iProfessionalRepository;
    private final IAppointmentRepository iAppointmentRepository;
    private final ISpecialtyRepository iSpecialtyRepository;
    private final ProfessionalAdapter professionalAdapter;

    @Override
    public ProfessionalDTO create(ProfessionalDTO professionalDTO) {
        Professional professional = professionalAdapter.dtoToEntity(professionalDTO);
        Specialty specialty = iSpecialtyRepository.findById(professionalDTO.getSpecialtyId()).get();
        professional.setSpecialty(specialty);

        Professional savedProfessional = iProfessionalRepository.save(professional);

        return professionalAdapter.entityToDTO(savedProfessional);
    }

    @Override
    public List<ProfessionalDTO> findByAppointmentsDateAndCountGreaterThan(LocalDate date, Long quantity) {

        List<Long> appointments = iAppointmentRepository
                .findProfessionalsIdsByDateTimeBetweenAndAppointmentsCountGreaterThan(
                        date.atStartOfDay(), date.atTime(LocalTime.MAX), quantity);

        List<Professional> professionals = iProfessionalRepository.findAllById(appointments);

        return professionals.stream()
                .map(professional -> professionalAdapter.entityToDTO(professional))
                .collect(toList());

    }
}
