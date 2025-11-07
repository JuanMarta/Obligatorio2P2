
package dominio;

import java.util.Collections;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;

public class Sistema extends Observable  implements Serializable {
    
    private ArrayList<Area> listaAreas;
    private ArrayList<Manager> listaManagers;
    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<Movimiento> listaMovimientos;
    
    public Sistema(){
        listaAreas = new ArrayList<>();
        listaManagers = new ArrayList<>();
        listaEmpleados = new ArrayList<>();
        listaMovimientos = new ArrayList<>();
    }

    public ArrayList<Movimiento> getListaMovimientos() {
        return listaMovimientos;
    }

    public void setListaMovimientos(ArrayList<Movimiento> listaMovimientos) {
        this.listaMovimientos = listaMovimientos;
    }

    public ArrayList<Area> getListaAreas() {
        return listaAreas;
    }

    public void setListaAreas(ArrayList<Area> listaAreas) {
        this.listaAreas = listaAreas;
    }

    public ArrayList<Manager> getListaManagers() {
        return listaManagers;
    }

    public void setListaManagers(ArrayList<Manager> listaManagers) {
        this.listaManagers = listaManagers;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }
    
    public void agregarArea(Area elArea){
        listaAreas.add(elArea);
        setChanged();
        notifyObservers();
    }
    
    public void agregarManager(Manager elManager){
        listaManagers.add(elManager);
        setChanged();
        notifyObservers();
    }
    
    public void agregarEmpleado(Empleado elEmpleado){
        listaEmpleados.add(elEmpleado);
        elEmpleado.getArea().agregarEmpleado(elEmpleado, 1);
        elEmpleado.getManager().agregarEmpleado(elEmpleado);
        setChanged();
        notifyObservers();
    }
    
    public void agregarMovimiento(Movimiento elMovimiento){
        listaMovimientos.add(elMovimiento);
        setChanged();
        notifyObservers();
    }
    
    public boolean unicidadPersona(Persona p) {
        return ! getListaEmpleados().contains(p) && ! getListaManagers().contains(p);
    }
    
    public boolean buscarAreaPorNombre(String elNombre){
        boolean ret = false;
        for (int i = 0; i < listaAreas.size()&&!ret; i++) {
            if(listaAreas.get(i).getNombre().equalsIgnoreCase(elNombre)){
                ret = true;
            }
        }
        return ret;
    }
    public boolean buscarPersonaporCedula(String laCi){
        boolean ret = false;
        for (int i = 0; i < listaManagers.size()&&!ret; i++) {
            if(listaManagers.get(i).getCedula().equalsIgnoreCase(laCi)){
                ret = true;
            }
        }
        for (int i = 0; i < listaEmpleados.size()&&!ret; i++) {
            if(listaEmpleados.get(i).getCedula().equalsIgnoreCase(laCi)){
                ret = true;
            }
        }
        return ret;
    }
    
    public ArrayList<Area> areasOrdenadasPorNombre(){
        Collections.sort(listaAreas);
        return listaAreas;
    }

    public ArrayList<Manager> managersOrdenadosPorAntiguedad() {
        Collections.sort(listaManagers);
        return listaManagers;
    }

    public ArrayList<Empleado> empleadosOrdenadosPorSalario() {
        Collections.sort(listaEmpleados);
        return listaEmpleados;
    }

    public boolean moverEmpleado(Empleado e, int mesActual, Area destino) {
        boolean movido = false;
        if (destino.puedeAceptar(e, mesActual)) {
            Area areaOrigen = e.getArea();
            areaOrigen.quitarEmpleado(e, mesActual);
            e.setArea(destino);
            destino.agregarEmpleado(e, mesActual);
            movido = true;
            setChanged();
            notifyObservers();
        }
        return movido;

    }

    public void eliminarArea(Area a) {
        if (a.sinEmpleados()) {
            listaAreas.remove(a);
            setChanged();
            notifyObservers();
        }
    }
    
    public void eliminarManager(Manager m){
        if(m.sinEmpleados()){
            listaManagers.remove(m);
            setChanged();
            notifyObservers();
        }
    }
    
}
