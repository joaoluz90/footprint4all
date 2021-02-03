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
@Table(name="escala")
public class Escala {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="esc_id") private int id;
    @Column(name="esc_valor") private int valor;
    @Column(name="esc_desc") private String descricao;
    @OneToMany @JoinColumn(name="esc_id") @JsonIgnoreProperties({"escala"}) private List<Classificado> classificacoes;

    public Escala() {}

    public int getId() {
        return id;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

