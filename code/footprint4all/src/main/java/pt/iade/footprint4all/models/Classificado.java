package pt.iade.footprint4all.models;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="classificado")
@IdClass(ClassificadoId.class)
public class Classificado {
    @Column(name="cla_data") private Date data;
    @Id @Column(name="cla_uti_id")
    @JsonIgnore private int utilizadorId;
    @ManyToOne @MapsId("utilizadorId") @JoinColumn(name="cla_uti_id") @JsonIgnoreProperties("classificado") private Utilizador utilizador;
    @Id @Column(name="cla_esc_id")
    @JsonIgnore private int escalaId;
    @ManyToOne @MapsId("escalaId") @JoinColumn(name="cla_esc_id") @JsonIgnoreProperties("classificacoes") private Escala escala;
    
    public Classificado() {}

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getUtilizadorId() {
        return utilizadorId;
    }

    public void setUtilizadorId(int utilizadorId) {
        this.utilizadorId = utilizadorId;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public Escala getEscala() {
        return escala;
    }

    public void setEscala(Escala escala) {
        this.escala = escala;
    }

    public int getEscalaId() {
        return escalaId;
    }

    public void setEscalaId(int escalaId) {
        this.escalaId = escalaId;
    }
}
