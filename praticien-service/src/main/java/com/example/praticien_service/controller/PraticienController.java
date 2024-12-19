package com.example.praticien_service.controller;

import com.example.praticien_service.model.Praticien;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/praticiens")
public class PraticienController {

    private final List<Praticien> praticiens = new ArrayList<>();

    {
        praticiens.add(new Praticien(1L, "Dr. John", "Doe", "Cardiology", "john.doe@example.com", "+123456789"));
        praticiens.add(new Praticien(2L, "Dr. Jane", "Smith", "Neurology", "jane.smith@example.com", "+987654321"));
        praticiens.add(new Praticien(3L, "Dr. Alice", "Johnson", "Pediatrics", "alice.johnson@example.com", "+111222333"));
        praticiens.add(new Praticien(4L, "Dr. Bob", "Brown", "Orthopedics", "bob.brown@example.com", "+444555666"));
        praticiens.add(new Praticien(5L, "Dr. Charlie", "Garcia", "Dermatology", "charlie.garcia@example.com", "+777888999"));
    }

    @GetMapping
    public List<Praticien> getAllPraticiens() {
        return praticiens;
    }

    @GetMapping("/{id}")
    public Praticien getPraticienById(@PathVariable Long id) {
        return praticiens.stream()
                .filter(praticien -> praticien.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Praticien addPraticien(@RequestBody Praticien praticien) {
        praticiens.add(praticien);
        return praticien;
    }

    @PutMapping("/{id}")
    public Praticien updatePraticien(@PathVariable Long id, @RequestBody Praticien updatedPraticien) {
        for (Praticien praticien : praticiens) {
            if (praticien.getId().equals(id)) {
                praticien.setFirstName(updatedPraticien.getFirstName());
                praticien.setLastName(updatedPraticien.getLastName());
                praticien.setSpecialty(updatedPraticien.getSpecialty());
                praticien.setEmail(updatedPraticien.getEmail());
                praticien.setPhoneNumber(updatedPraticien.getPhoneNumber());
                return praticien;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletePraticien(@PathVariable Long id) {
        praticiens.removeIf(praticien -> praticien.getId().equals(id));
    }
}