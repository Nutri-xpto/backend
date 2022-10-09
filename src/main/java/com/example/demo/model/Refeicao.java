package com.example.demo.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.example.demo.dto.RefeicaoDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Refeicao refeicao = (Refeicao) o;
        return id == refeicao.id && nome.equals(refeicao.nome) && alimentos.equals(refeicao.alimentos) && horario.equals(refeicao.horario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, alimentos, horario);
    }
}
