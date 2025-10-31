
package dominio;


public class Movimiento {
    private String mesRealizacion;
    private String nombreAreaOrigen;
    private String nombreAreaDestino;
    private String nombreEmpleado;
    
    public Movimiento(String elMes, String nombreOrigen, String nombreDestino, String nombreEmpleado){
        mesRealizacion = elMes;
        nombreAreaOrigen = nombreOrigen;
        nombreAreaDestino = nombreDestino;
        nombreEmpleado = nombreEmpleado;
    }

    public String getMesRealizacion() {
        return mesRealizacion;
    }

    public void setMesRealizacion(String mesRealizacion) {
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

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }
}
