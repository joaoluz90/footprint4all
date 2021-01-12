package pt.iade.footprint4all.models;

import java.io.Serializable;

public class ClassificadoId implements Serializable {
    private static final long serialVersionUID = 1L;
    private int utilizadorId;
    private int escalaId;

    public ClassificadoId() {}

    public int getEscalaId() {
        return escalaId;
    }

    public void setEscalaId(int escalaId) {
        this.escalaId = escalaId;
    }

    public int getUtilizadorId() {
        return utilizadorId;
    }

    public void setUtilizadorId(int utilizadorId) {
        this.utilizadorId = utilizadorId;
    };
}
