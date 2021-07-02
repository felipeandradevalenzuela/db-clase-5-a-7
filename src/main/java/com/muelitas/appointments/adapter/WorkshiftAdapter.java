package com.muelitas.appointments.adapter;

import com.muelitas.appointments.dtos.AppointmentDTO;
import com.muelitas.appointments.dtos.WorkshiftDTO;
import com.muelitas.appointments.models.Appointment;
import com.muelitas.appointments.models.Workshift;
import org.springframework.stereotype.Component;

@Component
public class WorkshiftAdapter {

    public WorkshiftDTO entityToDTO(Workshift workshift) {
        WorkshiftDTO workshiftDTO = new WorkshiftDTO();
        workshiftDTO.setStartsAt(workshift.getStartsAt());
        workshiftDTO.setEndsAt(workshift.getEndsAt());
        workshiftDTO.setWeekDay(workshift.getWeekDay());

        return workshiftDTO;
    }
}
