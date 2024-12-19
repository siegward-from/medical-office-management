package com.example.patient_service.service;

import com.example.patient_service.model.Patient;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PatientService {
    private final List<Patient> patients = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public List<Patient> getAllPatients() {
        return new ArrayList<>(patients);
    }

    public Optional<Patient> getPatientById(Long id) {
        return patients.stream()
                .filter(patient -> patient.getId().equals(id))
                .findFirst();
    }

    public Patient createPatient(Patient patient) {
        patient.setId(idGenerator.incrementAndGet());
        patients.add(patient);
        return patient;
    }

    public Patient updatePatient(Long id, Patient updatedPatient) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId().equals(id)) {
                updatedPatient.setId(id);
                patients.set(i, updatedPatient);
                return updatedPatient;
            }
        }
        throw new RuntimeException("Patient not found with id: " + id);
    }

    public void deletePatient(Long id) {
        patients.removeIf(patient -> patient.getId().equals(id));
    }
}