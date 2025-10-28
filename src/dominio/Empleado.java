package dominio;

public class Empleado extends Persona implements Comparable<Empleado> {

    private double salarioMensual;
    private String cv;
    private Manager manager;
    private Area area;

    public Empleado(String elNombre, String laCedula, String elCelular, double elSalario, String elCv, Manager elManager, Area elArea) {
        super(elNombre, laCedula, elCelular);
        salarioMensual = elSalario;
        cv = elCv;
        manager = elManager;
        area = elArea;
    }

    public Empleado() {
        super();
        salarioMensual = 0;
        cv = "";
        manager = null;
        area = null;
    }

    public double getSalarioMensual() {
        return salarioMensual;
    }

    public void setSalarioMensual(double salarioMensual) {
        this.salarioMensual = salarioMensual;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public double getSalarioAnual() {
        return salarioMensual * 12;
    }

    @Override
    public String toString() {
        return super.toString() + " - $" + this.getSalarioMensual();
    }

    @Override
    public int compareTo(Empleado o) {
        return Double.compare(salarioMensual, o.getSalarioMensual());
    }
}
