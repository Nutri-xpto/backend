package com.example.demo.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "receita")
public class Receita {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "quantidade", nullable = false)
    private long quantidade;

    @Column(name = "ingredientes", nullable = false)
    private String ingredientes;

    @Column(name =  "modoPreparo" , nullable = false)
    private String modoPreparo;

    public Receita(long quantidade, String ingredientes, String modoPreparo){
        this.quantidade = quantidade;
        this.ingredientes = ingredientes;
        this.modoPreparo = modoPreparo;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receita receita = (Receita) o;
        return id == receita.id && quantidade == receita.quantidade && ingredientes.equals(receita.ingredientes) && modoPreparo.equals(receita.modoPreparo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantidade, ingredientes, modoPreparo);
    }
}
