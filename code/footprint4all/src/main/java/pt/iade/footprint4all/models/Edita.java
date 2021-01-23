package pt.iade.footprint4all.models;

import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Table(name="edita")
public class Edita {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="edi_id") private int id;
    @Column(name="edi_data") private Date data;
    @ManyToMany(cascade = CascadeType.ALL)
    @ManyToOne @JoinColumn(name="edi_id", insertable = false, updatable = false) @JsonIgnoreProperties({"edicoes"}) private Formulario forms;


    public Edita() {}

    public int getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    
}
