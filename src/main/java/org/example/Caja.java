public class Caja {
    private String nombreCaja;

    public Caja(String nombreCaja) {
        this.nombreCaja = nombreCaja;
    }

    // Sincronizamos el método para asegurar que dos hilos no accedan a la misma caja simultáneamente
    public synchronized void gestionarCompra(Cliente cliente) {
        System.out.println("La " + nombreCaja + " comienza a atender al cliente " + cliente.getNombre());

        long initialTime = System.currentTimeMillis();

        for (Producto producto : cliente.getCarrito()) {
            cobrarProducto(cliente, producto);
        }

        long tiempoTotal = System.currentTimeMillis() - initialTime;
        System.out.println("La " + nombreCaja + " ha terminado de atender al cliente " + cliente.getNombre() +
                " en " + (tiempoTotal / 1000.0) + " segundos.");
    }

    private void cobrarProducto(Cliente cliente, Producto producto) {
        try {
            System.out.println(nombreCaja + " esta cobrando el producto " + producto.getNombre() +
                    " del cliente " + cliente.getNombre());
            Thread.sleep(1000); // Simula el tiempo de procesamiento de cada producto
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
