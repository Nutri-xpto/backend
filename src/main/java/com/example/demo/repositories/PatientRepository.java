package com.example.demo.repositories;

import com.example.demo.model.Nutritionist;
import com.example.demo.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {



    }
