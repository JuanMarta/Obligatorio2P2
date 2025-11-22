// Trabajo desarrollado por: Santiago Alonso 349491 Juan Marta 332281
package dominio;

import excepciones.CedulaInvalidaException;
import excepciones.StringVacioException;
import excepciones.TelefonoInvalidoException;
import java.io.Serializable;

public abstract class Persona implements Serializable {

    private String nombre;
    private String cedula;
    private String telefono;
    private static final long serialVersionUID = 1;

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
        if (cedula.length() != 8) {
            throw new CedulaInvalidaException();
        }
        try {
            Integer.parseInt(cedula);
        } catch (NumberFormatException e) {
            throw new CedulaInvalidaException();
        }
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) throws StringVacioException, TelefonoInvalidoException {
        if (telefono.isEmpty()) {
            throw new StringVacioException();
        }
        try {
            Integer.parseInt(telefono);
        } catch (NumberFormatException e) {
            throw new TelefonoInvalidoException();
        }
        this.telefono = telefono;
    }


    @Override
    public String toString() {
        return this.getNombre() + " (" + this.getCedula() + ")";
    }
}
