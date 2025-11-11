package dominio;

import excepciones.CedulaInvalidaException;
import excepciones.StringVacioException;
import excepciones.TelefonoInvalidoException;
import java.io.Serializable;

public abstract class Persona implements Serializable {

    private String nombre;
    private String cedula;
    private String telefono;

    public Persona(String elNombre, String laCedula, String elCelular) throws StringVacioException, CedulaInvalidaException, TelefonoInvalidoException {
        this.setNombre(elNombre);
        this.setCedula(laCedula);
        this.setTelefono(elCelular);
    }

    public Persona(String laCedula) {
        cedula = laCedula;
    }

    public Persona() {
        nombre = "";
        cedula = "";
        telefono = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws StringVacioException {
        if (nombre.isEmpty()) {
            throw new StringVacioException();
        }
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) throws StringVacioException, CedulaInvalidaException {
        if (cedula.isEmpty()) {
            throw new StringVacioException();
        }
        if(cedula.length() != 8){
            throw new CedulaInvalidaException();
        }
        try{
            Integer.parseInt(cedula);
        }catch (NumberFormatException e){
            throw new CedulaInvalidaException();
        }
        verificarCedula(cedula);
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) throws StringVacioException, TelefonoInvalidoException {
        if (telefono.isEmpty()) {
            throw new StringVacioException();
        }
        try{
            Integer.parseInt(telefono);
        }catch (NumberFormatException e){
            throw new TelefonoInvalidoException();
        }
        this.telefono = telefono;
    }
    
    public void verificarCedula(String cedula) throws CedulaInvalidaException{
        int ver = Integer.parseInt("" + cedula.charAt(7));
        int[] mult = {2, 9, 8, 7, 6, 3, 4};
        int suma = 0;
        for (int i = 0; i < 7; i++) {
            suma += Integer.parseInt(cedula.charAt(i) + "") * mult[i];
        }
        int resto = suma % 10;
        int digitoVerificador = (10 - resto) % 10;
        if(ver != digitoVerificador){
            throw new CedulaInvalidaException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        Persona otra = (Persona) o;
        return this.cedula.equals(otra.getCedula());
    }

    @Override
    public String toString() {
        return this.getNombre() + " (" + this.getCedula() + ")";
    }
}
