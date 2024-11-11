package Modelo;
public class Doctor {
    private String Dcod; //Codigo
    private String Dnom; //Nombre
    private String Dapel; //Apellido
    private String Desp; //Especialidad
    private String Dtel; //Telefono
    
    public Doctor(){}
    public Object[] DRegistro(int num){
        Object[] fila = {num,Dcod,Dnom,Dapel,Desp};
        return fila;
    }
    //Getter and Setters
    public String getDcod() {
        return Dcod;    }
    public void setDcod(String Dcod) {
        this.Dcod = Dcod;    }
    public String getDnom() {
        return Dnom;    }
    public void setDnom(String Dnom) {
        this.Dnom = Dnom;    }
    public String getDapel() {
        return Dapel;    }
    public void setDapel(String Dapel) {
        this.Dapel = Dapel;    }
    public String getDesp() {
        return Desp;    }
    public void setDesp(String Desp) {
        this.Desp = Desp;    }
    public String getDtel() {
        return Dtel;    }
    public void setDtel(String Dtel) {
        this.Dtel = Dtel;    }    
}
