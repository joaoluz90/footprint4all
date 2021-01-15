package pt.iade.footprint4all.models;

import javax.persistence.Entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="administrador")
public class Administrador {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="admi_id") private int id;
    @Column(name="admi_datainicio") private Date datainicio;
    @Column(name="admi_datafinal") private Date datafim;
    @OneToMany @JoinColumn(name="edi_admi_id") @JsonIgnoreProperties({"administrador"}) private List<Edita> edits;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "admi_uti_id", referencedColumnName = "uti_id")
    private Utilizador utilizador;

    public Administrador() {}

    

    public Date getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

    public Date getDatafim() {
        return datafim;
    }

    public void setDatafim(Date datafim) {
        this.datafim = datafim;
    }

    public List<Edita> getEdits() {
        return edits;
    }

    public void setEdits(List<Edita> edits) {
        this.edits = edits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }
    
}
