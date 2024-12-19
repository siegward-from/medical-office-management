package com.example.rendezvous_service.service;

import com.example.rendezvous_service.model.RendezVous;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RendezVousService {

    private List<RendezVous> rendezVousList = new ArrayList<>();
    public RendezVousService() {
        rendezVousList.add(new RendezVous(1L, 1L, 1L, "2024-01-20T10:00:00", "Client Meeting"));
        rendezVousList.add(new RendezVous(2L, 2L, 2L, "2024-01-21T15:30:00", "Project Presentation")); 
        rendezVousList.add(new RendezVous(3L, 3L, 3L, "2024-01-22T09:00:00", "Team Meeting"));
        rendezVousList.add(new RendezVous(4L, 4L, 4L, "2024-01-23T14:00:00", "Requirements Discussion"));
        rendezVousList.add(new RendezVous(5L, 5L, 5L, "2024-01-24T11:30:00", "Code Review"));
    }


    public List<RendezVous> getAllRendezVous() {
        return new ArrayList<>(rendezVousList);
    }

    public Optional<RendezVous> getRendezVousById(Long id) {
        return rendezVousList.stream()
                .filter(rendezVous -> rendezVous.getId().equals(id))
                .findFirst();
    }

    public RendezVous addRendezVous(RendezVous rendezVous) {
        rendezVousList.add(rendezVous);
        return rendezVous;
    }

    public Optional<RendezVous> updateRendezVous(Long id, RendezVous updatedRendezVous) {
        for (RendezVous rendezVous : rendezVousList) {
            if (rendezVous.getId().equals(id)) {
                rendezVous.setDateTime(updatedRendezVous.getDateTime());
                rendezVous.setDescription(updatedRendezVous.getDescription());
                return Optional.of(rendezVous);
            }
        }
        return Optional.empty();
    }

    public boolean deleteRendezVous(Long id) {
        return rendezVousList.removeIf(rendezVous -> rendezVous.getId().equals(id));
    }
}