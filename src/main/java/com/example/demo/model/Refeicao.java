package com.example.demo.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.example.demo.dto.RefeicaoDTO;

@Entity
@Table(name = "refeicao")
public class Refeicao{

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @ElementCollection
    @CollectionTable(name = "alimento", joinColumns = @JoinColumn(name = "id"))
    private List<String> alimentos;

    @Column(name = "horario", nullable = false)
    private String horario;

    public Refeicao() {
        super();
    }

    public Refeicao(String nome, List<String> alimentos, String horario) {
        this.nome = nome;
        this.alimentos = alimentos;
        this.horario = horario;
    }

    public static Refeicao dtoToEntity(RefeicaoDTO dto) {
        System.out.println(new Refeicao( dto.getNome(), dto.getAlimentos(), dto.getHorario()).toString());
        return new Refeicao( dto.getNome(), dto.getAlimentos(), dto.getHorario()) ;
    }
    
    public String toString() {
        return this.horario + " " + this.nome + " " + this.alimentos + " ";
    }
}
