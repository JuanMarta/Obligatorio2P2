package dominio;

import java.io.Serializable;

public abstract class Persona implements Serializable {

    private String nombre;
    private String cedula;
    private String celular;

    public Persona(String elNombre, String laCedula, String elCelular) {
        nombre = elNombre;
        cedula = laCedula;
        celular = elCelular;
    }
    
    public Persona(String laCedula) {
        cedula = laCedula;
    }

    public Persona() {
        nombre = "";
        cedula = "";
        celular = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public boolean equals(Object o){
        Persona otra = (Persona) o;
        return this.cedula.equals(otra.getCedula());
    }
    
    @Override
    public String toString() {
        return this.getNombre() + " (" + this.getCedula() + ")";
    }
}
