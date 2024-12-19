package com.example.patient_service.controller;

import com.example.patient_service.model.Patient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
@Tag(name = "Patient Controller", description = "API endpoints for patient management")
public class PatientController {

    private final List<Patient> patients = new ArrayList<>();

    {
        patients.add(new Patient(1L, "John", "Doe", "john.doe@example.com", "+123456789", "1990-01-01"));
        patients.add(new Patient(2L, "Jane", "Smith", "jane.smith@example.com", "+987654321", "1985-05-15"));
        patients.add(new Patient(3L, "Alice", "Johnson", "alice.johnson@example.com", "+111222333", "1995-11-30"));
        patients.add(new Patient(4L, "Bob", "Brown", "bob.brown@example.com", "+444555666", "1988-07-12"));
        patients.add(new Patient(5L, "Charlie", "Garcia", "charlie.garcia@example.com", "+777888999", "1992-03-25"));   
    }

    @GetMapping
    @Operation(summary = "Get all patients")
    public List<Patient> getAllPatients() {
        return patients;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get patient by ID")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        return patients.stream()
                .filter(patient -> patient.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create new patient")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        patients.add(patient);
        return ResponseEntity.ok(patient);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update existing patient")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient updatedPatient) {
        for (Patient patient : patients) {
            if (patient.getId().equals(id)) {
                patient.setFirstName(updatedPatient.getFirstName());
                patient.setLastName(updatedPatient.getLastName());
                patient.setEmail(updatedPatient.getEmail());
                patient.setPhoneNumber(updatedPatient.getPhoneNumber());
                patient.setDateOfBirth(updatedPatient.getDateOfBirth());
                return ResponseEntity.ok(patient);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete patient")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        boolean removed = patients.removeIf(patient -> patient.getId().equals(id));
        return removed ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}