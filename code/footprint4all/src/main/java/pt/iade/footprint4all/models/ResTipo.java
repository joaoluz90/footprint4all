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
@Table(name="restipo")
public class ResTipo {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="restipo_id") private int id;
    @Column(name="restipo_nome") private String nome;
    @OneToMany @JoinColumn(name="res_restipo_id") @JsonIgnoreProperties({"tiporesposta"}) private List<Resposta> respostas;

    public ResTipo() {}

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }

    
}
