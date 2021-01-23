package pt.iade.footprint4all.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
@Table(name="questionario")
public class Questionario {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="quest_id") private int id;
    @ManyToOne @JoinColumn(name="quest_form_id") @JsonIgnoreProperties({"questionario"}) private Formulario formulario;
    @ManyToOne @JoinColumn(name="quest_sec_id") @JsonIgnoreProperties({"questions"}) private Seccao seccao;
    @ManyToOne @JoinColumn(name="quest_per_id") @JsonIgnoreProperties({"questionarios"}) private Pergunta pergunta;
    @OneToMany @JoinColumn(name="res_quest_id") @JsonIgnoreProperties({"questionario"}) private List<Resposta> respostas;

    public Questionario() {}

    public int getId() {
        return id;
    }

    public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }

    public Seccao getSeccao() {
        return seccao;
    }

    public void setSeccao(Seccao seccao) {
        this.seccao = seccao;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    
    
}
