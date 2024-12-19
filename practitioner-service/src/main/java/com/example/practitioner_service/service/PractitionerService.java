package com.example.practitioner_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.practitioner_service.model.Practitioner;
import com.example.practitioner_service.repository.PractitionerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PractitionerService {

    @Autowired
    private PractitionerRepository practitionerRepository;

    public List<Practitioner> getAllPractitioners() {
        return practitionerRepository.findAll();
    }

    public Optional<Practitioner> getPractitionerById(Long id) {
        return practitionerRepository.findById(id);
    }

    public Practitioner addPractitioner(Practitioner practitioner) {
        return practitionerRepository.save(practitioner);
    }

    public Optional<Practitioner> updatePractitioner(Long id, Practitioner updatedPractitioner) {
        return practitionerRepository.findById(id).map(practitioner -> {
            practitioner.setFirstName(updatedPractitioner.getFirstName());
            practitioner.setLastName(updatedPractitioner.getLastName());
            practitioner.setSpecialty(updatedPractitioner.getSpecialty());
            practitioner.setEmail(updatedPractitioner.getEmail());
            practitioner.setPhoneNumber(updatedPractitioner.getPhoneNumber());
            return practitionerRepository.save(practitioner);
        });
    }

    public boolean deletePractitioner(Long id) {
        if (practitionerRepository.existsById(id)) {
            practitionerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}