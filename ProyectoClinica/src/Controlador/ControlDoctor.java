package Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.*;
import Vista.*;
import Procesos.*;
import Persistencia.*;
import Estructuras.*;
import Impresion.Mensajes;
public class ControlDoctor implements ActionListener{
    VistaDoctor vista;
    PilaDoctor pila;
    public ControlDoctor(VistaDoctor VDoc){
        vista=VDoc;
        vista.btnDingresar.addActionListener(this);
        vista.btnDborrar.addActionListener(this);
        vista.btnDbuscar.addActionListener(this);
        pila = new PilaDoctor();
        pila = AlmacenarDoctor.Recuperar();
        
        ProcesosDoctor.Presentación(vista);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==vista.btnDingresar){
            pila.Apilar(ProcesosDoctor.LeerDatos(vista));
            ProcesosDoctor.LimpiarEntradas(vista);
            Persistencia.AlmacenarDoctor.Guardar(pila);
        }
        if(e.getSource()==vista.btnDborrar){
            int resp = Mensajes.Confirmar("Confirmar","Deseas retirar a \n"+
                             pila.UltimoObjeto().toString());
           if(resp==0){
               pila.Desapilar();
           }
        }
        if(e.getSource()==vista.btnDbuscar){
            if(e.getSource() == vista.btnDbuscar){
           String codbus=Mensajes.Leer("Ingrese codigo a buscar...");
           Doctor encontrado = pila.BuscarDoctor(codbus);
           if(encontrado==null){
               Mensajes.Mostrar("Codigo "+codbus+" no existe en la pila");
           }else{
               Mensajes.Mostrar(encontrado.toString());
           }
        }
    }
}
}