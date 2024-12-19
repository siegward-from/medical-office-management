package com.example.appointment_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.appointment_service.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}