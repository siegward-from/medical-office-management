package com.example.api_gateway_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/patient")
    public Mono<ResponseEntity<Object>> patientFallback() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "error");
        response.put("message", "Patient Service is currently unavailable");
        response.put("timestamp", System.currentTimeMillis());
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response));
    }

    @GetMapping("/practitioner")
    public Mono<ResponseEntity<Map<String, String>>> practitionerFallback() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "error");
        response.put("message", "Practitioner Service is currently unavailable");
        return Mono.just(new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE));
    }

    @GetMapping("/appointment")
    public Mono<ResponseEntity<Map<String, String>>> appointmentFallback() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "error");
        response.put("message", "Appointment Service is currently unavailable");
        return Mono.just(new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE));
    }

    @GetMapping("/medical-record")
    public Mono<ResponseEntity<Map<String, String>>> medicalRecordFallback() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "error");
        response.put("message", "Medical Record Service is currently unavailable");
        return Mono.just(new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE));
    }
} 