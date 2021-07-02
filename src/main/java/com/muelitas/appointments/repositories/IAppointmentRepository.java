package com.muelitas.appointments.repositories;

import com.muelitas.appointments.enums.AppointmentState;
import com.muelitas.appointments.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByDateTimeBetween(LocalDateTime startDate, LocalDateTime endDate);

    @Query("SELECT professional.id FROM Appointment " +
            " WHERE dateTime BETWEEN :startDate AND :endDate" +
            " GROUP BY professional.id " +
            " HAVING COUNT(professional.id) > :quantity")
    List<Long> findProfessionalsIdsByDateTimeBetweenAndAppointmentsCountGreaterThan(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate,
            @Param("quantity") Long quantity);

    List<Appointment> findByDateTimeBetweenAndAppointmentState(LocalDateTime startDate, LocalDateTime endDate, AppointmentState state);

    List<Appointment> findAllByAppointmentState(Enum<AppointmentState> appointmentState);

    List<Appointment> findByProfessionalIdAndAppointmentState(Long id, AppointmentState appointmentState);

}
