package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "dieta")
public class Dieta {

    // Dieta é um objeto que atua apenas linkando referencia, logo todos os elementos propostos devem existir, garantir isso via service;
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    public List<Refeicao> dia;

    @ManyToOne
    public Nutritionist nutri;

    @ManyToOne
    public Patient pacient;

    public Dieta(List<Refeicao> dia, Nutritionist nutri, Patient pacient) {
        this.dia = dia;
        this.nutri = nutri;
        this.pacient = pacient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dieta dieta = (Dieta) o;
        return Objects.equals(id, dieta.id) && Objects.equals(dia, dieta.dia) && Objects.equals(nutri, dieta.nutri) && Objects.equals(pacient, dieta.pacient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dia, nutri, pacient);
    }
}
