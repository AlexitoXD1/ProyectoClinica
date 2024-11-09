package Persistencia;
import Impresion.Mensajes;
import java.io.*;
import Colecciones.ArregloUsuarios;
public class AlmacenarUsuarios {
    static String nombrearchivo="ListaUsuarios.bin";
    public static void GuardarUsuarios(ArregloUsuarios Lista){
        try{
            FileOutputStream fos= new FileOutputStream(nombrearchivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Lista);
            oos.close();
        }catch(Exception ex){
            Mensajes.Mostrar("ERROR no se guardar..."+ex);
        }
    }
    public static ArregloUsuarios RecuperarDatos(){
        
        ArregloUsuarios Lista=new ArregloUsuarios(50);
        
        try{
            FileInputStream fis = new FileInputStream(nombrearchivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Lista= (ArregloUsuarios)ois.readObject();
            ois.close();
        }catch(Exception ex){
            Mensajes.Mostrar("ERROR no se puede recuperar "+ex);
        }
        return Lista;
    }
}

