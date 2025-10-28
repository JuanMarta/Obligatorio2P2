
package dominio;

import java.util.Collections;
import java.io.Serializable;
import java.util.ArrayList;

public class Sistema implements Serializable {
    
    private ArrayList<Area> listaAreas;
    private ArrayList<Manager> listaManagers;
    private ArrayList<Empleado> listaEmpleados;
    
    public Sistema(){
        listaAreas = new ArrayList<>();
        listaManagers = new ArrayList<>();
        listaEmpleados = new ArrayList<>();
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
    }
    
    public void agregarManager(Manager elManager){
        listaManagers.add(elManager);
    }
    
    public void agregarEmpleado(Empleado elEmpleado){
        listaEmpleados.add(elEmpleado);
    }
    
    public Area buscarAreaPorNombre(String elNombre){
        Area encontrada = null;
        boolean aux = false;
        for (int i = 0; i < listaAreas.size()&&!aux; i++) {
            if(listaAreas.get(i).getNombre().equalsIgnoreCase(elNombre)){
                encontrada = listaAreas.get(i);
                aux = true;
            }
        }
        return encontrada;
    }
    
    public Manager buscarManagerPorCi(String elCi){
        Manager encontrado = null;
        boolean aux = false;
        for (int i = 0; i < listaManagers.size()&&!aux; i++) {
            if(listaManagers.get(i).getCedula().equalsIgnoreCase(elCi)){
                encontrado = listaManagers.get(i);
                aux = true;
            }
        }
        return encontrado;
    }
    public Empleado buscarEmpleadoPorCi(String elCi){
        Empleado encontrado = null;
        boolean aux = false;
        for (int i = 0; i < listaEmpleados.size()&&!aux; i++) {
            if(listaEmpleados.get(i).getCedula().equalsIgnoreCase(elCi)){
                encontrado = listaEmpleados.get(i);
                aux = true;
            }
        }
        return encontrado;
    }
    
    public ArrayList<Area> areasOrdenadasPorNombre(){
        Collections.sort(listaAreas);
        return listaAreas;
    }
    public ArrayList<Manager> managersOrdenadosPorAntiguedad(){
        Collections.sort(listaManagers);
        return listaManagers;
    }
    public ArrayList<Empleado> empleadosOrdenadosPorSalario(){
        Collections.sort(listaEmpleados);
        return listaEmpleados;
    }
    
    public boolean moverEmpleado (Empleado e, int mesActual, Area nuevoArea){
        boolean movido = false;
        if(nuevoArea.puedeAceptar(e, mesActual)){
            Area areaOrigen = e.getArea();
            this.agregarEmpleado(e);
            areaOrigen.quitarEmpleado(e);
            e.setArea(nuevoArea);
            movido = true;
        }
        return movido;
    }
    
    public void eleiminarArea(Area a){
        if(a.sinEmpleados()){
            listaAreas.remove(a);
        }
    }
    
    public void eliminarManager(Manager m){
        if(m.sinEmpleados()){
            listaManagers.remove(m);
        }
    }
    
}
