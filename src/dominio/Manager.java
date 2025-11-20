// Trabajo desarrollado por: Santiago Alonso 349491 Juan Marta 332281
package dominio;

import excepciones.CedulaInvalidaException;
import excepciones.StringVacioException;
import excepciones.TelefonoInvalidoException;
import java.util.ArrayList;
import java.util.Collections;

public class Manager extends Persona implements Comparable<Manager> {

    private int antiguedad;
    private ArrayList<Empleado> listaEmpleados;

    public Manager(String elNombre, String laCedula, String elCelular, int laAntiguedad) throws StringVacioException, CedulaInvalidaException, TelefonoInvalidoException {
        super(elNombre, laCedula, elCelular);
        antiguedad = laAntiguedad;
        listaEmpleados = new ArrayList<>();
    }

    public Manager() {
        super();
        antiguedad = 0;
        listaEmpleados = new ArrayList<>();
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public void agregarEmpleado(Empleado elEmpleado) {
        listaEmpleados.add(elEmpleado);
        empleadosOrdenadosPorSalario();
    }

    public void quitarEmpleado(Empleado elEmpleado) {
        listaEmpleados.remove(elEmpleado);
    }

    public int getCantidadEmpleados() {
        return listaEmpleados.size();
    }

    public boolean sinEmpleados() {
        return listaEmpleados.isEmpty();
    }

    public void empleadosOrdenadosPorSalario() {
        Collections.sort(listaEmpleados);
    }

    @Override
    public String toString() {
        return super.toString() + " - Antigüedad: " + this.getAntiguedad();
    }

    @Override
    public int compareTo(Manager o) {
        return o.getAntiguedad() - this.antiguedad;
    }
}
