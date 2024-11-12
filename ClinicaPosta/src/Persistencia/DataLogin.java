package Persistencia;

import Modelo.Usuario;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

//Debido a que hashtable es una clase obsoleta se esta usando hashmap
//que es una clase actual y no cambia en nada la lógica de hasttable
//debido a que son lo mismo

public class DataLogin {

    private static final String URL_GUARDADO = "Usuarios.bin";
    
    /*Se usa hash table para guardar la lista de usuarios del sistema
      Tenemos como índice del hash map al usuario y como valor del índice a la contraseña
    */
    
    private HashMap<String, String> listaUsuarios;   

    public DataLogin() {
        listaUsuarios = new HashMap<>();
        cargarCitasDesdeArchivo();
    }

    public void registrar(Usuario usuario) {
        listaUsuarios.put(usuario.getUsuario(), usuario.getPassword());
        guardarEnArchivo();
    }

    public void actualizar(Usuario usuario) {
        if (listaUsuarios.containsKey(usuario.getUsuario())) {
            listaUsuarios.put(usuario.getUsuario(), usuario.getPassword());
        }
        guardarEnArchivo();
    }
    
    /**
     * Ingresamos como parámetro nickUsuario para posteriormente usar el método
     * .containsKey, este método me permite buscar el índice del hashmap dentro
     * de toda la lista
     * @param nickUsuario Ingreso como parámetro el usuario a buscar
     * @return Me retorna true si se encontró el usuario y false si no
     */
    public boolean usuarioExiste(String nickUsuario) {          
        return listaUsuarios.containsKey(nickUsuario);
    }

    public String getPassword(String nickUsuario) {
        return listaUsuarios.get(nickUsuario);
    }

    public void borrar(String nickUsuario) {
        listaUsuarios.remove(nickUsuario);
        guardarEnArchivo();
    }

    private void guardarEnArchivo() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(URL_GUARDADO))) {
            out.writeObject(listaUsuarios);
        } catch (IOException e) {
//            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public ArrayList<Usuario> obtenerTodasLasCitas() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        listaUsuarios.forEach((usuario, password) -> usuarios.add(new Usuario(usuario, password)));
        return usuarios;
    }

    private void cargarCitasDesdeArchivo() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(URL_GUARDADO))) {
            listaUsuarios = (HashMap<String, String>) in.readObject();
        } catch (FileNotFoundException e) {
            listaUsuarios = new HashMap<>();
        } catch (IOException | ClassNotFoundException e) {
//            System.out.println("ERROR: " + e.getMessage());
            listaUsuarios = new HashMap<>();
        }
    }
}
