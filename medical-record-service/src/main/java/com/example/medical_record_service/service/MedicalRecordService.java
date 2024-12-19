package com.example.medical_record_service.service;

import com.example.medical_record_service.model.MedicalRecord;
import com.example.medical_record_service.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordRepository.findAll();
    }

    public Optional<MedicalRecord> getMedicalRecordById(Long id) {
        return medicalRecordRepository.findById(id);
    }

    public MedicalRecord addMedicalRecord(MedicalRecord medicalRecord) {
        return medicalRecordRepository.save(medicalRecord);
    }

    public Optional<MedicalRecord> updateMedicalRecord(Long id, MedicalRecord updatedMedicalRecord) {
        return medicalRecordRepository.findById(id).map(medicalRecord -> {
            medicalRecord.setPatientId(updatedMedicalRecord.getPatientId());
            medicalRecord.setPractitionerId(updatedMedicalRecord.getPractitionerId());
            medicalRecord.setRecordDate(updatedMedicalRecord.getRecordDate());
            medicalRecord.setDiagnosis(updatedMedicalRecord.getDiagnosis());
            medicalRecord.setTreatment(updatedMedicalRecord.getTreatment());
            medicalRecord.setNotes(updatedMedicalRecord.getNotes());
            return medicalRecordRepository.save(medicalRecord);
        });
    }

    public boolean deleteMedicalRecord(Long id) {
        if (medicalRecordRepository.existsById(id)) {
            medicalRecordRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
