package Procesos;

import Modelo.*;
import java.util.Arrays;
import java.util.Comparator;

public class Busquedas {

    public static Paciente buscarPacientePorCodigo(Paciente[] pacientes, String codigo) {
        // Filtrar elementos nulos
        Paciente[] pacientesFiltrados = Arrays.stream(pacientes)
                .filter(paciente -> paciente != null)
                .toArray(Paciente[]::new);

        // Ordenar el arreglo
        Arrays.sort(pacientesFiltrados, Comparator.comparing(Paciente::getCodigo));

        // Llamar a la búsqueda binaria recursiva
        return busquedaBinaria(pacientesFiltrados, codigo, 0, pacientesFiltrados.length - 1);
    }

    private static Paciente busquedaBinaria(Paciente[] pacientes, String codigo, int inicio, int fin) {
        if (inicio > fin) {
            return null; // No encontrado
        }

        int medio = inicio + (fin - inicio) / 2;
        int comparacion = pacientes[medio].getCodigo().compareTo(codigo);

        if (comparacion == 0) {
            return pacientes[medio]; // Encontrado
        } else if (comparacion < 0) {
            return busquedaBinaria(pacientes, codigo, medio + 1, fin);
        } else {
            return busquedaBinaria(pacientes, codigo, inicio, medio - 1);
        }
    }


    public static Paciente buscarPacientePorCodigo_SecuencialRecursiva(Paciente[] pacientes, String codigo) {
        return buscarPacientePorCodigo_SecuencialRecursiva(pacientes, codigo, 0);
    }

    private static Paciente buscarPacientePorCodigo_SecuencialRecursiva(Paciente[] pacientes, String codigo, int indice) {
        if (indice >= pacientes.length) {
            return null; // No encontrado
        }

        Paciente mascota = pacientes[indice];

        if (mascota != null && codigo.equals(mascota.getCodigo())) {
            return mascota; // Encontrado
        }

        return buscarPacientePorCodigo_SecuencialRecursiva(pacientes, codigo, indice + 1);
    }
    
}//fin de la clase
