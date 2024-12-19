package com.example.practitioner_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.practitioner_service.model.Practitioner;
import com.example.practitioner_service.service.PractitionerService;
import java.util.List;

@RestController
@RequestMapping("/practitioners")
public class PractitionerController {

    @Autowired
    private PractitionerService practitionerService;

    @GetMapping
    public List<Practitioner> getAllPractitioners() {
        return practitionerService.getAllPractitioners();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Practitioner> getPractitionerById(@PathVariable Long id) {
        return practitionerService.getPractitionerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Practitioner addPractitioner(@RequestBody Practitioner practitioner) {
        return practitionerService.addPractitioner(practitioner);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Practitioner> updatePractitioner(@PathVariable Long id, @RequestBody Practitioner updatedPractitioner) {
        return practitionerService.updatePractitioner(id, updatedPractitioner)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePractitioner(@PathVariable Long id) {
        if (practitionerService.deletePractitioner(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}