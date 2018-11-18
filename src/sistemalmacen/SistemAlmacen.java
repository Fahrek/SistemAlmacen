package sistemalmacen;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SistemAlmacen {

    public static void main(String[] args) throws IOException {
        Producto[] lp = GeneradorProductos.generarProductos(10);
        AlmacenGestion ag = new AlmacenGestion(lp);
        Producto[] s1 = ag.prepararPedidoTCA(3);
        Producto[] s2 = ag.prepararPedidoSM(3);
        TiendaPrimeraMano t1 = new TiendaPrimeraMano("EmpresaSoftPlanet", s1);
        TiendaSegundaMano t2 = new TiendaSegundaMano("EmpresaSoftExpres", s2);
        ag.imprimeListaProductos();
        t1.imprimeEstadisticas();
        t2.imprimeEstadisticas();
        FileWriter escritor = new FileWriter("Estadisticas_02.txt");
        PrintWriter pw = new PrintWriter(escritor);
        t2.imprimeEstadisticas(pw);
        pw.close();
    }
}
