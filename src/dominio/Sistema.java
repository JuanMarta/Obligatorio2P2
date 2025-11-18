package dominio;

import excepciones.NumFueraDeRangoException;
import excepciones.StringVacioException;
import java.util.Collections;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Observable;

public class Sistema extends Observable implements Serializable {

    private ArrayList<Area> listaAreas;
    private ArrayList<Manager> listaManagers;
    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<Movimiento> listaMovimientos;

    public Sistema() {
        try {
            listaAreas = new ArrayList<>();
            listaManagers = new ArrayList<>();
            listaEmpleados = new ArrayList<>();
            listaMovimientos = new ArrayList<>();
        } catch (Exception ex) {
            System.getLogger(Sistema.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    // ---------------------------------------------------
    // -------------------- Areas ------------------------
    // ---------------------------------------------------
    public ArrayList<Area> getListaAreas() {
        return listaAreas;
    }

    public void setListaAreas(ArrayList<Area> listaAreas) {
        this.listaAreas = listaAreas;
    }

    public void agregarArea(Area elArea) {
        listaAreas.add(elArea);
        setChanged();
        notifyObservers();
    }

    public boolean buscarAreaPorNombre(String elNombre) {
        boolean ret = false;
        for (int i = 0; i < listaAreas.size() && !ret; i++) {
            if (listaAreas.get(i).getNombre().equalsIgnoreCase(elNombre)) {
                ret = true;
            }
        }
        return ret;
    }

    public ArrayList<Area> areasOrdenadasPorNombre() {
        Collections.sort(listaAreas);
        return listaAreas;
    }

    public ArrayList<Area> areasOrdenadasPorPresupuestoAsignado() {
        Collections.sort(getListaAreas(), new Comparator<Area>() {
            public int compare(Area a1, Area a2) {
                double porcentajeArea1 = a1.porcentajePresupuestoAsignado();
                double porcentajeArea2 = a2.porcentajePresupuestoAsignado();

                return Double.compare(porcentajeArea2, porcentajeArea1);
            }
        });

        return getListaAreas();
    }

    public void eliminarArea(Area a) {
        if (a.sinEmpleados()) {
            listaAreas.remove(a);
            setChanged();
            notifyObservers();
        }
    }

    // ---------------------------------------------------
    // -------------------- Managers ---------------------
    // ---------------------------------------------------
    public ArrayList<Manager> getListaManagers() {
        return listaManagers;
    }

    public void setListaManagers(ArrayList<Manager> listaManagers) {
        this.listaManagers = listaManagers;
    }

    public void agregarManager(Manager elManager) {
        listaManagers.add(elManager);
        setChanged();
        notifyObservers();
    }

    public ArrayList<Manager> managersOrdenadosPorAntiguedad() {
        Collections.sort(listaManagers);
        return listaManagers;
    }

    public void eliminarManager(Manager m) {
        if (m.sinEmpleados()) {
            listaManagers.remove(m);
            setChanged();
            notifyObservers();
        }
    }

    // ---------------------------------------------------
    // -------------------- Empleados --------------------
    // ---------------------------------------------------
    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public void agregarEmpleado(Empleado elEmpleado) {
        listaEmpleados.add(elEmpleado);
        elEmpleado.getArea().agregarEmpleado(elEmpleado, 1);
        elEmpleado.getManager().agregarEmpleado(elEmpleado);
        setChanged();
        notifyObservers();
    }

    public ArrayList<Empleado> empleadosOrdenadosPorSalario() {
        Collections.sort(listaEmpleados);
        return listaEmpleados;
    }

    public boolean moverEmpleado(Empleado e, int mesActual, Area destino) {
        boolean movido = false;
        if (destino.puedeAceptar(e.getSalarioMensual(), mesActual)) {
            Area areaOrigen = e.getArea();
            areaOrigen.quitarEmpleado(e, mesActual);
            e.setArea(destino);
            destino.agregarEmpleado(e, mesActual);
            movido = true;
            setChanged();
            notifyObservers();
            Movimiento m = new Movimiento(mesActual, areaOrigen.getNombre(), destino.getNombre(), e.getCedula(), e.getNombre());
            this.agregarMovimiento(m);
        }
        return movido;
    }

    // ----------------------------------------------------
    // ------------------- Movimientos --------------------
    // ----------------------------------------------------
    public ArrayList<Movimiento> getListaMovimientos() {
        return listaMovimientos;
    }

    public void setListaMovimientos(ArrayList<Movimiento> listaMovimientos) {
        this.listaMovimientos = listaMovimientos;
    }

    public void agregarMovimiento(Movimiento elMovimiento) {
        listaMovimientos.add(elMovimiento);
        setChanged();
        notifyObservers();
    }

    public ArrayList<Movimiento> filtroMovimiento(int mes, String nomAreaOrigen, String nomAreaDestino, String cedula) {
        ArrayList<Movimiento> lista = new ArrayList<>();

        for (Movimiento m : getListaMovimientos()) {
            boolean coincideMes = (!(mes > 0) || m.getMesRealizacion() == mes);
            boolean coincideOrigen = (nomAreaOrigen == null || m.getNombreAreaOrigen().equals(nomAreaOrigen));
            boolean coincideDestino = (nomAreaDestino == null || m.getNombreAreaDestino().equals(nomAreaDestino));
            boolean coincideCedula = (cedula == null || m.getCedulaEmpleado().equals(cedula));

            if (coincideMes && coincideOrigen && coincideDestino && coincideCedula) {
                lista.add(m);
            }
        }
        Collections.sort(lista);

        return lista;
    }

    // ---------------------------------------------------
    // ------------------- Persona -----------------------
    // ---------------------------------------------------
    public void intEnRango(int min, int max, int valor) throws NumFueraDeRangoException {
        if (min > valor || max < valor) {
            throw new NumFueraDeRangoException();
        }
    }

    public void doubleEnRango(int min, int max, double valor) throws NumFueraDeRangoException {
        if (min > valor || max < valor) {
            throw new NumFueraDeRangoException();
        }
    }

    public boolean unicidadPersona(String cedula) {
        boolean ret = false;
        for (int i = 0; i < listaManagers.size() && !ret; i++) {
            ret = listaManagers.get(i).getCedula().equalsIgnoreCase(cedula);
        }
        for(int i = 0; i < listaEmpleados.size()&& !ret; i++){
            ret = listaEmpleados.get(i).getCedula().equalsIgnoreCase(cedula);
        }
        return ret;
    }

    public boolean buscarPersonaporCedula(String laCi) {
        boolean ret = false;
        for (int i = 0; i < listaManagers.size() && !ret; i++) {
            if (listaManagers.get(i).getCedula().equalsIgnoreCase(laCi)) {
                ret = true;
            }
        }
        for (int i = 0; i < listaEmpleados.size() && !ret; i++) {
            if (listaEmpleados.get(i).getCedula().equalsIgnoreCase(laCi)) {
                ret = true;
            }
        }
        return ret;

    }
}
