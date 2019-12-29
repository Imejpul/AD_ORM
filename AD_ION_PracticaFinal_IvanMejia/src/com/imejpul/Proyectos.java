package com.imejpul;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Proyectos {
    private String codigo;
    private String nombre;
    private String ciudad;

    @Id
    @Column(name = "CODIGO", nullable = false, length = 6)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 40)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "CIUDAD", nullable = true, length = 40)
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proyectos proyectos = (Proyectos) o;
        return Objects.equals(codigo, proyectos.codigo) &&
                Objects.equals(nombre, proyectos.nombre) &&
                Objects.equals(ciudad, proyectos.ciudad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, ciudad);
    }
}
