// Trabajo desarrollado por: Santiago Alonso 349491 Juan Marta 332281
package dominio;

import java.io.Serializable;

public class Movimiento implements Serializable, Comparable<Movimiento> {

    private int mesRealizacion;
    private Area areaOrigen;
    private Area areaDestino;
    private Empleado empleado;
    private static final long serialVersionUID = 1;

    public Movimiento(int mesRealizacion, Area areaOrigen, Area areaDestino, Empleado empleado) {
        this.mesRealizacion = mesRealizacion;
        this.areaOrigen = areaOrigen;
        this.areaDestino = areaDestino;
        this.empleado = empleado;
    }

    public int getMesRealizacion() {
        return mesRealizacion;
    }

    public void setMesRealizacion(int mesRealizacion) {
        this.mesRealizacion = mesRealizacion;
    }

    public Area getAreaOrigen() {
        return areaOrigen;
    }

    public void setAreaOrigen(Area area) {
        this.areaOrigen = area;
    }

    public Area getAreaDestino() {
        return areaDestino;
    }

    public void setAreaDestino(Area area) {
        this.areaDestino = area;
    }
    
    public Empleado getEmpleado() {
        return empleado;
    }
    
    public void setEmpleado(Empleado e) {
        this.empleado = e;
    }

    @Override
    public int compareTo(Movimiento o) {
        return this.mesRealizacion - o.mesRealizacion;
    }
}
