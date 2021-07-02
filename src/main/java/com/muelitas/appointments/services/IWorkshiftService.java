package com.muelitas.appointments.services;

import com.muelitas.appointments.dtos.WorkshiftDTO;

import java.util.List;

public interface IWorkshiftService {

    WorkshiftDTO create(Long professionalId, WorkshiftDTO workshiftDTO);
    List<WorkshiftDTO> findScheduleByProfessional(Long professionalId);
}
