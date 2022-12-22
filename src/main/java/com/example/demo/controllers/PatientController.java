package com.example.demo.controllers;

import com.example.demo.dto.PatientDTO;
import com.example.demo.model.Nutritionist;
import com.example.demo.model.Patient;
import com.example.demo.repositories.PatientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    private final PatientRepository repository;

    public PatientController(PatientRepository repository) { this.repository = repository; }

    @PostMapping("/patient")
    ResponseEntity<Patient> create(@RequestBody PatientDTO patient){
        return new ResponseEntity<>(this.repository.save( Patient.dtoToEntity(patient)), HttpStatus.CREATED );
    }

    @GetMapping("/patients")
    ResponseEntity<List<Patient>> getAll(){
        return new ResponseEntity<>(this.repository.findAll(), HttpStatus.OK);
    }

<<<<<<< HEAD
/*    @DeleteMapping("/patient")
=======
   /* @DeleteMapping("/patient")
>>>>>>> dc855673de90778da8fdd7fb85d03a0c2091ca49
    ResponseEntity<Patient> delete(@PathVariable Long id){
        try {
            this.repository.delete(this.repository.findById(id));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (IllegalArgumentException pat){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
<<<<<<< HEAD
    }*/
=======
    }
    */
>>>>>>> dc855673de90778da8fdd7fb85d03a0c2091ca49
}
