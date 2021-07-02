package com.muelitas.appointments.adapter;

import com.muelitas.appointments.dtos.AppointmentDTO;
import com.muelitas.appointments.models.Appointment;
import org.springframework.stereotype.Component;

@Component
public class AppointmentAdapter {


    public AppointmentDTO entityToDTO(Appointment appointment) {
        AppointmentDTO appointmentDTO = new AppointmentDTO();
        appointmentDTO.setPatientId(appointment.getPatient().getId());
        appointmentDTO.setProfessionalId(appointment.getProfessional().getId());
        appointmentDTO.setDateTime(appointment.getDateTime());
        appointmentDTO.setState(appointment.getAppointmentState());

        return appointmentDTO;
    }

}
