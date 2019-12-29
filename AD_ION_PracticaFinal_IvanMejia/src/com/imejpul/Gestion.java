package com.imejpul;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(GestionPK.class)
public class Gestion {
    private GestionPK id;
    private String codproveedor;
    private String codpieza;
    private String codproyecto;
    private Double cantidad;

    public Gestion() {
    }

    public Gestion(GestionPK id, String codproveedor, String codpieza, String codproyecto, Double cantidad) {
        this.id = id;
        this.codproveedor = codproveedor;
        this.codpieza = codpieza;
        this.codproyecto = codproyecto;
        this.cantidad = cantidad;
    }

    @Id
    @Column(name = "CODPROVEEDOR", nullable = false, length = 6)
    public String getCodproveedor() {
        return codproveedor;
    }

    public void setCodproveedor(String codproveedor) {
        this.codproveedor = codproveedor;
    }

    @Id
    @Column(name = "CODPIEZA", nullable = false, length = 6)
    public String getCodpieza() {
        return codpieza;
    }

    public void setCodpieza(String codpieza) {
        this.codpieza = codpieza;
    }

    @Id
    @Column(name = "CODPROYECTO", nullable = false, length = 6)
    public String getCodproyecto() {
        return codproyecto;
    }

    public void setCodproyecto(String codproyecto) {
        this.codproyecto = codproyecto;
    }

    @Basic
    @Column(name = "CANTIDAD", nullable = true, precision = 0)
    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gestion gestion = (Gestion) o;
        return Objects.equals(codproveedor, gestion.codproveedor) &&
                Objects.equals(codpieza, gestion.codpieza) &&
                Objects.equals(codproyecto, gestion.codproyecto) &&
                Objects.equals(cantidad, gestion.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codproveedor, codpieza, codproyecto, cantidad);
    }

    public GestionPK getId() {
        return id;
    }

    public void setId(GestionPK id) {
        this.id = id;
    }
}
