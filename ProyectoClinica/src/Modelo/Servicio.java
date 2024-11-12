package Modelo;

import java.io.Serializable;

public class Servicio implements Serializable {

    private static final long serialVersionUID = 1L;
    private String idMascota;
    private String IdServicio;
    private String nomServicio;
    private double precio;
    private String area;
    private String descripcion;

    public Servicio() {
    }

    public Servicio(String idMascota, String IdServicio, String nomServicio, double precio, String area, String descripcion) {
        this.idMascota = idMascota;
        this.IdServicio = IdServicio;
        this.nomServicio = nomServicio;
        this.precio = precio;
        this.area = area;
        this.descripcion = descripcion;
    }

    public String ServicioCompleto() {
        return IdServicio + " " + nomServicio;
    }

    public Servicio(Object[] registro) {
        this.idMascota = registro[0].toString();
        this.IdServicio = registro[1].toString();
        this.nomServicio = registro[2].toString();
        this.precio = Double.parseDouble(registro[3].toString());
        this.area = registro[4].toString();
        this.descripcion = registro[5].toString();
    }

    public Object[] getRegistro() {
        Object[] fila = {idMascota, IdServicio, nomServicio, precio, area, descripcion};
        return fila;
    }

    public String getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(String idMascota) {
        this.idMascota = idMascota;
    }

    public String getIdServicio() {
        return IdServicio;
    }

    public void setIdServicio(String IdServicio) {
        this.IdServicio = IdServicio;
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
