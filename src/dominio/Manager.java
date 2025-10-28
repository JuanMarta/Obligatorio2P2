package dominio;

import java.util.ArrayList;

public class Manager extends Persona {

    private int antiguedad;
    private ArrayList<Empleado> listaEmpleados;

    public Manager(String elNombre, String laCedula, String elCelular, int laAntiguedad) {
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

    @Override
    public String toString() {
        return super.toString() + " - Antigüedad: " + this.getAntiguedad();
    }
}
