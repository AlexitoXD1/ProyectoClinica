package Persistencia;
import Estructuras.PilaDoctor;
import java.io.*;
import Impresion.Mensajes;

public class AlmacenarDoctor {
    public static String ARCHIVO="DatosPilaOperarios.bin";
    public static void Guardar(PilaDoctor pila){
       try{
           FileOutputStream fos=new FileOutputStream(ARCHIVO);
           ObjectOutputStream oos =  new ObjectOutputStream(fos);
           oos.writeObject(pila);
           oos.close();
       }catch(Exception ex){
           Mensajes.Leer("ERROR no se puede guardar "+ex);
       }       
    }// fin guardar
    
    public static PilaDoctor Recuperar(){
        PilaDoctor pila =new PilaDoctor();
       try{
           FileInputStream fis =  new FileInputStream(ARCHIVO);
           ObjectInputStream ois = new ObjectInputStream(fis);
           pila = (PilaDoctor)ois.readObject();
           ois.close();
       }catch(Exception ex){
           Mensajes.Mostrar("ERROR no se puede recuperar..."+ex);
       }
       return pila;
    }
}
