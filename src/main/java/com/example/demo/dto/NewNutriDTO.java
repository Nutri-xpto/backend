package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class NewNutriDTO {

    private String nome;

    private String email;

    private String password;

    private String passwordConfirmacion;

    private String code;

    private String education;

    private String clinicAdress;

    private String city;

    private String additionalInfo;


    public NewNutriDTO(String nome, String email, String password, String passwordConfirmacion, String code, String education, String clinicAdress, String city, String additionalInfo) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.passwordConfirmacion = passwordConfirmacion;
        this.code = code;
        this.education = education;
        this.clinicAdress = clinicAdress;
        this.city = city;
        this.additionalInfo = additionalInfo;
    }

    @Override
    public String toString() {
        return "NewNutriDTO{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", code='" + code + '\'' +
                ", education='" + education + '\'' +
                ", clinicAdress='" + clinicAdress + '\'' +
                ", city='" + city + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                '}';
    }
}
