package dominio;

import java.io.Serializable;
import java.util.ArrayList;

public class Area implements Serializable, Comparable<Area> {

    private String nombre;
    private String descripcion;
    private double presupuestoAnual;
    private double presupuestoActual;
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
        presupuestoActual = 0;
        listaEmpleados = new ArrayList<>();
    }

    public double getPresupuestoActual() {
        return presupuestoActual;
    }

    public void setPresupuestoActual(double presupuestoActual) {
        this.presupuestoActual = presupuestoActual;
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


    public boolean puedeAceptar(Empleado e, int mesIngreso) {
        double salarioMensual = e.getSalarioMensual();
        return this.getPresupuestoActual() >= (13 - mesIngreso) * salarioMensual;
    }
    
    public boolean sinEmpleados() {
        return listaEmpleados.isEmpty();
    }

    @Override
    public String toString() {
        return this.getNombre() + " ($" + this.getPresupuestoAnual() + ")";
    }

    @Override
    public int compareTo(Area o) {
        return nombre.compareToIgnoreCase(o.getNombre());
    }
    @Override
    public boolean equals(Object o){
        Area otra = (Area) o;
        return this.nombre.equals(otra.getNombre());
    }
}
