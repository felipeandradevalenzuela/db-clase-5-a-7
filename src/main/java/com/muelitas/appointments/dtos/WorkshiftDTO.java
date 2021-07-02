package com.muelitas.appointments.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkshiftDTO {

    private DayOfWeek weekDay;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime startsAt;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime endsAt;
}
