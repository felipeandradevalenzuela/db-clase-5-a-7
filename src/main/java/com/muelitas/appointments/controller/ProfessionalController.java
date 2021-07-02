package com.muelitas.appointments.controller;

import com.muelitas.appointments.dtos.ProfessionalDTO;
import com.muelitas.appointments.services.IProfessionalService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/professionals")
@AllArgsConstructor
public class ProfessionalController {

    private final IProfessionalService iProfessionalService;

    @PostMapping()
    public ProfessionalDTO create(@RequestBody ProfessionalDTO professionalDTO) {
        return iProfessionalService.create(professionalDTO);
    }

    @GetMapping("/workshifts")
    public List<ProfessionalDTO> findByAppointmentDateAndGreaterThan(
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            @RequestParam LocalDate date,
            @RequestParam Long quantity) {
        return iProfessionalService.findByAppointmentsDateAndCountGreaterThan(date, quantity);
    }
}
