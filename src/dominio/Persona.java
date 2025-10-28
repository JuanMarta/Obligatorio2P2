package dominio;

public abstract class Persona {

    private String nombre;
    private String cedula;
    private String celular;

    public Persona(String elNombre, String laCedula, String elCelular) {
        nombre = elNombre;
        cedula = laCedula;
        celular = elCelular;
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
    public String toString() {
        return this.getNombre() + " (" + this.getCedula() + ")";
    }
}
