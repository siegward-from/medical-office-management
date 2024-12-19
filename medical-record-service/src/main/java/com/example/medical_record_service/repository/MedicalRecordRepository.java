package com.example.medical_record_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.medical_record_service.model.MedicalRecord;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {

}
