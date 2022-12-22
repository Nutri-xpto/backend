package com.example.demo.services;

import com.example.demo.dto.NewNutriDTO;
import com.example.demo.dto.PatientDTO;
import com.example.demo.model.Nutritionist;
import com.example.demo.model.Patient;
import com.example.demo.repositories.NutritionistRepository;
import com.example.demo.repositories.PatientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class NutricionistService {

    private final NutritionistRepository nutritionistRepository;

    private final PatientRepository patientRepository;

    public NutricionistService(NutritionistRepository nutritionistRepository, PatientRepository patientRepository) {
        this.nutritionistRepository = nutritionistRepository;
        this.patientRepository = patientRepository;
    }

    public ResponseEntity<Object> createPatient(PatientDTO patient){
       return new ResponseEntity<>(this.patientRepository.save( Patient.dtoToEntity(patient)), HttpStatus.CREATED);
    }

   public ResponseEntity<List<Patient>> getAllPatients(){
       return new ResponseEntity<>(this.patientRepository.findAll(), HttpStatus.OK);
    }


    public ResponseEntity<Object> deletePatient(Long id) {
        try {
            this.patientRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException pat) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    public ResponseEntity<List<Nutritionist>> getAllNutricionists(){
        return new ResponseEntity<List<Nutritionist>>(this.nutritionistRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Nutritionist> createNutricionist(NewNutriDTO nutri){
        return new ResponseEntity<Nutritionist>(this.nutritionistRepository.save( Nutritionist.dtoToEntity(nutri)), HttpStatus.CREATED );
    }

}
