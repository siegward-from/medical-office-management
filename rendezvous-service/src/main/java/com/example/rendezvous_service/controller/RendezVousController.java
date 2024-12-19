package com.example.rendezvous_service.controller;

import com.example.rendezvous_service.model.RendezVous;
import com.example.rendezvous_service.service.RendezVousService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rendezvous")
public class RendezVousController {

    private final RendezVousService rendezVousService;

    public RendezVousController(RendezVousService rendezVousService) {
        this.rendezVousService = rendezVousService;
    }

    @GetMapping
    public List<RendezVous> getAllRendezVous() {
        return rendezVousService.getAllRendezVous();
    }

    @GetMapping("/{id}")
    public Optional<RendezVous> getRendezVousById(@PathVariable Long id) {
        return rendezVousService.getRendezVousById(id);
    }

    @PostMapping
    public RendezVous addRendezVous(@RequestBody RendezVous rendezVous) {
        return rendezVousService.addRendezVous(rendezVous);
    }

    @PutMapping("/{id}")
    public Optional<RendezVous> updateRendezVous(@PathVariable Long id, @RequestBody RendezVous updatedRendezVous) {
        return rendezVousService.updateRendezVous(id, updatedRendezVous);
    }

    @DeleteMapping("/{id}")
    public void deleteRendezVous(@PathVariable Long id) {
        rendezVousService.deleteRendezVous(id);
    }
}