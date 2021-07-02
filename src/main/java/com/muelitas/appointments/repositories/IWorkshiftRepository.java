package com.muelitas.appointments.repositories;

import com.muelitas.appointments.dtos.WorkshiftDTO;
import com.muelitas.appointments.models.Workshift;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IWorkshiftRepository extends JpaRepository<Workshift, Long> {

    //Set<Workshift> findByProfessionalIdAndIsActive(Long id, Boolean isActive);
    List<Workshift> findByProfessionalId(Long id);
}
