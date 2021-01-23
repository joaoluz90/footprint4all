package pt.iade.footprint4all.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="resposta")
public class Resposta {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="res_id") private int id;
    @Column(name="res_string") private String string;
    @ManyToOne @JoinColumn(name = "res_uti_id") @JsonIgnoreProperties({"resposta"}) private Utilizador utilizador;
    @ManyToOne @JoinColumn(name="res_quest_id") @JsonIgnoreProperties({"respostas"}) private Questionario questionario;
    @ManyToOne @JoinColumn(name="res_restipo_id") @JsonIgnoreProperties({"respostas"}) private ResTipo tiporesposta;

    public Resposta() {}

    public int getId() {
        return id;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public ResTipo getTiporesposta() {
        return tiporesposta;
    }

    public void setTiporesposta(ResTipo tiporesposta) {
        this.tiporesposta = tiporesposta;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public Questionario getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }
    
}
