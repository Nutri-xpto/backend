package com.example.demo.repositories;

import com.example.demo.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

//    void delete(Optional<Patient> patient);

}
