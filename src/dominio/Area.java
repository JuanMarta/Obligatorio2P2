// Trabajo desarrollado por: Santiago Alonso 349491 Juan Marta 332281
package dominio;

import excepciones.StringVacioException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Observable;

public class Area extends Observable implements Serializable, Comparable<Area> {

    private String nombre;
    private String descripcion;
    private double presupuestoAnual;
    private double presupuestoActual;
    private ArrayList<Empleado> listaEmpleados;

    public Area(String elNombre, String laDescripcion, double elPresupuesto) throws StringVacioException {
        setNombre(elNombre);
        setDescripcion(laDescripcion);
        setPresupuestoAnual(elPresupuesto);
        setPresupuestoActual(elPresupuesto);
        listaEmpleados = new ArrayList<>();
    }

    public Area() {
        nombre = "Sin nombre";
        descripcion = "Sin descripción";
        presupuestoActual = 0;
        listaEmpleados = new ArrayList<>();
    }

    public double getPresupuestoAnual() {
        return presupuestoAnual;
    }

    public void setPresupuestoAnual(double presupuestoAnual) {
        this.presupuestoAnual = presupuestoAnual;
        setChanged();
        notifyObservers();
    }

    public double getPresupuestoActual() {
        return presupuestoActual;
    }

    public void setPresupuestoActual(double presupuestoActual) {
        this.presupuestoActual = presupuestoActual;
        setChanged();
        notifyObservers();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws StringVacioException {
        if (nombre.isEmpty()) {
            throw new StringVacioException();
        } else {
            this.nombre = nombre;
            setChanged();
            notifyObservers();
        }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) throws StringVacioException {
        if (descripcion.isEmpty()) {
            throw new StringVacioException();
        } else {
            this.descripcion = descripcion;
            setChanged();
            notifyObservers();
        }
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> empleados) {
        this.listaEmpleados = empleados;
        setChanged();
        notifyObservers();
    }

    public void agregarEmpleado(Empleado elEmpleado, int mesIngreso) {
        listaEmpleados.add(elEmpleado);
        setPresupuestoActual(presupuestoActual - (13 - mesIngreso) * elEmpleado.getSalarioMensual());
        empleadosOrdenadosPorSalario();
        setChanged();
        notifyObservers();
    }

    public void quitarEmpleado(Empleado elEmpleado, int mesEgreso) {
        listaEmpleados.remove(elEmpleado);
        setPresupuestoActual(presupuestoActual + ((13-elEmpleado.getMesEnElArea())-(mesEgreso-elEmpleado.getMesEnElArea())) * elEmpleado.getSalarioMensual());
        setChanged();
        notifyObservers();
    }

    public boolean puedeAceptar(double salarioMensual, int mesIngreso) {
        return this.getPresupuestoActual() >= (13 - mesIngreso) * salarioMensual;
    }

    public boolean sinEmpleados() {
        return listaEmpleados.isEmpty();
    }

    public void empleadosOrdenadosPorSalario() {
        Collections.sort(listaEmpleados);
    }

    public ArrayList<Empleado> empleadosOrdenadosPorNombre() {
        Collections.sort(listaEmpleados, new Comparator<Empleado>() {
            @Override
            public int compare(Empleado o1, Empleado o2) {
                return o1.getNombre().compareTo(o2.getNombre());
            }
        });
        
        return listaEmpleados;
    }

    public double porcentajePresupuestoAsignado() {
        return ((this.getPresupuestoAnual() - this.getPresupuestoActual()) * 100) / this.getPresupuestoAnual();
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
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Area otra = (Area) o;
        return this.nombre.equals(otra.getNombre());
    }
}
