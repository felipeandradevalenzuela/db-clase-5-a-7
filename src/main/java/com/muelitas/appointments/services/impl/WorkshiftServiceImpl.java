package com.muelitas.appointments.services.impl;

import com.muelitas.appointments.adapter.WorkshiftAdapter;
import com.muelitas.appointments.dtos.WorkshiftDTO;
import com.muelitas.appointments.models.Professional;
import com.muelitas.appointments.models.Workshift;
import com.muelitas.appointments.repositories.IProfessionalRepository;
import com.muelitas.appointments.repositories.IWorkshiftRepository;
import com.muelitas.appointments.services.IWorkshiftService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class WorkshiftServiceImpl implements IWorkshiftService {

    private final IWorkshiftRepository iWorkshiftRepository;
    private final IProfessionalRepository iProfessionalRepository;
    private final WorkshiftAdapter workshiftAdapter;

    @Override
    public WorkshiftDTO create(Long professionalId, WorkshiftDTO workshiftDTO) {
        Professional professional = iProfessionalRepository.getById(professionalId);

        Workshift workshift = new Workshift();
        workshift.setProfessional(professional);
        BeanUtils.copyProperties(workshiftDTO, workshift);

        Workshift savedWorkshift = iWorkshiftRepository.save(workshift);
        BeanUtils.copyProperties(savedWorkshift, workshiftDTO);

        return workshiftDTO;
    }

    @Override
    public List<WorkshiftDTO> findScheduleByProfessional(Long proffesionalId) {
        List<Workshift> workshifts = iWorkshiftRepository.findByProfessionalId(proffesionalId);

        return workshifts.stream()
                .map(workshift -> workshiftAdapter.entityToDTO(workshift))
                .collect(toList());
    }
}
