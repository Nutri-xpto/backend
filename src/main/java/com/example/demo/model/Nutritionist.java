package com.example.demo.model;

import com.example.demo.controllers.PatientController;
import com.example.demo.dto.NewNutriDTO;
import com.example.demo.dto.NutritionistDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "nutritionist")
public class Nutritionist {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "passwordConfirmation", nullable = false)
    private String passwordConfirmation;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "educations", nullable = false)
    private String educations;

    @Column(name = "clinicAdress", nullable = false)
    private String clinicAddress;

    @Column(name = "additionalInfo", nullable = false)
    private String additionalInfo;

    @OneToMany
    private List<Patient> patients;

    public Nutritionist(String name, String email, String password, String passwordConfirmation, String code, String educations, String clinicAddress, String city, String additionalInfo) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.code = code;
        this.educations = educations;
        this.clinicAddress = clinicAddress;
    }

    @Override
    public String toString() {
        return "Nutritionist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", code=" + code +
                ", educations=" + educations +
                ", clinicAddress=" + clinicAddress +
                '}';
    }

    public static Nutritionist dtoToEntity(NewNutriDTO dto){
        return new Nutritionist(dto.getNome(), dto.getEmail(), dto.getPassword(), dto.getPasswordConfirmacion(), dto.getCode(), dto.getEducation(), dto.getClinicAdress(), dto.getCity(), dto.getAdditionalInfo()) ;
    }

    public boolean addPatient(Patient patient){
        if (patients.contains(patient)) return false;
        patients.add(patient);
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nutritionist that = (Nutritionist) o;
        return id == that.id && code == that.code && Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(educations, that.educations) && Objects.equals(clinicAddress, that.clinicAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, code, educations, clinicAddress);
    }
}
