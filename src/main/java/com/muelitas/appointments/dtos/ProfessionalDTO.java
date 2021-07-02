package com.muelitas.appointments.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessionalDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private Long specialtyId;

}
