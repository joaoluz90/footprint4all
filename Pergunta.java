package pt.iade.footprint4all.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="pergunta")
public class Pergunta {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="per_id") private int id;
    @Column(name="per_string") private String string;
    @OneToMany @JoinColumn(name="res_per_id") @JsonIgnoreProperties({"pergunta"}) private List<Resposta> respostas;

    public Pergunta() {}

    public int getId() {
        return id;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }

    
}
