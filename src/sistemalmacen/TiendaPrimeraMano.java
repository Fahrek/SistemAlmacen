package sistemalmacen;

public class TiendaPrimeraMano {

    private String nombre;
    private Producto[] stock;

    public TiendaPrimeraMano() {
    }

    public TiendaPrimeraMano(String nombre, Producto[] stock) {
        this.nombre = nombre;
        this.stock = stock;
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

    public void imprimeEstadisticas() {
        System.out.println("--------------------------------------------------");
        System.out.println("---------- Lista de productos de 1ª mano ---------");
        int n = stock.length;
        double beneficio = 0.0;
        for (int i = 0; i < n; i++) {
            stock[i].imprime();
            beneficio += stock[i].getValor();
        }
        System.out.println("El beneficio de la tienda central(TC) es: " + beneficio);
        System.out.println("--------------------------------------------------");
    }
}
