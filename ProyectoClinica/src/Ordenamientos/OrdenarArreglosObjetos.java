package Ordenamientos;

import Modelo.ArregloPaciente;
import Modelo.Paciente;

public class OrdenarArreglosObjetos {
    
    public static int[] Insercion(int a[]) {
        for (int i = 1; i < a.length; i++) {
            int value = a[i];
            int j = i;
            while (j > 0 && a[j - 1] > value) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = value;
        }
        return a;
    }
    public static Paciente[] OrdernarPacientesPorCodigo(Paciente a[]) {
        for (int i = 1; i < a.length; i++) {
            Paciente value = a[i];
            int j = i;
            while (j > 0 && a[j - 1].getCodigo().compareTo(value.getCodigo()) > 0) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = value;
        }
        return a;
    }
}