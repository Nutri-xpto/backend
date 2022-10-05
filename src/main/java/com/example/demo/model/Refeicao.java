package com.example.demo.model;

import java.sql.Time;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "refeicao")
public class Refeicao{

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "nome", nullable= false)
    private String nome;

    @ElementCollection
    @CollectionTable(name = "alimento", joinColumns = @JoinColumn(name = "id"))
    private List<String> alimentos;

    @Column(name = "horario", columnDefinition = "TIME", nullable = false)
    private Time horario;
    
}
