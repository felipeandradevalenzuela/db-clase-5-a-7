package com.muelitas.appointments.adapter;

import com.muelitas.appointments.dtos.ProfessionalDTO;
import com.muelitas.appointments.models.Professional;
import org.springframework.stereotype.Component;

@Component
public class ProfessionalAdapter {

    public ProfessionalDTO entityToDTO(Professional professional) {
        ProfessionalDTO professionalDTO = new ProfessionalDTO();
        professionalDTO.setId(professional.getId());
        professionalDTO.setFirstName(professional.getFirstName());
        professionalDTO.setLastName(professional.getLastName());
        professionalDTO.setSpecialtyId(professional.getSpecialty().getId());

        return professionalDTO;
    }

    public Professional dtoToEntity(ProfessionalDTO professionalDTO) {
        Professional professional = new Professional();
        professional.setFirstName(professionalDTO.getFirstName());
        professional.setLastName(professionalDTO.getLastName());

        return professional;
    }
}
