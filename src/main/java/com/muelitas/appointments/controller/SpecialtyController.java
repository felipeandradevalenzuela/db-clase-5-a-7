package com.muelitas.appointments.controller;

import com.muelitas.appointments.dtos.ProfessionalDTO;
import com.muelitas.appointments.dtos.SpecialtyDTO;
import com.muelitas.appointments.services.IProfessionalService;
import com.muelitas.appointments.services.ISpecialtyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/specialties")
@AllArgsConstructor
public class SpecialtyController {

    private final ISpecialtyService iSpecialtyService;

    @PostMapping()
    public SpecialtyDTO create(@RequestBody SpecialtyDTO specialtyDTO){
        return iSpecialtyService.create(specialtyDTO);
    }
}
