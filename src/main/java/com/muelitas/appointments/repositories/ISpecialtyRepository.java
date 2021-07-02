package com.muelitas.appointments.repositories;

import com.muelitas.appointments.models.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISpecialtyRepository extends JpaRepository<Specialty, Long> {

}
