package com.example.rendezvous_service.model;

import java.time.LocalDateTime;

public class RendezVous {

    private Long id;
    private Long praticienId;
    private Long patientId;
    private LocalDateTime dateTime;
    private String description;

    public RendezVous(Long id, Long praticienId, Long patientId, String dateTime, String description) {
        this.id = id;
        this.praticienId = praticienId;
        this.patientId = patientId;
        this.dateTime = LocalDateTime.parse(dateTime);
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPraticienId() {
        return praticienId;
    }

    public void setPraticienId(Long praticienId) {
        this.praticienId = praticienId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}
