package pt.iade.footprint4all.models;

import javax.persistence.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Id;

@Entity
@Table(name="seccao")
public class Seccao {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="sec_id") private int id;
    @Column(name="sec_nome") private String nome;
    @ManyToMany @JoinColumn(name="per_sec_id") @JsonIgnoreProperties({"seccao"}) private List<Pergunta> perguntas;

    public Seccao() {}

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Pergunta> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(List<Pergunta> perguntas) {
        this.perguntas = perguntas;
    }
    
}
