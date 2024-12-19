package com.example.praticien_service.service;

import com.example.praticien_service.model.Praticien;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PraticienService {

    private List<Praticien> praticiens = new ArrayList<>();

    public List<Praticien> getAllPraticiens() {
        return new ArrayList<>(praticiens);
    }

    public Optional<Praticien> getPraticienById(Long id) {
        return praticiens.stream()
                .filter(praticien -> praticien.getId().equals(id))
                .findFirst();
    }

    public Praticien addPraticien(Praticien praticien) {
        praticiens.add(praticien);
        return praticien;
    }

    public Optional<Praticien> updatePraticien(Long id, Praticien updatedPraticien) {
        for (Praticien praticien : praticiens) {
            if (praticien.getId().equals(id)) {
                praticien.setFirstName(updatedPraticien.getFirstName());
                praticien.setLastName(updatedPraticien.getLastName());
                praticien.setSpecialty(updatedPraticien.getSpecialty());
                praticien.setEmail(updatedPraticien.getEmail());
                praticien.setPhoneNumber(updatedPraticien.getPhoneNumber());
                return Optional.of(praticien);
            }
        }
        return Optional.empty();
    }

    public boolean deletePraticien(Long id) {
        return praticiens.removeIf(praticien -> praticien.getId().equals(id));
    }
}