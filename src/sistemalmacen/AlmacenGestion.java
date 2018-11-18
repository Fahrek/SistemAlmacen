package sistemalmacen;

import java.util.ArrayList;
import java.util.List;

public class AlmacenGestion {

    private Producto[] almacen;

    public AlmacenGestion() {
    }

    public AlmacenGestion(Producto[] almacen) {
        this.almacen = almacen;
    }

    public Producto[] getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Producto[] almacen) {
        this.almacen = almacen;
    }

    public void ordenarAlmacenPorValor() {
        Producto aux = new Producto();
        for (int i = 0; i < almacen.length - 1; i++) {
            for (int j = 0; j < almacen.length - i - 1; j++) {
                if (almacen[i].getValor() > almacen[i + 1].getValor()) {
                    aux = almacen[j];
                    almacen[j] = almacen[j + 1];
                    almacen[j + 1] = aux;
                }
            }
        }
    }

    public void ordenarAlmacenPorPeso() {
        Producto aux = new Producto();
        for (int i = 0; i < almacen.length - 1; i++) {
            for (int j = 0; j < almacen.length - i - 1; j++) {
                if (almacen[i].getPeso() > almacen[i + 1].getPeso()) {
                    aux = almacen[j];
                    almacen[j] = almacen[j + 1];
                    almacen[j + 1] = aux;
                }
            }
        }
    }

    public Producto busquedaProductoSec(String id) {
        int n = almacen.length - 1;
        Producto p = new Producto();
        for (int i = 0; i < n; i++) {
            if (almacen[i].getID().compareTo(id) == 0) {
                p = almacen[i];
            }
        }
        return p;
    }

    public Producto busquedaProductoBin(String id) {
        int izq = 0;
        int dcha = almacen.length - 1;
        boolean encontrado = false;

        while (dcha >= izq || encontrado == false) {
            int central = (izq + dcha) / 2;
            if (almacen[central].getID() == null ? id == null : almacen[central].getID().equals(id)) {
                encontrado = true;
                return almacen[central];
            } else if (id.compareTo(almacen[central].getID()) > 0) {
                izq = central + 1;
            } else {
                dcha = central - 1;
            }
        }
        return null;
    }

    public Producto[] prepararPedidoTCA(int n) {
        // Primero hay que forzar la ordenacion del almacen
        this.ordenarAlmacenPorValor();
        List<Producto> lstock = new ArrayList<>();
        int i = almacen.length - 1;
        int j = 0;
        while ((i >= 0) && (j < n)) {
            if (almacen[i].getClase().compareTo("A") == 0) {
                lstock.add(almacen[i]);
                almacen[i].setAsignado(true);
                j++;
            }
            i--;
        }

        Producto[] resultado = new Producto[lstock.size()];
        lstock.toArray(resultado);
        return resultado;
    }

    public Producto[] prepararPedidoSM(int n) {
        // Primero hay que forzar la ordenacion del almacen
        this.ordenarAlmacenPorValor();
        List<Producto> lstock = new ArrayList<>();
        int i = almacen.length - 1;
        int j = 0;
        while ((i >= 0) && (j < n)) {
            if (almacen[i].isAsignado() == false) {
                lstock.add(almacen[i]);
                almacen[i].setAsignado(true);
                j++;
            }
            i--;
        }

        Producto[] resultado = new Producto[lstock.size()];
        lstock.toArray(resultado);
        return resultado;
    }

    public void imprimeListaProductos() {
        int n = almacen.length;
        for (int i = 0; i < n; i++) {
            almacen[i].imprime();
        }
    }
}
