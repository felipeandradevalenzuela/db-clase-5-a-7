package com.muelitas.appointments.controller;

import com.muelitas.appointments.dtos.PatientDTO;
import com.muelitas.appointments.services.IPatientService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/patients")
@AllArgsConstructor
public class PatientController {

    private final IPatientService iPatientService;

    @PostMapping()
    public PatientDTO create(@RequestBody PatientDTO patientDTO) {
        return iPatientService.create(patientDTO);
    }

    @GetMapping("/appointments")
    public List<PatientDTO> findByAppointmentDate(
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            @RequestParam LocalDate date) {
        return iPatientService.findAllByAppointmentDate(date);
    }
}
