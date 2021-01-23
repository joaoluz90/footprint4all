package pt.iade.footprint4all.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="pergunta")
public class Pergunta {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="per_id") private int id;
    @Column(name="per_string") private String string;
    @ManyToOne @JoinColumn(name="per_pertipo_id") @JsonIgnoreProperties({"tipopergunta"}) private PerTipo tipopergunta;
    @OneToMany @JoinColumn(name="quest_per_id") @JsonIgnoreProperties({"perguntas"}) private List<Questionario> questionarios;

    public Pergunta() {}

    public int getId() {
        return id;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public PerTipo getTipopergunta() {
        return tipopergunta;
    }

    public void setTipopergunta(PerTipo tipopergunta) {
        this.tipopergunta = tipopergunta;
    }

}
