
package dominio;


public class Movimiento implements Comparable<Movimiento>{
    private int mesRealizacion;
    private String nombreAreaOrigen;
    private String nombreAreaDestino;
    private String cedulaEmpleado;
    private String nombreEmpleado;
    
    public Movimiento(int elMes, String nombreOrigen, String nombreDestino, String cedula, String nombre){
        mesRealizacion = elMes;
        nombreAreaOrigen = nombreOrigen;
        nombreAreaDestino = nombreDestino;
        cedulaEmpleado = cedula;
        nombreEmpleado = nombre;
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

    public String getCedulaEmpleado() {
        return cedulaEmpleado;
    }

    public void setCedulaEmpleado(String nombreEmpleado) {
        this.cedulaEmpleado = nombreEmpleado;
    }
    
    public String getNombreEmpleado() {
        return nombreEmpleado;
    }
    
    public void setNombreEmpleado(String nombre) {
        this.nombreEmpleado = nombre;
    }    

    @Override
    public int compareTo(Movimiento o) {
        return this.mesRealizacion - o.mesRealizacion;
    }
}
