package com.muelitas.appointments.controller;

import com.muelitas.appointments.dtos.AppointmentDTO;
import com.muelitas.appointments.dtos.ProfessionalDTO;
import com.muelitas.appointments.models.Appointment;
import com.muelitas.appointments.services.IAppointmentService;
import com.muelitas.appointments.services.IProfessionalService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/appointments")
@AllArgsConstructor
public class AppointmentController {

    private final IAppointmentService iAppointmentService;

    @PostMapping()
    public AppointmentDTO create(@RequestBody AppointmentDTO appointmentDTO) {
        return iAppointmentService.create(appointmentDTO);
    }

    @GetMapping("/pending")
    public List<AppointmentDTO> findByStatePendingByDate(
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            @RequestParam LocalDate date) {
        return iAppointmentService.findByAppointmentStatePendingByDate(date);
    }

    @GetMapping("/completed")
    public List<AppointmentDTO> findByStateCompleted() {
        return iAppointmentService.findByAppointmentStateCompleted();
    }

    @GetMapping("/rescheduled")
    public List<AppointmentDTO> findByStateRescheduled() {
        return iAppointmentService.findByAppointmentStateRescheduled();
    }

    @GetMapping("/rescheduled/{professionalId}")
    public List<AppointmentDTO> findByStateRescheduledAndProfessionalId(@PathVariable Long professionalId) {
        return iAppointmentService.findByAppointmentStateRescheduledAndProfessionalId(professionalId);
    }
}

