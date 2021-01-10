package pt.iade.footprint4all.models;

import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
    @ManyToMany @JoinColumn(name="edi_form_id") @JsonIgnoreProperties({"formulario"}) private List<Edita> edicoes;
    @ManyToMany @JoinColumn(name="sec_form_id") @JsonIgnoreProperties({"formulario"}) private List<Seccao> seccao;
    @OneToMany @JoinColumn(name="res_form_id") @JsonIgnoreProperties({"formulario"}) private List<Resposta> respostas;

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
}
