package com.example.demo.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.*;

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

    @Column(name = "hora", nullable = false)
    private String hora;

    @ManyToMany
    private List<Receita> opcoes;

    public Refeicao(String nome, List<Receita> opcoes, String hora) {
        this.nome = nome;
        this.opcoes = opcoes;
        this.hora = hora;
    }

    public static Refeicao dtoToEntity(RefeicaoDTO dto) {
        return new Refeicao( dto.getNome(), dto.getOpcoes(), dto.getHora()) ;
    }

    @Override
    public String toString() {
        return "Refeicao{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", hora='" + hora + '\'' +
                ", opcoes=" + opcoes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Refeicao refeicao = (Refeicao) o;
        return id == refeicao.id && nome.equals(refeicao.nome) && hora.equals(refeicao.hora) && opcoes.equals(refeicao.opcoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, hora, opcoes);
    }
}
