package com.muelitas.appointments.services.impl;

import com.muelitas.appointments.adapter.PatientAdapter;
import com.muelitas.appointments.dtos.PatientDTO;
import com.muelitas.appointments.models.Appointment;
import com.muelitas.appointments.models.Patient;
import com.muelitas.appointments.repositories.IAppointmentRepository;
import com.muelitas.appointments.repositories.IPatientRepository;
import com.muelitas.appointments.services.IPatientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements IPatientService {

    private final IPatientRepository iPatientRepository;
    private final IAppointmentRepository iAppointmentRepository;
    private final PatientAdapter patientAdapter;

    @Override
    public PatientDTO create(PatientDTO patientDTO) {
        Patient patient = patientAdapter.dtoToEntity(patientDTO);
        Patient savedPatient = iPatientRepository.save(patient);

        return patientAdapter.entityToDTO(savedPatient);
    }

    @Override
    public List<PatientDTO> findAllByAppointmentDate(LocalDate date) {
        List<Appointment> appointments = iAppointmentRepository
                .findByDateTimeBetween(date.atStartOfDay(), date.atTime(LocalTime.MAX));

        return appointments.stream()
                .map(appointment -> patientAdapter.entityToDTO(appointment.getPatient()))
                .collect(toList());
    }

}
