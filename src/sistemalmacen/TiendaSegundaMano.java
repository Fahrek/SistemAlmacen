package sistemalmacen;

import java.io.PrintWriter;

public class TiendaSegundaMano {

    private String nombre;
    private Producto[] stock;

    public TiendaSegundaMano() {
    }

    public TiendaSegundaMano(String nombre, Producto[] stock) {
        this.nombre = nombre;
        this.stock = stock;
        this.aplicarDescuento();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Producto[] getStock() {
        return stock;
    }

    public void setStock(Producto[] stock) {
        this.stock = stock;
    }

    public void aplicarDescuento() {
        int n = stock.length - 1;
        for (int i = 0; i < n; i++) {
            if (stock[i].getClase().compareTo("B") == 0) {
                stock[i].setValor(stock[i].getValor() * 0.75);
            }
            if (stock[i].getClase().compareTo("C") == 0) {
                stock[i].setValor(stock[i].getValor() * 0.50);
            }
        }
    }

    public void imprimeEstadisticas() {
        System.out.println("--------------------------------------------------");
        System.out.println("---------- Lista de productos de 2ª mano ---------");
        int n = stock.length;
        double beneficio = 0.0;
        for (int i = 0; i < n; i++) {
            stock[i].imprime();
            beneficio += stock[i].getValor(); // acumulador
        }
        System.out.println("El beneficio de la tienda de segunda mano(SM) es: " + beneficio);
        System.out.println("--------------------------------------------------");
    }

    public void imprimeEstadisticas(PrintWriter salida) {
        salida.println("--------------------------------------------------");
        salida.println("---------- Lista de productos de 2ª mano ---------");
        int n = stock.length;
        double beneficio = 0.0;
        for (int i = 0; i < n; i++) {
            stock[i].imprime(salida);
            beneficio += stock[i].getValor(); // acumulador
        }
        salida.println("El beneficio de la tienda de segunda mano(SM) es: " + beneficio);
        salida.println("--------------------------------------------------");
    }
}
