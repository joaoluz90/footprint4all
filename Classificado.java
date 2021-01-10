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
    @Id @Column(name="cla_uti_id")
    @JsonIgnore private int utilizadorId;
    @ManyToOne @MapsId("utilizadorId") @JoinColumn(name="cla_uti_id")
    @JsonIgnoreProperties("classificado")
    private Utilizador utilizador;
    @Id @Column(name="cla_esc_id")
    @JsonIgnore private int escalaId;
    @ManyToOne @MapsId("escalaId")
    @JoinColumn(name="cla_esc_id")
    @JsonIgnoreProperties("escala")
    private Escala escala;
    @Column(name="cla_data") private Date data;
    
    public Classificado() {}

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
}
