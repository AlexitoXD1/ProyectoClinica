package Pila;

import java.io.Serializable;

public class Doctor implements Comparable<Doctor>, Serializable {

    private static final long serialVersionUID = 1L;
    private String cod;
    private String nombre;
    private String cargo; // Parámetro existente
    private String area;

    // Constructor predeterminado
    public Doctor() {
    }

    // Constructor con parámetros
    public Doctor(String cod, String nombre, String cargo, String area) {
        this.cod = cod;
        this.nombre = nombre;
        this.cargo = cargo;
        this.area = area;
    }

    @Override
    public int compareTo(Doctor other) {
        return this.cod.compareTo(other.cod);
    }

    @Override
    public String toString() {
        return "Empleado \n"
                + "cod: " + cod + "\nombre: " + nombre + "\ncargo: " + cargo + "area"+area;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

}
