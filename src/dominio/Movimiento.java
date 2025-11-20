// Trabajo desarrollado por: Santiago Alonso 349491 Juan Marta 332281
package dominio;

import java.io.Serializable;


public class Movimiento implements Serializable,Comparable<Movimiento>{
    private int mesRealizacion;
    private String nombreAreaOrigen;
    private String nombreAreaDestino;
    private String nombreEmpleado;
    private String cedulaEmpleado;
    
    public Movimiento(int elMes, String nombreOrigen, String nombreDestino, String nombre, String cedula){
        mesRealizacion = elMes;
        nombreAreaOrigen = nombreOrigen;
        nombreAreaDestino = nombreDestino;
        nombreEmpleado = nombre;
        cedulaEmpleado = cedula;
    }

    public int getMesRealizacion() {
        return mesRealizacion;
    }

    public void setMesRealizacion(int mesRealizacion) {
        this.mesRealizacion = mesRealizacion;
    }

    public String getNombreAreaOrigen() {
        return nombreAreaOrigen;
    }

    public void setNombreAreaOrigen(String nombreAreaOrigen) {
        this.nombreAreaOrigen = nombreAreaOrigen;
    }

    public String getNombreAreaDestino() {
        return nombreAreaDestino;
    }

    public void setNombreAreaDestino(String nombreAreaDestino) {
        this.nombreAreaDestino = nombreAreaDestino;
    }

    
    public String getNombreEmpleado() {
        return nombreEmpleado;
    }
    
    public void setNombreEmpleado(String nombre) {
        this.nombreEmpleado = nombre;
    }
    
    public String getCedulaEmpleado() {
        return cedulaEmpleado;
    }
    
    public void setCedulaEmpleado(String cedula) {
        this.cedulaEmpleado = cedula;
    }

    @Override
    public int compareTo(Movimiento o) {
        return this.mesRealizacion - o.mesRealizacion;
    }
}
