package pt.iade.footprint4all.models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name="restipo")
public class ResTipo {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="respTip_id") private int id;
    @Column(name="respTip_nome") private String nome;
    @OneToMany @JoinColumn(name="res_resTip_id") private List<Resposta> respostas;

    public ResTipo() {}

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }
    
}
