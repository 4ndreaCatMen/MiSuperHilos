import java.util.List;

public class Cliente extends Thread {
    private String nombre;
    private List<Producto> carrito;
    private Caja caja;

    public Cliente(String nombre, List<Producto> carrito, Caja caja) {
        this.nombre = nombre;
        this.carrito = carrito;
        this.caja = caja;
    }

    @Override
    public void run() {
        // Cuando el hilo del cliente se inicia, se procesa su compra en la caja asignada.
        caja.gestionarCompra(this);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Producto> getCarrito() {
        return carrito;
    }
}
