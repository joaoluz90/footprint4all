package pt.iade.footprint4all.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Id;

@Entity
@Table(name="utilizador")
public class Utilizador {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="uti_id") private int id;
    @Column(name="uti_dnsc") private Date dnsc;
    @Column(name="uti_nome") private String nome;
    @Column(name="uti_morada") private String morada;
    @Column(name="uti_genero") private Character genero;
    @Column(name="uti_naci") private String nacionalidade;
    @OneToMany @JoinColumn(name="cla_uti_id") @JsonIgnoreProperties({"utilizador"}) List<Classificado> classificado;
    @ManyToOne @JoinColumn(name="uti_id", insertable = false, updatable = false) @JsonIgnoreProperties({"utilizador"}) Resposta resposta;
    @OneToOne(mappedBy = "utilizador") private Administrador administrador;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "uti_cod_id", referencedColumnName = "cod_id")
    private CodigoPostal codigopostal;

    public Utilizador(){}

    public int getId() {
        return id;
    }

    public Date getDnsc() {
        return dnsc;
    }

    public void setDnsc(Date dnsc) {
        this.dnsc = dnsc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public CodigoPostal getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(CodigoPostal codigopostal) {
        this.codigopostal = codigopostal;
    }
}
