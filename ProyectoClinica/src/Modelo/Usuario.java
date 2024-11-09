package Modelo;
import java.io.Serializable;
public class Usuario implements Serializable {
    private String nom;
    private String contra;
    private String corre;
    private String tel;
    public Usuario(){}
    public Object[] Registro(int num){
        Object[] fila={num,contra,nom,corre,tel};
        return fila;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getCorre() {
        return corre;
    }

    public void setCorre(String corre) {
        this.corre = corre;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    

    
    
}
