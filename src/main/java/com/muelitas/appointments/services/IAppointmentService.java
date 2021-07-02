package com.muelitas.appointments.services;

import com.muelitas.appointments.dtos.AppointmentDTO;

import java.time.LocalDate;
import java.util.List;

public interface IAppointmentService {

    AppointmentDTO create(AppointmentDTO appointmentDTO);

    List<AppointmentDTO> findByAppointmentStateCompleted();

    List<AppointmentDTO> findByAppointmentStateRescheduled();

    List<AppointmentDTO> findByAppointmentStatePendingByDate(LocalDate date);

    List<AppointmentDTO> findByAppointmentStateRescheduledAndProfessionalId(Long professionalId);

    //void reschedule(Long id,AppointmentDTO appointmentDTO);
}
