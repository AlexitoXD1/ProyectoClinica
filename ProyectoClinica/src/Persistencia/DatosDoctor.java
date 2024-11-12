package Persistencia;
//libreria

import java.io.*;
import Pila.*;
import Procesos.*;

public class DatosDoctor {

    public static void GuardarEnArchivo(PilaDoctor Lista) {
        try {
            FileOutputStream fos = new FileOutputStream("InfoDoctor.bin");
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(Lista);
            }
        } catch (IOException ex) {
            Mensajes.MostrarTexto("ERROR no se puede guardar Pila.." + ex);
        }
    }//fin guardar   

    public static PilaDoctor RecuperaDeArchivo() {
        PilaDoctor Lista = new PilaDoctor();
        try {
            FileInputStream fis = new FileInputStream("InfoDoctor.bin");
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                Lista = (PilaDoctor) ois.readObject();
            }
        } catch (IOException | ClassNotFoundException ex) {
            Mensajes.MostrarTexto("ERROR no se puede recuperar Pila.." + ex);
        }
        return Lista;
    }//fin recuperar
}
