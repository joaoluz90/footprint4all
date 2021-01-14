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
    @ManyToOne @JoinColumn(name = "per_res_id") @JsonIgnoreProperties({ "respostas" }) private Pergunta pergunta;

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

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }
    
    
}
