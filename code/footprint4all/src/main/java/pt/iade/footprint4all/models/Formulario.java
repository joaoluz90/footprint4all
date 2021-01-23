package pt.iade.footprint4all.models;

import java.sql.Date;
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
@Table(name="formulario")
public class Formulario {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="form_id") private int id;
    @Column(name="form_nome") private String nome_formulario;
    @Column(name="form_data") private Date data;
    @OneToMany @JoinColumn(name="edi_form_id") @JsonIgnoreProperties({"forms"}) private List<Edita> edicoes;
    @OneToMany @JoinColumn(name="quest_form_id") @JsonIgnoreProperties({"formulario"}) private List<Questionario> questionarios;

    public Formulario() {}

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome_formulario;
    }

    public void setNome(String nome) {
        this.nome_formulario = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNome_formulario() {
        return nome_formulario;
    }

    public void setNome_formulario(String nome_formulario) {
        this.nome_formulario = nome_formulario;
    }

    public List<Edita> getEdicoes() {
        return edicoes;
    }

    public void setEdicoes(List<Edita> edicoes) {
        this.edicoes = edicoes;
    }    
}
