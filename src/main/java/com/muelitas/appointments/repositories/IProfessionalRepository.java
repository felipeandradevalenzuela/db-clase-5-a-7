package com.muelitas.appointments.repositories;

import com.muelitas.appointments.models.Professional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProfessionalRepository extends JpaRepository<Professional, Long> {

}
