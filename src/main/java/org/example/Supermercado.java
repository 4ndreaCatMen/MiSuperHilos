import java.util.Arrays;
import java.util.List;

public class Supermercado {
    public static void main(String[] args) {
        // Creamos dos cajas para el supermercado
        Caja caja1 = new Caja("Caja 1");
        Caja caja2 = new Caja("Caja 2");

        // Creamos los productos para cada cliente
        List<Producto> productosCliente1 = Arrays.asList(new Producto("Libros"), new Producto("Magdalenas"), new Producto("Café"));
        List<Producto> productosCliente2 = Arrays.asList(new Producto("Colonia"), new Producto("Crema Facial"));
        List<Producto> productosCliente3 = Arrays.asList(new Producto("Videojuegos"), new Producto("Galletas"));
        List<Producto> productosCliente4 = Arrays.asList(new Producto("Tabaco"), new Producto("Frutas"), new Producto("Patatas"));
        List<Producto> productosCliente5 = Arrays.asList(new Producto("Queso"), new Producto("Yogures"));

        // Creamos los clientes y los asignamos a diferentes cajas
        Cliente cliente1 = new Cliente("Luis", productosCliente1, caja1);
        Cliente cliente2 = new Cliente("Gema", productosCliente2, caja2);
        Cliente cliente3 = new Cliente("Patricia", productosCliente3, caja1);
        Cliente cliente4 = new Cliente("Ginés", productosCliente4, caja2);
        Cliente cliente5 = new Cliente("Josemi", productosCliente5, caja1);

        // Iniciamos los hilos para que los clientes pasen por las cajas
        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();
        cliente5.start();

        // Esperamos a que todos los clientes terminen
        try {
            cliente1.join();
            cliente2.join();
            cliente3.join();
            cliente4.join();
            cliente5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}