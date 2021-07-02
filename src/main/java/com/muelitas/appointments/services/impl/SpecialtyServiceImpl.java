package com.muelitas.appointments.services.impl;

import com.muelitas.appointments.dtos.SpecialtyDTO;
import com.muelitas.appointments.models.Specialty;
import com.muelitas.appointments.repositories.ISpecialtyRepository;
import com.muelitas.appointments.services.ISpecialtyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SpecialtyServiceImpl implements ISpecialtyService {

    private final ISpecialtyRepository iSpecialtyRepository;

    @Override
    public SpecialtyDTO create(SpecialtyDTO specialtyDTO) {
        Specialty specialty = new Specialty();
        BeanUtils.copyProperties(specialtyDTO, specialty);

        Specialty savedSpecialty = iSpecialtyRepository.save(specialty);

        BeanUtils.copyProperties(savedSpecialty, specialtyDTO);

        return specialtyDTO;
    }


}
