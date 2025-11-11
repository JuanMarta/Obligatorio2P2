package dominio;

import auxiliar.ArchivoGrabacion;
import excepciones.CedulaInvalidaException;
import excepciones.StringVacioException;
import excepciones.TelefonoInvalidoException;
import java.io.File;

public class Empleado extends Persona implements Comparable<Empleado> {

    private double salarioMensual;
    private String cv;
    private Manager manager;
    private Area area;

    public Empleado(String elNombre, String laCedula, String elCelular, double elSalario, String elCv, Manager elManager, Area elArea) throws StringVacioException, CedulaInvalidaException, TelefonoInvalidoException {
        super(elNombre, laCedula, elCelular);
        this.setSalarioMensual(elSalario);
        this.setCv(elCv);
        this.setManager(elManager);
        this.setArea(elArea);
    }

    public Empleado() {
        super();
        salarioMensual = 0;
        cv = "";
        manager = null;
        area = null;
    }
    
    // Generalmente usado en la unicidad de la cedula
    public Empleado(String laCedula) {
        super(laCedula);
    }

    public double getSalarioMensual() {
        return salarioMensual;
    }

    public void setSalarioMensual(double salarioMensual) {
        this.salarioMensual = salarioMensual;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String elCv) throws StringVacioException {
        if (elCv.isEmpty()) {
            throw new StringVacioException();
        } else {
            File carpeta = new File("cvs");
            if (!carpeta.exists()) {
                carpeta.mkdir();
            }
            cv = "cvs/CV" + super.getCedula() + ".txt";
            ArchivoGrabacion ag = new ArchivoGrabacion(cv);
            ag.grabarLinea(elCv);
            ag.cerrar();
        }
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public double getSalarioAnual() {
        return salarioMensual * 12;
    }
    
    @Override
    public String toString() {
        return super.toString() + " - $" + this.getSalarioMensual();
    }

    @Override
    public int compareTo(Empleado o) {
        return Double.compare(salarioMensual, o.getSalarioMensual());
    }
}
