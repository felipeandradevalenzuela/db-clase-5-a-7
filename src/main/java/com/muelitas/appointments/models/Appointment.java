package com.muelitas.appointments.models;

import com.muelitas.appointments.enums.AppointmentState;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    private Professional professional;

    @Enumerated(EnumType.STRING)
    private AppointmentState appointmentState;

    private LocalDateTime dateTime;

    @OneToOne(fetch = FetchType.LAZY)
    private RescheduledAppointment rescheduledAppointment;
}
