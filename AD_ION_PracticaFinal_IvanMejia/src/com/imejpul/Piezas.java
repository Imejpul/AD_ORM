package com.imejpul;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Piezas {
    private String codigo;
    private String nombre;
    private double precio;
    private String descripcion;

    @Id
    @Column(name = "CODIGO", nullable = false, length = 6)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 20)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "PRECIO", nullable = false, precision = 0)
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Basic
    @Column(name = "DESCRIPCION", nullable = true, length = -1)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piezas piezas = (Piezas) o;
        return Double.compare(piezas.precio, precio) == 0 &&
                Objects.equals(codigo, piezas.codigo) &&
                Objects.equals(nombre, piezas.nombre) &&
                Objects.equals(descripcion, piezas.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, precio, descripcion);
    }
}
