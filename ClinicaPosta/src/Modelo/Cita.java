package Modelo;

import java.io.Serializable;
import java.sql.Timestamp;

public class Cita implements Serializable {

    private static final long serialVersionUID = 1L;

    private String codigoCita;
    private String idPaciente;
    private String idEspecialidad;
    private String nombreDoctor;
    private String servicio;
    private Timestamp fecha;
    private int estado;

    public Cita(String codigoCita, String idPaciente, String idEspecialidad, String nombreDoctor, String servicio, Timestamp fecha, int estado) {
        this.codigoCita = codigoCita;
        this.idPaciente = idPaciente;
        this.idEspecialidad = idEspecialidad;
        this.nombreDoctor = nombreDoctor;
        this.servicio = servicio;
        this.fecha = fecha;
        this.estado = estado;
    }

    public String getCodigoCita() {
        return codigoCita;
    }

    public void setCodigoCita(String codigoCita) {
        this.codigoCita = codigoCita;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(String idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getNombreDoctor() {
        return nombreDoctor;
    }

    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String toEstado() {
        switch (estado) {
            case 0:
                return "pendiente";
            case 1:
                return "cancelado";
            case 2:
                return "atendido";
        }
        return "";
    }

    public static int parseEstado(String nameEstado) {
        if (nameEstado.equalsIgnoreCase("pendiente")) {
            return 0;
        } else if (nameEstado.equalsIgnoreCase("cancelado")) {
            return 1;
        } else if (nameEstado.equalsIgnoreCase("atendido")) {
            return 2;
        } else {
            return 0;
        }
    }

}
