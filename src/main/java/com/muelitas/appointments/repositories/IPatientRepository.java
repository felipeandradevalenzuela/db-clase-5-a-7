package com.muelitas.appointments.repositories;

import com.muelitas.appointments.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepository extends JpaRepository<Patient, Long> {
}
