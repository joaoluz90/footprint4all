package pt.iade.footprint4all.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="edita")
public class Edita {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="edi_id") private int id;
    @Column(name="edi_data") private Date data;

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
