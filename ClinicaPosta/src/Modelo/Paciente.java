package Modelo;

import java.io.Serializable;

public class Paciente implements Comparable<Paciente>, Serializable {

    private static final long serialVersionUID = 1L;

    //Atributos
    private String codigo;
    private String nombre;
    private String genero;
    private int edad;
    private String especialidad;
    private String fecha;

    public Paciente(String codigo, String nombre, String genero, int edad, String especialidad, String fecha) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.especialidad = especialidad;
        this.fecha = fecha;
    }

    // Crea un array de objetos con el número proporcionado y los atributos de la Paciente
    public Object[] Registro(int num) {
        Object fila[] = {num, codigo, nombre, genero, edad, especialidad, fecha};
        return fila;
    }

    //Constructor sin parametros
    public Paciente() {
    }

    //Sobreescritura del metodo toString
    @Override
    public String toString() {
        return "Paciente{" + "codigo=" + codigo + ", nombre=" + nombre + ", genero=" + genero + ", edad=" + edad
                + ", especialidad=" + especialidad + ", fecha=" + fecha + '}';
    }

    public String imprimir() {
        String datos = "";
        datos += " PACIENTE";
        datos += "\n - Codigo     : " + codigo;
        datos += "\n - Nombre     : " + nombre;
        datos += "\n - Genero       : " + genero;
        datos += "\n - Edad       : " + edad;
        datos += "\n - Especialidad: " + especialidad;
        datos += "\n - Fecha      : " + fecha;
        return datos;
    }

    // Getters y Setters
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public int compareTo(Paciente other) {
        return this.codigo.compareTo(other.codigo);
    }
}
