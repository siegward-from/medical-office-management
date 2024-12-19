package com.example.practitioner_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.practitioner_service.model.Practitioner;

public interface PractitionerRepository extends JpaRepository<Practitioner, Long> {
}