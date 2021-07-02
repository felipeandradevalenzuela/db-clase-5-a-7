package com.muelitas.appointments.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Professional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @ManyToOne(fetch = FetchType.LAZY)
    private Specialty specialty;
}
