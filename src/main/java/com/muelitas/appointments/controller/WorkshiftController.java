package com.muelitas.appointments.controller;

import com.muelitas.appointments.dtos.AppointmentDTO;
import com.muelitas.appointments.dtos.WorkshiftDTO;
import com.muelitas.appointments.services.IAppointmentService;
import com.muelitas.appointments.services.IWorkshiftService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@RestController
@AllArgsConstructor
public class WorkshiftController {

    private final IWorkshiftService iWorkshiftService;

    @PostMapping("/professionals/{professionalId}/workshifts")
    public WorkshiftDTO create(@PathVariable Long professionalId, @RequestBody WorkshiftDTO workshiftDTO){
        return iWorkshiftService.create(professionalId, workshiftDTO);
    }
    
    @GetMapping("/professionals/{professionalId}/schedule")
    public List<WorkshiftDTO> findScheduleByProfessional(@PathVariable Long professionalId){
        return iWorkshiftService.findScheduleByProfessional(professionalId);
    }
    
}
