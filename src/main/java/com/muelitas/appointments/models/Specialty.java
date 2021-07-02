package com.muelitas.appointments.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

}
