package com.muelitas.appointments.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class RescheduledAppointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idNewAppointment;
}
