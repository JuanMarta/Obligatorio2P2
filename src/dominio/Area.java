package dominio;

import java.io.Serializable;
import java.util.ArrayList;

public class Area implements Serializable {

    private String nombre;
    private String descripcion;
    private double presupuestoAnual;
    private ArrayList<Empleado> listaEmpleados;

    public Area(String elNombre, String laDescripcion, double elPresupuesto) {
        nombre = elNombre;
        descripcion = laDescripcion;
        presupuestoAnual = elPresupuesto;
        listaEmpleados = new ArrayList<>();
    }

    public Area() {
        nombre = "Sin nombre";
        descripcion = "Sin descripción";
        presupuestoAnual = 0;
        listaEmpleados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPresupuestoAnual() {
        return presupuestoAnual;
    }

    public void setPresupuestoAnual(double presupuestoAnual) {
        this.presupuestoAnual = presupuestoAnual;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> empleados) {
        this.listaEmpleados = empleados;
    }

    public void agregarEmpleado(Empleado elEmpleado) {
        listaEmpleados.add(elEmpleado);
    }

    public void quitarEmpleado(Empleado elEmpleado) {
        listaEmpleados.remove(elEmpleado);
    }

    public double getMontoAsignado() {
        double total = 0;
        for (int i = 0; i < listaEmpleados.size(); i++) {
            total += listaEmpleados.get(i).getSalarioMensual();
        }
        return total;
    }

    public double getPresupuestoDisponible() {
        return presupuestoAnual - this.getMontoAsignado();
    }

    public boolean puedeAceptar(Empleado e, int mesActual) {
        double salarioMensual = e.getSalarioMensual();
        return this.getPresupuestoDisponible() >= (13 - mesActual) * salarioMensual;
    }

    public boolean sinEmpleados() {
        return listaEmpleados.isEmpty();
    }

    @Override
    public String toString() {
        return this.getNombre() + " ($" + this.getPresupuestoAnual() + ")";
    }
}
