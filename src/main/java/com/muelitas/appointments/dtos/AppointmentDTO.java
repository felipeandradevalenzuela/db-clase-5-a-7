package com.muelitas.appointments.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.muelitas.appointments.enums.AppointmentState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {

    private Long patientId;
    private Long professionalId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dateTime;
    private AppointmentState state;

}
