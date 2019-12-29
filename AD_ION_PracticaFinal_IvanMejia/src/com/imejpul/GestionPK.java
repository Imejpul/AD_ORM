package com.imejpul;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class GestionPK implements Serializable {
    private String codproveedor;
    private String codpieza;
    private String codproyecto;

    @Column(name = "CODPROVEEDOR", nullable = false, length = 6)
    @Id
    public String getCodproveedor() {
        return codproveedor;
    }

    public void setCodproveedor(String codproveedor) {
        this.codproveedor = codproveedor;
    }

    @Column(name = "CODPIEZA", nullable = false, length = 6)
    @Id
    public String getCodpieza() {
        return codpieza;
    }

    public void setCodpieza(String codpieza) {
        this.codpieza = codpieza;
    }

    @Column(name = "CODPROYECTO", nullable = false, length = 6)
    @Id
    public String getCodproyecto() {
        return codproyecto;
    }

    public void setCodproyecto(String codproyecto) {
        this.codproyecto = codproyecto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GestionPK gestionPK = (GestionPK) o;
        return Objects.equals(codproveedor, gestionPK.codproveedor) &&
                Objects.equals(codpieza, gestionPK.codpieza) &&
                Objects.equals(codproyecto, gestionPK.codproyecto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codproveedor, codpieza, codproyecto);
    }
}
