package com.muelitas.appointments.models;

import lombok.Data;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity
public class Workshift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Professional professional;
    @Enumerated(EnumType.STRING)
    private DayOfWeek weekDay;
    private LocalTime startsAt;
    private LocalTime endsAt;
    private boolean isActive;
}
