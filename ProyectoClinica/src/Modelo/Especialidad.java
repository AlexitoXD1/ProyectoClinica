package Modelo;

import java.io.Serializable;

public class Especialidad implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String codigo;
    private String nombre;
    private String nivel;
    private String descripcion;

    public Especialidad(String codigo, String nombre, String nivel, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel = nivel;
        this.descripcion = descripcion;
    }
    
    
    public Especialidad() {

    }

    public Object[] Registro(int num) {
        Object fila[] = {num, codigo, nombre, nivel, descripcion};
        return fila;
    }

    //getter y setter
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}//fin de la clase
