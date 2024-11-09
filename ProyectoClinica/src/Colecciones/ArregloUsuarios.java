package Colecciones;

import java.io.Serializable;
import Modelo.*;
public class ArregloUsuarios implements Serializable{
    private Usuario[] Lista;
    public static int contador;
    
    //getter y setter
    public Usuario[] getLista() {
        return Lista;
    }

    public void setLista(Usuario[] Lista) {
        this.Lista = Lista;
    }
  
    
    
    
    public ArregloUsuarios(int cantidad){
        Lista = new Usuario[cantidad];
        contador=0;
    }
    public void AgregarUsuario(Usuario emp){
        Lista[contador]=emp;
        contador++;
    }
    public void ActualizarUsuario(int posicion, Usuario actual){
        Lista[posicion]=actual;
    }
    public Usuario RecuperarUsuario(int posicion){
        return Lista[posicion];
    }
    public void EliminarUsuario(int posicion){
        for(int j=posicion;j<contador-1;j++){
            Lista[j]=Lista[j+1];
        }
        Lista[contador-1]=null;
        contador--;
    }
    
    public void ActualizarContador(){
        contador=0;
        for(int i=0;i<Lista.length;i++){
            if(Lista[i]!=null){
                contador++;
            }
        }
    }
    
    public int MostrarContador(){
        return contador;
    }

  
    
    
    
}//
