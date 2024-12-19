package com.example.appointment_service.service;

import com.example.appointment_service.model.Appointment;
import com.example.appointment_service.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    public Appointment addAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public Optional<Appointment> updateAppointment(Long id, Appointment updatedAppointment) {
        return appointmentRepository.findById(id).map(appointment -> {
            appointment.setPatientId(updatedAppointment.getPatientId());
            appointment.setPractitionerId(updatedAppointment.getPractitionerId());
            appointment.setAppointmentDate(updatedAppointment.getAppointmentDate());
            appointment.setLocation(updatedAppointment.getLocation());
            appointment.setNotes(updatedAppointment.getNotes());
            return appointmentRepository.save(appointment);
        });
    }

    public boolean deleteAppointment(Long id) {
        if (appointmentRepository.existsById(id)) {
            appointmentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
