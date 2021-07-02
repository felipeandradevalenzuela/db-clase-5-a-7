package com.muelitas.appointments.services.impl;

import com.muelitas.appointments.adapter.AppointmentAdapter;
import com.muelitas.appointments.dtos.AppointmentDTO;
import com.muelitas.appointments.enums.AppointmentState;
import com.muelitas.appointments.models.Appointment;
import com.muelitas.appointments.models.Patient;
import com.muelitas.appointments.models.Professional;
import com.muelitas.appointments.repositories.IAppointmentRepository;
import com.muelitas.appointments.repositories.IPatientRepository;
import com.muelitas.appointments.repositories.IProfessionalRepository;
import com.muelitas.appointments.services.IAppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static com.muelitas.appointments.enums.AppointmentState.PENDING;
import static com.muelitas.appointments.enums.AppointmentState.RESCHEDULED;
import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements IAppointmentService {

    private final IAppointmentRepository iAppointmentRepository;
    private final IPatientRepository iPatientRepository;
    private final IProfessionalRepository iProfessionalRepository;
    private final AppointmentAdapter appointmentAdapter;

    @Override
    public AppointmentDTO create(AppointmentDTO appointmentDTO) {
        Optional<Patient> patient = iPatientRepository
                .findById(appointmentDTO.getPatientId());
        Optional<Professional> professional = iProfessionalRepository
                .findById(appointmentDTO.getProfessionalId());


        Appointment appointment = new Appointment();
        appointment.setAppointmentState(PENDING);
        BeanUtils.copyProperties(appointmentDTO, appointment);

        appointment.setPatient(patient.get());
        appointment.setProfessional(professional.get());

        Appointment savedAppointment = iAppointmentRepository.save(appointment);

        BeanUtils.copyProperties(savedAppointment, appointmentDTO);

        return appointmentDTO;
    }

    @Override
    public List<AppointmentDTO> findByAppointmentStateCompleted() {
        return findByAppointmentState(AppointmentState.COMPLETED);
    }

    @Override
    public List<AppointmentDTO> findByAppointmentStateRescheduled() {
        return findByAppointmentState(AppointmentState.RESCHEDULED);
    }

    @Override
    public List<AppointmentDTO> findByAppointmentStatePendingByDate(LocalDate date) {
        List<Appointment> appointments = iAppointmentRepository
                .findByDateTimeBetweenAndAppointmentState(date.atStartOfDay(), date.atTime(LocalTime.MAX), PENDING);

        return appointments.stream()
                .map(appointment -> appointmentAdapter.entityToDTO(appointment))
                .collect(toList());
    }

    @Override
    public List<AppointmentDTO> findByAppointmentStateRescheduledAndProfessionalId(Long professionalId) {
        List<Appointment> appointments = iAppointmentRepository.findByProfessionalIdAndAppointmentState(professionalId, RESCHEDULED);

        return appointments.stream()
                .map(appointment -> appointmentAdapter.entityToDTO(appointment))
                .collect(toList());
    }

    private List<AppointmentDTO> findByAppointmentState(Enum<AppointmentState> state) {

        List<Appointment> appointments = iAppointmentRepository
                .findAllByAppointmentState(state);

        return appointments.stream()
                .map(appointment -> appointmentAdapter.entityToDTO(appointment))
                .collect(toList());
    }
}
