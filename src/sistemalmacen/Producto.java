package sistemalmacen;

import java.io.PrintWriter;
import java.text.DecimalFormat;

public class Producto {

    private String ID;
    private double valor;
    private double peso;
    private boolean asignado;
    private String clase;

    public Producto() {
    }

    public Producto(String ID, double valor, double peso, boolean asignado, String clase) {
        this.ID = ID;
        this.valor = valor;
        this.peso = peso;
        this.asignado = asignado;
        this.clase = clase;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean isAsignado() {
        return asignado;
    }

    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public void imprime() {
        DecimalFormat d1 = new DecimalFormat("00.00");
        DecimalFormat d2 = new DecimalFormat("00.0");
        System.out.println("ID: " + this.getID() + " | valor: " + d1.format(this.getValor()) + " | peso: " + d2.format(this.getPeso()) + " | asignado: " + this.isAsignado() + " | clase: " + this.getClase());
    }

    public void imprime(PrintWriter salida) {
        DecimalFormat d1 = new DecimalFormat("00.00");
        DecimalFormat d2 = new DecimalFormat("00.0");
        salida.println("ID: " + this.getID() + " | valor: " + d1.format(this.getValor()) + " | peso: " + d2.format(this.getPeso()) + " | asignado: " + this.isAsignado() + " | clase: " + this.getClase());
    }
}
