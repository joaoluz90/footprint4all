package pt.iade.footprint4all.models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Id;

@Entity
@Table(name="pertipo")
public class PerTipo {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="pertipo_id") private int id;
    @Column(name="pertipo_nome") private String nome;
    @OneToMany @JoinColumn(name="per_pertipo_id") @JsonIgnoreProperties({"pertipo"}) private List<Pergunta> perguntas;

    public PerTipo() {}

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
