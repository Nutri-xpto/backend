package com.example.demo.dto;

import com.example.demo.model.Address;
import com.example.demo.model.Education;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor @Setter
@Getter
public class NutritionistDTO {

    private String name;

    private String email;

    private String password;

    private int code;

    private Set<Education> educations;

    private Address clinicAddress;

    public NutritionistDTO(String name, String email, String password, int code, Set<Education> educations, Address clinicAddress) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.code = code;
        this.educations = educations;
        this.clinicAddress = clinicAddress;
    }

    @Override
    public String toString() {
        return "NutritionistDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", code='" + code + '\'' +
                ", educations=" + educations +
                ", clinicAddress=" + clinicAddress +
                '}';
    }
}
