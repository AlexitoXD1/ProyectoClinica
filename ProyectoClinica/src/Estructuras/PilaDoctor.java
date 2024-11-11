package Estructuras;
import java.io.Serializable;
import Modelo.*;
import Impresion.Mensajes;
import java.util.Stack;
import Persistencia.*;
public class PilaDoctor implements Serializable{
    private Stack<Doctor> pila;
    public PilaDoctor(){
        pila = new Stack();
    }
    //Metodo que agrega datos a la pila
    public void Apilar(Doctor Doc){
        pila.push(Doc);
        AlmacenarDoctor.Guardar(this);
    }
    //Metodo que elimina un Doctor de la pila
    public void Desapilar(Doctor Doc){
        if(pila.isEmpty()){
            Mensajes.Mostrar("La pila esta vacia.");
        }else{
            pila.pop();
            AlmacenarDoctor.Guardar(this);
        }
    }
}
