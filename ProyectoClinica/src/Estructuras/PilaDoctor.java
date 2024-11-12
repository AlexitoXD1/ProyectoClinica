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
    public void Desapilar(){
        if(pila.isEmpty()){
            Mensajes.Mostrar("La pila esta vacia.");
        }else{
            pila.pop();
            AlmacenarDoctor.Guardar(this);
        }
    }
    public int Cantidad(){
        return pila.size();
    }
    public Doctor ObtenerDoc(int pos){
        return pila.get(pos);
    }
    public Doctor UltimoObjeto(){
        return pila.peek();
    }
    public Doctor PrimerObjeto(){
        return pila.firstElement();
    }
    //Metodo que busca un Doctor en la pila
    public Doctor BuscarDoctor(String codDbus){
        for(int i=0;i<pila.size();i++){
            if(codDbus.equalsIgnoreCase(pila.get(i).getDcod()))
                return pila.get(i);
        }
        return null;
    }
    //Metodo que verifica si la pila esta vacia
    public boolean VerificarVacio(){
        return pila.empty();
    }
    public Stack<Doctor> getPila() {
        return pila;
    }
    public void setPila(Stack<Doctor> pila) {
        this.pila = pila;
    }
}
