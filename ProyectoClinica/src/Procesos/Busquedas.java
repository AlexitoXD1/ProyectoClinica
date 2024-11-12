package Procesos;

import Modelo.*;
import java.util.Arrays;
import java.util.Comparator;

public class Busquedas {

    public static Paciente buscarPacientePorCodigo(Paciente[] mascotas, String codigo) {
        // Filtrar elementos nulos
        Paciente[] mascotasFiltradas = Arrays.stream(mascotas)
                .filter(mascota -> mascota != null)
                .toArray(Paciente[]::new);

        // Ordenar el arreglo
        Arrays.sort(mascotasFiltradas, Comparator.comparing(Paciente::getCodigo));

        // Llamar a la búsqueda binaria recursiva
        return busquedaBinaria(mascotasFiltradas, codigo, 0, mascotasFiltradas.length - 1);
    }

    private static Paciente busquedaBinaria(Paciente[] mascotas, String codigo, int inicio, int fin) {
        if (inicio > fin) {
            return null; // No encontrado
        }

        int medio = inicio + (fin - inicio) / 2;
        int comparacion = mascotas[medio].getCodigo().compareTo(codigo);

        if (comparacion == 0) {
            return mascotas[medio]; // Encontrado
        } else if (comparacion < 0) {
            return busquedaBinaria(mascotas, codigo, medio + 1, fin);
        } else {
            return busquedaBinaria(mascotas, codigo, inicio, medio - 1);
        }
    }

//    public static void main(String[] args) {
//        // Ejemplo de uso
//        Paciente[] mascotas = {
//            new Paciente("001", "Firulais", "Pastor Alemán", 5, "Juan Pérez", "2022-01-01"),
//            new Paciente("002", "Pelusa", "Persa", 3, "María Gómez", "2023-02-01"),
//            new Paciente("003", "Rex", "Bulldog", 2, "Carlos Díaz", "2021-03-01")
//        };
//
//        Paciente buscada = buscarPacientePorCodigo(mascotas, "00s2");
//        if (buscada != null) {
//            System.out.println("Paciente encontrada: " + buscada.getNombre());
//        } else {
//            System.out.println("Paciente no encontrada.");
//        }
//    }

    public static Paciente buscarPacientePorCodigo_SecuencialRecursiva(Paciente[] mascotas, String codigo) {
        return buscarMascotaPorCodigo_SecuencialRecursiva(mascotas, codigo, 0);
    }

    private static Paciente buscarMascotaPorCodigo_SecuencialRecursiva(Paciente[] mascotas, String codigo, int indice) {
        if (indice >= mascotas.length) {
            return null; // No encontrado
        }

        Paciente mascota = mascotas[indice];

        if (mascota != null && codigo.equals(mascota.getCodigo())) {
            return mascota; // Encontrado
        }

        return buscarMascotaPorCodigo_SecuencialRecursiva(mascotas, codigo, indice + 1);
    }
    
}//fin de la clase
