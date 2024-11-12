package Modelo;

import java.io.Serializable;

public class Servicio implements Serializable {

    private static final long serialVersionUID = 1L;
    private String idPaciente;
    private String IdEspecialidad;
    private String nomServicio;
    private double precio;
    private String area;
    private String descripcion;

    public Servicio() {
    }

    public Servicio(String idPaciente, String IdEspecialidad, String nomServicio, double precio, String area, String descripcion) {
        this.idPaciente = idPaciente;
        this.IdEspecialidad = IdEspecialidad;
        this.nomServicio = nomServicio;
        this.precio = precio;
        this.area = area;
        this.descripcion = descripcion;
    }

    public String ServicioCompleto() {
        return IdEspecialidad + " " + nomServicio;
    }

    public Servicio(Object[] registro) {
        this.idPaciente = registro[0].toString();
        this.IdEspecialidad = registro[1].toString();
        this.nomServicio = registro[2].toString();
        this.precio = Double.parseDouble(registro[3].toString());
        this.area = registro[4].toString();
        this.descripcion = registro[5].toString();
    }

    public Object[] getRegistro() {
        Object[] fila = {idPaciente, IdEspecialidad, nomServicio, precio, area, descripcion};
        return fila;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getIdEspecialidad() {
        return IdEspecialidad;
    }

    public void setIdEspecialidad(String IdEspecialidad) {
        this.IdEspecialidad = IdEspecialidad;
    }

    public String getNomServicio() {
        return nomServicio;
    }

    public void setNomServicio(String nomServicio) {
        this.nomServicio = nomServicio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
